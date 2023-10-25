<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<hr>
<script type="text/javascript">

	$(function(){
		if($("#term").is(":checked")){
		    console.log("병역동의 체크 됨");
		    
		}else{
		    console.log("is 체크 안됨");
		    
		}
	});
</script>
	
<script>
	var textarea = document.getElementById('#detail');

</script>	
	
<div>
	<form action="${pageContext.request.contextPath }/apply/update" method="post" name="apply_write">
		<input type="hidden" value="${vo.APPLY_ID }" name="apply_id">
		<input type="hidden" value="${vo.APPLY_FORM_ID }" name="apply_form_id">
		<input type="hidden" value="${vo.ARMY_NO }" name="army_no">

		<table>
			<tr><th>회원 프로필 정보 가져오기 (수정 가능한 폼으로)</th></tr>
			<tr>
				<th>병역</th>
				<td>
					<select name="opt">
						<option value="0">해당없음</option>
						<option value="1">군필</option>
						<option value="2">미필</option>
						<option value="3">면제</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>병역 구분</th>
				<td>
					<select name="type">
						<option value="0">육군</option>
						<option value="1">해군</option>
						<option value="2">공군</option>
						<option value="3">해병</option>
						<option value="4">의경</option>
						<option value="5">공익</option>
						<option value="6">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>제대계급</th>
				<td>
					<select name="disch">
						<option value="0">이병</option>
						<option value="1">일병</option>
						<option value="2">상병</option>
						<option value="3">병장</option>
						<option value="4">하사</option>
						<option value="5">중사</option>
						<option value="6">상사</option>
						<option value="7">원사</option>
						<option value="8">준위</option>
						<option value="9">소위</option>
						<option value="10">중위</option>
						<option value="11">대위</option>
						<option value="12">소령</option>
						<option value="13">중령</option>
						<option value="14">대령</option>
						<option value="15">준장</option>
						<option value="16">소장</option>
						<option value="17">중장</option>
						<option value="18">대장</option>
						<option value="19">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>사유</th>
				<td><input type="text" value="${vo.RSN }" name="rsn"></td>
			</tr>
			<tr>
				<th>입영일</th>
				<td><input type="date" name="start_date"></td>
			</tr>
			<tr>
				<th>제대일</th>
				<td><input type="date" name="end_date"></td>
			</tr>
			<tr>
				<th>민감 정보 동의 여부</th>
				<td><input type="checkbox" name="termStat" id="term">체크여부 불러오는 방법 알아보기</td>
			</tr>
			<tr>
				<th>자기소개서 제목</th>
				<td><input type="text" name="title" value="${vo.TITLE }"></td>
			</tr>
			<tr>
				<th>자기소개서 내용</th>
				<td><textarea rows="15" cols="65" name="detail" id="detail">${vo.DETAIL }</textarea></td>
			</tr>
			<tr>
				<th><td><input type="submit" value="지원서 수정하기"></td></th>
			</tr>
		</table>
	</form>
</div>
