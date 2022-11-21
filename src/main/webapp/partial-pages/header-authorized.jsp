<header>
  <nav class="navbar navbar-expand-sm">
    <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse justify-content-md-center align-items-md-center collapse" id="navbarsExample09" style="">
      <ul class="navbar-nav mr-auto d-flex flex-row justify-content-around w-100">
        <li class="nav-item active">
          <div class="d-flex flex-column" style="line-height: 1">
            <span class="display-6" style="font-size: 15px;">Logged as:</span>
            <span class="h4 m-0">${sessionScope.user.getLogin()}</span>
          </div>
        </li>
        <li class="nav-item active h1">
          <a class="nav-link" href="#">Playlist Assistant</a>
        </li>
        <li class="nav-item active">
          <form action="${pageContext.request.contextPath}/auth/signout" method="POST">
            <button class="btn" type="submit">
              <span class="h4">Signout</span>
            </button>
          </form>
        </li>
      </ul>
    </div>
  </nav>
</header>