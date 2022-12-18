package eseo.twic.api_rest_client.dto;

public class Ville {

    String codeCommune;
    String nomCommune;
    String codePostal;
    String libelleAcheminement;
    String ligne5;
    Coordonnee coordonnee;

    public String getCodeCommune() {
        return codeCommune;
    }
    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }
    public String getNomCommune() {
        return nomCommune;
    }
    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }
    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }
    public String getLigne5() {
        return ligne5;
    }
    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
    }
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }
    public void setCoordonnee(Coordonnee coordonnee) {
            this.coordonnee = coordonnee;
        }


}
