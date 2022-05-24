package application;

import components.*;

import java.time.LocalDateTime;
import java.util.*;

public class Service {
    private List<Client> clients = new ArrayList<Client>();
    private List<Courier> couriers = new ArrayList<Courier>();
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();
    private List<Order> orders = new ArrayList<Order>();
    private List<Address> addresses = new ArrayList<Address>();
    private List<Dish> dishes = new ArrayList<Dish>();

    private final ReadServices readServices = new ReadServices();

    private static Service servicesInstance = null;

    public static Service getInstance() {
        if (servicesInstance == null)
            servicesInstance = new Service();
        return servicesInstance;
    }

    public final void showMenu() {
        System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #");
        System.out.println("# # # # #   Welcome!   # # # # #");
        System.out.println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #");
        System.out.println("    Here are the options: ");
        System.out.println("1. Add a client to the app.");
        System.out.println("2. Add an courier to the app.");
        System.out.println("3. Add a dish.");
        System.out.println("4. Add a restaurant for the app.");
        System.out.println("5. Show client list of the app.");
        System.out.println("6. Show courier list of the app.");
        System.out.println("7. Show restaurants of the app.");
        System.out.println("8. Show orders made in the app.");
        System.out.println("9. Show salary of a courier.");
        System.out.println("10. Show the price of an order.");
        System.out.println("11. Show credit of a client.");
        System.out.println("12. Show how many orders were given from restaurants with a turkish specific.");
        System.out.println("13. Delete the orders older than 24h.");
        System.out.println("14. Show estimated arrival time for the order of a given client.");
        System.out.println("15. EXIT");
        System.out.println(" - Introduce the option number: ");
    }

    public void addClient(Client client){
        clients.add(client);
    }
    public void showClients(){
        for(var client : clients){
            System.out.println(client.toString());
        }
    }

    public void addCourier(Courier courier){
        couriers.add(courier);
    }
    public void showCouriers(){
        for(var courier : couriers){
            System.out.println(courier.toString());
        }
    }

    public void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }
    public void showRestaurants(){
//        for(var restaurant : restaurants){
//            System.out.println(restaurant.toString());
//        }

//        restaurantRepository.findAll().forEach(Sout);
    }

    public void addOrder(Order order){
        orders.add(order);
    }
    public void showOrders(){
        for(var order : orders){
            System.out.println(order.toString());
        }
    }

    public void addAddress(Address address)
    {
//        addresses.add(address);

//        adressesRepository.save(address);
    }

    public void showAddresses(){
        for(var address : addresses){
            System.out.println(address.toString());
        }
    }

    public void addDish(Dish dish){dishes.add(dish);}
    public void showDishes(){
        for(var dish : dishes){
            System.out.println(dish.toString());
        }
    }
//    1. Compute the salary of a courier
    public Float computeSalary(Courier courier){
        return courier.getWorkedHours()*courier.getEurPerHour();
    }

//    2. Determine how much money does an order cost
    public Double computePrice(Order order){
        Double price = 0.0;

        for(Map.Entry<Dish, Integer> dish : order.getOrderedDishes().entrySet()){
                price += dish.getKey().getDishPrice() * dish.getValue();
        }

        return price;
    }

//    3. Compute the credit for a client (how much money he spent on orders).
    public Double computeCredit(Client client){
        Double credit = 0.0;

        for(var order : orders){
            if(order.getClient().getId().equals(client.getId())){
                credit += computePrice(order);
            }
        }

        return credit;
    }

//    4. Find out how many orders were from restaurants with a given specific(eg. turkish)
    public Integer noOfOrders(String specific){
        Integer numberOfOrders = 0;

        for(var restaurant : restaurants){
            if(restaurant.getTypeOfCuisine().equals(specific)){
                for(var order : orders){
                    if(order.getRestaurant().getId().equals(restaurant.getId())){
                        numberOfOrders += 1;
                    }
                }
            }
        }

        return numberOfOrders;
    }

//    5. Delete from the list the orders older than 24h
    public void deleteOrders(){
        for(var order : orders){
            if(order.getTimeOfOrder().plusHours(24).compareTo(LocalDateTime.now()) < 0){
                    orders.remove(order);
            }
        }
    }

//    6. For the order by a given client, compute the estimated arrival time
    public LocalDateTime arrivalTime(Client client){
        LocalDateTime arrival = LocalDateTime.now();

        for(var order : orders){
            if(order.getClient().getId().equals(client.getId())){
                    arrival = order.getTimeOfOrder().plusMinutes(order.getRestaurant().getWaitingTime());
            }
        }

        return arrival;
    }

}
