<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	BoardVO vo = (BoardVO) request.getAttribute("boardvo");    	
%>

{
	"seq" : "<%= vo.getSeq() %>",
	"subject" : "<%= vo.getSubject() %>",
	"writer" : "<%= vo.getWriter() %>",
	"mail" : "<%= vo.getMail() %>",
	"password" : "<%= vo.getPassword() %>",
	<%-- "content" : "<%= vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>" --%>	
	"content" : "<%= vo.getContent().replaceAll("\\n|(\\r\\n)", "\\\\n") %>"	
}













