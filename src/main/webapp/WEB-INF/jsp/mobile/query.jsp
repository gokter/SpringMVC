<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Mobile Location</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/mobile/query"
		method="post">
		Mobile number: <input type="text" name="mobileCode" value="${param.mobileCode }"/>
		<h1>${result }</h1>
		 <br /> <input
			type="submit" />
	</form>
</body>
</html>