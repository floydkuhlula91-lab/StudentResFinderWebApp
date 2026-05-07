package servlet;

import business.SearchSB;
import model.Listing;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {
    private SearchSB searchSB = new SearchSB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double min = Double.parseDouble(request.getParameter("min"));
        double max = Double.parseDouble(request.getParameter("max"));

        try {
            List<Listing> listings = searchSB.filterByPrice(min, max);
            request.setAttribute("listings", listings);
            RequestDispatcher rd = request.getRequestDispatcher("searchResults.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error filtering listings", e);
        }
    }
}

