package persistence;

import components.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//create table restaurants(
//        id int,
//        username varchar(50),
//        emailAddress varchar(100),
//        addressID int,
//        phoneNumber varchar(15),
//        cuisine varchar(50),
//        waitingTime long);

public class RestaurantsRepository implements CRUDRepository<Restaurant> {

    private Connection connection;

    public RestaurantsRepository() {
        try {
            this.connection = DbConnection.getInstance();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Verify connectivity to database!!");
        }
    }

    @Override
    public void save(Restaurant restaurant) {

        String query = "insert into restaurants values (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, restaurant.getId());
            preparedStatement.setString(2, restaurant.getUsername());
            preparedStatement.setString(3, restaurant.getEmailAdress());
            preparedStatement.setInt(4, restaurant.getRestaurantAddress());
            preparedStatement.setString(5, restaurant.getPhoneNumber());
            preparedStatement.setString(6, restaurant.getTypeOfCuisine());
            preparedStatement.setLong(7, restaurant.getWaitingTime());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> couriers = new ArrayList<>();
        String query = "select * from restaurants";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Integer ID = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                Integer address = resultSet.getInt(4);
                String phone = resultSet.getString(5);
                String cuisine = resultSet.getString(6);
                Long waitingTime = resultSet.getLong(7);
                couriers.add(new Restaurant(username, email, address, phone, cuisine, waitingTime));
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return couriers;
    }
}
