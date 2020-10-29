<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String result = (String) request.getAttribute("result");

	if(result != null){ // 사용불가능
%>		
		
		{ "sw" : "사용중인 id입니다."	 }	
		
		
<%
	}else { // 사용가능
%>    
		
		{ "sw" : "사용가능 id입니다."	 }	
		
		
<%
	}
%>    