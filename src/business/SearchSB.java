package business;

import dao.ListingDAO;
import model.Listing;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class SearchSB {
    private ListingDAO listingDAO = new ListingDAO();

    public List<Listing> searchByLocation(String location) throws SQLException {
        return listingDAO.searchByLocation(location);
    }

    public List<Listing> filterByPrice(double min, double max) throws SQLException {
        return listingDAO.filterByPrice(min, max);
    }

    public List<Listing> getAllListings() throws SQLException {
        return listingDAO.getAllListings();
    }

    public Listing getListingById(int id) throws SQLException {
        return listingDAO.getListingById(id);
    }
}
