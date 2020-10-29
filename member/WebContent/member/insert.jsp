<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	String id = (String) request.getAttribute("saveOk");

	if(id != null){
%>
	
	{ "sw" : "가입성공 축하합니다" }	
		
<%	}else{ %>
	
	{ "sw" : "가입실패" }	
		
<%		
	}
%>    
