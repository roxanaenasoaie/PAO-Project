package components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    private Client client;
    private Courier courier;
    private Restaurant restaurant;
    private TreeMap<Dish, Integer> orderedDishes;
    private LocalDateTime timeOfOrder;

    public Order(Client client, Courier courier, Restaurant restaurant, TreeMap<Dish, Integer> orderedDishes) {
        this.client = client;
        this.courier = courier;
        this.restaurant = restaurant;
        this.orderedDishes = orderedDishes;
        this.timeOfOrder = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Map<Dish, Integer> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(TreeMap<Dish, Integer> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }
    public void setTimeOfOrder(LocalDateTime timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", courier=" + courier +
                ", restaurant=" + restaurant +
                ", orderedDishes=" + orderedDishes +
                ", timeOfOrder=" + timeOfOrder +
                '}';
    }
}
