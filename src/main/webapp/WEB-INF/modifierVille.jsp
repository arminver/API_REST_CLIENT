<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier une ville</title>
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
                <strong>Modifier les informations de la ville suivante : <c:out value="${ville.getNomCommune() }"></c:out></strong>
            </p>
            <br>
            <div class="columns is-5-tablet is-4-desktop is-3-widescreen">
                <div class="column">
                    <form class="box" method="post">
                        <div class="field">
                            <label class="label">Nom</label>
                            <div class="control has-icons-left">
                                <input type="hidden" name="nomVille" id="nomVille" class="input" value="<c:out value="${ville.getNomCommune() }"> </c:out>" required>
                                <input type="text" name="nom" id="nom" class="input" value="<c:out value="${ville.getNomCommune() }"> </c:out>" required>
                                <span class="icon is-small is-left">
                						<i class="fa fa-map-pin"></i>
                                    </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Code de la commune</label>
                            <div class="control has-icons-left">
                                <input type="text" name="codeCommune" id="codeCommune"  class="input" value="<c:out value="${ville.getCodeCommune() }"> </c:out>">
                                <span class="icon is-small is-left">
                                        <i class="fa fa-barcode"></i>
                                    </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Code postal</label>
                            <div class="control has-icons-left">
                                <input type="text" class="input" name="codePostal" id="codePostal" value="<c:out value="${ville.getCodePostal() }"> </c:out>">
                                <span class="icon is-small is-left">
                                       <i class="fa fa-envelope"></i>
                                    </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Libéllé acheminement</label>
                            <div class="control has-icons-left">
                                <input type="text" name="libelle" id="libelle" class="input" value="<c:out value="${ville.getLibelleAcheminement() }"> </c:out>">
                                <span class="icon is-small is-left">
                                       <i class="fa fa-road"></i>
                                    </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Ligne 5</label>
                            <div class="control has-icons-left">
                                <input type="text" name="ligne5" id="ligne5" class="input" value="<c:out value="${ville.getLigne5() }"> </c:out>">
                                <span class="icon is-small is-left">
                                        <i class="fa fa-train"></i>
                                    </span>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Longitude</label>
                            <div class="control has-icons-left">
                                <input type="text" name="longitude" id="longitude" class="input" value="<c:out value="${ville.getCoordonnee().getLongitude() }"> </c:out>">
                                <span class="icon is-small is-left">
                                        <i class="fa fa-globe"></i>
                                    </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">Latitude</label>
                            <div class="control has-icons-left">
                                <input type="text" name="latitude" id="latitude" class="input" value="<c:out value="${ville.getCoordonnee().getLatitude() }"> </c:out>">
                                <span class="icon is-small is-left">
                                        <i class="fa fa-globe"></i>
                                    </span>
                            </div>
                        </div>
                        <br>
                        <div class="field has-text-centered">
                            <input class="button is-success" value="Valider les modifications" type="submit"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>