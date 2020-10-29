<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("listvalue");
%>

<%--원래 직접 html을 만들어주는데 우린 json이용 --%>

[

<%
	for(int i =0; i <list.size() ; i++){
		MemberVO vo = list.get(i);
		if(i > 0) out.print(",");
%>

	{
		"id" : "<%= vo.getMem_id() %>",
		"name" : "<%= vo.getMem_name() %>",
		"bir" : "<%= vo.getMem_bir() %>",
		"zip" : "<%= vo.getMem_zip() %>",
		"add1": "<%= vo.getMem_add1() %>",
		"add2" : "<%= vo.getMem_add2() %>",
		"mail" : "<%= vo.getMem_mail() %>",
		"hp" : "<%= vo.getMem_hp() %>"
	}
	
<%
	}
%>

]



