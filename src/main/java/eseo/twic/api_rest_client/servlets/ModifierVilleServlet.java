package eseo.twic.api_rest_client.servlets;

import eseo.twic.api_rest_client.dao.VilleDao;
import eseo.twic.api_rest_client.dto.Ville;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ModifierVille")
public class ModifierVilleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    VilleDao villeDao = new VilleDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateCodeCommune = request.getParameter("codeCommuneInsee");
        Ville ville = villeDao.villeWithCodeCommune(updateCodeCommune);

        request.setAttribute("codeCommuneInsee", updateCodeCommune);
        request.setAttribute("ville", ville);

        this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateNomCommune = request.getParameter("nom");
        String updateCodeCommune = request.getParameter("codeCommune");
        String updateCodePostal = request.getParameter("codePostal");
        String updateLibelleAcheminement = request.getParameter("libelle");
        String updateLigne5 = request.getParameter("ligne5");
        String updateLatitude = request.getParameter("latitude");
        String updateLongitude = request.getParameter("longitude");

        Ville villeNonModifiee = villeDao.villeWithCodeCommune(updateCodeCommune);
        request.setAttribute("villeNonModifiee", villeNonModifiee);

        VilleDao ville = new VilleDao();
        ville.updateVille(
                updateNomCommune,
                updateCodeCommune,
                updateCodePostal,
                updateLibelleAcheminement,
                updateLigne5,
                updateLatitude,
                updateLongitude
        );

        Ville villeModifiee = ville.villeWithCodeCommune(updateCodeCommune);
        request.setAttribute("villeModifiee", villeModifiee);

        this.getServletContext().getRequestDispatcher("/WEB-INF/villeModifiee.jsp").forward(request, response);
    }
}
