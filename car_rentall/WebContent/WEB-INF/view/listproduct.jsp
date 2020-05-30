<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
	<h2 align="center">List Product</h2>
   <table>
        <thead>
          <tr>
            <th >ID</th>
            <th>Name Product</th>
            <th>Species</th>
            <th>quantity</th>     
            <th>driver</th>
            <th>Data_hire</th>
            <th>pay_day</th>
            <th>Avartar</th>
            <th>price</th>
          </tr>
        </thead>
        <c:forEach items="${listpt}" var="product">
        <tbody>
          <tr>
            <td>${product.idproduct}</td>
            <td>${product.nameproduct}</td>
            <td>${product.species}</td>
            <td>${product.quantity}</td>
            <td><img src="images/${product.avatar}" width="170px" height="220px"/></td>
            <td>${product.price}</td>    
          </tr>
        </tbody>
        </c:forEach>
      </table>
      </body>
      </html>