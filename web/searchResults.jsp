<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Listing" %>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <h2>Search Results</h2>

    <%
        List<Listing> listings = (List<Listing>) request.getAttribute("listings");
        if (listings != null && !listings.isEmpty()) {
            for (Listing l : listings) {
    %>
        <div>
            <h3><%= l.getTitle() %></h3>
            <p><%= l.getDescription() %></p>
            <p>Price: R<%= l.getPrice() %></p>
            <p>Location: <%= l.getLocation() %></p>
            <img src="<%= l.getImagePath() %>" width="200">
            <a href="viewListing?id=<%= l.getListingId() %>">View Details</a>
        </div>
    <%
            }
        } else {
    %>
        <p>No listings found.</p>
    <%
        }
    %>

    <hr>
    <a href="search.jsp">Back to Search</a>
</body>
</html>
