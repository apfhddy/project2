<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div align="center">
    <table class="boardTable" style="table-layout: fixed;">
        <tr>
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="memberNo" value="${vo.memberNo}">
            <th>배경이미지</th>
            <td>${vo.bgImg}</td>
            <th>프로필이미지</th>
            <td>${vo.mainImg}</td>
            <th>조회수</th>
            <td>${vo.hit}</td>
            <th>업데이트 날짜</th>
            <td>${vo.updated}</td>
        </tr>
        <tr>
            <th>소개글</th>
            <td colspan="8">${vo.content}</td>
        </tr>
        <tr>
            <th>닉네임</th>
            <td>${vo.nickname}</td>
            <th>현재 직책</th>
            <td>${vo.posi}</td>
        </tr>
    </table>
</div>

<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/pf/pfList'">

<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















