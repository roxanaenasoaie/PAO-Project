package persistence;

import components.Address;
import components.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//create table clients(
//        id int,
//        username varchar(50),
//        emailAddress varchar(100),
//        addressID int,
//        phoneNumber varchar(15));

public class ClientsRepository implements CRUDRepository<Client> {

    private Connection connection;

    public ClientsRepository() {
        try {
            this.connection = DbConnection.getInstance();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Verify connectivity to database!!");
        }
    }

    @Override
    public void save(Client client) {

        String query = "insert into clients values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, client.getId());
            preparedStatement.setString(2, client.getUsername());
            preparedStatement.setString(3, client.getEmailAdress());
            preparedStatement.setInt(4, client.getDeliveryAddressID());
            preparedStatement.setString(5, client.getPhoneNumber());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String query = "select * from clients";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Integer ID = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                Integer addressID = resultSet.getInt(4);
                String phone = resultSet.getString(5);
                clients.add(new Client(username, email, addressID, phone));
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

}
