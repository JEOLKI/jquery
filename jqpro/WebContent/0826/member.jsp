<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 

	// (1~3은 지금은없음)
	// 1. 클라이언트 요청시 전달 되는 데이터를 받는다.
	
	// 2. 1번에서 받은 데이터를 가지고 db를 통해서 CRUD작업이 이루어진다.
	// SqlMapClient객체를 얻어온다.
	SqlMapClient client = SqlMapClientFactory.getClient();
	
	List<MemberVO> list = client.queryForList("member.getMemberAll");
	
	// 3. CRUD 작업의 결과를 가지고 응답데이터를 생성한다.
%>

[

<%
	for(int i = 0; i <list.size() ; i++){
		MemberVO member = list.get(i);
		if(i>0) out.print(", "); // 자바내에서 출력방식 : 컴마 출력
%>	
	
	{
		"id" : "<%= member.getMem_id() %>",
		"name" : "<%= member.getMem_name() %>",
		"tel" : "<%= member.getMem_tel() %>",
		"addr" : "<%= member.getMem_addr() %>"
	}
	
<%		
	}
%>

]


