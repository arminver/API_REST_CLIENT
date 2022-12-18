package eseo.twic.api_rest_client.servlets;

import eseo.twic.api_rest_client.dao.VilleDao;
import eseo.twic.api_rest_client.dto.Ville;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    VilleDao villeDao = new VilleDao();
    ArrayList<Ville> villes;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        villes = (ArrayList<Ville>) villeDao.findVilles();
        request.setAttribute("villes", villes);
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
