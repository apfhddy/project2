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
	<form action="${pageContext.request.contextPath }/exam/update" method="post" name = "write" >
		<input type="hidden" name="no" value="${vo.no }">
		<input type="hidden" name="pfNo" value="${vo.pfNo }">
		<input type="hidden" name="memberNo" value="${vo.memberNo }">
		
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
			<input type="button" value="수정" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>
<%@include file = "/WEB-INF/views/layout/footer.jsp" %>