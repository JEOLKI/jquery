<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	List<BoardVO> list = (List<BoardVO>) request.getAttribute("listvalue");
	int spage = (Integer) request.getAttribute("spage");
	int epage = (Integer) request.getAttribute("epage");
	int tpage = (Integer) request.getAttribute("tpage");
	int cpage = (Integer) request.getAttribute("cpage");

%>

{
	"tpage" : "<%= tpage %>",
	"epage" : "<%= epage %>",
	"spage" : "<%= spage %>",
	"cpage" : "<%= cpage %>",
	"data"  : 
	[
		<%
		for(int i =0 ; i<list.size() ; i++){
			BoardVO vo = list.get(i);
			if(i >0 ) out.print(", ");
		%>
			{
				"seq" : "<%= vo.getSeq() %>",
			 	"subject" : "<%= vo.getSubject() %>",
			 	"writer" : "<%= vo.getWriter() %>",
			 	"mail" : "<%= vo.getMail() %>",
			 	"content" : "<%= vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>",
			 	"hit" : "<%= vo.getHit() %>",
			 	"wip" : "<%= vo.getWip() %>",
			 	"wdate" : "<%= vo.getWdate() %>"
			}			
		<%
		}
		%>
    ]
	
	    
}    