<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Update book</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2 style="text-align:center; color:blue;">UPDATE BOOK</h2>
	
	<form:form method="POST" action="${pageContext.request.contextPath}/book/updateBook" modelAttribute="book">
         <table border="0">
         	<tr>
         	<td><form:input type="hidden" path="id"/></td>
         	</tr>
            <tr>
               <td>Name</td>
               <td><form:input type="text" path="name"/></td>
            </tr>
            <tr>
               <td>Author</td>
               <td><form:input type="text" path="author"/></td>
            </tr>
            <tr>
               <td>Publisher</td>
               <td><form:input type="text" path="publisher"/></td>
            </tr>
             <tr>
               <td>Price</td>
               <td><form:input type="number" path="price"/></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
               </td>
            </tr>
         </table>
      </form:form>
</body>
</html>