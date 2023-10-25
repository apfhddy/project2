<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
    <table class="boardTable" style="table-layout: fixed;">
        <tr>
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="memberNo" value="${vo.memberNo}">
				<th width="60">업계</th>
				<td><input type="text" name = "jareaCid" value="${vo.jareaCid}"></td>
				<th width="60">시험 성적</th>
				<td><input type="text" name = "legi" value="${vo.legi}"></td>
				<th width="60">시험명</th>
				<td><input type="text" name = "name" value="${vo.name}"></td>
				<th width="60">시험 점수</th>
				<td><input type="text" name = "score" value="${vo.score}"></td>
				<th width="60">레벨</th>
				<td><input type="text" name = "lv" value="${vo.lv}"></td>
				<th width="60">응시연월</th>
				<td><input type="text" name = "examDate" value="${vo.examDate}"></td>
				<th width="60">상세설명</th>
				<td><input type="text" name = "detail" value="${vo.detail}"></td>
        </tr>
    </table>
</div>

<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/pf/pfList'">

<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















