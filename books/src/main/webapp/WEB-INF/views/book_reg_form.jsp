<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<style type="text/css">
#thumbnailContainer{
	width:180px;
	height:270px;
}
#table{
	text-align: center;
	border-collapse: collapse;
}
#table td{
	border:solid 1px;
}
#table td input{
	width:80%;
	border:1px solid gray;
}
.attr{
	width:100px;
}
#table td textarea{
	overflow-y:scroll;
	border:none;
	resize:none;
}
#top{
	text-align: right;
}
.errors{
	color: hotpink;
	font-style: italic;
}
</style>
<script type="text/javascript">
function setTumbnail(){
	let fileInfo = document.getElementById("imgFile").files[0];
	let reader = new FileReader();
	
	reader.onload = function(){
		document.getElementById("thumbnailImg").src = reader.result;
	}
	if(fileInfo){
		reader.readAsDataURL(fileInfo);
	}
}

//var regEx = new RegExp(".*?\.(exe|txt|zip|php|jsp|)");
</script>
</head>
<body>
<header>
	<h1>도서 정보 관리 - 도서 추가</h1>
</header>
<article>
<form:form action="add" commandName="regForm" method="post" enctype="multipart/form-data">
	<table id="table">
		<tr><td colspan="3" id="top"><font color="red">*</font>표시는 필수입니다. </td></tr>
		<tr>
			<td id="thumbnailContainer" rowspan="7"><img src="" id="thumbnailImg" width="180"></td>
			<td class="attr"><font color="red">*</font>BOOK ISBN</td>
			<td><form:input path="isbn" pattern="[0-9]+" placeholder="숫자만 입력"/><br>
			<form:errors path="isbn" cssClass="errors"/></td>
		<tr>
		<tr>
			<td class="attr"><font color="red">*</font>도서명</td>
			<td><form:input path="bookname"/><br>
			<form:errors path="bookname" cssClass="errors"/></td>
		</tr>
		<tr>
			<td class="attr"><font color="red">*</font>저자</td>
			<td><form:input path="writer"/><br>
			<form:errors path="writer" cssClass="errors"/></td>
		</tr>
		<tr>
			<td class="attr"><font color="red">*</font>출판사</td>
			<td><form:input path="publisher"/><br>
			<form:errors path="publisher" cssClass="errors"/></td>
		</tr>
		<tr>
			<td class="attr"><font color="red">*</font>도서 가격</td>
			<td><form:input path="price" pattern="[0-9]+" placeholder="숫자만 입력"/><br>
			<form:errors path="price" cssClass="errors"/></td>
		</tr>
		<tr>
			<td class="attr"><font color="red">*</font>도서이미지</td>
			<td><input type="file"  id="imgFile" name="imgFile" value="${regForm.imgFile }"
				onChange="setTumbnail()"><br>
			<form:errors path="imgFile" cssClass="errors"/></td>
		</tr>
		<tr>
			<td><font color="red">*</font>책 소개</td>
			<td colspan="2">
				<textarea name="content" rows="10" cols="45">${regForm.content }</textarea>
				<br><form:errors path="content" cssClass="errors"/>
			</td>
		</tr>
	</table>
	<input type="submit" value="도서정보 추가">&nbsp;&nbsp;&nbsp;
	<input type="button" value="도서정보 목록" onclick="location.href='<c:url value="/list"/>'">
</form:form>
</article>
</body>
</html>