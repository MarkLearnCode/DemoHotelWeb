const form = document.querySelector('form');

form.addEventListener('submit', function(event) {
  event.preventDefault(); 
  const firstName = form.querySelector('#first-name').value;
  const lastName = form.querySelector('#last-name').value;
  const phone = form.querySelector('#phone').value;
  const email = form.querySelector('#email').value;

  const formData = {
    firstName: firstName,
    lastName: lastName,
    phone: phone,
    email: email
  };

  localStorage.setItem('formData',JSON.stringify(formData));

  console.log(JSON.stringify(formData));
});