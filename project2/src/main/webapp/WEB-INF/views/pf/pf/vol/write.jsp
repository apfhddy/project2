<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath }/pf/vol/write" method="post" name = "write">
		<table class = "boardTable">
			<tr>
				<th width="60">내용</th>
				<td><input type="text" name = "content" required></td>
				<th width="60">사회활동(추후 카테고리로 제공할 것)</th>
				<td><input type="text" name = "socialactCid" required></td>
				<th width="60">단체명</th>
				<td><input type="text" name = "org" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="date" name = "startDate" size = "400">
				</td>
				<td colspan="2">
					<input type="date" name = "endDate" size = "400">
				</td>
				<th width="60">상세내용</th>
				<td colspan="2">
					<input type="text" name = "detail" size = "400">
				</td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="submit" value="작성" onclick="javascript:checkWrite()">		
		</div>
	</form>
</div>
		
<!-- <script type="text/javascript">
	$(document).ready(function() {
 	 	$('#summernote').summernote();
	});
</script> -->

<script type ="text/javascript">

function checkWrite() {
        document.write.submit();
}

</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>















