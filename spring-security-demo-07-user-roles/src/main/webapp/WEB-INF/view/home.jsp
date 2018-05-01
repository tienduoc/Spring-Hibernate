<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome!!!!!!!!! yoyo</h2>
	<hr>
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<hr>
		<!-- Add a link point to /leaders -> this is for manager -->
		<security:authorize access="hasRole('MANAGER')">
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
			<hr>
		</security:authorize>
		
		<!-- Add a link point to /systems -> this is for admin -->
		<security:authorize access="hasRole('ADMIN')">
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
			<hr>
		</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>