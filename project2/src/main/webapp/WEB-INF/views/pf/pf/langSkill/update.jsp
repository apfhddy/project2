<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
			document.write.submit();
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${pageContext.request.contextPath }/langSkill/update" method="post" name = "write" >
		<input type="hidden" name="no" value="${vo.no }">
		<input type="hidden" name="pfNo" value="${vo.pfNo }">
		<input type="hidden" name="memberNo" value="${vo.memberNo }">
		
		<table class = "boardTable">
			<tr>
				<th width="60">언어</th>
				<td><input type="text" name = "langNo"  value="${vo.langNo}"></td>
				<th width="60">수준</th>
				<td><input type="text" name = "lv"  value="${vo.lv}"></td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>