package com.shabatura.module3.service;

import com.shabatura.module3.actions.AbonentAction;
import com.shabatura.module3.actions.ActTypeAction;
import com.shabatura.module3.actions.ActivityAction;
import com.shabatura.module3.actions.DeviceAction;
import com.shabatura.module3.entity.Activity;

import java.util.List;
import java.util.Scanner;

public class ServiceMenu {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ActivityAction ACTIVITY_ACTION = new ActivityAction();
    private static final ActTypeAction ACT_TYPE_ACTION = new ActTypeAction();
    private static final DeviceAction DEVICE_ACTION = new DeviceAction();
    private static final AbonentAction ABONENT_ACTION = new AbonentAction();

    public void actionMenu() {
        final String[] actionsMenu = new String[ActionsMenu.values().length];
        for (int i = 0; i < actionsMenu.length; i++) {
            actionsMenu[i] = ActionsMenu.values()[i].getName();
        }
        int choice;
        do {
            System.out.println("\n\nВведите число, чтобы увидеть информацию");
            for (int i = 0; i < actionsMenu.length; i++) {
                System.out.printf("%d) %s%n", i + 1, actionsMenu[i]);
            }
            choice = SCANNER.nextInt();
            switch (choice) {
                case 1 : searchSMSbyPhrase();
                break;
                case 2 : topAbonentsByCalls();
                break;
                case 3 : topAbonentsBySMS();
                break;
                case 4 : topAbonentsByInternet();
                break;
                case 5 : mostPopularService();
                break;
                case 6 : mostPopularDevice();
                break;
            }
        } while (choice > 0 && choice < actionsMenu.length);
        SCANNER.close();
    }

    private void searchSMSbyPhrase() {
        System.out.println("Введите фразу по которой вы хотите найти сообщение:");
        SCANNER.nextLine();
        String phrase = SCANNER.nextLine();
        List<Activity> SMSyByText = ACTIVITY_ACTION.getSMSyByText(phrase);
        if (!SMSyByText.isEmpty()){
            for (Activity activity : SMSyByText) {
                System.out.println(activity);
            }
        } else {
            System.out.println("В базе нет такого сообщения '" + phrase + "'");
        }
    }

    private void topAbonentsByCalls() {
        System.out.println("TOP 5 абонентов по вызовам");
        List<Object[]> subscribers = ABONENT_ACTION.getTop5AbonentsByCall();
        printInfo(subscribers);
    }

    private void topAbonentsBySMS() {
        System.out.println("TOP 5 абонентов по количеству СМС");
        List<Object[]> subscribers = ABONENT_ACTION.getTop5AbonentsBySMS();
        printInfo(subscribers);
    }
    private void topAbonentsByInternet() {
        System.out.println("TOP 5 абонентов по использованию сети");
        List<Object[]> subscribers = ABONENT_ACTION.getTop5AbonentsByInternet();
        printInfo(subscribers);
    }

    private void mostPopularService() {
        System.out.println("Самый популярный сервис среди абонентов:");
        List<Object[]> activity = ACT_TYPE_ACTION.getMostPopularActivity();
        printInfo(activity);
    }

    private void mostPopularDevice() {
        System.out.println("Самая популярная модель среди абонентов:");
        List<Object[]> activity = DEVICE_ACTION.getMostPopularDevice();
        printInfo(activity);
    }

    public void printInfo(List<Object[]> information){
        for (Object[] info : information) {
            System.out.printf("%s: %s%n", info[0], info[1]);
        }
    }
}
