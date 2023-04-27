<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 이체 페이지</title>
<link rel="stylesheet" type="text/css" href="css/Account.css">
<script type="text/javascript" src="script/transaction.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<c:forEach var="customer" items="${customer}">
			<h1>${customer.name}님</h1>
		</c:forEach>
		<form name="frm" method="post" action="AccountServlet">
			<input type="hidden" name="command" value="transaction_write">
			<table>
				<tr>
					<c:forEach var="account" items="${account}">
						<td>출금가능금액 ${account.balance}원</td>
					</c:forEach>
				</tr>
					<tr>
						<th>본인 계좌번호: </th>
						<td><input type="text" name="sender_account"></td>
					</tr>
					<tr>
						<th>받는 계좌번호: </th>
						<td><input type="text" name="receiver_account"></td>
					</tr>
					<tr>
						<th>이체 금액: </th>
						<td><input type="text" name="amount"></td>
					</tr>
					<tr>
						<th>내통장 메모: </th>
						<td><input type="text" name="send_context"></td>
					</tr>
			</table>
			<br> <br> 
			<input type="submit" value="이체" onclick="AccountCheck()">
			<input type="button" value="목록" onclick="location.href='AccountServlet?command=transaction'">
			<!-- location.href='AccountServlet?command=transaction' -->
		</form>
	</div>
</body>
</html>