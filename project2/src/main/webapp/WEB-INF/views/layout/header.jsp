<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="finalPath" value="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div class="header">
			<input type="button" value="회원 프로필 추가" onclick="location.href='${pageContext.request.contextPath}/profile/addProfile'">
			<input type="button" value="회원 프로필" onclick="location.href='${pageContext.request.contextPath}/profile/profile'">
			<input type="button" value="사전평가 문제 출제" onclick="location.href='${pageContext.request.contextPath}/pretest/writeform'">
			<input type="button" value="사전평가 문제 리스트" onclick="location.href='${pageContext.request.contextPath}/pretest/list'">
			<input type="button" value="채용공고 작성" onclick="location.href='${pageContext.request.contextPath}/jpost/writeform'">
			<input type="button" value="채용공고 리스트" onclick="location.href='${pageContext.request.contextPath}/jpost/list'">
			<input type="button" value="지원서 작성" onclick="location.href='${pageContext.request.contextPath}/apply/writeform'">
			<input type="button" value="지원서 리스트" onclick="location.href='${pageContext.request.contextPath}/apply/list'">
		</div>
		<div>

		