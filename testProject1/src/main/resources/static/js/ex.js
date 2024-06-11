/**
 * 순수 자바스크립트 형식으로 작성해줄 수 있고,
 * jQuery형식으로도 작성해 줄 수 있음
 */

/*
example.html 에서 21번째 줄
<button id="btn">연결테스트</button>를 클릭했을 때
나오는 기능
*/
//방법1
document.querySelector("#btn").addEventListener("click",btn);
/*
위의 코드를 제이쿼리 형식으로 변경하기
*/
//방법2
$(document).ready(function() {
	$("#btn").click(btn);
})


/*
example.html 에서 23번째 줄
<button onclick="btn()">연결테스트</button>를 클릭했을 때
나오는 기능
*/
function btn() {
	alert("클릭되었습니다.");
}


