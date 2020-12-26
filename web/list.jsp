<%@ page import="java.util.List" %>
<%@ page import="model.Country" %><%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 27.12.2020
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Counties list</title>
  </head>
  <body>
        <label>Countries list</label>
        <table>
          <tr>
            <th>
              <label>ID</label>
            </th>
            <th>
              <label>Title</label>
            </th>
          </tr>
          <%
            List<Country> countries = (List<Country>)request.getAttribute("countries");
            for(Country country : countries){
              out.print("<tr>");
              out.print("<th>" + country.getId() + "</th>");
              out.print("<th>" + country.getTitle() + "</th>");
              out.print("<th>");
              out.println("<form method=\"get\" action=\"change\">");
              out.println("<input type=\"hidden\" name=\"countryId\" value=\"" + country.getId() + "\"/>");
              out.println("<input type=\"submit\" value = \"Delete\"/>");
              out.println("</form>");
              out.println("</th>");
              out.println("<th>");
              out.println("<form method=\"get\" action=\"one\">");
              out.println("<input type=\"hidden\" name=\"countryId\" value=\"" + country.getId() + "\"/>");
              out.println("<input type=\"submit\" value = \"Modify\"/>");
              out.println("</form>");
              out.println("</th>");
              out.println("</tr>");
            }
          %>
        </table>
        <p>
          <a href="Create.html">Add new country</a>
        </p>
  </body>
</html>
