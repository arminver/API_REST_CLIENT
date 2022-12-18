package eseo.twic.api_rest_client.dao;

import eseo.twic.api_rest_client.dto.Ville;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IVilleDao {

    List<Ville> findVilles();

    void addVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne5, String longitude, String latitude)
        throws UnsupportedEncodingException;

    void updateVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne5, String longitude, String latitude)
        throws UnsupportedEncodingException;

    void deleteVille(String codeCommune);

    Ville villeWithCodeCommune(String codeCommune);
}
