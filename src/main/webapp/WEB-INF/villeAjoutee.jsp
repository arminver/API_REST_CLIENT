<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Ville modifiée</title>
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
<section>
  <div class="hero-body">
    <div class="container">
      <p class="Title has-text-centered" style="font-size: 24px">
        <strong>La ville  suivante : <c:out value="${ villeAjout.getNomCommune()}"></c:out></strong>
      </p>
      <p class="Title has-text-centered" style="font-size: 24px">
        <strong>A bien été ajoutée dans la base de données, voici ses informations : </strong>
      </p>
    </div>
  </div>
</section>

<div style="margin: 0 20px 20px 20px; font-size: 16px">
  <table id="table_villes"
         class="table is-bordered is-striped is-narrow is-hoverable "
         style="width: 100%">
    <thead>
    <tr>
      <th>Nom</th>
      <th>Code commune</th>
      <th>Code postal</th>
      <th>Libelle acheminement</th>
      <th>Ligne 5</th>
      <th>Latitude</th>
      <th>Longitude</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td><c:out value="${ villeAjout.getNomCommune() }"></c:out></td>
      <td><c:out value="${ villeAjout.getCodeCommune() }"></c:out></td>
      <td><c:out value="${ villeAjout.getCodePostal() }"></c:out></td>
      <td><c:out value="${ villeAjout.getLibelleAcheminement() }"></c:out></td>
      <td><c:out value="${ villeAjout.getLigne5() }"></c:out></td>
      <td><c:out value="${ villeAjout.getCoordonnee().getLatitude() }"></c:out></td>
      <td><c:out value="${ villeAjout.getCoordonnee().getLongitude() }"></c:out></td>
    </tr>
    </tbody>
  </table>
</div>
</body>
</html>