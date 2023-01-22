package com.shabatura.module4.servlets;

import com.shabatura.module4.dao.RaceDao;
import com.shabatura.module4.dao.RaceStatusDao;
import com.shabatura.module4.model.Race;
import com.shabatura.module4.model.RaceStatus;
import com.shabatura.module4.service.CallableRace;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

@WebServlet(
        name = "StartServlet",
        urlPatterns = {"/race/start"}
)
public class StartServlet extends HttpServlet{
    private static final LocalDateTime DATE_TIME = LocalDateTime.now();
    private static final RaceDao RACE_DAO = new RaceDao();
    private static final RaceStatusDao RACE_STATUS_DAO = new RaceStatusDao();
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
        resp.setContentType("text/html");
        req.getRequestDispatcher("start.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String amountOfHorses = request.getParameter("amountOfHorses");
        String bet = request.getParameter("bet");

        int numberOfHorses = Integer.parseInt(amountOfHorses);
        int numberForABet = Integer.parseInt(bet);
        if (numberOfHorses != 0) {
            try {
                LinkedList<Integer> finish = new LinkedList<>();
                List<Future<LinkedList<Integer>>> listOfFuture = new ArrayList<>();
                ExecutorService executor = Executors.newFixedThreadPool(numberOfHorses);
                getListOfFutureTask(finish, listOfFuture, numberOfHorses, executor);
                RaceStatus raceStatus = createAndSaveRaceStatus(8, listOfFuture.get(0).get().get(0), numberForABet);
                String sql = "INSERT INTO race_status VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, 14);
                statement.setDate(2, Date.valueOf("1988-09-29"));
                statement.setInt(3, numberForABet);
                statement.setInt(4, listOfFuture.get(0).get().get(0));
                statement.executeQuery(sql);
                RACE_STATUS_DAO.getAll().forEach(System.out::println);
                for (int i = 0; i < numberOfHorses; i++) {
                    int position = listOfFuture.get(i).get().get(i);
                    int horseNumber = i + 1;
                    Race race = createAndSaveRace(numberOfHorses, horseNumber, numberForABet, position, raceStatus);
                }
            } catch (SQLException | ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                writer.close();
            }
            request.getRequestDispatcher("start.jsp").forward(request, response);
        }

    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }

    private static void getListOfFutureTask(LinkedList<Integer> finish, List<Future<LinkedList<Integer>>> listOfFuture,
                                            int numberOfHorses, ExecutorService executor) {
        for (int i = 1; i < numberOfHorses + 1; i++) {
            CallableRace callable = new CallableRace((i), finish);
            Future<LinkedList<Integer>> futureTask = executor.submit(callable);
            listOfFuture.add(futureTask);
        }
        executor.shutdown();
    }

    private static RaceStatus createAndSaveRaceStatus(int id, int winner, int numberForABet) {
        RaceStatus raceStatus = new RaceStatus(id, winner, numberForABet, DATE_TIME);
        RACE_STATUS_DAO.save(raceStatus);
        return raceStatus;
    }

    private static Race createAndSaveRace(int amount, int horseNumber, int numberForABet,
                                          int place, RaceStatus raceStatus) {
        Race race = new Race(DATE_TIME, horseNumber, amount, place, numberForABet);
        race.setRaceStatus(raceStatus);
        RACE_DAO.save(race);
        return race;
    }

}
