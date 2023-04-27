const form = document.getElementById('signupform');
const email = document.getElementById('email');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');
const username = document.getElementById('name');
const phone = document.getElementById('phone');
const address = document.getElementById('address');
const signbtn = document.getElementById('signbtn');

signbtn.addEventListener('click', e => {	
	
	if (checkInputs()){
		
		addmember();
	};
	console.log('test btn');
});

function checkInputs() {	
	const emailValue = email.value.trim();
	const passwordValue = password.value.trim();
	const password2Value = password2.value.trim();
    const nameValue = username.value.trim();
    const phoneValue = phone.value.trim();
    const addressValue = address.value.trim();
	let incorrect=true;
	
	if(emailValue === '') {
		setErrorFor(email, '請輸入Email');
		incorrect=false;
	} else if (!isEmail(emailValue)) {
		setErrorFor(email, 'Email格式不符');
		incorrect=false;
	} else {
		setSuccessFor(email);
	}
	
	if(passwordValue === '') {
		setErrorFor(password, '請輸入密碼');
		incorrect=false;
	} else if (!isPassword(passwordValue)) {
		setErrorFor(password, '請設定 6 個字元以上的密碼');
		incorrect=false;
	}else {
		setSuccessFor(password);
	}
	
	if(password2Value === '') {
		setErrorFor(password2, '請輸入密碼');
		incorrect=false;
	} else if(passwordValue !== password2Value) {
		setErrorFor(password2, '您輸入的兩個密碼並不相符');
		incorrect=false;
	} else{
		setSuccessFor(password2);
	}

    if(nameValue === '') {
		setErrorFor(username, '請輸入姓名');
		incorrect=false;
	} else {
		setSuccessFor(username);
	}
    
    if(phoneValue === '') {
		setErrorFor(phone, '請輸入電話');
		incorrect=false;
	}  else if (isNaN(phoneValue)) {
		setErrorFor(phone, '電話格式不符');
		incorrect=false;
	}else {
		setSuccessFor(phone);
	}
    
    if(addressValue === '') {
		setErrorFor(address, '請輸入地址');
		incorrect=false;
	} else {
		setSuccessFor(address);
	}
	
	
	return incorrect;
}

function setErrorFor(input, message) {
	const signupitem = input.parentElement;
	const small = signupitem.querySelector('small');
	signupitem.className = 'signupitem error';
	small.innerText = message;
}

function setSuccessFor(input) {
	const signupitem = input.parentElement;
	signupitem.className = 'signupitem success';
}
	
function isEmail(email) {
	return/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
function isPassword(password) {
	return /^.{6,12}$/.test(password);
}