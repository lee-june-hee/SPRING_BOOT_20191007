<details>
<summary><b>2주차</b></summary>

<br>

## 1. 웹 개발 트렌드 및 프레임워크 개요

### 1) 스프링 프레임워크와 스프링 부트

- **스프링 프레임워크 1.0 (2004년)**: 오픈 소스 기반의 대표적인 웹 프레임워크로, 설정 및 XML 기반 구성으로 인해 진입 장벽이 매우 높았습니다[cite: 72].
- **스프링 부트의 등장 (2014년)**: 작은 규모 및 단순 서블릿 관리를 지향하며 자바 언어와 JVM 위에서 실행됩니다[cite: 72].
  - **주요 기능**: 자동 환경 설정, 자동 빌드 및 리로드 등 편의성과 자동화 기능이 강화되었습니다[cite: 72].

### 2) 전자정부 표준 프레임워크

- 2010년 이후 공개된 스프링 기반의 프레임워크로 주요 개발 가이드를 제공합니다[cite: 73].
- 국내 주요 공공기관 웹 프로젝트에 자바, JSP, jQuery 등과 함께 요구되며, 최근 5.X 버전부터 스프링 부트 지원을 시작했습니다[cite: 73].

### 3) 프레임워크 8대 특징

- **개발 용이성**: 패턴 기반 개발 및 비즈니스 로직에만 집중 가능[cite: 73].
- **시스템 복잡도 감소**: 복잡한 기술을 숨기고 잘 정의된 기술 셋 적용[cite: 73].
- **이식성**: 플랫폼 연동을 프레임워크가 제공하여 비의존적 개발 가능[cite: 73].
- **품질 보증**: 검증된 기술 개발 패턴에 따라 초급/고급 개발자 간 차이 완화[cite: 73].
- **운영 용이성**: 변경이 용이하고 아키텍처 파악이 쉬움[cite: 73].
- **개발 코드 최소화**: 반복 개발을 제거하고 공통 컴포넌트 활용[cite: 73].
- **변경 용이성**: 구조화된 아키텍처 적용으로 플랫폼 비의존적[cite: 73].
- **설계와 코드 재사용성**: 사전에 개발된 패턴 및 컴포넌트 재사용[cite: 73].

---

## 2. 개발 환경 및 프로젝트 구성

### 1) 개발 환경

- **자바(Java)**: 자바 25 LTS 이상 권장 (최소 17 버전)[cite: 76].
- **IDE**: VS Code를 사용하며 `Extension Pack for Java`, `Spring Boot Extension Pack`을 설치합니다[cite: 77].
- **JDK 경로 설정 (`settings.json`)**: `spring-boot.ls.java.home` 및 `java.jdt.ls.java.home`에 설치된 JDK 경로를 등록합니다[cite: 78].

### 2) Spring Initializr 프로젝트 생성

- **기본 설정**: Maven Project, Jar 패키징, Java 버전을 선택합니다[cite: 79].
- **7가지 주요 의존성**: Spring Boot DevTools, Lombok, Spring Web, Spring Web Services, Thymeleaf, Spring Data JPA, MySQL Driver[cite: 80].
- **프로젝트 폴더 구조**:
  - `src/main/java`: 루트 패키지 경로[cite: 81].
  - `src/main/resources`: `static`(CSS, 이미지, JS 등), `templates`(HTML 템플릿) 폴더 포함[cite: 81].
  - `pom.xml`: 빌드 및 종속성 설정 파일[cite: 81].

---

## 3. Java 실행 구조 및 문법 규칙

### 1) 컴파일 타임과 런타임 환경

- **컴파일 타임**: 자바 컴파일러(`javac.exe`)가 소스코드(`.java`)를 자바 바이트 코드(`.class`)로 변환합니다[cite: 84].
- **런타임 환경**: 자바 클래스 로더가 바이트 코드를 읽고, JVM이 운영체제 및 하드웨어와 소통하며 실행합니다[cite: 84].

### 2) JVM 및 자바의 특징

- **플랫폼 독립성**: 어떤 환경에서도 동일 실행 가능 (단점: 초기 컴파일 필요)[cite: 84].
- **바이트코드 실행**: 플랫폼 독립성 확보 (단점: 인터프리터/JIT 필요)[cite: 84].
- **가비지 컬렉션 (GC)**: 메모리 누수 자동 방지 (단점: 초기 성능 저하 가능성)[cite: 84].
- **보안**: 샌드박스 방식으로 시스템 보안 강화 (단점: 복잡한 구현 필요)[cite: 84].
- **성능**: JIT 컴파일러를 통한 실행 속도 향상 (단점: 초기 컴파일 오버헤드)[cite: 84].

### 3) 자바 클래스 명명 규칙

- 하나 이상의 문자로 이루어져야 합니다 (예: `Car`)[cite: 96].
- 첫 글자는 숫자가 올 수 없습니다[cite: 96].
- 특수문자는 `$`와 `_`만 허용됩니다[cite: 96].
- 자바 키워드(예: `int`, `for`)는 사용할 수 없습니다[cite: 96].

---

## 4. 웹 서버 아키텍처 및 동작 원리

### 1) 정적 vs 동적 웹사이트

- **정적 웹사이트 (Client-side)**: HTML, CSS, 단순 JS 위주의 화면[cite: 88].
- **동적 웹사이트 (Server-side)**: DB와 연동하여 서버 사이드 프로그래밍 언어로 동작[cite: 88].
- **기본 구조**: 클라이언트 브라우저 $\rightarrow$ Web Server $\rightarrow$ WAS $\rightarrow$ DB[cite: 88].

### 2) 스프링 부트 아키텍처

- 톰캣(Tomcat)을 내장하고 있어 별도의 WAS 설치 없이 자바 기반 동적 웹페이지를 실행합니다[cite: 89].
- 스프링 컨테이너가 자바 객체의 생성, 초기화, 의존성 주입(DI), 종료를 관리합니다[cite: 89].

### 3) DispatcherServlet (프론트 컨트롤러) 동작 과정

1. **요청**: 클라이언트(User)가 특정 URI로 요청 전송[cite: 90].
2. **핸들러 탐색**: `DispatcherServlet`이 `HandlerMapping`을 통해 매핑되는 컨트롤러 검색[cite: 90].
3. **비즈니스 로직 수행**: `Controller`가 처리를 수행하고 `ModelAndView` 반환[cite: 90].
4. **뷰 결정**: `ViewResolver`가 처리 결과를 생성할 View 결정[cite: 90].
5. **결과 리턴**: 결정된 `View`가 클라이언트에 최종 HTML 화면을 출력[cite: 90].

### 4) 웹 주소 식별자 구조

- **URI (Uniform Resource Identifier)**: 자원의 위치(URL)와 자원의 이름(URN)을 모두 포함하는 상위 개념[cite: 90].
- **주소 구성 예시**: `Domain` (물리적 서버) + `URI` (서버 매핑 파일 식별) + `Query String` (GET 요청 파라미터 값)[cite: 90].

---

## 5. Thymeleaf (타임리프) 엔진 및 스프링 어노테이션

### 1) Thymeleaf 템플릿 엔진

- 레거시 JSP를 대체하는 HTML 기반의 서버 사이드 템플릿 엔진입니다[cite: 92].
- MVC 패턴에서 **View(화면 출력)** 역할을 담당하며 `DispatcherServlet`을 통해 동작합니다[cite: 92].
- **주요 기능**: 데이터 바인딩, 연산, 템플릿 Fragment 분리, 반복 및 조건 제어문 지원[cite: 92].
- **기본 문법**:
  - 선언부: `<html lang="en" xmlns:th="http://www.thymeleaf.org">`[cite: 94].
  - 텍스트 변수 출력: `<span th:text="${data}"></span>`[cite: 94].

### 2) 404 에러 (NoResourceFoundException) 발생 원인

- HTML 파일을 `localhost:8080/hello.html`처럼 정적 리소스 경로로 직접 접근할 경우, 템플릿 엔진 렌더링을 거치지 않아 에러가 발생합니다[cite: 95].
- 반드시 `@Controller` 파일에서 `@GetMapping("/hello")` 형태로 URL 매핑을 연결해주어야 합니다[cite: 96].

### 3) 핵심 스프링 부트 어노테이션 요약

| 어노테이션                       | 의미 / 역할                                                     |
| :------------------------------- | :-------------------------------------------------------------- |
| `@SpringBootApplication`         | 스프링 부트 애플리케이션 명시 (자동 설정 기능 활성화)[cite: 83] |
| `@Controller`                    | View를 제공하는 컨트롤러 명시[cite: 83]                         |
| `@RestController`                | REST API(데이터)를 제공하는 컨트롤러 명시[cite: 83]             |
| `@RequestMapping`                | 특정 URL 주소를 매핑[cite: 83]                                  |
| `@GetMapping` / `@PostMapping`   | HTTP GET / POST 방식의 URL 주소 매핑[cite: 83]                  |
| `@PutMapping` / `@DeleteMapping` | HTTP PUT / DELETE 방식의 URL 주소 매핑[cite: 83]                |
| `@RequestParam`                  | URL Query Parameter 값을 매핑[cite: 83]                         |
| `@RequestBody`                   | HTTP Body 파싱 후 자바 객체 매핑[cite: 83]                      |
| `@Valid`                         | POJO Java 클래스 값의 유효성 검증[cite: 83]                     |

</details>

<details>
<summary><b>3주차</b></summary>

<br>

## 1. 페이지 개요 및 UI 설계

- **목적**: 웹 개발 기술 스택(프론트엔드, 백엔드, DB, 배포 등)과 작업 프로세스를 소개하는 상세 페이지입니다[cite: 102].
- **스타일 전략**: 메인 화면(`index.html`)과 동일한 폰트(DM Sans) 및 CSS 파일을 재사용하여 전체적인 디자인 통일성을 유지했습니다[cite: 102].
- **CSS 변수 오버라이딩**: 흰색 배경에서 가독성을 높이기 위해 `detailed_web.html` 내부 `<style>` 태그에서 원본 민트색 엑센트를 더 진한 색상(`--accent-dark: #0e7a5a;`)으로 재정의하여 적용했습니다[cite: 102].

## 2. 주요 섹션 구성 및 특징

### 1) 상단 네비게이션바 (Navbar)

- **스타일 변경**: 메인 화면에서는 투명했던 네비게이션바를 흰색 솔리드 배경(`.navbar-solid`)으로 변경했습니다[cite: 102].
- **가독성 확보**: 배경색 변경에 맞춰 브랜드 로고 텍스트, 버튼 테두리 및 글자 색상을 어두운 계열(검은색, 민트 계열)로 반전시켜 가시성을 높였습니다[cite: 102].

### 2) 페이지 헤더 및 요약 정보

- **헤더 영역 (`.page-header`)**: 'Services / Web' 메뉴 경로와 웹 개발 서비스(기획~배포)에 대한 전반적인 소개 문구를 포함합니다[cite: 102].
- **통계 요약 (`.featured-numbers`)**: 웹 프로젝트 수(18), 경력(7+년), 주요 분야(4), 가동률(99%) 등 핵심 지표를 수치화하여 4분할 레이아웃으로 배치했습니다[cite: 102].

### 3) 기술 스택 카드 (`.tech-thumb`)

메인 화면의 서비스 썸네일을 변형하여 4개의 핵심 기술 카드를 구성했습니다[cite: 102].

- **프론트엔드**: HTML5, CSS3, JavaScript(ES6+), Bootstrap 5, jQuery, Thymeleaf[cite: 102].
- **백엔드**: Java 25, Spring Boot 4.1, Spring MVC, Spring Data JPA, Lombok, REST API[cite: 102].
- **데이터베이스**: MySQL, H2 Database, JPA/Hibernate, MyBatis, SQL 튜닝[cite: 102].
- **개발 도구 & 배포**: Git/GitHub, Maven, Docker, AWS EC2, IntelliJ IDEA[cite: 102].
- **태그 디자인 (`.tech-tag`)**: 부트스트랩 배지(Badge) 대신 템플릿 색상 변수를 활용하여 모서리가 둥근 커스텀 태그를 직접 구현했습니다[cite: 102].

### 4) 숙련도 및 작업 흐름 (진행 방식)

- **숙련도 그래프 (`.skill-bar`)**: 주요 기술(Java/Spring Boot, HTML/CSS, JS, DB)에 대한 숙련도를 퍼센티지(width) 기반의 막대그래프(Progress Bar) 형태로 시각화했습니다[cite: 102].
- **작업 흐름 (`.flow-item`)**: 좌측 테두리와 원형 마커(`::before` 가상 요소)를 활용해 4단계(요구사항 분석 $\rightarrow$ 화면 설계 $\rightarrow$ 서버 개발 $\rightarrow$ 테스트/배포) 타임라인 UI를 구축했습니다[cite: 102].

### 5) 마무리 및 하단 네비게이션

- 페이지 하단에 사용자의 연락을 유도하는 Call-to-Action(CTA) 섹션을 배치하고, '연락하기' 앵커 태그(`/section_5`) 및 '목록으로 돌아가기' 버튼을 제공합니다[cite: 102].

</details>

<details>
<summary><b>4주차</b></summary>

<br>

## 1. 데이터베이스 최신 트렌드 및 MySQL 개요

### 1) 데이터베이스 트렌드

- **RDB 강세**: Oracle, MySQL 등이 여전히 관계형 데이터베이스(RDB)의 대세이며, PostgreSQL, MariaDB, SQLite 같은 오픈소스 DBMS가 큰 인기를 얻고 있습니다[cite: 103].
- **환경 변화**: 클라우드 및 컨테이너 환경의 확산과 더불어 AI/빅데이터 처리를 위한 NoSQL 시장도 크게 성장하고 있습니다[cite: 103].
- **프로젝트 DB 선택 기준**: 비용, 안정성, 호환성, 성능 최적화, 확장성, 플랫폼 종속성 등을 종합적으로 고려해야 합니다[cite: 104].

### 2) MySQL 특징

- 2010년 오라클이 인수한 오픈 소스 기반 RDB로, 무료(Community)와 상용화(Enterprise) 버전이 분리된 오픈 코어 모델을 채택하고 있습니다[cite: 105].
- 최신 8.x 이상의 버전에서는 NoSQL(JSON Collections) 지원이 추가되었으며, 워드프레스 등 주요 웹 시스템에서 가장 널리 사용됩니다[cite: 105].

---

## 2. JPA (Java Persistence API) 및 영속성 계층

### 1) JPA와 ORM 개념

- **ORM (Object-Relational Mapping)**: 객체 지향 프로그래밍(OOP)의 클래스와 관계형 데이터베이스(RDB)의 테이블을 자동으로 매핑해주는 기술입니다[cite: 108].
- **JPA의 역할**: 개발자가 직접 SQL을 작성하지 않아도 JPA가 쿼리를 대신 생성하여 데이터를 조회, 수정, 저장, 삭제합니다[cite: 108]. 데이터 제어 방식을 메서드 기반으로 표준화합니다[cite: 108].

### 2) 영속성(Persistence) 구조

- **Hibernate**: JPA 인터페이스의 대표적인 실제 구현체 프레임워크입니다[cite: 109].
- **EntityManager**: 프로그램(엔티티 객체)과 DB 사이에서 영속성 컨텍스트를 자동 관리하고 트랜잭션 처리의 복잡성을 줄여줍니다[cite: 109].

---

## 3. MySQL 연동 및 환경 설정

### 1) 의존성 추가 (`pom.xml`)

- `spring-boot-starter-data-jpa`: JPA 사용을 위한 스프링 부트 스타터 패키지[cite: 108].
- `mysql-connector-j`: Java 앱과 MySQL을 연결해주는 JDBC 드라이버 커넥터[cite: 110].

### 2) 접속 정보 설정 (`application.properties`)

- **URL**: `spring.datasource.url=jdbc:mysql://localhost:3306/spring?serverTimezone` (기본 포트 3306)[cite: 113].
- **계정**: `username=root`, `password=설정한비밀번호`[cite: 113].
- **JPA 옵션**:
  - `spring.jpa.hibernate.ddl-auto=update`: 엔티티 클래스 변경 사항에 맞춰 DB 테이블을 자동 생성/수정[cite: 113].
  - `spring.jpa.show-sql=true`: 실행되는 SQL 쿼리를 터미널(콘솔)에 출력[cite: 113].

### 3) HikariCP

- 스프링 부트의 기본 커넥션 풀(Connection Pool)로, 애플리케이션 시작 시 DB 연결 리소스를 최적화하여 맺어둡니다 (`HikariPool-1 Start completed` 로그 확인)[cite: 114].

---

## 4. 스프링 부트 MVC 계층 구조 및 데이터 흐름

단일 폴더(패키지) 구조에서 벗어나 역할에 따라 패키지를 세분화(Model, View, Controller, Service, Repository)하여 개발하는 것이 표준적입니다[cite: 118, 119].

1. **클라이언트 요청 (Web Browser)**: HTTP 요청 전송[cite: 120].
2. **Controller (제어 계층)**: URL 매핑, 파라미터 수집, Service 호출 후 결과 데이터(DTO)와 View 반환[cite: 120].
3. **Service (서비스 계층)**: 비즈니스 로직 처리, 트랜잭션 관리, Repository 호출 및 데이터 가공[cite: 120].
4. **Repository (영속 계층)**: JPA 인터페이스 기반으로 DB 접근 및 쿼리 실행[cite: 120].
5. **JPA (Hibernate) & DB**: 객체-관계 맵핑(ORM) 처리 후 MySQL에서 실제 SQL 쿼리 실행[cite: 120].

---

## 5. 계층별 핵심 코드 구현

### 1) Entity 클래스 (`TestDB.java` - Domain)

- DB 테이블과 매핑되는 핵심 데이터 객체입니다[cite: 121].
- `@Entity`: JPA가 관리하는 엔티티 클래스임을 명시[cite: 121].
- `@Table(name = "testdb")`: 실제 매핑될 DB 테이블 이름 지정[cite: 121].
- `@Id`: 테이블의 기본키(PK) 지정[cite: 121].
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`: DB의 Auto Increment 방식을 따라 자동 번호 할당[cite: 121].
- `@Column`: 컬럼 속성 설정 (예: `nullable = true`)[cite: 121].

### 2) Repository 인터페이스 (`TestRepository.java`)

- `@Repository` 어노테이션으로 스프링 빈(Bean)에 등록[cite: 122].
- `extends JpaRepository<TestDB, Long>`: 기본키 타입이 Long인 TestDB 엔티티의 기본 CRUD 연산(`findAll()`, `findById()`, `save()`, `deleteById()` 등)을 상속받아 자동 제공받음[cite: 122, 128].

### 3) Service 클래스 (`TestService.java`)

- `@Service` 어노테이션으로 서비스 계층 등록[cite: 123].
- `@Autowired`를 통해 `TestRepository` 인스턴스를 의존성 주입(DI) 받아 호출[cite: 123].

### 4) Controller 클래스 (`DemoController.java`)

- `@Autowired`로 `TestService`를 주입받음[cite: 124].
- 데이터를 조회한 뒤 `model.addAttribute("속성명", 데이터)`를 통해 Thymeleaf 템플릿(View)으로 전달[cite: 124].

---

## 6. Thymeleaf 반복문 처리

- 다수의 사용자 데이터(List)를 화면에 렌더링할 때 **`th:each`** 문법을 사용합니다[cite: 129].
- 예시: `<tr th:each="user : ${users}">` 구문을 통해 전달받은 `${users}` 리스트 항목 수만큼 `<tr>` 태그를 반복 생성하고 내부 변수(`user.id`, `user.name`)를 출력합니다[cite: 129].

</details>

<details>
<summary><b>5주차</b></summary>

<br>

## 1. 웹 보안 기초 및 암호화

### 1) 주요 웹 보안 개념

- **OWASP Top 10 (2025)**: 웹 애플리케이션의 주요 보안 위험 중 해킹의 주된 시작점은 'A01 접근 제어 실패(Broken Access Control)'와 'A07 인증 실패(Authentication Failures)'입니다[cite: 136].
- **인증(Authentication) vs 인가(Authorization)**: 인증은 사용자의 신원을 확인("너 누구야?")하는 로그인 과정이며, 인가는 해당 사용자의 권한을 확인("너 이거 해도 돼?")하는 접근 제어 과정입니다[cite: 136].

### 2) 비밀번호 저장 방식 (BCrypt)

- 비밀번호는 평문 저장이 금지되어 있으며, 복호화가 불가능한 일방향 암호화(해시)를 사용해야 합니다[cite: 137].
- **BCrypt 특징**:
  - 매번 무작위 Salt(22자)를 자동 생성하여 결합하므로, 동일한 비밀번호라도 해시 결과(60자)가 항상 다르게 생성됩니다[cite: 137].
  - MD5나 SHA-256과 달리 암호화 연산 속도를 의도적으로 늦추어 무차별 대입 공격(Brute-force)을 효과적으로 방어합니다[cite: 137].

---

## 2. 스프링 시큐리티(Spring Security) 동작 원리

### 1) 로그인 방식 및 세션

- 전통적인 웹 사이트는 서버가 로그인을 저장하고 브라우저 쿠키에 `JSESSIONID`를 발급하는 세션(Session) 방식을 사용합니다 (이후 토큰, 소셜, 패스키 방식으로 발전)[cite: 138].

### 2) 시큐리티 필터 체인 (Security FilterChain)

- 요청이 컨트롤러(`@Controller`)에 도달하기 전, 여러 보안 필터가 체인처럼 연결되어 검사를 수행합니다[cite: 144].
- **주요 흐름**: `CsrfFilter` (토큰 검사) $\rightarrow$ `UsernamePasswordAuthenticationFilter` (POST /login 처리) $\rightarrow$ `LogoutFilter` (POST /logout 처리) $\rightarrow$ `AuthorizationFilter` (권한 검사) $\rightarrow$ `DispatcherServlet`[cite: 144].
- 통과에 실패하면 로그인 화면으로 리다이렉트(302) 되거나 접근이 거부(403)됩니다[cite: 144].

### 3) 로그인 검증 흐름

1. 클라이언트(브라우저) POST 요청[cite: 145].
2. 시큐리티 필터 및 Provider를 거쳐 `MemberService`의 `loadUserByUsername()` 호출[cite: 145].
3. `MemberRepository`를 통해 DB에서 회원 조회[cite: 145].
4. **비밀번호 비교**: `PasswordEncoder.matches(입력 비번, DB 해시)`를 통해 비밀번호 일치 여부를 검증[cite: 145].
   - _보안 요소_: `matches()`는 고정 시간 비교를 사용하여 타이밍 공격(Timing Attack)을 방어하며, 비밀번호 비교 및 세션 저장은 시큐리티가 자동으로 수행합니다[cite: 155].

---

## 3. 백엔드 핵심 코드 구현

### 1) 보안 설정 클래스 (`SecurityConfig.java`)

- `@Configuration`과 `@EnableWebSecurity` 어노테이션으로 스프링 시큐리티를 활성화합니다[cite: 146].
- **`PasswordEncoder` 빈 등록**: 비밀번호 암호화를 위해 `BCryptPasswordEncoder` 객체를 등록합니다[cite: 146].
- **`SecurityFilterChain` 빈 등록**:
  - `authorizeHttpRequests`: URL별 접근 규칙을 설정하며, 위에서부터 순서대로 검사합니다. 정적 리소스나 로그인/가입 페이지는 `permitAll()`로 허용하고, 나머지는 `authenticated()`로 로그인 상태를 요구합니다[cite: 146, 147].
  - `formLogin`: 사용자 정의 로그인 페이지 URL, 성공/실패 시 이동할 URL을 지정합니다[cite: 146].
  - `logout`: POST 요청을 통한 로그아웃을 처리하며, 성공 시 이동 URL 설정, 세션 완전 삭제(`invalidateHttpSession`), `JSESSIONID` 쿠키 삭제를 수행합니다[cite: 158].

### 2) 데이터 객체 분리 (Entity vs DTO)

- **분리 목적**: 화면에서 전달되는 데이터와 DB 필드가 다를 수 있으며, 사용자가 임의로 권한(`role`) 필드를 조작하여 전송하는 보안 취약점을 방지하기 위해 분리합니다[cite: 151].
- **`Member` (엔티티)**: DB 테이블과 맵핑되며 `id`, `username`(unique), `password`, `name`, `role` 필드를 가집니다[cite: 149].
- **`MemberForm` (DTO)**: 회원가입 화면과 컨트롤러 간 데이터 교환에 사용되며 확인용 비밀번호 필드를 추가로 가집니다[cite: 151].

### 3) 서비스 계층 (`MemberService.java`)

- **회원 가입 (`signup`)**:
  - 아이디 중복을 검사하고, 입력받은 비밀번호를 `passwordEncoder.encode()`로 해시 암호화하여 저장합니다[cite: 152].
  - 서버 로직 내에서 기본 권한(`USER`)을 강제로 셋팅하여 DB에 `save` 합니다[cite: 152].
- **로그인 연동 (`UserDetailsService` 구현)**:
  - 스프링 시큐리티가 요구하는 `UserDetailsService` 인터페이스를 구현하고 `loadUserByUsername()` 메서드를 오버라이딩합니다[cite: 154].
  - DB에서 사용자를 조회한 후 시큐리티 전용 객체인 `UserDetails` (`User.builder()`)로 변환하여 반환하면, 이후의 비밀번호 검증 처리는 시큐리티가 전담합니다[cite: 154, 155].

</details>

<details>
<summary><b>6주차</b></summary>

<br>

## 1. 웹 보안 트렌드 및 접근 제어 모델

### 1) 접근 제어 실패 (Broken Access Control)

- **OWASP Top 10 (2025) A01**: 로그인은 수행했으나 권한 검사(인가)를 누락하여 발생하는 가장 대표적인 취약점입니다[cite: 166].
- **주요 피해 사례**: URL 조작을 통한 남의 정보 조회(IDOR), 관리자 페이지 직접 접근, 요청 조작을 통한 권한 상승 등이 있습니다[cite: 166, 182].
- **핵심 원칙**: "화면의 메뉴를 숨기는 것은 보안이 아니다"라는 점을 명심하고, 모든 요청마다 권한을 검사해야 합니다[cite: 166].

### 2) 권한 관리 모델

- **RBAC (Role-Based Access Control)**: 사람에게 직접 권한을 주지 않고, 역할(Role)을 부여하여 관리를 쉽게 하는 방식입니다 (예: `USER`, `MANAGER`, `ADMIN`)[cite: 167].
- **ABAC (Attribute-Based Access Control)**: 부서, 시간, 위치 등 속성 조건을 기반으로 권한을 제어하는 방식입니다[cite: 167].
- **최소 권한 원칙 (Least Privilege)**: 해킹 시 피해를 최소화하기 위해 사용자에게 꼭 필요한 권한만 부여해야 합니다[cite: 167, 168].

---

## 2. 스프링 시큐리티 권한(Role) 기초 개념

### 1) `ROLE_` 접두사 자동 적용

- 스프링 시큐리티 내부에서는 권한 식별을 위해 `ROLE_` 접두사를 자동으로 붙여 비교합니다[cite: 175].
- 설정 클래스나 화면에서 `hasRole("ADMIN")`이라고 작성하면 정상 동작하지만, `hasRole("ROLE_ADMIN")`이라고 작성하면 서버 시작 시 에러(`should not start with ROLE_`)가 발생합니다[cite: 175, 190].

### 2) DB 권한과 세션 권한의 동기화

- 로그인하는 순간 DB의 권한 정보가 시큐리티 세션(`SecurityContextHolder`)에 복사됩니다[cite: 176].
- 이후 DB에서 관리자가 권한을 `ADMIN`으로 변경하더라도, 기존 세션에는 여전히 `[ROLE_USER]`로 남아있게 됩니다[cite: 176, 181].
- **해결**: 권한이 변경된 사용자는 반드시 다시 로그인해야 새로운 권한이 세션에 반영됩니다[cite: 176].

---

## 3. 철저한 접근 제어 3단계 (이중 잠금)

단순히 화면에서 메뉴를 숨기는 것(1단계)만으로는 URL 강제 접속을 막을 수 없으므로, URL 제어(2단계)와 메서드 제어(3단계)를 통한 이중 잠금이 필수적입니다[cite: 183, 184].

1. **화면 제어 (`sec:authorize`)**: Thymeleaf 템플릿에서 조건에 따라 메뉴 버튼을 보이거나 숨깁니다 (안내판 떼기 역할일 뿐, 실제 차단 효과는 없음)[cite: 184].
2. **URL 제어 (`requestMatchers`)**: `SecurityConfig`에서 URL 패턴을 검사하여 컨트롤러에 도착하기 전(`AuthorizationFilter`)에 요청을 차단합니다 (1차 잠금)[cite: 184, 186].
3. **메서드 제어 (`@PreAuthorize`)**: 비즈니스 로직(Service)의 메서드 실행 직전에 한 번 더 차단합니다 (2차 잠금)[cite: 184, 187].
   - _이중 잠금이 필요한 이유_: URL 패턴 작성 시 오타, 순서 실수, URL을 거치지 않는 내부 호출(스케줄러 등), URL로 표현 불가능한 세밀한 조건(IDOR) 방어를 위해 필요합니다[cite: 188].

---

## 4. 백엔드 주요 코드 구현 로직

### 1) 설정 계층 (`SecurityConfig.java`)

- `@EnableMethodSecurity`: `@PreAuthorize`를 통한 메서드 수준의 보안 검사를 활성화합니다[cite: 187].
- **URL 권한 규칙 선언**: `.requestMatchers("/admin/**").hasRole("ADMIN")`을 통해 하위 경로 전체를 관리자 전용으로 제한합니다[cite: 184].
- **규칙 순서**: 구체적인 규칙(`/admin/**`)이 반드시 포괄적인 규칙(`anyRequest()`)보다 위에 위치해야 합니다[cite: 184, 188].

### 2) 제어 계층 (`MemberController.java` & `AdminController.java`)

- **IDOR 방어 (`/mypage`)**: 파라미터로 회원 번호(`?id=3`)를 받지 않고, `Principal` 객체를 통해 현재 로그인한 세션 사용자의 아이디(`principal.getName()`)를 가져와 본인 정보만 조회합니다[cite: 174].
- **PRG 패턴 (`POST /admin/members/{id}/role`)**: 상태를 변경하는 POST 요청 후, 새로고침 시 중복 전송을 막기 위해 `RedirectAttributes.addFlashAttribute`를 사용하여 메시지를 담고 리다이렉트합니다[cite: 180].

### 3) 서비스 계층 (`MemberService.java`)

- **화이트리스트 검증**: `List.of("USER", "ADMIN")`을 선언하고 `.contains()`로 확인하여, 브라우저 개발자 도구 등으로 조작된 권한 값(`SUPER` 등)이 넘어오는 것을 원천 차단합니다[cite: 179].
- `@PreAuthorize("hasRole('ADMIN')")`: 권한 변경 및 회원 삭제 메서드 상단에 부착하여 관리자만 실행 가능하도록 통제합니다[cite: 187].

---

## 5. 403 권한 거부 및 표현식 요약

### 1) `403 Forbidden` 처리

- 인증(로그인)은 성공했으나, 인가(권한 검사)에 실패했을 때 `AuthorizationFilter`에 의해 발생합니다[cite: 185, 186].
- 403 예외가 발생하면 스프링 부트가 `templates/error/403.html` 파일을 찾아 자동으로 렌더링합니다[cite: 186].

### 2) 시큐리티 권한 표현식(SpEL) 요약

| 표현식                                          | 의미                                  | 사용 예시                                                |
| :---------------------------------------------- | :------------------------------------ | :------------------------------------------------------- |
| **`permitAll()`**                               | 누구나 접근 가능                      | 메인 화면, 로그인/가입 화면, 정적 리소스[cite: 147, 189] |
| **`authenticated()`** / **`isAuthenticated()`** | 로그인한 사용자만 접근                | 내 정보 페이지 (`/mypage`)[cite: 189]                    |
| **`isAnonymous()`**                             | 로그인하지 않은 사용자만 접근         | 헤더의 로그인 버튼 출력 조건[cite: 189]                  |
| **`hasRole('ADMIN')`**                          | `ROLE_ADMIN` 권한을 보유한 사용자     | 관리자 페이지 (`/admin/**`)[cite: 189]                   |
| **`hasAnyRole('ADMIN', 'MANAGER')`**            | 나열된 권한 중 하나라도 보유          | 여러 관리 등급 접근 허용 시[cite: 189]                   |
| **`authentication.name`**                       | 현재 로그인한 사용자의 식별자(아이디) | 화면 상단 "OOO님" 렌더링 시[cite: 189]                   |

</details>

<details>
<summary><b>7주차</b></summary>

<br>

## 1. 웹 렌더링 트렌드와 API의 개념

### 1) API (Application Programming Interface)

- 프로그램끼리 데이터(JSON)를 주고받는 약속(Request-Response)입니다[cite: 197].
- 서버가 화면을 그리지 않고 데이터만 제공하므로, 웹, 모바일 앱, 스마트워치, AI 챗봇 등 다양한 클라이언트와 1:N 연동이 가능합니다[cite: 197].

### 2) SSR vs CSR

- **SSR (Server-Side Rendering)**: 기존 방식으로, 백엔드(서버)가 Thymeleaf 등을 사용해 HTML을 완성하여 브라우저에 전송합니다[cite: 198].
- **CSR (Client-Side Rendering)**: 최신 트렌드로, 서버는 순수 JSON 데이터(REST API)만 전송하고, React나 Vue 같은 프론트엔드 앱이 직접 화면을 렌더링합니다[cite: 198].

---

## 2. REST API와 JSON

### 1) REST 설계 원칙

- API 설계 방식으로, **주소(URL)는 대상(무엇을)**을 나타내고, **HTTP 메서드는 행위(어떻게)**를 나타냅니다[cite: 199, 214].
- **주요 HTTP 메서드**[cite: 199, 214]:
  - `GET`: 데이터 조회
  - `POST`: 데이터 생성
  - `PATCH`: 데이터 일부 수정 (cf. `PUT`은 전체 교체)
  - `DELETE`: 데이터 삭제

### 2) JSON (JavaScript Object Notation)

- 데이터를 요청하고 응답하는 표준 형식입니다[cite: 199].
- 객체는 `{}` (중괄호), 배열은 `[]` (대괄호)로 표현되며, `"키": 값` 형태로 구성됩니다[cite: 204].

---

## 3. Spring Boot의 API 어노테이션

### 1) `@RestController` vs `@Controller`

- **`@Controller`**: 뷰(View) 템플릿의 경로 문자열(HTML 이름)을 반환하여 브라우저에 렌더링합니다[cite: 204].
- **`@RestController`**: 반환하는 자바 객체를 JSON 데이터로 자동 변환하여 앱이나 JS 등에 응답합니다[cite: 204]. (`@Controller` + `@ResponseBody`의 결합형)[cite: 204].

### 2) `@RequestBody`

- HTTP 요청 본문(Body)에 담긴 JSON 데이터를 자바 객체(DTO)로 변환하여 매핑합니다[cite: 218].

---

## 4. DTO 분리와 응답 보안 (정보 노출 방지)

### 1) 엔티티 객체의 직접 반환 위험성

- `Member` 엔티티 객체를そのまま 반환하면 내부에 있는 비밀번호 해시값(`$2a$10$...`)까지 모두 JSON으로 유출되어 심각한 보안 위험이 발생합니다[cite: 206, 207].

### 2) 역할에 따른 객체 분리

- **`Member` (엔티티)**: DB 저장용 객체로 모든 필드(비밀번호 포함)를 가집니다[cite: 207, 208].
- **`MemberForm` (요청 DTO)**: 사용자로부터 들어오는 데이터용으로, 권한(`role`) 조작 등을 방지합니다[cite: 208].
- **`MemberResponse` (응답 DTO)**: 서버에서 사용자에게 나가는 데이터용으로, 노출할 필드(id, 아이디, 이름, 권한)만 담아 정보 유출을 차단합니다 (자바 16의 `record`로 구현 가능)[cite: 208, 209].

---

## 5. HTTP 상태 코드 및 Postman API 테스트

### 1) 주요 HTTP 상태 코드 (`ResponseEntity` 응답)

API의 성공/실패 여부는 화면이 아닌 상태 코드로 판단합니다[cite: 199, 215].

- **200 OK**: 성공 (조회, 수정)[cite: 215]
- **201 Created**: 새로운 리소스 생성 완료 (등록 성공)[cite: 215]
- **204 No Content**: 성공했으나 돌려줄 본문 내용 없음 (삭제 성공)[cite: 215]
- **400 Bad Request**: 잘못된 요청 (빈 값, 중복 등)[cite: 215]
- **401 Unauthorized**: 인증 실패 (로그인 정보 없음)[cite: 215]
- **403 Forbidden**: 인가 실패 (권한 없음)[cite: 215]
- **404 Not Found**: 대상을 찾을 수 없음[cite: 215]

### 2) Postman과 인증 방식 (Basic vs Session)

- **브라우저 (세션 인증)**: 최초 1회 로그인 후, 자동으로 브라우저가 쿠키(`JSESSIONID`)를 전송합니다[cite: 212].
- **Postman/앱 (Basic 인증)**: 쿠키가 없으므로 API를 호출할 때마다 `Authorization` 헤더에 인증 정보(아이디:비밀번호)를 함께 보내야 합니다[cite: 211, 212, 223].
- _주의_: Basic 인증은 암호화가 아닌 단순 Base64 인코딩이므로 실서비스에서는 반드시 HTTPS 환경에서 사용해야 합니다[cite: 212].

---

## 6. 전역 예외 처리 (오류 모으기)

- API의 각 컨트롤러 메서드마다 반복되는 `try-catch` 블록(예: 400 예외 처리)을 제거할 수 있습니다[cite: 227].
- **`@RestControllerAdvice`**와 **`@ExceptionHandler`**를 결합하여, 애플리케이션 전역에서 발생하는 특정 예외(예: `IllegalArgumentException`)를 한 곳에서 일괄적으로 400 JSON 에러 응답으로 처리합니다[cite: 227].

</details>

<details>
<summary><b>9주차</b></summary>

<br>

## 1. 게시판 기본 개념 및 보안 트렌드

### 1) 게시판과 CRUD

- **CRUD**: 웹 서비스의 가장 기본이 되는 Create(쓰기), Read(읽기), Update(수정), Delete(삭제) 기능입니다.
- **게시판의 필수 요소**: 누가 썼는지(작성자 연결), 내 글만 고칠 수 있는지(권한 확인), 없는 글 접근 시 안내 화면(404) 처리가 필수입니다.
- **HTML 폼과 URL 설계**: `@Controller` 기반 SSR 화면의 HTML `<form>`은 `GET`과 `POST`만 지원하므로, 수정(`POST /board/{id}/edit`)과 삭제(`POST /board/{id}/delete`)도 주소 끝에 행위를 붙여 POST로 처리합니다.

### 2) 게시판 보안과 접근 제어 발전

- **무단 수정·삭제 취약점**: 화면에서 수정·삭제 버튼을 숨기더라도 주소창에 `/board/2/edit`을 직접 입력해 접근할 수 있습니다 (OWASP A01 접근 제어 실패).
- **서버 측 본인 확인 필수**: URL 규칙만으로는 글의 주인을 판별할 수 없으므로, 서비스 계층에서 DB의 작성자와 로그인 사용자를 직접 비교해야 합니다.

| 주차      | 기준          | 질문                 | 실패 시 처리                           |
| :-------- | :------------ | :------------------- | :------------------------------------- |
| **5주차** | 로그인 (인증) | 누구세요?            | 비로그인 $\rightarrow$ 로그인 화면     |
| **6주차** | 역할 (`ROLE`) | 관리자인가요?        | `USER` $\rightarrow$ 관리자 페이지 403 |
| **9주차** | 주인 (작성자) | 이 글을 쓴 사람인가? | 남의 글 수정·삭제 $\rightarrow$ 403    |

---

## 2. 게시글 엔티티 및 연관관계 (`Post.java`)

- **`posts` 테이블 매핑**: `id`(PK), `title`(최대 100자), `content`(`TEXT`), `createdAt`, `updatedAt`, `viewCount` 필드로 구성됩니다.
- **작성자 연결 (`@ManyToOne`)**:
  - 회원 1명이 여러 글을 작성하므로 게시글 기준 N:1(`@ManyToOne(fetch = FetchType.LAZY)`) 관계를 맺고 `@JoinColumn(name = "member_id", nullable = false)`로 외래 키(FK)를 연결합니다.
  - 아이디 문자열만 저장하지 않고 `Member` 객체를 참조함으로써 `post.getAuthor().getName()`으로 최신 회원 정보를 바로 조회하고, DB 외래 키로 데이터 정합성을 보장합니다.
  - `FetchType.LAZY`(지연 로딩)를 사용해 작성자 정보가 실제로 필요할 때만 조회하여 불필요한 쿼리를 줄입니다.

---

## 3. 게시판 CRUD 및 본인 확인 구현

### 1) DTO 및 리포지토리

- **`PostForm` (DTO)**: 제목(`title`)과 내용(`content`)만 입력받고 작성자(`author`)는 받지 않습니다. 작성자는 서버에서 로그인 정보(`Principal`)로 직접 지정하여 작성자 조작을 차단합니다.
- **`PostRepository`**: `JpaRepository<Post, Long>`을 상속받아 기본 CRUD 메서드를 사용합니다.

### 2) 서비스 계층 (`PostService.java`)

- **글쓰기 (`write`) / 수정 (`edit`)**: JPA `save()`는 `id`가 없으면 `INSERT`, 있으면 `UPDATE`를 수행합니다. 제목·내용 빈 값 및 100자 제한 검증(`validate`)을 거칩니다.
- **상세 조회 (`findById`)**: 존재하지 않는 글 번호 요청 시 `ResponseStatusException(HttpStatus.NOT_FOUND)`를 발생시켜 `templates/error/404.html`을 렌더링합니다.
- **본인 확인 (이중 확인)**:
  - `checkWriter(Post)`: `SecurityContextHolder`에서 로그인 아이디를 꺼내 글 작성자와 다르면 `AccessDeniedException`(403)을 발생시킵니다.
  - 수정(`findForEdit`, `edit`)은 본인만 가능하고, 삭제(`delete`)는 본인 또는 관리자(`isAdmin()` - `ROLE_ADMIN`)만 가능합니다.

### 3) 컨트롤러 및 보안 설정

- **`BoardController`**: `@RequestMapping("/board")` 기반으로 목록, 상세, 글쓰기, 수정, 삭제를 처리하며, `board/form.html`은 `postId` 유무에 따라 글쓰기/수정 모드로 공용 사용합니다.
- **`SecurityConfig`**: `.requestMatchers("/board", "/board/{id:\\d+}").permitAll()`로 목록과 숫자 ID 상세 조회만 비로그인 허용하고, `/board/write` 등은 로그인을 요구합니다.

---

## 4. 9주차 연습문제 구현

- **조회수 증가**: `PostService.read(id)`에서 상세 화면 진입 시 `viewCount`를 1 증가시켜 저장하도록 구현했습니다.
- **내가 쓴 글 모아보기**: `PostRepository`에 `findByAuthor_UsernameOrderByIdDesc(String username)`를 추가하고, `GET /board/my` 요청 시 로그인한 회원의 글만 최신순으로 `board/list.html`을 재사용해 출력합니다.

</details>

<details>
<summary><b>10주차</b></summary>

<br>

## 1. 페이징, 검색, 댓글 트렌드

- **페이징 방식**: 페이지 번호 방식(게시판·검색 결과), 더보기 버튼(댓글), 무한 스크롤(SNS 피드) 중 게시판에 적합한 **페이지 번호 방식**을 적용합니다.
- **검색 방식**: 소규모 게시판은 DB `LIKE` 쿼리로 구현하며, 규모가 커지면 전문 검색(`FULLTEXT`)이나 전용 검색 엔진(Elasticsearch)을 도입합니다.

---

## 2. 페이징 구현 (`Pageable` & `Page`)

### 1) 요청과 응답 구조

- **`PageRequest.of(page, size, sort)`**: 0부터 시작하는 페이지 번호(`Math.max(page, 0)`), 페이지당 개수(10개), 정렬 기준(`Sort.by(DESC, "id")`)을 전달합니다.
- **`Page<Post>`**: 이번 페이지의 글 목록(`getContent()`), 현재 페이지(`getNumber()`), 전체 페이지 수(`getTotalPages()`), 전체 글 수(`getTotalElements()`), 첫/마지막 페이지 여부(`isFirst()`, `isLast()`)를 함께 반환합니다.

### 2) 페이징 SQL과 `Page` vs `Slice`

- `Page`는 데이터 조회(`LIMIT ? OFFSET ?`)와 전체 개수 조회(`SELECT count(...)`) 쿼리를 2번 실행합니다.
- 뒤쪽 페이지일수록 `OFFSET`이 커져 느려지는 약점이 있으며, 대용량 서비스에서는 키셋 페이징(`WHERE id < 마지막id`)이나 `count` 쿼리가 없는 `Slice`(더보기/무한 스크롤용)를 활용합니다.

---

## 3. 검색 구현 (JPQL & 파라미터 바인딩)

- **JPQL (`@Query`)**: 메서드 이름이 길어지는 복잡한 조건을 엔티티와 필드 이름 기준으로 작성합니다.
  - 예: `@Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")`
- **SQL 인젝션 방어**: 문자열 이어 붙이기 대신 `:keyword` 파라미터 바인딩(`like ?`)을 사용하여 `' OR 1=1` 같은 입력도 단순 문자열 값으로 처리합니다.
- **상태 유지**: HTTP는 무상태(Stateless)이므로 컨트롤러에서 `@RequestParam(required = false) String keyword`를 받아 모델에 다시 넘겨 검색창과 페이지 이동 링크(`/board?page=1&keyword=...`)에 유지합니다.

---

## 4. 댓글 기능 및 PRG 패턴

### 1) 댓글 엔티티와 지연 로딩 (`Comment.java`)

- `comments` 테이블에 매핑되며 `post_id`(`@ManyToOne Post post`)와 `member_id`(`@ManyToOne Member author`) 외래 키 2개를 가집니다.
- `@ManyToOne`의 기본값은 즉시 로딩(`EAGER`)이므로 `fetch = FetchType.LAZY`로 명시하여, 실제 작성자 이름 등을 사용할 때 프록시가 DB를 조회하도록 합니다.

### 2) 댓글 CRUD와 PRG 패턴

- **`CommentController`**: `@RequestMapping("/board/{postId}/comments")` 경로로 댓글 작성(`POST`) 및 삭제(`POST /{id}/delete`, 본인 또는 관리자)를 처리합니다.
- **PRG (Post-Redirect-Get) 패턴**: 댓글 등록 후 화면을 바로 반환하지 않고 `redirect:/board/{postId}#comments`로 리다이렉트하여, F5 새로고침 시 댓글이 중복 등록되는 현상을 방지합니다.

---

## 5. 연관 데이터 삭제 정리 및 N+1 문제

외래 키 참조 무결성 때문에 연관 데이터가 있는 글이나 회원을 삭제하면 500 오류가 발생하므로, 데이터 성격에 따라 처리 방식을 분리합니다.

| 삭제 대상           | 연관 데이터      | 선택 방식                 | 구현 방법                                                                                                                        |
| :------------------ | :--------------- | :------------------------ | :------------------------------------------------------------------------------------------------------------------------------- |
| **게시글 (`Post`)** | 댓글 (`Comment`) | **함께 삭제 (`cascade`)** | `Post`에 `@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)` 및 `@ToString.Exclude`, `@EqualsAndHashCode.Exclude` 추가 |
| **회원 (`Member`)** | 글·댓글          | **삭제 막기**             | `MemberService.deleteMember()`에서 `existsByAuthor(member)` 검사 후 `IllegalArgumentException` 발생 (화면 안내 / API 400)        |

- **N+1 문제**: 목록 1페이지(10개 글) 조회 시 글마다 댓글 수(`post.comments.size()`)를 그리기 위해 댓글 조회 SQL이 N번 추가 실행되는 현상입니다. 실무에서는 `fetch join`, `@BatchSize`, 댓글 수 별도 컬럼 등으로 해결합니다.

---

## 6. 10주차 연습문제 구현

- **내가 쓴 글 페이징**: `PostRepository.findByAuthor_Username(String username, Pageable pageable)`을 추가하고, `GET /board/my?page=0`에서 `page`와 `pageUrl("/board/my")`를 넘겨 10개씩 페이징 처리했습니다.
- **작성자로 검색**: `PostRepository.searchByWriter` JPQL(`p.author.name LIKE %:name%`)을 추가하고, 컨트롤러에서 `type`(`title_content` / `writer`) 파라미터를 받아 검색 범위를 선택·유지하도록 구현했습니다.

</details>

<details>
<summary><b>11주차</b></summary>

<br>

## 1. 모집글 확장 및 파일 업로드 (포스터)

### 1) `Post` 엔티티 확장

- 별도 테이블을 만들지 않고 `Post`에 `capacity`(정원, `null`이면 일반 글), `appliedCount`(신청 인원), `posterFile`(저장 파일명) 필드를 추가했습니다.
- 남은 자리는 DB에 저장하지 않고 `isRecruit()`, `isFull()`, `getRemaining()` 메서드로 계산하여 Thymeleaf(`${post.recruit}`, `${post.full}`, `${post.remaining}`)에서 사용합니다.

### 2) 파일 업로드 및 보안 4원칙 (`FileStore.java`)

- HTML 폼에 `enctype="multipart/form-data"`를 설정하고, `PostForm`에서 `MultipartFile poster`로 파일 조각을 수신합니다.
- **업로드 보안 4원칙 (OWASP 권고)**:
  1. **확장자 허용 목록**: `jpg`, `jpeg`, `png`, `gif`, `webp`만 허용
  2. **파일 내용 검사**: 확장자·Content-Type 위조를 막기 위해 파일 앞부분 바이트(매직 넘버)로 실제 이미지인지 검증
  3. **서버 측 파일명 생성**: 덮어쓰기 및 경로 조작(`../`) 방지를 위해 `UUID`로 파일명 재생성
  4. **별도 폴더 저장**: `static/` 대신 프로젝트 외부 `uploads/` 폴더에 저장하고 `.gitignore`에 추가
- **이미지 노출 및 용량 제한**:
  - `WebConfig`(`WebMvcConfigurer`)에서 `/uploads/**` 요청을 `file:uploads/` 경로에 매핑하고, `SecurityConfig`에서 `/uploads/**`를 `permitAll()`로 허용합니다.
  - `application.properties`에 `spring.servlet.multipart.max-file-size=5MB`, `max-request-size=10MB`를 설정합니다 (초과 시 `413.html`).

---

## 2. 신청 바구니 (`HttpSession`)

- **세션 바구니**: 확정 전 임시 목록을 서버 메모리 세션(`HttpSession`)에 모집글 번호(`LinkedHashSet<Long>`)로 보관하여 중복을 막고 담은 순서를 유지합니다.
- **`CartController`**: `@RequestMapping("/cart")` 기반으로 바구니 조회(`GET /cart`), 담기(`POST /cart/{postId}`), 빼기(`POST /cart/{postId}/remove`)를 처리하며, `PostService.findAllById()`로 담은 글 목록을 한 번에 조회합니다.

---

## 3. 신청 확정과 트랜잭션 (`@Transactional`)

### 1) 신청 내역 구조

- **`Enrollment` 엔티티 (`enrollments` 테이블)**: 신청 회원(`member_id`), 모집글(`post_id`), 신청 시간(`createdAt`)을 저장합니다.
- **`EnrollmentRepository`**: 중복 신청 확인(`existsByMemberAndPost`) 및 내 신청 내역 조회(`findByMember_UsernameOrderByIdDesc`) 메서드를 제공합니다.

### 2) 트랜잭션(ACID)과 `@Transactional`

- **문제 상황**: 바구니에 B, C가 담긴 상태에서 `@Transactional` 없이 확정하면, B는 `save()`마다 개별 커밋되어 DB에 남고 C에서 정원 마감 예외가 발생하는 **부분 성공 사고**가 발생합니다.
- **해결**: `EnrollmentService.confirm()`에 `@Transactional`을 적용해 모든 신청 내역 `INSERT`와 인원 증가 `UPDATE`를 하나의 작업 단위로 묶습니다. 하나라도 예외가 발생하면 전체 롤백되어 원자성(Atomicity)을 보장합니다.
- **프록시와 실무 함정**:
  - 스프링은 서비스 앞에 프록시 객체를 세워 트랜잭션을 관리합니다.
  - 기본 롤백 대상은 `RuntimeException`/`Error`(체크 예외는 커밋), 내부 `try-catch`로 예외를 삼키면 롤백 안 됨, 같은 클래스 내 `this` 호출은 프록시를 거치지 않음, DB 외 파일 저장 등은 롤백되지 않음에 주의해야 합니다.
- **변경 감지 (Dirty Checking)**: `@Transactional` 안에서 조회한 영속 엔티티의 값을 변경하면 별도의 `save()` 호출 없이도 커밋 시점에 자동으로 `UPDATE` SQL이 실행됩니다.
- **Flash 메시지**: `CartController.confirm()`에서 `RedirectAttributes.addFlashAttribute()`를 사용해 리다이렉트 후 1회성 성공/실패 메시지를 전달합니다.

---

## 4. 11주차 연습문제 구현

- **신청 취소 (`POST /cart/enrollments/{id}/cancel`)**:
  - `cart.html` 취소 버튼 활성화 및 `EnrollmentService.cancel()` 구현.
  - `@Transactional` 내에서 본인 신청인지 검증(타인 요청 시 403 `AccessDeniedException`), `save()` 없이 변경 감지로 `appliedCount - 1`, 신청 내역 삭제를 한 묶음으로 처리했습니다.
- **삭제 정리**:
  - `EnrollmentRepository`에 `existsByPost`, `existsByMember` 추가.
  - 신청자가 있는 모집글 삭제 시 `PostService.delete()`에서 예외 발생 후 `?deleteError`로 리다이렉트하여 차단하고, 신청자가 없는 글 삭제 시 `fileStore.delete()`로 포스터 파일도 함께 삭제했습니다.
  - `MemberService.deleteMember()`에서 신청 내역이 있는 회원 삭제도 차단하도록 보완했습니다.

</details>

<details>
<summary><b>12주차</b></summary>

<br>

## 1. 실시간 웹과 WebSocket / STOMP

### 1) HTTP vs WebSocket 및 실시간 방식 비교

- 기존 HTTP는 브라우저가 요청해야만 서버가 응답하지만, **WebSocket**은 최초 1회 HTTP 업그레이드(`101 Switching Protocols`) 후 연결을 유지해 서버가 먼저 브라우저에 데이터를 보낼 수 있습니다.

| 방식                 | 동작                                      | 장점              | 단점                                  |
| :------------------- | :---------------------------------------- | :---------------- | :------------------------------------ |
| **폴링 (Polling)**   | 주기적으로 서버에 요청                    | 구현이 단순함     | 대부분 헛걸음, 실시간성 떨어짐        |
| **롱 폴링**          | 변경 시까지 응답 대기                     | 폴링보다 빠름     | 매번 연결을 다시 맺어야 함            |
| **SSE**              | 서버 $\rightarrow$ 브라우저 단방향 스트림 | 간단, 자동 재연결 | 양방향 통신 불가                      |
| **WebSocket (적용)** | 1회 연결 후 양방향 유지                   | 빠르고 가벼움     | 연결 관리 및 다중 서버 확장 고민 필요 |

### 2) STOMP 메시징 구조

- WebSocket 위에서 구독(Subscribe)과 발행(Publish) 규칙을 정하는 프로토콜입니다.
- **`/topic/seats`**: `convertAndSend()`로 구독한 모든 사용자(비로그인 포함)에게 남은 자리 갱신 메시지를 전송합니다.
- **`/user/queue/notifications`**: `convertAndSendToUser()`로 특정 로그인 아이디의 사용자에게만 개인 알림을 전송합니다.

---

## 2. WebSocket 설정 및 메시지 DTO

- **설정**: `pom.xml`에 `spring-boot-starter-websocket` 의존성을 추가하고, `WebSocketConfig`(`@EnableWebSocketMessageBroker`)에서 엔드포인트(`/ws`)와 브로커(`/topic`, `/queue`, `/user`)를 등록합니다. `SecurityConfig`에서 `/ws` 경로를 `permitAll()`로 개방합니다.
- **불변 메시지 DTO (`record`)**:
  - `SeatMessage(Long postId, int appliedCount, int capacity, int remaining)`: 남은 자리 변경 정보
  - `Notification(String to, String text, Long postId)`: 수신자 로그인 아이디(`to`), 알림 문구, 이동할 글 번호

---

## 3. 커밋 뒤 전송: 이벤트와 `@TransactionalEventListener`

### 1) 유령 메시지 문제

- `confirm()` 트랜잭션 안에서 `SimpMessagingTemplate`으로 실시간 메시지를 바로 보내면, 이후 정원 마감 등으로 DB 트랜잭션이 롤백되어도 이미 나간 WebSocket 메시지는 취소되지 않아 화면과 DB가 불일치하는 **유령 메시지**가 발생합니다.

### 2) 이벤트 기반 해결 구조

- **이벤트 발행 (`EnrollmentService`)**: `ApplicationEventPublisher.publishEvent()`로 `SeatMessage`와 `Notification` 이벤트만 발행합니다.
- **커밋 후 전송 (`RealtimeNotifier`)**: `@TransactionalEventListener`(기본 `phase = AFTER_COMMIT`)가 붙은 리스너 메서드가 **트랜잭션이 정상 커밋된 직후에만** 실제 WebSocket 메시지를 전송합니다. 롤백되면 이벤트가 버려져 유령 메시지를 방지합니다.
- **주의사항**: `@TransactionalEventListener`는 트랜잭션에 묶여 동작하므로, `@Transactional`이 없는 메서드에서 발행한 이벤트는 리스너가 실행되지 않습니다.

---

## 4. 12주차 연습문제 구현

- **신청 취소 실시간 반영**: 이미 `@Transactional`이 적용된 `EnrollmentService.cancel()`에 `SeatMessage`와 작성자 개인 `Notification` 이벤트 발행을 추가하여, 취소 즉시 마감 $\rightarrow$ 모집 중 전환과 취소 알림이 반영되도록 구현했습니다.
- **댓글 실시간 알림**: `CommentService.write()`에 `@Transactional`을 추가하고 `ApplicationEventPublisher`를 주입해, 다른 사용자가 내 글에 댓글을 달면 게시글 작성자에게 실시간 알림이 전송되도록 구현했습니다 (본인 글에 본인 댓글은 알림 생략).

</details>
