package com.example.demo.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.domain.Member;
import com.example.demo.model.domain.Post;
import com.example.demo.model.dto.PostForm;
import com.example.demo.model.repository.EnrollmentRepository;
import com.example.demo.model.repository.MemberRepository;
import com.example.demo.model.repository.PostRepository;

@Service // 게시판 서비스
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired // [11주차] 단계 2 : 업로드 파일 저장소 (제공 코드)
    private FileStore fileStore;
    @Autowired // [11주차 연습문제 2] 신청 내역 확인용
    private EnrollmentRepository enrollmentRepository;

    public List<Post> findAll() { // 전체 목록 (최신 글이 위로)
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Post write(PostForm form, String username) { // 글쓰기 (작성자 = 로그인한 회원)
        validate(form);
        Member author = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        Post post = new Post();
        post.setTitle(form.getTitle().trim());
        post.setContent(form.getContent());
        post.setAuthor(author); // 작성자는 화면이 아니라 서버가 정한다
        post.setCreatedAt(LocalDateTime.now());
        post.setCapacity(form.getCapacity()); // [11주차] 단계 1 : 정원 (비우면 null = 일반 글)
        post.setPosterFile(fileStore.save(form.getPoster())); // [11주차] 단계 2 : 포스터 저장 → 파일 이름 (없으면 null)
        return postRepository.save(post); // INSERT
    }

    private void validate(PostForm form) { // 빈 값 검사 (5주차 회원가입과 같은 방식)
        // [11주차] 단계 1 : 모집 인원은 1~100명
        if (form.getCapacity() != null && (form.getCapacity() < 1 || form.getCapacity() > 100)) {
            throw new IllegalArgumentException("모집 인원은 1~100명으로 입력하세요.");
        }
        if (form.getTitle() == null || form.getTitle().isBlank()
                || form.getContent() == null || form.getContent().isBlank()) {
            throw new IllegalArgumentException("제목과 내용을 모두 입력하세요.");
        }
        if (form.getTitle().trim().length() > 100) {
            throw new IllegalArgumentException("제목은 100자까지 입력할 수 있습니다.");
        }
    }

    public static final int PAGE_SIZE = 10; // 한 페이지에 보여 줄 글 수
    // [10주차] 단계 1 : 페이지 목록 (page 는 0 부터)

    // [10주차] 단계 2 + 연습문제 2 : 페이지 목록 + 검색 (제목+내용 / 작성자)
    public Page<Post> findPage(String type, String keyword, int page) {
        PageRequest pageable = PageRequest.of(Math.max(page, 0), PAGE_SIZE, Sort.by(Sort.Direction.DESC, "id"));
        if (keyword == null || keyword.isBlank()) {
            return postRepository.findAll(pageable);
        }
        String trimmed = keyword.trim();
        if ("writer".equals(type)) {
            return postRepository.searchByWriter(trimmed, pageable); // 작성자 이름으로 검색
        }
        return postRepository.search(trimmed, pageable); // 기본: 제목 + 내용 검색
    }

    // [11주차] 단계 3 : 바구니에 담긴 글들 (번호 목록으로 한 번에)
    public List<Post> findAllById(Collection<Long> ids) {
        return postRepository.findAllById(ids); // SELECT ... WHERE id IN (?, ?, ?)
    }

    public Post findById(Long id) { // 글 1개 (없으면 404 → templates/error/404.html)
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "글이 존재하지 않습니다."));
    }

    // 9주차 연습문제 추가: 조회수 1 증가 후 글 반환 (상세 보기용)
    public Post read(Long id) {
        Post post = findById(id);
        post.setViewCount(post.getViewCount() + 1);
        return postRepository.save(post);
    }

    // 9주차 연습문제 추가: 특정 작성자가 쓴 글 목록 조회 (최신순)
    public List<Post> findByAuthor(String username) {
        return postRepository.findByAuthor_UsernameOrderByIdDesc(username);
    }

    // [10주차 연습문제 1] 내가 쓴 글 페이징 (10개씩, 최신순)
    public Page<Post> findMyPage(String username, int page) {
        PageRequest pageable = PageRequest.of(Math.max(page, 0), PAGE_SIZE, Sort.by(Sort.Direction.DESC, "id"));
        return postRepository.findByAuthor_Username(username, pageable);
    }

    public Post findForEdit(Long id) { // 수정 화면에 보여 줄 글 (본인 글만)
        Post post = findById(id);
        checkWriter(post); // ★ 추가
        return post;
    }

    public Post edit(Long id, PostForm form) { // 글 수정
        Post post = findForEdit(id);
        validate(form);
        post.setTitle(form.getTitle().trim());
        post.setContent(form.getContent());
        post.setUpdatedAt(LocalDateTime.now()); // 수정 시간 기록
        return postRepository.save(post); // id 가 있으니 UPDATE
    }

    // [11주차 연습문제 2] 글 삭제 (신청자 있으면 막기 + 포스터 파일 삭제)
    public void delete(Long id) { // 글 삭제 (본인 또는 관리자)
        Post post = findById(id);
        if (!isAdmin())
            checkWriter(post); // ★ 추가 : 관리자는 누구 글이든 삭제 가능
        if (enrollmentRepository.existsByPost(post)) {
            throw new IllegalStateException("신청자가 있는 모집글은 삭제할 수 없습니다.");
        }
        String posterFile = post.getPosterFile();
        postRepository.delete(post); // DELETE
        fileStore.delete(posterFile); // 포스터 파일 함께 삭제
    }

    private void checkWriter(Post post) { // 로그인한 사람이 글쓴이인지 → 아니면 403
        String loginUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!post.getAuthor().getUsername().equals(loginUsername)) {
            throw new AccessDeniedException("본인이 쓴 글만 수정·삭제할 수 있습니다.");
        }
    }

    private boolean isAdmin() { // 로그인한 사람이 관리자(ROLE_ADMIN)인지
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }
}