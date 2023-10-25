<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="./jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
$(function(){
	if($("#term").is(":checked")){
	    console.log("병역동의 체크 됨");
	    
	}else{
	    console.log("is 체크 안됨");
	    
	}
});
</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<hr>
<div align="center">
	<form action="${pageContext.request.contextPath }/apply/write" method="post" name="apply_write">
		<table class="">
			<tr>
				<th>회원 프로필 정보 가져오기 (수정 가능한 폼으로)</th>
			</tr>
			<tr>
				<th>병역</th>
				<td>
					<select name="opt">
						<option value="">[필수]병역을 선택하세요</option>
						<optgroup label="-----------"></optgroup>
						<option value="0">해당없음</option>
						<option value="1">군필</option>
						<option value="2">미필</option>
						<option value="3">면제</option>
					</select>
				</td>
			</tr>
			<tr><th><td>'군필' 누르면 활성화 되게끔 </td></th></tr>
			<tr>
				<th>병역 구분</th>
				<td>
					<select name="type">
						<option value="">[필수]병역 구분을 선택하세요</option>
						<optgroup label="-----------"></optgroup>
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
						<option value="">[필수]제대계급을 선택하세요</option>
						<optgroup label="-----------"></optgroup>
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
				<td><input type="text" name="rsn" placeholder="최대 100자까지 입력"></td>
			</tr>
			<tr><th><td>'병역', '병역구분' 중에 어떤 내용에 대한걸 쓸지?</td></th></tr>
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
				<td><input type="checkbox" name="termStat" id="term"></td>
			</tr>
			<tr><th><td>체크 해야만 넘어갈 수 있게</td></th></tr>
			<tr>
				<th><input type="button" value="추가"></th>
				<td>추가는 JS로 처리</td>
			</tr>
			<tr>
				<th>자기소개서 제목</th>
				<td><input type="text" name="title" placeholder="최대 100자까지 입력가능"></td>
			</tr>
			<tr>
				<th>자기소개서 내용</th>
				<td><textarea rows="15" cols="65" name="detail" placeholder="최대 1,333자까지 입력가능"></textarea></td>
			</tr>
			<tr><th><td>입력하는 length를 실시간으로 표기 '14/1,333'</td></th></tr>
			<tr>
				<th><input type="submit" value="저장하기"></th>
			</tr>	
		</table>
	</form>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
