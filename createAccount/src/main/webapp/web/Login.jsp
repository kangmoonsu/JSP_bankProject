<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String path = request.getContextPath(); %>
<html>
<head>
	<meta charset="UTF-8">
	<title>중앙 로그인</title>
	 <link href = "<%=path%>/css/Login.css" type = "text/css" rel = "stylesheet">
	
</head>
<body>
	<div class="main">
		<!--웹페이지 상단-->
		<header>
			<!--LOGO-->
			<div class="logo" style="margin-bottom: 40px;"></div>
		<label>중앙은행</label><br/> 
		</header>

		<!--로그인 부분-->
		<form method="post" action="AccountServlet" name="frm">
		<div class="login-wrap">

			<div class="login-id-wrap">
				<input id="input-id" name="userid" placeholder="아이디" type="text" ></input>
			</div>
			<div class="login-pw-wrap">
				<input id="input-pw" name="pwd" placeholder="비밀번호" type="password" ></input>
			</div>
			<div class="login-btn-wrap">
				<input type="submit" value="로그인" id="login-btn" onclick="return loginCheck()"></input>
			</div>
		
		</div>
		</form>

		<!--class,PW 찾기 및 회원가입 부분-->
		<section class="find-signup-wrap">

			<div id="find-signup-wrap-ko">
				<span class="find-id">
					<a href="https://nid.naver.com/user2/help/idInquiry?lang=ko_KR" target="_blank" title="QR코드 로그인">아이디
						찾기</a>
				</span>

				<span class="find-pw">
					<a href="https://nid.naver.com/user2/help/pwInquiry?lang=ko_KR" target="_blank"
						title="일회용번호 로그인">비밀번호 찾기</a>
				</span>

				<span class="sign-up">
					<a href="./signup.html" target="_blank"
						title="일회용번호 로그인">회원가입</a>
				</span>
			</div>

			<div id="find-signup-wrap-en" style="display:none;">
				
				<span class="find-id-en">
					<span>Forgot your</span> 
					<a href="https://nid.naver.com/user2/help/idInquiry?lang=ko_KR" target="_blank" title="QR코드 로그인">Username</a>
				</span>

				<span class="find-pw">
					<span>or</span> 
					<a href="https://nid.naver.com/user2/help/pwInquiry?lang=ko_KR" target="_blank"
						title="일회용번호 로그인">Password?</a>
				</span>

				<span class="sign-up">
					<a href="https://nid.naver.com/user2/V2Join?m=agree&lang=ko_KR" target="_blank"
						title="일회용번호 로그인">Sign up</a>
				</span>
			</div>


		</section>

		<!--저작권 정보-->
		<footer>
			<div class="copyright-wrap">
				<span> Copyright © JOONGANG Corp. All Rights Reserved.</span>
			</div>
		</footer>

	</div>

</body>

</html>