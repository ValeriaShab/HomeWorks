<%@page language="java" import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Sample</title>
</head>
    <body>
    <h2 align="center">Start of races</h2>
    <p>To check races statistic push the link below</p>
    <p><a href="status">Races statistic</a></p>
        <form action="start" method="POST">
          <label for="amountOfHorses">Amount of horses:</label><br>
          <input type="number" id="amountOfHorses" name="amountOfHorses"><br>
          <label for="bet">Number of the horse for a bet:</label><br>
          <input type="number" id="bet" name="bet" min="1" max="amountOfHorses"><br>
          <input type="submit" value="Start">
        </form>
    </body>
</html>