<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.0.2/css/bootstrap.min.css" />
<title>Spring Security Kerberos Sample</title>
</head>
<body>
	<h1>
		You are the user
		<%=request.getRemoteUser()%>!
	</h1>
</body>
</html>