<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
    <table class="boardTable" style="table-layout: fixed;">
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="memberNo" value="${vo.memberNo}">
			<tr>
				<th width="60">상장명</th>
				<td><input type="text" name = "name" value="${vo.name }"></td>
				<th width="60">발행처</th>
				<td><input type="text" name = "author" value="${vo.author }"></td>
			</tr>
			<tr>
				<th width="60">발행날짜</th>
				<td colspan="2">
					<input type="date" name = "awardDate" value="${vo.awardDate }" size = "400">
				</td>
				<th width="60">상세내용</th>
				<td colspan="2">
					<input type="text" name = "detail" value="${vo.detail }" size = "400">
				</td>
			</tr>
	</table>
</div>

<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/pf/pfList'">

<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















