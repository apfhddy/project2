<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
    <table class="boardTable" style="table-layout: fixed;">
        <tr>
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="memberNo" value="${vo.memberNo}">
            <th>활동구분</th>
            <td>${vo.socialactCid}</td>
            <th>단체명</th>
            <td>${vo.name}</td>
            <th>직책</th>
            <td>${vo.posi}</td>
            <th>현재활동상태</th>
            <td>${vo.stat}</td>
        </tr>
        <tr>
            <th>설명</th>
            <td colspan="8">${vo.text}</td>
        </tr>
    </table>
</div>

<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/pf/pfList'">

<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















