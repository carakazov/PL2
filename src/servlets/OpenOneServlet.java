package servlets;

import dao.CountryDAO;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenOneServlet extends HttpServlet {
    private final CountryDAO countryDAO = new CountryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int countryId = Integer.parseInt(req.getParameter("countryId"));
        Country country = countryDAO.getOneById(countryId);
        req.setAttribute("country", country);
        req.getRequestDispatcher("Change.jsp").forward(req, resp);
    }
}
