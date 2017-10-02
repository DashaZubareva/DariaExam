<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sit
  Date: 28.09.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<div>

    <h2>Заполните поля:</h2>

    <form action="/sendNew" method="POST">
        <table style="width:100%">
            <tr>
                <th>Год производтсва</th>
                <th>Марка машины</th>
                <th>Цвет</th>
            </tr>
            <tr>
                <td><input class="flds" type="text" name="year" placeholder="Введите год..." /></td>
                <td><input class="flds" type="text" name="name" placeholder="Введите марку..." /></td>
                <td><input class="flds" type="text" name="color" placeholder="Введите цвет" /></td>
            </tr>
        </table>
        <div class="buttons">
            <input type="submit" value="отправить" />
        </div>

    </form>
</div>
</body>
</html>
