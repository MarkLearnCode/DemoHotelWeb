const form = document.getElementById('loginform');
const email = document.getElementById('email');
const password = document.getElementById('password');
const loginbtn = document.getElementById('loginbtn');

loginbtn.addEventListener('click', e => {	
	checkInputs();	
  console.log('test btn');
});

function checkInputs() {	
	const emailValue = email.value.trim();
	const passwordValue = password.value.trim();

  if(emailValue === '') {
		setErrorFor(email, '請輸入Email');
	} else if (!isEmail(emailValue)) {
		setErrorFor(email, 'Email格式不符');
	}else {
    setSuccessFor(email);
  }
	
	if(passwordValue === '') {
		setErrorFor(password, '請輸入密碼');
	} else if (!isPassword(passwordValue)) {
		setErrorFor(password, '密碼格式不符');
	}else {
    setSuccessFor(password);
  }	
}

function setErrorFor(input, message) {
  const small = input.parentElement.querySelector('small');
  small.innerText = message;
  small.style.visibility = 'visible';
  small.style.color = '#e74c3c';
}
function setSuccessFor(input) {
  const small = input.parentElement.querySelector('small');
  small.innerText = '';
  small.style.visibility = 'hidden';
}

function isEmail(email) {
	return/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
function isPassword(password) {
	return /^.{6,12}$/.test(password);
}