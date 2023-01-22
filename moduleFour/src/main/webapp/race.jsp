<%@page language="java" import="java.util.*" %>
<html>
    <body>
    <h2 align="center">Races statistic</h2>
    <p>To start the race push the link below</p>
            <p><a href="race/start">Start new race</a></p>
        <table style="width:50%">
        <p> Race with id</p>
          <tr>
            <td><b>id</b></td>
            <td><b>date</b></td>
            <td><b>horse_number</b></td>
            <td><b>place</b></td>
            <td><b>number_for_a_bet</b></td>
            <td><b>amount</b></td>
            <td><b>race_id</b></td>
          </tr>
          <%Iterator itr;%>
          <% List data= (List)request.getAttribute("data");
          for (itr=data.iterator(); itr.hasNext(); )
          {
          %>
          <tr>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
            <td><%=itr.next()%></td>
          </tr>
          <%}%>
        </table>
    </body>
</html>