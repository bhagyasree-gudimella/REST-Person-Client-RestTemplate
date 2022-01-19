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
<title>Person details Page</title>
</head>
<body>
	<h2>Person Details</h2>
	<hr>
	<br>
		<table border="1"  cellpadding="2">
		<tr>
			<th>First Name</th>
			<td>${mPerson.first_name}</td>
		</tr>
		<tr>
			<th>Middle Name</th>
			<td>${mPerson.middle_name}</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${mPerson.last_name}</td>
		</tr>
		<tr>
			<th>Email Address</th>
			<td>${mPerson.email_address}</td>
		</tr>
		<tr>
			<th>Gender</th>
			<td>${mPerson.gender}</td>
		</tr>
		<tr>
			<th>Address</th>
			<td>${mPerson.address}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${mPerson.city}</td>
		</tr>
		<tr>
			<th>State</th>
			<td>${mPerson.state}</td>
		</tr>
		<tr>
			<th>Country</th>
			<td>${mPerson.country}</td>
		</tr>
		<tr>
			<th>Zipcode</th>
			<td>${mPerson.zipcode}</td>
		</tr>
		<tr>
			<th>Phone Number</th>
			<td>${mPerson.phone_number}</td>
		</tr>
		<tr>
			<th>Bank Name</th>
			<td>${mPerson.bank_name}</td>
		</tr>
		<tr>
			<th>Account Details</th>
			<td>${mPerson.account_details}</td>
		</tr>
		<tr>
			<th>SSN Number</th>
			<td>${mPerson.ssn_number}</td>
		</tr>
	
	</table>
</body>
</html>