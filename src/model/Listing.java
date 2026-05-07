package model;

public class Listing {
    private int listingId;
    private int landlordId;
    private String title;
    private String description;
    private double price;
    private String location;
    private String imagePath;

    
    public int getListingId() { 
        return listingId; 
    }
    public void setListingId(int listingId) { 
        this.listingId = listingId;
    }

    public int getLandlordId() {
        return landlordId; 
    }
    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getDescription() { 
        return description;
    }
    public void setDescription(String description) { 
        this.description = description;
    }

    public double getPrice() {
        return price; 
    }
    public void setPrice(double price) {
        this.price = price; 
    }

    public String getLocation() { 
        return location;
    }
    public void setLocation(String location) {
        this.location = location; 
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath; 
    }
}

