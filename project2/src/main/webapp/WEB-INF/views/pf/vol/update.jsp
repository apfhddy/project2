<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
			document.write.submit();
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${pageContext.request.contextPath }/pf/vol/update" method="post" name = "write" >
		<input type="hidden" name="no" value="${vo.no }">
		<input type="hidden" name="pfId" value="${vo.pfId }">
		<input type="hidden" name="memberNo" value="${vo.memberNo }">
		
		<table class = "boardTable">
			<tr>
				<th width="60">내용</th>
				<td><input type="text" name = "content" value= "${vo.content}"></td>
				<th width="60">사회활동(추후 카테고리로 제공할 것)</th>
				<td><input type="text" name = "socialactCid" value= "${vo.socialactCid}"></td>
				<th width="60">단체명</th>
				<td><input type="text" name = "org" value= "${vo.org}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="date" name = "startDate" value= "${vo.startDate}" size = "400">
				</td>
				<td colspan="2">
					<input type="date" name = "endDate" value= "${vo.endDate}" size = "400">
				</td>
				<th width="60">상세내용</th>
				<td colspan="2">
					<input type="text" name = "detail" value= "${vo.detail}" size = "400">
				</td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>