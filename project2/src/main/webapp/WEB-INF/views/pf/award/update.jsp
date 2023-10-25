<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
			document.write.submit();
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${pageContext.request.contextPath }/award/update" method="post" name = "write" >
		<input type="hidden" name="no" value="${vo.no }">
		<input type="hidden" name="pfNo" value="${vo.pfNo }">
		<input type="hidden" name="memberNo" value="${vo.memberno }">
		
		<table class = "boardTable">
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
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>