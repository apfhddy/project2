<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkWrite() {
		if(document.write.title.value == ""){
			alert("제목을 입력하십시오!");
		}else if(document.write.content.value == ""){
			alert("내용을 입력하십시오!")
		}else{
			document.write.submit();
		}
	}
</script>
<%@include file = "/WEB-INF/views/layout/header.jsp" %>
<div align="center">
	<form action="${pageContext.request.contextPath }/pf/update" method="post" name = "write" >
		<input type="hidden" name="pfNo" value="${vo.pfNo }">
		<input type="hidden" name="memberId" value="${vo.memberId }">
		
		<table class = "boardTable">
			<tr>
				<th width="60">소개글</th>
				<td><input type="text" name = "content" value="${vo.content}" ></td>
				<th width="60">닉네임</th>
				<td><input type="text" name = "nickname" value="${vo.nickname}"></td>
				<th width="60">현재 직책</th>
				<td><input type="text" name = "posi" value="${vo.posi}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name = "bgImg" value="${vo.bgImg}" size = "400">
				</td>
				<td colspan="2">
					<input type="file" name = "mainImg" value="${vo.mainImg}"  size = "400">
				</td>
			</tr>
		</table>
		<div class = "btnBox">
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>