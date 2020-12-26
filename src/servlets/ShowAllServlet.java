package servlets;

import dao.CountryDAO;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllServlet extends HttpServlet {
    private final CountryDAO countryDAO = new CountryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countries = countryDAO.getAll();
        req.setAttribute("countries", countries);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Country country = new Country(0, title);
        countryDAO.add(country);
        List<Country> countries = countryDAO.getAll();
        req.setAttribute("countries", countries);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
