package main.java.com.shabatura.module2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        System.out.println("Please set limit for the check type: ");
        Scanner scanner = new Scanner(System.in);
        Invoice.setLimit(scanner.nextInt());
        ShopService.writeFileWithInvoices();

        AnalyticalInformation analyticalInformation = new AnalyticalInformation();
        analyticalInformation.getSoldGoodsByCategory();
        analyticalInformation.getSumOfAllChecks();
        analyticalInformation.firstThreeChecks();
        analyticalInformation.countRetailChecks();
        analyticalInformation.getMinSumOfCheck();
        analyticalInformation.getChecksWithOneKindOfGoods();
        analyticalInformation.getUnder18Checks();
        analyticalInformation.sortAllOrders();
    }
}
