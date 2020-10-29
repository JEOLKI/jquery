<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

	p {
		font-size: 1.5em;
		color: blue;
	}

</style>


</head>
<body>
jsp : Java Server page<br>

<% 
	String userId = request.getParameter("id");
	String userPass = request.getParameter("pass");
	String userGender  = request.getParameter("radioGroup");

%>

<p><%= userId %>님 환영합니다.</p>





</body>
</html>