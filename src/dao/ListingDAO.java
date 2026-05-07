package dao;

import model.Listing;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListingDAO {

    public List<Listing> searchByLocation(String location) throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Listing> results = new ArrayList<>();
        String sql = "SELECT * FROM listings WHERE location LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + location + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            results.add(mapListing(rs));
        }
        rs.close();
        ps.close();
        conn.close();
        return results;
    }

    public List<Listing> filterByPrice(double min, double max) throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Listing> results = new ArrayList<>();
        String sql = "SELECT * FROM listings WHERE price BETWEEN ? AND ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, min);
        ps.setDouble(2, max);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            results.add(mapListing(rs));
        }
        rs.close();
        ps.close();
        conn.close();
        return results;
    }

    public List<Listing> getAllListings() throws SQLException {
        Connection conn = DBConnection.getConnection();
        List<Listing> results = new ArrayList<>();
        String sql = "SELECT * FROM listings";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            results.add(mapListing(rs));
        }
        rs.close();
        stmt.close();
        conn.close();
        return results;
    }

    public Listing getListingById(int id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM listings WHERE listingId=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Listing listing = null;
        if (rs.next()) {
            listing = mapListing(rs);
        }
        rs.close();
        ps.close();
        conn.close();
        return listing;
    }

    private Listing mapListing(ResultSet rs) throws SQLException {
        Listing l = new Listing();
        l.setListingId(rs.getInt("listingId"));
        l.setLandlordId(rs.getInt("landlordId"));
        l.setTitle(rs.getString("title"));
        l.setDescription(rs.getString("description"));
        l.setPrice(rs.getDouble("price"));
        l.setLocation(rs.getString("location"));
        l.setImagePath(rs.getString("imagePath"));
        return l;
    }
}

