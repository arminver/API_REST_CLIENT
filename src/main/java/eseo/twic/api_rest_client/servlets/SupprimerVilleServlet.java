package eseo.twic.api_rest_client.servlets;

import eseo.twic.api_rest_client.dao.VilleDao;
import eseo.twic.api_rest_client.dto.Ville;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/SupprimerVille")
public class SupprimerVilleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    VilleDao villeDao = new VilleDao();
    Ville villes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String villeDeleteCode = request.getParameter("codeCommuneInsee");
        Ville ville = villeDao.villeWithCodeCommune(villeDeleteCode);

        villeDao.deleteVille(villeDeleteCode);

        request.setAttribute("codeCommuneInsee", villeDeleteCode);
        request.setAttribute("ville", ville);

        this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerVille.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
