<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath }/jstat/write" method="post" name = "write">
		<table class = "boardTable">
			<tr>
				<th width="60">재직상태</th>
				<td><input type="text" name = "jstatCid" required></td>
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















