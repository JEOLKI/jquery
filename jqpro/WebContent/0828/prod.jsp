<%@page import="kr.or.ddit.lprod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
<%

	List<ProdVO> list = (List<ProdVO>) request.getAttribute("listvalue");
	
	// list가 값이 없는경우 P401, P402
	
%>

[

<% 
	for(int i = 0; i <list.size(); i++){
		ProdVO vo = list.get(i);
		if( i > 0) out.print(", ");
		
%>
		{
			"id" : "<%= vo.getProd_id() %>",
			"name" : "<%= vo.getProd_name() %>"
		}
<% 
	}

%>

]
    
    
    
    