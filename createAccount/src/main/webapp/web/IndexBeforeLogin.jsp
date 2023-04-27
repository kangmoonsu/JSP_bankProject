<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
body {
	width: 60%;
	align: center;
	margin: 0 auto;
}

.header {
	padding: 30px;
	background: #ffd000;
	font-size: 30px;
	position: relative;
	border-radius: 5px;
	margin: 20px;
}

.title {
	color: white;
	font-size: 30px;
	text-align: left;
}

.box-container {
	display: flex;
	justify-content: center;
}

.box {
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 20px;
	padding: 20px;
	background-color: #ffd000;
	color: white;
	border-radius: 10%;
	width: 150px;
	height: 150px;
	font-size: 20px;
	cursor: pointer;
}

.login {
	position: absolute;
	top: 30px;
	right: 120px;
	background-color: #ffd000;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	font-size: 18px;
}

.signup {
	position: absolute;
	top: 30px;
	right: 30px;
	background-color: #ffd000;
	color: white;
	text-decoration: none;
	border-radius: 5px;
	font-size: 18px;
}

.clear {
	clear: both;
}

.main_img {
	text-align: center;
}
.foot{
	text-align: center;
}

</style>
</head>
<body>
	<div class="header">
		<h1 class="title">중앙은행</h1>
		<a href="#" class="signup">회원가입</a>
		<a href="#" class="login">로그인</a> 
		<div class="clear"></div>
	</div>
	<div class = "main_img">
		<img src="https://via.placeholder.com/650X400" alt="샘플이미지">
	</div>
	<div class="box-container">
		<div class="box" onclick="location.href='https://www.google.com';">계좌개설</div>
		<div class="box" onclick="location.href='https://www.naver.com';">환율정보</div>
		<div class="box" onclick="location.href='https://www.daum.net';">이체하기</div>
		<div class="box" onclick="location.href='https://www.nytimes.com';">1:1문의</div>
	</div>	
	<div class="foot">
		<span> Copyright © JOONGANG Bank Corp. All Rights Reserved.</span>
	</div>
</body>
</html>
