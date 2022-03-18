<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form:form action="#" commandName="mrc" method="post" onsubmit>
	<table>
		<tr>
			<td>아이디 :</td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>비밀번호(1111) :</td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td>비밀번호확인 : </td>
			<td><form:password path="confirmPassword"/></td>
		</tr>
	</table>
	<input type="submit" value="회원가입">
	</form:form>
</body>
</html>