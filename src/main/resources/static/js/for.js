const form = document.getElementById('forgetform');
const email = document.getElementById('email');
const forgetbtn = document.getElementById('forgetbtn');

forgetbtn.addEventListener('click', e => {	
	checkInputs();
	
});
function checkInputs() {	
	const emailValue = email.value.trim();

  if(emailValue === '') {
		setErrorFor(email, '請輸入Email');
	} else if (!isEmail(emailValue)) {
		setErrorFor(email, 'Email格式不符');
	}else {
    setSuccessFor(email);
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
