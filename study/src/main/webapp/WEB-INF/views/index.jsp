<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
// 버튼 클릭 이벤트 핸들러
	$('button').click(function() {
    	var id = this.id; // 요청할 ID 값 (예시로 123 사용)

    	$.ajax({
        	url: '/study/loadData.do?id=' + id, // 요청 시 URL에 ID 값을 추가
        	type: 'GET',
        	dataType: 'json',
        	success: function(data) {
                // 성공적으로 데이터를 받아왔을 때 처리할 내용
                console.log(data);
                // 받아온 데이터를 HTML에 추가하여 표시할 수 있습니다.
                var detailDiv = $('.detail');
                detailDiv.empty(); // 기존 데이터 초기화

                // 받아온 데이터를 HTML에 추가하여 표시
                var detailHTML = '<p>Name: ' + data.name + '</p>' +
                                 '<p>Age: ' + data.age + '</p>' +
                                 '<p class="deleteBtn" data-id="' + id + '">delete</p>'; // 삭제 버튼에 데이터 속성 추가
                detailDiv.append(detailHTML);

                // 삭제 버튼에 클릭 이벤트 추가
                $('.deleteBtn').click(function() {
                    var deleteId = $(this).data('id'); // 삭제할 데이터의 ID
                    $.ajax({
                        url: '/study/delete.do?id=' + deleteId, // 삭제 요청 보내는 URL
                        type: 'POST', // DELETE 메소드로 요청
                        success: function(response) {
                            console.log('Data deleted successfully');
                            // 성공적으로 데이터 삭제 후 할 작업을 추가하세요
                            // 예: 삭제된 데이터를 화면에서 제거하는 등
                            //화면 리로드
                            location.reload();
                        },
                        error: function(xhr, status, error) {
                            console.error('데이터를 삭제하는 중 에러 발생:', status, error);
                        }
                    });
                });
        	},
        	error: function(xhr, status, error) {
            	// 요청이 실패했을 때 처리할 내용
            	console.error('데이터를 불러오는 중 에러 발생:', status, error);
        	}
    	});
	});
});
</script>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<div class="content">
	<h1>main</h1>
	<c:forEach var="sample" items="${sampleList}">
		<button id="${sample.name }" >${sample.name }</button>
	</c:forEach>
	 <form action="/study/submitForm.do" method="post"> <!-- 컨트롤러의 URL을 지정 -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br><br>

        <label for="age">Age:</label>
        <input type="text" id="age" name="age"><br><br>

        <input type="submit" value="Submit">
    </form>
	<hr>
</div>
<div class="detail"></div>
</body>
</html>
