package servlet;

import business.SearchSB;
import model.Listing;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/viewListing")
public class ViewListingDetailsServlet extends HttpServlet {
    private SearchSB searchSB = new SearchSB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Listing listing = searchSB.getListingById(id);
            request.setAttribute("listing", listing);
            RequestDispatcher rd = request.getRequestDispatcher("viewListing.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving listing details", e);
        }
    }
}
