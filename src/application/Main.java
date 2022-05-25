package application;

import components.*;
import persistence.AdressesRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main {
    public static void main(String[] args) throws IOException {
        AdressesRepository adressesRepository = new AdressesRepository();
        adressesRepository.save(new Address(1, "Doamnei","Bucuresti","Bucuresti","Romania","B",20,4,16));



        Service services = Service.getInstance();

        List<String[]> dataAdresses, dataClients, dataCouriers, dataDishes, dataRestaurants;

        ReadFromCsv readFromCsv = ReadFromCsv.getInstance();

        dataAdresses = readFromCsv.read("csv_data/addresses.csv");
        for(String[] data : dataAdresses){
            Address addr = new Address(parseInt(data[1]), data[2], data[3], data[4], data[5], data[6], parseInt(data[7]), parseInt(data[8]), parseInt(data[9]));
            services.addAddress(addr);
        }

        dataClients = readFromCsv.read("csv_data/clients.csv");
        for(String[] data : dataClients){
            Client clnt = new Client(data[1], data[2], parseInt(data[3]), data[4]);
            services.addClient(clnt);
        }

        dataCouriers = readFromCsv.read("csv_data/couriers.csv");
        for(String[] data : dataCouriers){
            Courier crr = new Courier(data[1], data[2], parseFloat(data[3]), parseFloat(data[4]));
            services.addCourier(crr);
        }

        dataDishes = readFromCsv.read("csv_data/dishes.csv");
        for(String[] data : dataDishes){
            System.out.println(data[3]);
            //Dish dsh = new Dish(data[0], parseFloat(data[1]), parseFloat(data[2]), data[3]);
        }

        dataRestaurants = readFromCsv.read("csv_data/restaurants.csv");
        for(String[] data : dataRestaurants){
            Restaurant rst = new Restaurant(data[1], data[2], parseInt(data[3]), data[4], data[5], parseLong(data[6]));
            services.addRestaurant(rst);
        }

        Address anabanana_address = new Address(20, "Washington", "Bucharest", "Bucharest", "Romania", "B", 27, 4, 20);
        Client anabanana = new Client("anabanana", "anabanana@gmail.com", 20, "+40755667231");

        Courier gheorghita = new Courier("gheorghita", "gheorghita@yahoo.com", 23.0f, 5.1f);

        String[] baklavaIngredients = {"sugar", "milk"};
        Dish baklava = new Dish("baklava", 150f, 23.20f, Arrays.stream(baklavaIngredients).toList());


        Scanner in = new Scanner(System.in);
        int option;
        boolean exit = false;

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