<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Distance entre deux villes</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.9.3/css/bulma.min.css">
    <link rel="stylesheet"
          href="https://cdn.datatables.net/1.11.5/css/dataTables.bulma.min.css">
    <link rel="stylesheet"
          href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.bulma.min.css">
</head>
<%@include file="navbar.jsp"%>
<body>

<section class="has-text-centered">
    <c:choose>
        <c:when test="${ empty nomA }">
            <form method="post">
                <div class="columns is-mobile is-centered">
                    <div class="column is-half">
                        <div class="select is-small is-rounded is-info" style="margin-top: 8px">
                            <select name="pointA" id="pointA">
                                <option value="" disabled selected hidden>Ville n°1</option>
                                <c:forEach items="${ villes }" var="current" varStatus="status">
                                    <option value="${current.nomCommune}">${current.nomCommune}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="select is-small is-rounded is-info" style="margin-top: 8px">
                            <select name="pointB" id="pointB">
                                <option value="" disabled selected hidden>Ville n°2</option>
                                <c:forEach items="${ villes }" var="current" varStatus="status">
                                    <option value="${current.nomCommune}">${current.nomCommune}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <input class="button is-info is-medium" value="Calculer" type="submit" />
            </form>
        </c:when>
        <c:otherwise>
            <div class="has-text-centered" style="font-size: 24px">
                <c:out value="La distance entre ${ nomA } et ${ nomB } est de ${ distance } km."></c:out>
            </div>
        </c:otherwise>
    </c:choose>
</section>

</body>
</html>