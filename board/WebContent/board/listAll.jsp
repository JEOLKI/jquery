<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("listvalue");
%>    
   
[
<%
	for(int i = 0 ; i < list.size() ; i++){
		BoardVO vo = list.get(i);
		if(i > 0) out.print(", ");
%>
		{
		 	"seq" : "<%= vo.getSeq() %>",
		 	"subject" : "<%= vo.getSubject() %>",
		 	"writer" : "<%= vo.getWriter() %>",
		 	"mail" : "<%= vo.getMail() %>",
		 	"content" : "<%= vo.getContent() %>",
		 	"hit" : "<%= vo.getHit() %>",
		 	"wip" : "<%= vo.getWip() %>",
		 	"wdate" : "<%= vo.getWdate() %>"
		}
<%
	}
%>
]   
    
    