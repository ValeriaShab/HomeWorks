package main.java.com.shabatura.module2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ShopService {

    public static List<Goods> readFromCSVtoList() throws MyException {
        File file = new File("Goods.csv");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Goods> goods = new ArrayList<>();

        while (true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            String line = scanner.nextLine();
            String[] items = line.split(",");

            for (int i = 0; i < items.length; i++) {
                Television television = new Television("", "", 0, 0, "");
                Telephone telephone = new Telephone("", "", "", 0);

                if (items[0].contains("Television")) {
                    television.series = items[1];
                    television.diagonal = Integer.parseInt(items[3]);
                    television.screenType = items[4];
                    television.country = items[5];
                    television.price = Integer.parseInt(items[6]);
                    goods.add(television);
                } else if (items[0].contains("Telephone")) {
                    telephone.series = items[1];
                    telephone.model = items[2];
                    telephone.screenType = items[4];
                    telephone.price = Integer.parseInt(items[6]);
                    goods.add(telephone);
                }
            }
        }
        scanner.close();
        return goods;
    }


    public static List<Goods> formOrder(List<Goods> goods) {
        Random random = new Random();
        List<Goods> randomOrder = new ArrayList<>();
        int randomNum = random.nextInt(1, 5);
        for (int i = 0; i < randomNum; i++) {
            randomOrder.add(goods.get(random.nextInt(goods.size())));
        }
        return randomOrder;
    }

    public static Invoice formInvoice() throws MyException {
        List<Goods> goods = formOrder(readFromCSVtoList());
        Customer customer = PersonService.generateCustomer();
        String type = Invoice.setType(Invoice.chooseInvoiceType(goods));
        return new Invoice(goods, customer, type);

    }

    public static LinkedList<Invoice> generateFifteenOrders() throws MyException {
        LinkedList<Invoice> fifteenOrdersList = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            fifteenOrdersList.add(formInvoice());
        }
        return fifteenOrdersList;
    }

    public static void writeFileWithInvoices() throws MyException {
        LinkedList<Invoice> invoices = generateFifteenOrders();
        try (FileWriter fileWriter = new FileWriter("invoices.txt")) {
            for (Invoice invoice : invoices) {
                fileWriter.write(invoice.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
