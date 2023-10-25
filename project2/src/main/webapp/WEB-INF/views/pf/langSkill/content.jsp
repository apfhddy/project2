<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
    <table class="boardTable" style="table-layout: fixed;">
        <tr>
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="memberNo" value="${vo.memberNo}">
				<th width="60">언어</th>
				<td>${vo.langNo }</td>
				<th width="60">수준</th>
				<td>${vo.lv }</td>
        </tr>
    </table>
</div>

<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/pf/pfList'">

<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















