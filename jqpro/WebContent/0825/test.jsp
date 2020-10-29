<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
h1{	
color : green;
}
span{
color : red;
font-size : 1.2em;
}
</style>


</head>
<body>

<h1>JSP : java Server Page</h1>
 <h2>서버 내에서 실행되는 스크립트 파일</h2>
 <p>html과 java코드를 혼용해서 사용할 수 있다</p>
 <p>- java코드를 쓸 때는 &lt;%  %&gt; 사이에 기술한다.</p>
 <p>- java변수 값을 출력 할 때는 &lt;%=  %&gt; 사이에 기술한다.</p>
 <p>클라이언트에서 전송시 입력한 데이터를 전송하면 여기서 받응</p>
 <p>String 변수 = request.getParameter("name")</p>
 
 <%
    //자바 문장 기술, 클라이언트(html)에서 전송시 입력한 데이터를 전송하면 여기서 받응
    request.setCharacterEncoding("UTF-8");
    
    String userId = request.getParameter("id");
    String userName = request.getParameter("name");
    String userPass = request.getParameter("pass");
 %>
 
 <span><%= userId %>님 환영합니다</span><br>
 <span><%= userName %>님 즐거운 하루 되세요.</span>
</body>
</html>