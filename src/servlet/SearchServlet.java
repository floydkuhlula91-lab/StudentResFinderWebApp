package servlet;

import business.SearchSB;
import model.Listing;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private SearchSB searchSB = new SearchSB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String location = request.getParameter("location");

        try {
            List<Listing> listings = searchSB.searchByLocation(location);
            request.setAttribute("listings", listings);
            RequestDispatcher rd = request.getRequestDispatcher("searchResults.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error searching listings", e);
        }
    }
}

