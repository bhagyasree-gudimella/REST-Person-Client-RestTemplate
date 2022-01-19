<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@include file="/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/WEB-INF/views/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>View Persons List</title>
</head>
<body>
	<h2>Persons List</h2>
	<hr>
	<br>
		<table border="1" cellpadding="15"> 
			<tr>
				<th>Personal Information</th>
				<th>Contact Information</th>
				<th>Bank Information</th>
			</tr>
			
			<c:forEach var="person" items="${personsList}">
				<c:set var="first_name" value="${person.getFirst_name()}"></c:set>
				<c:set var="middle_name" value="${person.getMiddle_name()}"></c:set>
				<c:set var="last_name" value="${person.getLast_name()}"></c:set>
				<c:set var="email_address" value="${person.getEmail_address()}"></c:set>
				<c:set var="gender" value="${person.getGender()}"></c:set>
				<c:set var="address" value="${person.getAddress()}"></c:set>
				<c:set var="city" value="${person.getCity()}"></c:set>
				<c:set var="state" value="${person.getState()}"></c:set>
				<c:set var="country" value="${person.getCountry()}"></c:set>
				<c:set var="zipcode" value="${person.getZipcode()}"></c:set>
				<c:set var="phone_number" value="${person.getPhone_number()}"></c:set>
				<c:set var="bank_name" value="${person.getBank_name()}"></c:set>
				<c:set var="account_details" value="${person.getAccount_details()}"></c:set>
				<c:set var="ssn_number" value="${person.getSsn_number()}"></c:set>
				
				<tr>
					<td>
						First name : ${first_name} <br>
						Middle name : ${middle_name} <br>
						Last name : ${last_name} <br>
						Email address : ${email_address} <br>
						Gender : ${gender} <br>
					</td>
					
					<td>
						Address : ${address} <br>
						City : ${city} <br>
						State : ${state} <br>
						Country : ${country} <br>
						ZIPCODE : ${zipcode} <br>
						Phone number : ${phone_number} <br>
					</td>
					
					<td>
						Bank name : ${bank_name} <br>
						Account details : ${account_details} <br>
						SSN : ${ssn_number} <br>
					</td>
				</tr>
				
			</c:forEach>
	</table>
</body>
</html>