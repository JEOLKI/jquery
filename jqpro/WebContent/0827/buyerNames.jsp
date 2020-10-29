<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   //1. 클라이언트 요청시 전달되는 데이터를 받는다.


   // 2. db를 통해서 CRUD 작업이 이루어 진다.
   // SqlMapClient 객체를 얻어온다. // 펙토리에서 생성후 가져오는 형태 : singleton
   SqlMapClient client = SqlMapClientFactory.getClient();
   List<BuyerVO> list = client.queryForList("buyer.getNames");
   
   // 3. CRUD 작업의 결과를 가지고 응답데이터를 생성한다.
%>

[
<%
   for(int i = 0; i < list.size(); i++){
      BuyerVO vo = list.get(i);
      if(i>0) out.print(",");
%>
{
   "id"   : "<%=vo.getBuyer_id()  %>",
   "name"   : "<%=vo.getBuyer_name()  %>"
}

<%
   }
%>
]