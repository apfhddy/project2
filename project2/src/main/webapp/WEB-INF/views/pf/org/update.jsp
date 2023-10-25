<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
			document.write.submit();
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${pageContext.request.contextPath }/org/update" method="post" name = "write" >
		<input type="hidden" name="no" value="${vo.no }">
		<input type="hidden" name="pfId" value="${vo.PfId }">
		<input type="hidden" name="memberNo" value="${vo.memberNo }">
		
		<table class = "boardTable">
			<tr>
				<th width="60">활동구분</th>
				<td><input type="text" name = "socialactCid" value="${vo.socialactCid }"></td>
				<th width="60">단체명</th>
				<td><input type="text" name = "name" value="${vo.name }"></td>
				<th width="60">직책</th>
				<td><input type="text" name = "posi" value="${vo.posi }"></td>
				<th width="60">활동 상태</th>
				<td><input type="text" name = "stat" value="${vo.stat }"></td>
				<th width="60">설명</th>
				<td><input type="text" name = "text" value="${vo.text }"></td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>