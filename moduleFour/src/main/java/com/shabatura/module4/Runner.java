package com.shabatura.module4;

import com.shabatura.module4.dao.RaceDao;
import com.shabatura.module4.dao.RaceStatusDao;
import com.shabatura.module4.model.Race;
import com.shabatura.module4.model.RaceStatus;
import com.shabatura.module4.service.CallableRace;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    private static RaceStatusDao RACE_STATUS_DAO = new RaceStatusDao();
    private static final RaceDao RACE_DAO = new RaceDao();
    private static final LocalDateTime DATE_TIME = LocalDateTime.now();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedList<Integer> finish = new LinkedList<>();
        List<Future<LinkedList<Integer>>> listOfFuture = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfHorses = getNumberOfHorses(scanner);
        int numberForABat = getNumberForABet(scanner, numberOfHorses);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfHorses);
        getListOfFutureTask(finish, listOfFuture, numberOfHorses, executor);
        for (int i = 0; i < numberOfHorses; i++) {
            int position = listOfFuture.get(i).get().get(i);
            System.out.println("Horse with number " + "'" + position + "'" + " finished " + (i + 1));
        }
        RaceStatus raceStatus = createAndSaveRaceStatus(listOfFuture.get(0).get().get(0), numberForABat);
        RACE_STATUS_DAO.getAll().forEach(System.out::println);
        for (int i = 0; i < numberOfHorses; i++) {
            int position = listOfFuture.get(i).get().get(i);
            int horseNumber = i + 1;
            Race race = createAndSaveRace(numberOfHorses, horseNumber, numberForABat, position, raceStatus);
        }
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

    private static int getNumberOfHorses(Scanner scanner) {
        System.out.println("Input number of horses:");
        int numberOfHorses = scanner.nextInt();
        return numberOfHorses;
    }

    private static int getNumberForABet(Scanner scanner, int numberOfHorses) {
        System.out.println("Choose number for a bet from 1 to " + numberOfHorses);
        int horseForABet = scanner.nextInt();
        while (horseForABet < 1 || horseForABet > numberOfHorses) {
            System.out.println("Wrong number. Try again");
            horseForABet = scanner.nextInt();
        }
        return horseForABet;
    }

    private static RaceStatus createAndSaveRaceStatus(int winner, int numberForABet) {
        RaceStatus raceStatus = new RaceStatus(winner, numberForABet, DATE_TIME);
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
