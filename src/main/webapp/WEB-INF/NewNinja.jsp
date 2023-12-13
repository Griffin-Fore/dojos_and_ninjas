<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

<!-- Bean command means you have a misspelling -->
    <meta charset="UTF-8">
    <title>New Ninja</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   		<form:form action="/create/ninja" method="post" modelAttribute="Ninjas">
   			<form:label path="dojo">Dojo:</form:label>
   			<form:select path="dojo">
				<c:forEach var="oneDojo" items="${allDojos}">
					<option value="${oneDojo.id}"><c:out value="${oneDojo.name}"/></option>
				</c:forEach>
   			</form:select>

   			<form:label path="first_name">First Name:</form:label>
   			<form:input path="first_name"/>

   			<form:label path="last_name">Last Name:</form:label>
   			<form:input path="last_name"/>

   			<form:label path="age">Age:</form:label>
   			<form:input path="age"/>

   			<button>Submit</button>
   		</form:form>
</body>
</html>
