<main>
  <p class="display-5 fs-3 text-decoration-underline">The place to get new music based on what you love</p>

  <div class="login-reg-panel">
    <div class="login-info-box">
      <h2>Already have an account?</h2>
      <p></p>
      <label id="label-register" for="log-reg-show">Login</label>
      <input type="radio" name="active-log-panel" id="log-reg-show"  checked="checked">
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
        <input type="text" placeholder="Nickname">
        <input type="password" placeholder="Password">
        <input onclick="processLogin('${pageContext.request.contextPath}/auth/login')" id="login" type="button" value="Login">
<%--        <a href="">Forgot password?</a>--%>
      </div>
      <div class="register-show">
        <h2>REGISTER</h2>
        <input type="text" placeholder="Nickname">
        <input type="password" placeholder="Password">
        <input type="password" placeholder="Confirm Password">
        <input onclick="processRegister('${pageContext.request.contextPath}/auth/register', '${pageContext.request.contextPath}/select-favourite-artists')" id="register" type="button" value="Register">
      </div>
      <div class="errors-block" style="visibility: hidden;">

      </div>
    </div>
  </div>
</main>