# 📝 게시판 프로젝트

## 구현한 기능

* 로그인 및 회원가입
* 사용자 인증 및 권한 관리
* 게시글 등록, 수정, 삭제
* 게시글 목록 조회(검색 및 페이징)
* 게시글 상세 조회
* 댓글 기능


## 로그인

* [x]  스프링 시큐리티를 활용한 로그인 기능 구현
* [x]  테스트 코드 작성 및 통과

## 사용자 인증 및 권한 관리

JWT를 이용한 사용자 인증
* [x]  게시글 작성자만 수정 및 삭제 가능
* [x]  관리자는 모든 게시글 수정 및 삭제 가능 - TODO 삭제만 가능으로 변경

## 회원가입

* [x]  이메일 - 이메일 형식에 맞는지 검증
* [x]  휴대폰 번호 - 숫자와 하이폰으로 구성된 형식 검증
* [x]  유저네임(로그인시 사용되는 회원 아이디) - 영어와 숫자의 조합으로 최소 8자 최대 12자 형식
* [x]  작성자(닉네임) - 영어 대소문자 및 한글 이름 검증
* [x]  비밀번호 - 대소문자, 숫자 5개 이상, 특수문자 포함 2개 이상 검증
* [x]  테스트 코드 작성 및 통과

## 게시글 등록

* [x]  제목 - 200글자 이하 제한
* [x]  내용 - 1000글자 이하 제한
* [x]  생성및 수정 시간 자동관리 - TODO 테스트
* [x]  테스트 코드 작성 및 통과

## 게시글 수정

* [x]  생성일 기준 10일 이후 수정불가
* [x]  생성일 9일째 경고 알림(하루 후 수정 불가 알람)
* [x]  테스트 코드 작성 및 통과

## 게시글 목록조회

* [x]  생성일 기준 내림차순 오름차순 정렬
* [x]  title 기준 부분 검색 가능
* [x]  title 이 없을 경우 cratedAt 정렬 기준으로 표시
* [x]  deletedAt 기준 삭제된 게시글 제외
* [] 유저별 최근 본 포스트 최신순 정렬
* [x]  테스트 코드 작성 및 통과

## 게시글 상세보기

* [x]  수정 가능일 현재 날짜 기준 계산 및 표시
* [x]  테스트 코드 작성 및 통과

## 게시글 삭제
클라이언트단에서 '영구적으로 삭제하기' 옵션을 제공한다고 가정하고, 파라미터로 isSoftDelete를 받아오도록 함
* [x]  Soft Delete 적용 deletedAt 사용하여 삭제처리
* [x]  Hard Delete 적용
* [x]  테스트 코드 작성 및 통과 

## 📌 추가 할 기능

### 파일 업로드 기능

* [ ]  게시글에 이미지 첨부 기능 추가
* [ ]  이미지 파일 형식 크기 제한
* [ ]  이미지 업로드 시 S3와 같은 외부 스토리지 연동

### 댓글 기능

게시글에 댓글 추가 기능

* [x]  댓글 작성, 수정, 삭제 (Soft Delete)
* [x]  유저는 하나의 게시글에 하나의 댓글만 작성 가능 
* [x]  댓글 작성자는 본인의 댓글만 수정 및 삭제 가능

### 조회수 증가 기능

* [ ]  게시글 조회수 증가 기능
* [ ]  동일 사용자가 여러 번 조회 시 조회수 증가 방지 - 중복된 클릭일 경우 카운트하지 않고, updated_at만 업데이트
    #### 상세 구현 방법
    - 비회원의 조회는 카운트하지 않음(로그인 유저만 게시글 접근 가능)
    - 별도의 테이블을 생성해서 포스트 id와 유저네임을 매핑
    - 테이블 생성을 통해, 유저가 최근에 클릭한 포스트 리스트를 조회할 수 있음

### 좋아요 기능

* [ ]  댓글 및 좋아요 시 알림 기능
* [ ]  수정 제한 경고 알림

### 알림 기능

* [ ]  댓글 및 좋아요 시 알림 기능
* [ ]  수정 제한 경고 알림
