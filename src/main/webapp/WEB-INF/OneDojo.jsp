<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>One Dojo</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <!-- Needs a forEach to display the ninjas -->
   <h1><c:out value="${oneDojo.name}"/> Location Ninjas</h1>
   <table>
   		<thead>
   			<tr>
   				<th>First Name</th>
   				<th>Last Name</th>
   				<th>Age</th>
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach var="ninja" items="${oneDojo.ninjas}">
   				<tr>
   					<td><c:out value="${ninja.first_name}"/></td>
   					<td><c:out value="${ninja.last_name}"/></td>
   					<td><c:out value="${ninja.age}"/></td>
   				</tr>
   			</c:forEach>
   		</tbody>
   </table>
</body>
</html>

