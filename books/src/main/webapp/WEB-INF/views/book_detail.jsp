<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<style type="text/css">
table{
	margin-bottom:10px;
	width: 600px;
	border-collapse: collapse;
}
table td{
	text-align: center;
	border: solid 1px black;
}
.attr{
	width:100px;
}
#content{
	padding: 20px 20px 20px 20px;
}
#thumbnailContainer{
	padding:5px;
}
</style>
</head>
<body>
<header>
	<h1>도서 정보 관리 - 도서 정보</h1>
</header>
<article>
	<table>
		<tr>
			<td id="thumbnailContainer" rowspan="6"><img src="<c:url value='/image/${book.savedFilename }'/>" width="180"></td>
			<td class="attr">BOOK ISBN</td>
			<td>${book.isbn }</td>
		<tr>
		<tr>
			<td class="attr">도서명</td>
			<td>${book.bookname }</td>
		</tr>
		<tr>
			<td class="attr">저자</td>
			<td>${book.writer }</td>
		</tr>
		<tr>
			<td class="attr">출판사</td>
			<td>${book.publisher }</td>
		</tr>
		<tr>
			<td class="attr">도서 가격</td>
			<td>${book.price }</td>
		</tr>
		<tr>
			<td class="attr">책 소개</td>
			<td id="content" colspan="2">${book.content }</td>
		</tr>
	</table>
	<input type="button" value="도서정보 목록" onclick="location.href='<c:url value="/list"/>'">
</article>
</body>
</html>