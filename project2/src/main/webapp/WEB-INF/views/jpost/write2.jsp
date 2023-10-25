<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function checkWrite(){
		if(document.jpost_write.title.value == ""){
			alert("'채용공고 제목'란을 채워주세요");
		}else if(document.jpost_write.detail.value == ""){
			alert("'상세 내용'란을 채워주세요");
			<!-- date 타입은 어떻게 체크하는지?? -->
		}else if(document.jpost_write.locate.value == ""){
			alert("'근무지'란을 채워주세요");
		}else if(document.jpost_write.posi.value == ""){
			alert("'모집 직책'란을 채워주세요");
		}else if(document.jpost_write.task.value == ""){
			alert("'모집 주요 업무'란을 채워주세요");
		}else if(document.jpost_write.lv.value == ""){
			alert("'경력'란을 채워주세요");
		}else if(document.jpost_write.salary.value == ""){
			alert("'연봉'란을 채워주세요");
		}else if(document.jpost_write.edu.value == ""){
			alert("'교육 수준'란을 채워주세요");
		}else{
			document.jpost_write.submit();
		}
	}


</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<hr>
<div align="center">
	<form action="${pageContext.request.contextPath }/jpost/write" method="post" name="jpost_write">	<!-- name은 JS와 연계할 때 사용 / vo의 매개변수병과 맞추면 setter로 그 값을 가져올 수 있음-->
		<table class="">																				<!-- form action에서 name은 파트별로 구분이 필요할거 같아서 jpost_write로 명명 -->
			<tr>
				<th>지원자 접수 방법</th>
					<td>
						<select name="howto">
							<option value="">[필수]접수 방법을 선택하세요</option>
							<optgroup label="-----------"></optgroup>
							<option value="0">즉시지원</option>
							<option value="1">홈페이지 지원</option>
						</select>
					</td>
			</tr>
			<tr>
				<th>채용공고 제목</th>
				<td><input type="text" name="title" placeholder="최대 30자까지 입력가능"></td>
			</tr>
			<tr>
				<th>상세 내용</th>
				<td><textarea rows="15" cols="65" name="detail"></textarea></td>
			</tr>
			<tr>
				<th>지원 시작일</th>
				<td><input type="date" name="start_date"></td>	<!-- 데이트 피커로 만들기 / 표준시 구분 어떻게? -->
			</tr>
			<tr>
				<th>지원 종료일</th>
				<td><input type="date" name="end_date"></td>
			</tr>
			<tr>
				<th>근무지</th>
				<td><input type="text" name="locate" placeholder="ex) 서울시 성동구"></td>
			</tr>
			<tr>
				<th>고용 직군</th>
				<td>
 					<select name="jarea_no">
						<c:forEach var="i" items="${jalist }">
							<option value="${i.jarea_cno }">${i.jarea_type }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>근무시간</th>
				<td>
 					<select name="worktime_cno">
						<c:forEach var="i" items="${wtlist }">
							<option value="${i.worktime_cno }">${i.worktime_type }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>고용 형태</th>
				<td>
 					<select name="empl_no">
						<c:forEach var="i" items="${elist }">
							<option value="${i.empl_type_cno }">${i.empl_type }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>모집 직책</th>
				<td><input type="text" name="posi" placeholder="ex) 팀장"></td>
			</tr>
			<tr>
				<th>모집 주요 업무</th>
				<td><input type="text" name="task" placeholder="ex) 웹디자이너"></td>
			</tr>
			<tr>
				<th>경력</th>
				<td><input type="text" name="lv" placeholder="ex) 3년 이상"></td>
			</tr>
			<tr>
				<th>연봉</th>
				<td><input type="text" name="salary" placeholder="ex) 연봉 기입">만원</td>
			</tr>
			<tr>
				<th>교육 수준</th>
				<td><input type="text" name="edu" placeholder="ex) 초대졸 이상"></td>
			</tr>
			<tr>
				<th>근무 형태</th>
				<td>
					<select name="type">
					<option value="">[필수]근무 형태을 선택하세요</option>
						<optgroup label="-----------"></optgroup>
						<option value="0">대면</option>
						<option value="1">비대면</option>
						<option value="2">복합</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" name="file_name"></td>
			</tr>
			<tr>
				<th>URL 링크</th>
				<td><input type="url" name="url"></td>
			</tr>
		</table>
	</form>
	<div class="btn">
		<input type="button" value="공고 올리기" onclick="javascript:checkWrite()">
	</div>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
