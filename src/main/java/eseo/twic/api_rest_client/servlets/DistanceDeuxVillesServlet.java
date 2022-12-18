package eseo.twic.api_rest_client.servlets;

import eseo.twic.api_rest_client.dao.VilleDao;
import eseo.twic.api_rest_client.dto.CalculDistance;
import eseo.twic.api_rest_client.dto.Ville;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

@WebServlet("/DistanceDeuxVilles")
public class DistanceDeuxVillesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    VilleDao villeDao = new VilleDao();
    ArrayList<Ville> villes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        villeDao = new VilleDao();
        villes = (ArrayList<Ville>) villeDao.findVilles();
        request.setAttribute("villes", villes);

        this.getServletContext().getRequestDispatcher("/WEB-INF/calculDistance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        villeDao = new VilleDao();
        villes = (ArrayList<Ville>) villeDao.findVilles();

        String nomA = request.getParameter("pointA");
        String nomB = request.getParameter("pointB");
        request.setAttribute("nomA", nomA);
        request.setAttribute("nomB", nomB);

        Ville villeA = new Ville();
        Ville villeB = new Ville();

        for (Ville currentVille : villes){
            if (currentVille.getNomCommune().equals(nomA)){
                villeA = currentVille;
            } else if (currentVille.getNomCommune().equals(nomB)) {
                villeB = currentVille;
            }
        }

        CalculDistance distanceGestion = new CalculDistance();
        double distance = distanceGestion.Calcul(
                villeA.getCoordonnee().getLatitude(),
                villeA.getCoordonnee().getLongitude(),
                villeB.getCoordonnee().getLatitude(),
                villeB.getCoordonnee().getLongitude()
        ) / 1000;
        DecimalFormat df = new DecimalFormat("#.#");
        request.setAttribute("distance", df.format(distance));

        doGet(request, response);
    }
}
