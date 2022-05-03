package Application;

import Components.*;

import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDate;

public class ReadServices {
    protected Address readAddress(Scanner in){
        String street, city, county, country, buildingID;
        Integer streetNumber, floorNumber, apartmentNumber;

        System.out.println("Street: ");
        street = in.nextLine();
        System.out.println("City: ");
        city = in.nextLine();
        System.out.println("County: ");
        county = in.nextLine();
        System.out.println("Country: ");
        country = in.nextLine();
        System.out.println("Building ID: ");
        buildingID = in.nextLine();
        System.out.println("Street Number: ");
        streetNumber = in.nextInt();
        System.out.println("Floor: ");
        floorNumber = in.nextInt();
        System.out.println("Apartment: ");
        apartmentNumber = in.nextInt();

        return new Address(street, city, county, country, buildingID, streetNumber, floorNumber, apartmentNumber);
    }

    protected Client readClient(){
        Scanner in = new Scanner(System.in);

        String username, emailAddress, phoneNumber;

        System.out.println("Username: ");
        username = in.nextLine();
        System.out.println("Email Address: ");
        emailAddress = in.nextLine();
        System.out.println("Phone number: ");
        phoneNumber = in.nextLine();

        return new Client(username, emailAddress, readAddress(in), phoneNumber);

    }

    protected Courier readCourier(){
        Scanner in = new Scanner(System.in);

        String username, emailAddress;
        Float workedHours, eurPerHour;

        System.out.println("Username: ");
        username = in.nextLine();
        System.out.println("Email Address: ");
        emailAddress = in.nextLine();
        System.out.println("Worked hours: ");
        workedHours = in.nextFloat();
        System.out.println("Euro per worked hour: ");
        eurPerHour = in.nextFloat();

        return new Courier(username, emailAddress, workedHours, eurPerHour);

    }

    protected Restaurant readRestaurant(){
        Scanner in = new Scanner(System.in);

        String username, emailAddress, phoneNumber, typeOfCuisine;
        Integer waitingTime;

        System.out.println("Username: ");
        username = in.nextLine();
        System.out.println("Email Address: ");
        emailAddress = in.nextLine();
        System.out.println("Phone Number: ");
        phoneNumber = in.nextLine();
        System.out.println("Type of cuisine served: ");
        typeOfCuisine = in.nextLine();
        System.out.println("Average waiting time: ");
        waitingTime = in.nextInt();

        return new Restaurant(username, emailAddress, readAddress(in), phoneNumber, typeOfCuisine, waitingTime);
    }

    protected Dish readDish(){
        Scanner in = new Scanner(System.in);

        String dishName;
        Float dishWeight, dishPrice;
        List<String> ingredients = new ArrayList<String>();
        Integer ingredientsNumber;

        System.out.println("Dish name: ");
        dishName = in.nextLine();
        System.out.println("Dish weight in grams: ");
        dishWeight = in.nextFloat();
        System.out.println("Dish price in euros: ");
        dishPrice = in.nextFloat();

        System.out.println("Number of ingredients :");
        ingredientsNumber = in.nextInt();
        in.nextLine(); // consume the \n

        for (int i = 0; i < ingredientsNumber; i++) {
            System.out.println("Ingredient " + i + ": ");
            ingredients.add(in.nextLine());
        }

        return new Dish(dishName, dishWeight, dishPrice, ingredients);
    }

    protected Order readOrder(){
        Scanner in = new Scanner(System.in);

        Map<Dish, Integer> orderedDishes = new HashMap<Dish, Integer>();
        Integer numberOfDishes, dishPortions;
        Dish dish;

        System.out.println("How many type of dishes do you want to order?");
        numberOfDishes = in.nextInt();

        for(int i = 0; i < numberOfDishes; i++){
            System.out.println("Please enter dish details: ");
            dish = readDish();
            System.out.println("How many portions?");
            dishPortions = in.nextInt();

            orderedDishes.put(dish, dishPortions);
        }

        return new Order(readClient(), readCourier(), readRestaurant(), orderedDishes);
    }
}
