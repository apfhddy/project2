<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script type="text/javascript">
function deleteAction() {
	var check = confirm("삭제 하시겠습니까?");
	
	if(!check){
		return;
	}
	
	location.href = '${pageContext.request.contextPath }/post/delete?no=${post.NO}';
}

var xhr = new XMLHttpRequest();

function resultFn() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var data = xhr.responseText;

        if (data === '등록 성공') {
            clear();
            getList();
        } else {
            alert("실패")
        }
    }
}
xhr.open("POST", url, true);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.onreadystatechange = selectAll;
xhr.send(param);

function check(f){
	return true;
}

function rewrite(){
	var text = document.getElementById("text").value;
	var postNo = document.getElementById("postNo").value;
	
	var url = "${pageContext.request.contextPath}/post/rewrite";
	var param = "text=" + encodeURIComponent(text) + "&postNo=" + encodeURIComponent(postNo);
	
	sendRequest(url,param,resultFn(),"POST");
	
}

function getList(){
	//현재 url 에서 param 가져오기
	//var urlParams = new URL(location.href).searchParams;
	//var seq = urlParams.get('seq');
	var no = document.getElementById("no").value;
	var url = "${pageContext.request.contextPath}/post/getlist";
	var param = "no=" + encodeURIComponent(no);
	
	sendRequest(url,param,selectAll,"POST");
}

function selectAll(){
	var data = xhr.response; // 컨트롤러에서 넘어온 list를 담고 있다.
	var data2 = JSON.parse(data);
	var pcmt = document.getElementById("pcmt");
	
	text = '';
	data2.forEach(function(pcmt){
		text += '<div>';
		text += '<tr>';
		text += '<td> 댓글 번호 ' + pcmt.no + '</td>';
		text += '<td> 작성자 ' + pcmt.memberNo + '</td>';
		text += '<td> 내용 ' + pcmt.text + '</td>';
		text += '</tr>';
		text += '</div>';
	});
	
	pcmt.innerHTML = text;
	
} 

function clear(){
	// 내가 작성한 input 태그 비워주는 함수
	var inputc = document.getElementById("text");
	
	inputc.value = '';
}

function checkWrite() {
    var selectedValues = getCheckboxValue();
    if (selectedValues !== "") {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "${pageContext.request.contextPath}/survey/submitResponse", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                alert("응답이 성공적으로 저장되었습니다.");
            }
        };
        xhr.send("selectedValues=" + encodeURIComponent(selectedValues));
    } else {
        alert("최소한 하나 이상의 옵션을 선택해주세요.");
    }
}

function getCheckboxValue() {
    const query = 'input[name="content"]:checked';
    const selectedEls = document.querySelectorAll(query);

    let result = '';
    selectedEls.forEach((el) => {
        result += el.value + ' ';
    });

    return result.trim();
}


</script>
<div align="center">
    <table class="boardTable" style="table-layout: fixed;">
        <tr>
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="memberNo" value="${vo.memberNo}">
    </table>
</div>

<input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/pf/pfList'">

<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















