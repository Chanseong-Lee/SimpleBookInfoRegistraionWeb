<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<style type="text/css">
table{
	border-collapse: collapse;
	width:1000px;
}
table th, td{
	border: 1px solid black;
	padding-left: 10px;
	padding-right: 10px;
}
#searchForm{
	margin-bottom: 10px;
}
.num{
	width:70px;
	text-align: center;
}
.imgContainer{
	width:70px
}
.errors{
	color: hotpink;
	font-style: italic;
}
a:link {
	color:hotpink;
	text-decoration: none;
	text-shadow: 0 0 24px;
} 
a:visited { 
	color:pink;
	text-decoration: none; 
	text-shadow: 0 0 24px; 
}
</style>
</head>
<body>
<header>
	<h1>도서 정보 관리 - 도서 리스트</h1>
</header>
<article>
	<form:form action="search" method="get">
	<div id="searchForm">
		검색 키워드 입력 : 
		<form:select path="searchType">
			<form:option value="bookname">책이름</form:option>
			<form:option value="writer">저자</form:option>
			<form:option value="publisher">출판사</form:option>
		</form:select>
		<form:input path="searchValue" placeholder="책이름 or 저자 or 출판사 입력"/>
		<input type="submit" value="검색">
		<form:errors path="searchValue" cssClass="errors"/>
	</div>
	</form:form>
	<table>
		<tr>
			<th>등록 번호</th>
			<th>도서 표지</th>
			<th>도서 ISBN</th>
			<th>도서 제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
	<c:if test="${!empty books }">
		<c:forEach var="book" items="${books }">
		<tr>
			<td class="num">${book.num }</td>
			<td class="imgContainer"><img src="<c:url value="/image/${book.savedFilename }"/>" width="60"></td>
			<td>${book.isbn }</td>
			<td><a href="<c:url value="/read/${book.num }"/>">${book.bookname }</a></td>
			<td>${book.writer }</td>
			<td>${book.publisher }</td>
			<td>${book.price }</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty books }">
		<tr>
			<td colspan="7">데이터가 없습니다.</td>
		</tr>
	</c:if>
	</table>
	<input type="button" value="도서정보 추가" onclick="location.href='<c:url value="/add"/>'">
</article>
</body>
</html>