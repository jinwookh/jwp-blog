# 우아한 테크 코스 레벨2

## 게시글 생성/조회 기능 구현하기
### 구현 기능 목록
* 게시글 생성
    1. 메인페이지에서 게시글 생성 버튼 누르기
    2. GET /writing 요청
    3. 작성페이지로 이동 (article-edit.html)

* 게시글 작성
    1. POST /articles 요청
    2. 게시글 생성 시 게시글은 ArticleRepository 에 저장
    3. 게시글 페이지로 이동 (article.html)
    
* 게시글 목록 조회
    1. 게시글 페이지 이동 (index.html -> article.html)
    2. GET /articles/{articleId} 요청
    
## 게시글 수정/삭제 구현하기
### 구현 기능 목록
* 게시글 수정 페이지 이동
    1. 게시글 페이지 수정 버튼 누르기
    2. GET / articles/{articleId}/edit 요청
    3. 게시글 수정페이지로 이동 (article-edit.html)

* 게시글 수정
    1. PUT /articles/{articleId} 요청
    2. 게시글 페이지로 이동 (article.html)
    
* 게시글 삭제
    1. 게시글 페이지에서 삭제 버튼 누르기
    2. DELETE /articles/{articleId} 요청
    3. 게시글 목록 조회 페이지로 이동 (index.html)

## 회원 등록/조회 구현하기
### 구현 기능 목록
 * 회원가입 페이지 이동
 	1. POST / users 요청
 	2. DB에 user정보 저장
 	3. 생성후 로그인 페이지로 이동 (login.html)

 * 회원 조회 페이지 이동
 	1. GET / users 요청
 	2. DB에 저장된 회원 정보 노출

## 로그인 구현하기
### 구현 기능 목록
 * 로그인 기능
 	1. 성공
		* 메인 화면으로 이동
		* 메인 화면 우측 상단에 사용자 이름을 띄움
 	2. 실패
 		* 실패 메세지를 상황에 맞게 띄움
 			* 이메일이 없는 경우
 			* 비밀번호가 틀린 경우
	3. 로그인 한 유저가 로그인/회원가입 화면에 접근할 경우 메인 화면으로 이동

 * 로그아웃 기능
 	1. 메인 화면으로 이동

## 회원 수정/탈퇴 구현하기
### 구현 기능 목록
 * 회원 수정
 	1. 회원 수정 페이지로 이동 (signup.html)
 	2. 본인 재확인 후 수정
 	3. PUT / users/{userId} 요청
 
 * 회원 탈퇴
 	1. 본인 재확인 후 탈퇴
 	2. DELETE / users/{userId} 요청