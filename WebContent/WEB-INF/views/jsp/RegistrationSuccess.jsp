<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.lavanya.gudimella.vo.Person" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
     <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/WEB-INF/views/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
	<h2>Registration Success</h2>
	<hr>
	<br>	
	<br><br>
	
	<jsp:useBean id="mPerson" class="com.lavanya.gudimella.vo.Person" scope="session"></jsp:useBean>
	
		<table border="1" cellpadding="15"> 
			<tr>
				<th>Personal Information</th>
				<th>Contact Information</th>
				<th>Bank Information</th>
			</tr>
			
			<tr>
				<td>
					First Name : <jsp:getProperty property="first_name" name="mPerson"/>  <br>
					Middle Name : <jsp:getProperty property="middle_name" name="mPerson"/>  <br>
					Last Name : <jsp:getProperty property="last_name" name="mPerson"/>  <br>
					Email : <jsp:getProperty property="email_address" name="mPerson"/>  <br>
					Gender : <jsp:getProperty property="gender" name="mPerson"/>  <br>
				</td>
				
				<td>
					Address : <jsp:getProperty property="address" name="mPerson"/>  <br>
					City : <jsp:getProperty property="city" name="mPerson"/>  <br>
					State : <jsp:getProperty property="state" name="mPerson"/>  <br>
					Country : <jsp:getProperty property="country" name="mPerson"/>  <br>
					Contact : <jsp:getProperty property="phone_number" name="mPerson"/>  <br>
					ZIPCODE : <jsp:getProperty property="zipcode" name="mPerson"/>  <br>
				</td>
				
				<td>
					Bank Name : <jsp:getProperty property="bank_name" name="mPerson"/>  <br>
					Account Details : <jsp:getProperty property="account_details" name="mPerson"/>  <br>
					SSN : <jsp:getProperty property="ssn_number" name="mPerson"/>  <br> 
				</td>
			</tr>
		</table>
	
</body>
</html>