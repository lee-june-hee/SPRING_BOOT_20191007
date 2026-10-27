package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.Member;
import com.example.demo.model.dto.MemberForm;
import com.example.demo.model.repository.MemberRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*; // User, UserDetails 등

@Service // 서비스 등록
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired // SecurityConfig 에 등록한 BCryptPasswordEncoder 주입
    private PasswordEncoder passwordEncoder;

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    } // 클래스 아래쪽
    // 관리자가 부여할 수 있는 권한 (화면에서 넘어온 값을 그대로 믿지 않는다)

    private static final List<String> ROLES = List.of("USER", "MANAGER", "ADMIN"); // 6주차 수정 반영

    public Member signup(MemberForm form) { // 회원가입
        if (isBlank(form.getUsername()) || isBlank(form.getPassword()) || isBlank(form.getName())) {
            throw new IllegalArgumentException("아이디, 비밀번호, 이름은 필수입니다.");
        }

        // 5주차 연습문제 코드 추가 시작 (비밀번호 확인 검증)
        if (!form.getPassword().equals(form.getPasswordConfirm())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        // 5주차 연습문제 코드 추가 끝

        if (memberRepository.existsByUsername(form.getUsername())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        Member member = new Member();
        member.setUsername(form.getUsername());
        member.setPassword(passwordEncoder.encode(form.getPassword())); // ★ 암호화
        member.setName(form.getName());
        member.setRole("USER"); // 기본 권한
        return memberRepository.save(member); // INSERT
    }

    @Override // 로그인 시 시큐리티가 자동 호출
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원 없음 : " + username));
        return User.builder() // 시큐리티용 사용자 객체로 변환
                .username(member.getUsername())
                .password(member.getPassword()) // 암호화 값 → matches()로 비교
                .roles(member.getRole()) // USER → ROLE_USER
                .build();
    }

    // MemberService : 로그인한 아이디로 회원 조회
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(
                        "회원이 존재하지 않습니다 : " + username));
    }

    public List<Member> findAll() { // MemberService : 전체 회원 (id 순서)
        return memberRepository.findAll(Sort.by("id"));
    }

    // 7주차 연습문제 코드 추가 시작 (검색어 조회 로직)
    public List<Member> searchMembers(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return memberRepository.findAll(Sort.by("id"));
        }
        return memberRepository.findByUsernameContainingOrNameContaining(keyword, keyword);
    }
    // 7주차 연습문제 코드 추가 끝

    @PreAuthorize("hasRole('ADMIN')") // 관리자만 실행 가능 (2차 잠금)
    public Member changeRole(Long id, String role) { // 권한 변경
        if (!ROLES.contains(role)) { // 허용된 권한만
            throw new IllegalArgumentException("허용되지 않는 권한입니다 : " + role);
        }
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        // 6주차 연습문제 코드 추가 시작 (관리자 본인 보호)
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (member.getUsername().equals(currentUsername)) {
            throw new IllegalArgumentException("자기 자신의 권한은 변경할 수 없습니다.");
        }
        // 6주차 연습문제 코드 추가 끝

        member.setRole(role);
        return memberRepository.save(member); // ② 마지막 줄 : 바뀐 회원을 돌려준다
    }

    @PreAuthorize("hasRole('ADMIN')") // 관리자만 실행 가능 (2차 잠금)
    public void deleteMember(Long id) { // 회원 삭제
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        // 6주차 연습문제 코드 추가 시작 (관리자 본인 보호)
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (member.getUsername().equals(currentUsername)) {
            throw new IllegalArgumentException("자기 자신은 삭제할 수 없습니다.");
        }
        // 6주차 연습문제 코드 추가 끝

        memberRepository.delete(member); // DELETE
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

}