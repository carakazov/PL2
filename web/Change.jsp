<%@ page import="model.Country" %><%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 27.12.2020
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Country country = (Country) (request.getAttribute("country"));
    out.println("<form method=\"post\" action=\"change\">");
    out.println("<input type=\"hidden\" name=\"countryId\" value=\"" + country.getId() + "\"/>");
    out.println("<input type=\"text\" name=\"title\" value = \"" + country.getTitle() + "\"/>");
    out.println("<input type=\"submit\" value = \"Modify\"/>");
    out.println("</form>");
%>
</body>
</html>
