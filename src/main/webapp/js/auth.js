function processLogin(url) {
	hideErrorsBlock();

	let login = $(".login-show input[placeholder=Nickname]").val();
	let password = $(".login-show input[placeholder=Password]").val();

	let errors = [];
	if (!validateLogin(login)) {
		errors.push("Login must be at least 3 characters long and must not contain spaces.");
	}
	if (!validatePassword(password)) {
		errors.push("Password must be at least 3 characters long and must not contain spaces.");
	}

	if (errors.length !== 0) {
		showErrors(errors);
		return;
	}

	let data = "login="+login+"&password="+password;
	$.ajax({
	  type: "POST",
	  url: url,
	  data: data,
	  success: function(response) {
		  console.log(response);
		  if (response["status"] === 200) {
			  location.reload();
		  } else {
			  showErrors(response["errorPool"]);
		  }
	  },
	  error: function (response) {
	      console.log(response);
	  }
	});
}

function hideErrorsBlock() {
	$(".errors-block").hide();
}

function showErrors(errors) {
	let errorsBlock = $(".errors-block")
	errorsBlock.css('visibility', 'visible');
	errorsBlock.show();
	errorsBlock.html(createErrorsHtmlList(errors));
}

function createErrorsHtmlList(errors) {
	let html = "<ul class='list-group'>";
	errors.forEach(error => {
		html += "<li class='list-group-item list-group-item-danger'>" + error + "</li>";
	});
	html += "</ul>";
	return html;
}

function validateLogin(login) {
	return login.length >= 3 && !login.includes(" ");
}

function validatePassword(password) {
	return password.length >= 3 && !password.includes(" ");
}

function processRegister(registerUrl, afterRegisterUrl) {
	hideErrorsBlock();

	let login = $(".register-show input[placeholder=Nickname]").val();
	let password = $(".register-show input[placeholder=Password]").val();
	let passwordRepeat = $(".register-show input[placeholder*=Confirm]").val();

	let errors = [];
	if (!validateLogin(login)) {
		errors.push("Login must be at least 3 characters long and must not contain spaces.");
	}
	if (!validatePassword(password) || !validatePassword(passwordRepeat)) {
		errors.push("Password must be at least 3 characters long and must not contain spaces.");
	}
	if (password !== passwordRepeat) {
		errors.push("Passwords don't match.");
	}

	if (errors.length !== 0) {
		showErrors(errors);
		return;
	}

	let data = "login="+login+"&password="+password+"&passwordRepeat="+passwordRepeat;
	$.ajax({
		type: "POST",
		url: registerUrl,
		data: data,
		success: function(response) {
			console.log(response);
			if (response["status"] === 200) {
				window.location.replace(afterRegisterUrl);
			} else {
				showErrors(response["errorPool"]);
			}
		},
		error: function (response) {
			console.log(response);
		}
	});
}




$(document).ready(function(){
            $('.login-info-box').fadeOut();
            $('.login-show').addClass('show-log-panel');
        });


        $('.login-reg-panel input[type="radio"]').on('change', function() {
            if($('#log-login-show').is(':checked')) {
                $('.register-info-box').fadeOut(); 
                $('.login-info-box').fadeIn();
                
                $('.white-panel').addClass('right-log');
                $('.register-show').addClass('show-log-panel');
                $('.login-show').removeClass('show-log-panel');
                
            }
            else if($('#log-reg-show').is(':checked')) {
                $('.register-info-box').fadeIn();
                $('.login-info-box').fadeOut();
                
                $('.white-panel').removeClass('right-log');
                
                $('.login-show').addClass('show-log-panel');
                $('.register-show').removeClass('show-log-panel');
            }
        });