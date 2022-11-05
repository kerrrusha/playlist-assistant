<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Welcome</title>

  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

  <!-- main css -->
  <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

  <!-- auth css -->
  <link href="${pageContext.request.contextPath}/css/auth.css" rel="stylesheet">
</head>

<body class="text-center">
<header>
  <nav class="navbar navbar-expand-sm">
    <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse justify-content-md-center align-items-md-center collapse" id="navbarsExample09" style="">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active h1">
          <a class="nav-link" href="#">Playlist Assistant</a>
        </li>
      </ul>
    </div>
  </nav>
</header>

<main>
  <h1 class="bg-danger">registered - ${cookie.containsKey("uid")}</h1>
  <p class="display-5 fs-3 text-decoration-underline">The place to get new music based on what you love</p>
  <div class="login-reg-panel">
    <div class="login-info-box">
      <h2>Already have an account?</h2>
      <p></p>
      <label id="label-register" for="log-reg-show">Login</label>
      <input type="radio" name="active-log-panel" id="log-reg-show" checked="checked">
    </div>

    <div class="register-info-box">
      <h2>Don't have an account?</h2>
      <p></p>
      <label id="label-login" for="log-login-show">Register</label>
      <input type="radio" name="active-log-panel" id="log-login-show">
    </div>

    <div class="white-panel">
      <div class="login-show">
        <h2>LOGIN</h2>
        <input type="text" placeholder="Email">
        <input type="password" placeholder="Password">
        <input type="button" value="Login">
        <a href="">Forgot password?</a>
      </div>
      <div class="register-show">
        <h2>REGISTER</h2>
        <input type="text" placeholder="Email">
        <input type="password" placeholder="Password">
        <input type="password" placeholder="Confirm Password">
        <input type="button" value="Register">
      </div>
    </div>
  </div>
</main>

<footer>
  <div class="">
    <p>By <a href="https://linkedin.com/in/kerrrusha" target="_blank">kerrrusha</a> ©</p>
  </div>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
<%-- auth script --%>
<script src="${pageContext.request.contextPath}/js/auth.js" type="text/javascript"></script>
</body>
</html>