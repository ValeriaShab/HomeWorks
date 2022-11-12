package main.java.com.shabatura.module2;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyticalInformation {
    static LinkedList<Invoice> fifteenOrdersList;

    static {
        try {
            fifteenOrdersList = ShopService.generateFifteenOrders();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void getSoldGoodsByCategory() {
        long countTelephones = fifteenOrdersList.stream()
                .flatMap(s -> s.getGoods().stream())
                .map(s -> s.getClass().getSimpleName())
                .filter(s -> s.equalsIgnoreCase("Telephone"))
                .count();
        System.out.println("Telephones were sold - " + countTelephones);
        long countTelevisions = fifteenOrdersList.stream()
                .flatMap(s -> s.getGoods().stream())
                .map(s -> s.getClass().getSimpleName())
                .filter(s -> s.equalsIgnoreCase("Television"))
                .count();
        System.out.println("Televisions were sold - " + countTelevisions);
        System.out.println("________________________________________________________________________________________");
    }

    public void getSumOfAllChecks() {
        int sum = fifteenOrdersList.stream()
                .flatMap(s -> s.getGoods().stream())
                .map(s -> s.getPrice())
                .mapToInt(s -> s)
                .sum();
        System.out.println("Sum of all checks - " + sum);
        System.out.println("________________________________________________________________________________________");

    }

    public void firstThreeChecks() {
        System.out.println("Three first Invoices: ");
        fifteenOrdersList.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________");
    }

    public void countRetailChecks() {
        long retailChecks = fifteenOrdersList.stream()
                .filter(s -> s.getType().equalsIgnoreCase("retail"))
                .count();
        System.out.println("Retail checks: " + retailChecks);
        System.out.println("________________________________________________________________________________________");
    }

    public void getMinSumOfCheck() {
        Map<Customer, Integer> sumOfInvoice = fifteenOrdersList.stream()
                .collect(Collectors.toMap(Invoice::getCustomer,
                        invoice -> invoice.getGoods().stream()
                                .mapToInt(Goods::getPrice)
                                .sum()));

        Optional<Integer> min = sumOfInvoice.entrySet().stream()
                .map(s -> s.getValue().intValue())
                .min(Integer::compareTo);

        System.out.println("Minimal sum of Invoice - " + min.get() + " for Customers: ");
        sumOfInvoice.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), min.get()))
                .map(Map.Entry::getKey)
                .toList()
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________");
    }

    public void getChecksWithOneKindOfGoods() {
        List<Invoice> checksWithOnlyPhones = fifteenOrdersList.stream()
                .filter(s -> s.getGoods().stream()
                        .allMatch(t -> t.getClass().getSimpleName().equalsIgnoreCase("Telephone")))
                .collect(Collectors.toList());

        List<Invoice> checksWithOnlyTV = fifteenOrdersList.stream()
                .filter(s -> s.getGoods().stream()
                        .allMatch(t -> t.getClass().getSimpleName().equalsIgnoreCase("Television")))
                .collect(Collectors.toList());


        System.out.println("Invoices with oly Phones: ");
        printList(checksWithOnlyPhones);
        System.out.println("Invoices with oly TV: ");
        printList(checksWithOnlyTV);
        System.out.println("________________________________________________________________________________________");
    }

    public void getUnder18Checks() {
        System.out.println("Invoices for Customers younger 18: ");
        fifteenOrdersList.stream()
                .filter(s -> s.getCustomer().getAge() < 18)
                .peek(s -> s.setType("low_age"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("________________________________________________________________________________________");
    }

    public void sortAllOrders() {
        Comparator<Invoice> compareByAge = Comparator.comparing(t -> t.getCustomer().getAge());
        Comparator<Invoice> compareByItems = Comparator.comparing(t -> t.getGoods().stream()
                .count());
        Comparator<Invoice> compareBySum = Comparator.comparing(t -> t.getGoods().stream()
                .mapToInt(Goods::getPrice)
                .sum());
        Comparator<Invoice> compareByAllConditions = compareByAge.reversed().thenComparing(compareByItems).thenComparing(compareBySum);

        Collections.sort(fifteenOrdersList, compareByAllConditions);
        System.out.println("Sorted invoices: ");
        printList(fifteenOrdersList);
    }

    private void printList(List<Invoice> list) {
        list.stream()
                .forEach(System.out::println);
    }
}
