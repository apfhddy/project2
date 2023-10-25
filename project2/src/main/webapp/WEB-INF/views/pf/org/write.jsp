<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath }/org/write" method="post" name = "write">
		<table class = "boardTable">
			<tr>
				<th width="60">활동구분</th>
				<td><input type="text" name = "socialactCid" required></td>
				<th width="60">단체명</th>
				<td><input type="text" name = "name" required></td>
				<th width="60">직책</th>
				<td><input type="text" name = "posi" required></td>
				<th width="60">활동 상태</th>
				<td><input type="text" name = "stat" required></td>
				<th width="60">설명</th>
				<td><input type="text" name = "text" required></td>
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















