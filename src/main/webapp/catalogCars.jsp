<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sit
  Date: 28.09.2017
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog</title>
</head>
<body>
<div>
    <h2>Catalog Cars:</h2>
</br>

    <form action="welcome.jsp" method="POST">


        <div class="buttons">
            <input type="submit" value="Enter New Car"/>
        </div>

    </form>

    <c:forEach var="car" items="${cars}">

    <table width="40%" border="1">
        <tr width="40% " align="left">
            <td width="25% " align="left">${car.year}</td>
            <td width="25%" align="left">${car.name}</td>
            <td width="25%" align="left">${car.color}</td>
            <td width="25%"><a href="${pageContext.servletContext.contextPath}/sell?year=${car.year}">To Sell</a></td>
        </tr>
    </table>
    </c:forEach>


</div>
</body>
</html>