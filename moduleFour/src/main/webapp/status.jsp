<%@page language="java" import="java.util.*" %>
<html>
<body>
<h2 align="center">Races statistic</h2>
<p>To start the race push the link below</p>
        <p><a href="race/start">Start new race</a></p>
  <tr>
    <td><b>race_id</b></td>
    <td><b>date</b></td>
    <td><b>user_bet</b></td>
    <td><b>winner</b></td>
    <td><b>Select</b></td>
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
    <td><a href="race/{id}">Select</a></td>
  </tr>
  <%}%>
</table>
</body>
</html>