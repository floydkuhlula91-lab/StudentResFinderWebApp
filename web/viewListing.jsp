<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Listing" %>
<html>
<head>
    <title>Listing Details</title>
</head>
<body>
    <h2>Listing Details</h2>

    <%
        Listing l = (Listing) request.getAttribute("listing");
        if (l != null) {
    %>
        <div>
            <h3><%= l.getTitle() %></h3>
            <p><%= l.getDescription() %></p>
            <p>Price: R<%= l.getPrice() %></p>
            <p>Location: <%= l.getLocation() %></p>
            <img src="<%= l.getImagePath() %>" width="300">
        </div>
    <%
        } else {
    %>
        <p>No listing found.</p>
    <%
        }
    %>

    <hr>
    <a href="search.jsp">Back to Search</a>
</body>
</html>
