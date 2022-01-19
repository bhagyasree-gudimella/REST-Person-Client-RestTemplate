<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/WEB-INF/views/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>View Person By Id</title>
</head>
<body>
	<h2>Person ID</h2>
	<hr>
	<br>
	<form:form name="personId" modelAttribute="personId" method="post">
		Person ID 
		<form:input path="p_id" type="text"/> <br>
		
		<br><br>
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
	</form:form>
</body>
</html>