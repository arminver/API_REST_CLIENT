<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ajouter une ville</title>
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
<section class="hero is-fullheight">
  <div class="hero-body">
    <div class="container">
      <p class="Title has-text-centered" style="font-size: 24px">
        <strong>Ajouter une ville dans la base de données :</strong>
      </p>
      <br>
      <div class="columns is-5-tablet is-4-desktop is-3-widescreen">
        <div class="column">
          <form class="box" method="post" action="ajouterVille">
            <div class="field">
              <label class="label">Nom</label>
              <div class="control has-icons-left">
                <input type="text" name="nom" id="nom" class="input" placeholder="Nom de la ville" required>
                <span class="icon is-small is-left">
                						<i class="fa fa-map-pin"></i>
                                    </span>
              </div>
            </div>
            <div class="field">
              <label class="label">Code de la commune</label>
              <div class="control has-icons-left">
                <input type="text" name="codeCommune" id="codeCommune"  class="input" placeholder="Code commune de la ville" required>
                <span class="icon is-small is-left">
                                        <i class="fa fa-barcode"></i>
                                    </span>
              </div>
            </div>
            <div class="field">
              <label class="label">Code postal</label>
              <div class="control has-icons-left">
                <input type="text" class="input" name="codePostal" id="codePostal" placeholder="Code postal de la ville">
                <span class="icon is-small is-left">
                                       <i class="fa fa-envelope"></i>
                                    </span>
              </div>
            </div>
            <div class="field">
              <label class="label">Libéllé acheminement</label>
              <div class="control has-icons-left">
                <input type="text" name="libelle" id="libelle" class="input" placeholder="Libéllé acheminnement de la ville">
                <span class="icon is-small is-left">
                                       <i class="fa fa-road"></i>
                                    </span>
              </div>
            </div>
            <div class="field">
              <label class="label">Ligne 5</label>
              <div class="control has-icons-left">
                <input type="text" name="ligne5" id="ligne5" class="input" placeholder="Ligne 5 de la ville">
                <span class="icon is-small is-left">
                                        <i class="fa fa-train"></i>
                                    </span>
              </div>
            </div>
            <div class="field">
              <label class="label">Longitude</label>
              <div class="control has-icons-left">
                <input type="text" name="longitude" id="longitude" class="input" placeholder="Longitude de la ville">
                <span class="icon is-small is-left">
                                        <i class="fa fa-globe"></i>
                                    </span>
              </div>
            </div>

            <div class="field">
              <label class="label">Latitude</label>
              <div class="control has-icons-left">
                <input type="text" name="latitude" id="latitude" class="input" placeholder="Latitude de la ville">
                <span class="icon is-small is-left">
                                        <i class="fa fa-globe"></i>
                                    </span>
              </div>
            </div>
            <br>
            <div class="field has-text-centered">
              <input class="button is-success" value="Ajouter la ville dans la base de données" type="submit"/>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>