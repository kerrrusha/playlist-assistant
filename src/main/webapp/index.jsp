<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Playlist Assistant</title>

  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

  <!-- main css -->
  <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

  <!-- auth css -->
  <link href="${pageContext.request.contextPath}/css/auth.css" rel="stylesheet">
</head>

<body class="text-center">

<jsp:include page="partial-pages/header.jsp" />

<c:choose>
  <c:when test="${sessionScope.containsKey(\"uid\")}">
    <jsp:include page="partial-pages/index-authorized.jsp" />
  </c:when>

  <c:otherwise>
    <jsp:include page="partial-pages/index-not-authorized.jsp" />
  </c:otherwise>
</c:choose>

<jsp:include page="partial-pages/footer.jsp" />

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
<!-- auth logic -->
<script src="${pageContext.request.contextPath}/js/auth.js"></script>
</body>
</html>