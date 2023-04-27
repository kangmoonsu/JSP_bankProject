/**
 * 
 */
function AccountCheck() {
	return true;
}

function open_win(url) {
	window.open(url, '이체', "width=600, height=600");
}

function goAction() {
	window.opener.location.href='AccountServlet?command=transaction';
	
	window.opener.location.reload();

}

function transfer() {
	// 부모창 새로고침
	window.opener.location.reload();

	// 1초 후에 창을 닫습니다.
	setTimeout(function() {
		window.close();
	}, 1000);
}