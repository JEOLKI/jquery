<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// (1~3은 지금은없음)
	// 1. 클라이언트 요청시 전달 되는 데이터를 받는다.
	
	// 2. 1번에서 받은 데이터를 가지고 db를 통해서 CRUD작업이 이루어진다.
	// SqlMapClient 객체를 얻어오기
	SqlMapClient client = SqlMapClientFactory.getClient();
	List<MemberVO> list = client.queryForList("member.selectAll");
	
	// 3. CRUD 작업의 결과를 가지고 응답데이터를 생성한다.
%>

[
<%
	for(int i = 0; i < list.size() ; i++){
		MemberVO vo = list.get(i);
		if(i > 0 ) out.print(",");
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
    
    
    