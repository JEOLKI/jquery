/**
 * 
 */

/*function idchk() { }*/


idchk = function() {
	
	//입력한 id값 가져오기
	idvalue = $('#id').val().trim(); // 공백제거
	
	if (idvalue.length < 1) {
		alert("id를 입력하세요");
		return false;
	}
	
	return true;
	
}