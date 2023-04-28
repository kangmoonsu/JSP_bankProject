function createAccount() {
	// 주민등록번호와 이메일 입력 여부 확인
	const regNum1 = document.getElementById("reg_num1").value;
	const regNum2 = document.getElementById("reg_num2").value;
	const email = document.getElementById("email").value;

	if (regNum1 === "" || regNum2 === "") {
		alert("주민등록번호를 입력해주세요.");
		document.getElementById("reg_num1").focus();
		return;
	}

	if (!validateRegNum()) {
		return;
	}

	if (email === "") {
		alert("이메일을 입력해주세요.");
		document.getElementById("email").focus();
		return;
	}

	alert("계좌 개설이 완료되었습니다.");
}

function validateRegNum() {
	let regNum1 = document.getElementById("reg_num1").value;
	let regNum2 = document.getElementById("reg_num2").value;

	if (isNaN(regNum1) || isNaN(regNum2)) {
		alert("주민등록번호를 숫자로 입력해주세요.");
		regNum1.value = "";
        regNum2.value = "";
        regNum1.focus();
		return false;
	}

	return true;
}

function combineRegNum() {
    let reg_num1 = document.getElementById("reg_num1").value;
    let reg_num2 = document.getElementById("reg_num2").value;
    let combinedRegNum = reg_num1 + reg_num2;
    document.getElementById("combinedRegNum").value = combinedRegNum;
}