<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<div align="center">
	<form action="${pageContext.request.contextPath }/pf/write" method="post" name = "write">
		<table class = "boardTable">
			<tr>
				<th width="60">소개글</th>
				<td><input type="text" name = "content" required></td>
				<th width="60">닉네임</th>
				<td><input type="text" name = "nickname" required></td>
				<th width="60">현재 직책</th>
				<td><input type="text" name = "posi" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name = "bgImg" size = "400">
				</td>
				<td colspan="2">
					<input type="file" name = "mainImg" size = "400">
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

    if (document.write.content.value == "") {
        alert("내용을 입력하십시오!");
    } else if (document.write.posi.value == "") {
        alert("현재 직책을 입력하십시오!");
    } else {
        document.write.submit();
    }
}

</script>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>















