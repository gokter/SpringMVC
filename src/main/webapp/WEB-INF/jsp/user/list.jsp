<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user list</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/main.css" type="text/css">
</head>
<body>
	<a href="${pageContext.request.contextPath }/user/add">add user</a>
	<br />Current user:${sessionScope.loginUser.username }
	<c:forEach var="me" items="${users }">
		<h1>
			<a
				href="${pageContext.request.contextPath }/user/${me.value.username }">${me.value.username }</a>-----${me.value.password }-----${me.value.nickname }-----${me.value.email }
			<a
				href="${pageContext.request.contextPath }/user/${me.value.username}/update">update</a>
			<a
				href="${pageContext.request.contextPath }/user/${me.value.username }/delete">delete</a>
		</h1>
	</c:forEach>
</body>
</html>