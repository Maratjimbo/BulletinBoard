<%@ page import="board.model.Ad" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<style>
    <%@include file='/css/main.css' %>
</style>
<html>
    <head>
        <title>Board</title>
    </head>
    <body>
        <div>
            <h1>Board</h1>
        </div>
        <div>
            <div>
                <%
                    String auth = (String)request.getAttribute("authorized");
                    Map<Integer, Ad> ads = (Map<Integer, Ad>)request.getAttribute("ads");

                    if (auth.equals("false")) {
                        out.print("<a href='/login'\">Login</a>\n" +
                                "<a href='/registration'\">Registration</a>");
                    } else {
                        out.print("<a href='/logout'\">Logout</a><div>\n" +
                                "    <form method=\"post\">\n" +
                                "        <label>Title:<br>\n" +
                                "            <input type=\"text\" name=\"title\">\n" +
                                "        </label>\n" +
                                "        <br>Text:<br>\n" +
                                "        <textarea name=\"text\" rows=\"3\"></textarea>\n" +
                                "        <button type=\"submit\">Submit</button>\n" +
                                "    </form>\n" +
                                "</div>");
                    }
                    if (ads != null) {
                        for (Integer id : ads.keySet()) {
                            Ad ad = ads.get(id);
                            out.print("<h1>Title: " + ad.getTitle() + "</h1><br>\n" +
                                    "Author: " + ad.getAuthor() + "<br>\n" +
                                    "<p>" + ad.getText() + "</p>");
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>
