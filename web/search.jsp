<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Accommodation</title>
</head>
<body>
    <h2>Find Student Accommodation</h2>

    <!-- Search by Location -->
    <form action="search" method="get">
        <input type="text" name="location" placeholder="Enter location">
        <button type="submit">Search</button>
    </form>

    <!-- Filter by Price -->
    <form action="filter" method="get">
        <input type="number" name="min" placeholder="Min Price">
        <input type="number" name="max" placeholder="Max Price">
        <button type="submit">Filter</button>
    </form>
</body>
</html>
