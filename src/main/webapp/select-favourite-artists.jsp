<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Set Favourite Artists</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <!-- main css -->
    <link href="css/main.css" rel="stylesheet">
  </head>

  <body class="text-center">
  <jsp:include page="partial-pages/header.jsp" />

    <main>
      <div class="mt-3">
        <p class="display-6">Select <span id="current-selected">0</span>/<span id="max-artists">10</span> items</p>
        <p>Based on them, new tracks will be offered to your playlist</p>
        <button id="get-playlist-button" class="btn btn-light disabled" onclick="getPlaylist(
                '${pageContext.request.contextPath}/user/set-favourite-artists',
                '${pageContext.request.contextPath}/'
                )">
          <span class="fs-5">Get similar tracks playlist</span>
        </button>
        <div class="d-flex flex-row my-4 flex-wrap justify-content-center">
          <c:forEach var="var" items="${model.getArtists()}">
            <div class="entity">
              <img src="<c:out value="${var.getPhotoUrl()}"/>">
              <span><c:out value="${var.getArtistName()}"/></span>
            </div>
          </c:forEach>
        </div>
      </div>
    </main>

  <jsp:include page="partial-pages/footer.jsp" />


    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    <!-- set artists logic -->
    <script src="${pageContext.request.contextPath}/js/set-favourite-artists.js"></script>
  </body>
</html>