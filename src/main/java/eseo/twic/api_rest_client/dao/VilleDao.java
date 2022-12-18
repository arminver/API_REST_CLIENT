package eseo.twic.api_rest_client.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eseo.twic.api_rest_client.dto.Ville;
import eseo.twic.api_rest_client.transform.BuilderObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VilleDao implements IVilleDao{

    @Override
    public List<Ville> findVilles() {
        BuilderObject builder = new BuilderObject();
        JSONArray json;
        ArrayList<Ville> listeVilles = null;
        try {
            json = builder.readJsonFromUrl("http://localhost:8181/Villes");
            ObjectMapper mapper = new ObjectMapper();
            listeVilles = mapper.readValue(json.toString(), new TypeReference<ArrayList<Ville>>() {
            });
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return listeVilles;
    }

    @Override
    public void addVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne5, String longitude, String latitude) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            String requestBody = requestBody(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne5, longitude, latitude);
            System.out.println(requestBody);
            StringEntity stringEntity = new StringEntity(requestBody);
            HttpPost httpPost = new HttpPost();
            httpPost.setURI(new URI("http://localhost:8181/Ville_Ajouter"));
            httpPost.addHeader("Content-type", "application/json");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            System.out.println("Status Code - " + httpResponse.getStatusLine().toString());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne5, String longitude, String latitude) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            String requestBody = requestBody(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne5, longitude, latitude);
            System.out.println(requestBody);
            StringEntity stringEntity = new StringEntity(requestBody);
            HttpPut httpPut = new HttpPut();
            httpPut.setURI(new URI("http://localhost:8181/Ville_Modifier"));
            httpPut.addHeader("Content-type", "application/json");
            httpPut.setEntity(stringEntity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPut);
            System.out.println("Status Code - " + httpResponse.getStatusLine().toString());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVille(String codeCommune) {
        try {
            URL url = new URL("http://localhost:8181/Ville_Enlever?codeCommuneInsee="+codeCommune);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("DELETE");
            httpUrlConnection.setRequestProperty("Accept", "application/json");

            if (httpUrlConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + httpUrlConnection.getResponseCode());
            }
            httpUrlConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ville villeWithCodeCommune(String codeCommune) {
        BuilderObject builder = new BuilderObject();
        JSONArray json;
        ArrayList<Ville> listeVilles = new ArrayList<>();
        try {
            json = builder.readJsonFromUrl("http://localhost:8181/Ville?codeCommuneInsee=" + codeCommune);
            ObjectMapper mapper = new ObjectMapper();
            listeVilles = mapper.readValue(json.toString(), new TypeReference<ArrayList<Ville>>() {
            });
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return listeVilles.get(0);
    }

    private String requestBody(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne5, String longitude, String latitude) {
        return "{\n"
                + " \"nomCommune\": \""+nomCommune+"\",\n"
                + "	\"codeCommuneInsee\": \""+codeCommune+"\",\n"
                + "	\"codePostal\": \""+codePostal+"\",\n"
                + "	\"ligne5\": \""+ligne5+"\",\n"
                + "	\"libelleAcheminement\": \""+libelleAcheminement+"\",\n"
                + "	\"longitude\": \""+longitude+"\",\n"
                + "	\"latitude\": \""+latitude+"\"\n"
                + "	}";
    }
}
