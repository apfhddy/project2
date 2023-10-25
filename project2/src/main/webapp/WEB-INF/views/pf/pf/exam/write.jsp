<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath }/exam/write" method="post" name = "write">
		<table class = "boardTable">
			<tr>
				<th width="60">업계</th>
				<td><input type="text" name = "jareaCid" required></td>
				<th width="60">시험 성적</th>
				<td><input type="text" name = "legi" required></td>
				<th width="60">시험명</th>
				<td><input type="text" name = "name" required></td>
				<th width="60">시험 점수</th>
				<td><input type="text" name = "score" required></td>
				<th width="60">레벨</th>
				<td><input type="text" name = "lv" required></td>
				<th width="60">응시연월</th>
				<td><input type="text" name = "examDate" required></td>
				<th width="60">상세설명</th>
				<td><input type="text" name = "detail" required></td>
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















