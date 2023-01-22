package com.shabatura.module4.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "raceId",
        urlPatterns = {"/race/*"}
)
public class RaceServlet extends HttpServlet {
    final String connectionURL = "jdbc:postgresql://localhost:5432/module4";
    final String USER = "postgres";
    final String PASSWORD = "root";
    final String DRIVER = "org.postgresql.Driver";
    Connection connection = null;

    @Override
    public void init() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(connectionURL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultSet resultSet;
        String url = req.getRequestURL().toString();

        resp.setContentType("text/html");
        List dataList = new ArrayList();
        try {
            String sql = "SELECT * FROM races";
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                dataList.add(resultSet.getInt("id"));
                dataList.add(resultSet.getDate("date"));
                dataList.add(resultSet.getInt("horse_number"));
                dataList.add(resultSet.getInt("place"));
                dataList.add(resultSet.getInt("number_for_a_bet"));
                dataList.add(resultSet.getInt("amount"));
                dataList.add(resultSet.getInt("race_id"));
            }
            resultSet.close();
            statement.close();
            req.setAttribute("data", dataList);
            req.getRequestDispatcher("race.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }

    private boolean validateId(HttpServletRequest req) {
        return req.getPathInfo().matches("\\/\\d+");
    }
}
