<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<@@ page session="false" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    </head>

    <body>
        <h1>Welcome to Spittr</hi>

        <a href="<c:url value="/spittles" />">Spittles</a>
        <a href="<c:url value="/spittles/register" />">Register</a>
    </body>
</html>
