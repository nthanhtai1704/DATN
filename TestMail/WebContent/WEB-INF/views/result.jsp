<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>

<form action="ControllerConfirm"   method="GET">

Mã: <input type="text" name="number" />
<input type="hidden" type="password" name="number" value=<%= request.getAttribute("hidden") %> />

<input type="submit" value="Xác nhận"/>
</form>

</body>
</html>