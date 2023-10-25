<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath }/thesis/write" method="post" name = "write">
		<table class = "boardTable">
			<tr>
				<th width="60">논문/저서명</th>
				<td><input type="text" name = "title" required></td>
				<th width="60">출판사/발행처</th>
				<td><input type="text" name = "publisher" required></td>
				<th width="60">저자</th>
				<td><input type="text" name = "writer" required></td>
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















