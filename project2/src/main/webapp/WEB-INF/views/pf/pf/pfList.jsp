<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>	
	<h2>기본 프로필</h2>
		<a href="${pageContext.request.contextPath }pf/writeForm">pf입력</a> 
		<a href="${pageContext.request.contextPath }pf/content">pf보기</a> 
		<a href="${pageContext.request.contextPath }pf/updateForm">pf수정</a> 
	
	<h2>봉사활동</h2>
		<a href="${pageContext.request.contextPath }pf/vol/writeForm">vol입력</a>
		<a href="${pageContext.request.contextPath }pf/vol/content">vol보기</a>
		<a href="${pageContext.request.contextPath }pf/vol/updateForm">vol수정</a>
	
	<h2>논문/저서</h2>
		<a href="${pageContext.request.contextPath }pf/thesis/writeForm">thesis입력</a>
		<a href="${pageContext.request.contextPath }pf/thesis/content">thesis 보기</a>
		<a href="${pageContext.request.contextPath }pf/thesis/updateForm">thesis 수정</a>			

	<h2>수상 경력</h2>
		<a href="${pageContext.request.contextPath }pf/award/writeForm">award입력</a>
		<a href="${pageContext.request.contextPath }pf/award/content">award 보기</a>
		<a href="${pageContext.request.contextPath }pf/award/updateForm">award 수정</a>
		
	<h2>취득 시험 성적</h2>
		<a href="${pageContext.request.contextPath }pf/exam/writeForm">exam 입력</a>
		<a href="${pageContext.request.contextPath }pf/exam/content">exam 보기</a>
		<a href="${pageContext.request.contextPath }pf/exam/updateForm">exam 수정</a>
		
	<h2>외국어 능력</h2>
		<a href="${pageContext.request.contextPath }pf/langSkill/writeForm">langSkill 입력</a>
		<a href="${pageContext.request.contextPath }pf/langSkill/content">langSkill 보기</a>
		<a href="${pageContext.request.contextPath }pf/langSkill/updateForm">langSkill 수정</a>

	<h2>단체 활동</h2>
		<a href="${pageContext.request.contextPath }pf/org/writeForm">org 입력</a>
		<a href="${pageContext.request.contextPath }pf/org/content">org 보기</a>
		<a href="${pageContext.request.contextPath }pf/org/updateForm">org 수정</a>

	<h2>회원 재직 상태</h2>
		<a href="${pageContext.request.contextPath }pf/jstat/writeForm">jstat 입력</a>
		<a href="${pageContext.request.contextPath }pf/jstat/content">jstat 보기</a>
		<a href="${pageContext.request.contextPath }pf/jstat/updateForm">jstat 수정</a>
	
</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>		









