<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 이체 내역</title>
<link rel="stylesheet" type="text/css" href="css/Account.css">
<script type="text/javascript" src="script/transaction.js"></script>
</head>
<body>
	<div id="wrap" align="center">
	<c:forEach var="customer" items="${customer}">
		<h1>${customer.name}님계좌 내역</h1>
	</c:forEach>
	<c:forEach var="account" items="${account}">	
		<h2>금액 ${account.balance}원</h2>
	</c:forEach>
		<table>
			<tr>
				<td colspan="6" style="border: white; text-align: right">
					<a href="AccountServlet?command=transaction_write_form">이체</a>
				</td>
			</tr>
			<tr>
				<th>거래 번호</th>
				<th>내계좌번호</th>
				<th>받는 사람</th>
				<th>이체 금액</th>
				<th>내통장 메모</th>
				<th>이체 날짜</th>
			</tr>
			<c:forEach var="transaction" items="${transaction}">
				<tr class="record">
					<td>${transaction.transaction_num}</td>
					<td><input type="hidden" name="sender_account"> ${transaction.sender_account}</td>
					<td>${transaction.receiver_account}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.send_context}</td>
					<td><fmt:formatDate value="${transaction.transaction_date}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>