package Application;

import Components.*;

import java.time.LocalDateTime;
import java.util.*;

public class Service {
    private List<Client> clients = new ArrayList<Client>();
    private List<Courier> couriers = new ArrayList<Courier>();
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();
    private List<Order> orders = new ArrayList<Order>();

    private final ReadServices readServices = new ReadServices();

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
        for(var restaurant : restaurants){
            System.out.println(restaurant.toString());
        }
    }

    public void addOrder(Order order){
        orders.add(order);
    }
    public void showOrders(){
        for(var order : orders){
            System.out.println(order.toString());
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

//    7.
}
