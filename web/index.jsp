<%--
  Created by IntelliJ IDEA.
  User: Sit
  Date: 28.09.2017
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <div>
    <h2>Заполните поля:</h2>

    <form method="POST" action="" >
      <table style="width:100%">
        <tr>
          <th>Имя заявителя</th>
          <th>Доход в месяц</th>
          <th>ID паспорта</th>
        </tr>
        <tr>
          <td><input class="flds" type="text" name="userName" placeholder="Введите имя..." /></td>
          <td><input class="flds" type="text" name="income" placeholder="Введите доход..." /></td>
          <td><input class="flds" type="text" name="passportId" placeholder="Введите идентификационный номер паспорта..." /></td>
        </tr>
      </table>
      <div class="buttons">
        <input type="submit" value="Отправить на подпись" />
      </div>
    </form>
  </div>
</html>
