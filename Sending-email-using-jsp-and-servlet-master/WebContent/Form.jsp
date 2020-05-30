<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<h1 align="center">FORGOT PASSWORD </h1>
<br>
<form  action="EmailSendingServlet" method ="post">
<table>
<td>Enter your email id:<input type="email" name="recipient" size="50" required="required"></td>
<td>  
<input  type="submit" value="Send"></td>
</table>
</form>

</body>
</html>