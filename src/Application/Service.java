package Application;

import Components.*;
import java.util.*;

public class Service {
    private List<Client> clients = new ArrayList<Client>();
    private List<Courier> couriers = new ArrayList<Courier>();
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

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

//    1. Compute the salary of a courier
    public Float computeSalary(Courier courier){
        return courier.getWorkedHours()*courier.getEurPerHour();
    }

}
