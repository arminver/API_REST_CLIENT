package eseo.twic.api_rest_client.servlets;

import eseo.twic.api_rest_client.dao.VilleDao;
import eseo.twic.api_rest_client.dto.Ville;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AjouterVille")
public class AjouterVilleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterVille.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String codeCommune = request.getParameter("codeCommune");
        String codePostal = request.getParameter("codePostal");
        String libelle = request.getParameter("libelle");
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String ligne5 = request.getParameter("ligne5");

        VilleDao villeDao = new VilleDao();
        villeDao.addVille(nom, codeCommune, codePostal, ligne5, libelle, longitude, latitude);

        Ville ville = villeDao.villeWithCodeCommune(codeCommune);
        request.setAttribute("ville", ville);

        this.getServletContext().getRequestDispatcher("/WEB-INF/villeAjoutee.jsp").forward(request, response);
    }
}
