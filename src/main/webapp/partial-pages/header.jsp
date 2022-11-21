<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
  <c:when test="${sessionScope.containsKey(\"user\")}">
    <jsp:include page="header-authorized.jsp" />
  </c:when>

  <c:otherwise>
    <jsp:include page="header-not-authorized.jsp" />
  </c:otherwise>
</c:choose>