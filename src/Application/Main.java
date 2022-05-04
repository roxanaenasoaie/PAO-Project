package Application;

import Components.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Service services = Service.getInstance();

        Scanner in = new Scanner(System.in);
        int option;
        boolean exit = false;

        Address anabanana_address = new Address("Washington", "Bucharest", "Bucharest", "Romania", "B", 27, 4, 20);
        Client anabanana = new Client("anabanana", "anabanana@gmail.com", anabanana_address, "+40755667231");

        Courier gheorghita = new Courier("gheorghita", "gheorghita@yahoo.com", 23.0f, 5.1f);

        String[] baklavaIngredients = {"sugar", "milk"};
        Dish baklava = new Dish("baklava", 150f, 23.20f, Arrays.stream(baklavaIngredients).toList());

        while (!exit) {

            services.showMenu();

            option = in.nextInt();

            switch (option) {
                case 1 -> services.addClient(anabanana);
                case 2 -> services.addCourier(gheorghita);
                //case 3 -> services.addOrder();
                //case 4 -> services.addRestaurant();
                case 5 -> services.showClients();
                case 6 -> services.showCouriers();
                case 7 -> services.showRestaurants();
                case 8 -> services.showOrders();
                case 9 -> services.computeSalary(gheorghita);
                //case 10 -> services.computePrice();
                case 11 -> services.computeCredit(anabanana);
                case 12 -> services.noOfOrders("turkish");
                case 13 -> services.deleteOrders();
                case 14 -> services.arrivalTime(anabanana);
                default -> exit = true;
            }
        }
    }
}