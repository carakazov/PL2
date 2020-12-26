package servlets;

import dao.CountryDAO;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChangeDeleteServlet extends HttpServlet {
    private final CountryDAO countryDAO = new CountryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int countryId = Integer.parseInt(req.getParameter("countryId"));
        countryDAO.delete(countryId);
        List<Country> countries = countryDAO.getAll();
        req.setAttribute("countries", countries);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int countryId = Integer.parseInt(req.getParameter("countryId"));
        String title = req.getParameter("title");
        Country country = new Country(countryId, title);
        countryDAO.upadte(country);
        List<Country> countries = countryDAO.getAll();
        req.setAttribute("countries", countries);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
