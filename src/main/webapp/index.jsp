<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Voting Home</title>

</head>
<%@ include file="navbar.jsp"%> 
<body>
<div class="form-container" >
<form action="voterLogin" method="post">		
<h3>Enter your voter card number</h3>
<label for="voterNumber" class="form-container form-label"><b>Voter ID</b></label>
<br>
<input name="voterNumber" id="voterNumber" class="form-elements form-input" type="text"/>
<br>
<button type="submit" class="form-elements form-button">Login</button>
<br>
<a href="adminLogin.jsp" class="index-a">Admin</a>
</form>
</div>
</body>
</html>

