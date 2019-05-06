<%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 08.12.2018
  Time: 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
    <form method="post">
        <label>Name:
            <input type="text" name="userName">
        </label>

        <label>Password:
            <input type="text" name="password">
        </label>

        <button type="submit">Submit</button>
    </form>
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
