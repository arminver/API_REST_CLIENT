<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Supprimer une ville</title>
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

  <section class="section has-text-centered">
    <div class="container">
      <p class="Title" style="font-size: 18px">
        <c:out value="La ville avec le code commune INSEE suivant : ${codeCommuneInsee } a bien été enlevée de la base de données !"></c:out>
      </p>
      <br>
      <p class="Title" style="font-size: 18px">
        Voici les informations qui ont été supprimées
      </p>
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
        <td><c:out value="${ ville.getNomCommune() }"></c:out></td>
        <td><c:out value="${ ville.getCodeCommune() }"></c:out></td>
        <td><c:out value="${ ville.getCodePostal() }"></c:out></td>
        <td><c:out value="${ ville.getLibelleAcheminement() }"></c:out></td>
        <td><c:out value="${ ville.getLigne5() }"></c:out></td>
        <td><c:out value="${ ville.getCoordonnee().getLatitude() }"></c:out></td>
        <td><c:out value="${ ville.getCoordonnee().getLongitude() }"></c:out></td>
      </tr>
      </tbody>
    </table>
  </div>
  </body>
</html>