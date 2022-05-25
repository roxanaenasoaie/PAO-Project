package persistence;

import components.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//create table addresses(
//        id int,
//        street varchar(50),
//        city varchar(50),
//        county varchar(50),
//        country varchar(50),
//        buildingID varchar(3),
//        streetNumber int,
//        floorNumber int,
//        apartmentNumber int);

public class AdressesRepository implements CRUDRepository<Address> {

    private Connection connection;

    public AdressesRepository() {
        try {
            this.connection = DbConnection.getInstance();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Verify connectivity to database!!");
        }
    }

    @Override
    public void save(Address address) {

        String query = "insert into addresses values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, address.getAddressID());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getCounty());
            preparedStatement.setString(5, address.getCountry());
            preparedStatement.setString(6, address.getBuildingID());
            preparedStatement.setInt(7, address.getStreetNumber());
            preparedStatement.setInt(8, address.getFloorNumber());
            preparedStatement.setInt(9, address.getApartmentNumber());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        String query = "select * from addresses";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String street = resultSet.getString(2);
                String city = resultSet.getString("city");
                String county = resultSet.getString("county");
                String country = resultSet.getString("country");
                String buildingID = resultSet.getString("buildingID");
                int streetNumber = resultSet.getInt("streetNumber");
                int floorNumber = resultSet.getInt("floorNumber");
                int apartmentNumber = resultSet.getInt("apartmentNumber");
                addresses.add(new Address(id, street, city, county, country, buildingID, streetNumber, floorNumber, apartmentNumber));
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    }
}
