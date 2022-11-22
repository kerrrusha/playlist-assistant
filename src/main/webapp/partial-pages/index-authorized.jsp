<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<main>
  <div class="mt-3">
    <p class="display-6 mb-0">That's the music, what we found for you</p>
    <p class="d-flex flex-row justify-content-center align-items-center">Based on your choice - <a href="${pageContext.request.contextPath}/select-favourite-artists" class="btn text-decoration-underline px-2 mx-0"><strong>change it</strong></a></p>
    <div class="d-flex flex-row my-4 flex-wrap justify-content-center">
        <c:forEach var="var" items="${model.getTracks()}">
            <a class="entity" href="${var.getTrackViewUrl()}" target="_blank">
                <img src="<c:out value="${var.getArtworkUrl100()}"/>">
                <span><c:out value="${var.getArtistName()}"/> - <c:out value="${var.getTrackName()}"/></span>
            </a>
        </c:forEach>
    </div>
  </div>
</main>