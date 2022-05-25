package persistence;

import components.Client;
import components.Courier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//create table couriers(
//        id int,
//        username varchar(50),
//        emailAddress varchar(100),
//        workedHours float,
//        payPerHout float);

public class CouriersRepository implements CRUDRepository<Courier> {

    private Connection connection;

    public CouriersRepository() {
        try {
            this.connection = DbConnection.getInstance();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Verify connectivity to database!!");
        }
    }

    @Override
    public void save(Courier courier) {

        String query = "insert into couriers values (?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courier.getId());
            preparedStatement.setString(2, courier.getUsername());
            preparedStatement.setString(3, courier.getEmailAdress());
            preparedStatement.setFloat(4, courier.getWorkedHours());
            preparedStatement.setFloat(5, courier.getEurPerHour());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Courier> getAll() {
        List<Courier> couriers = new ArrayList<>();
        String query = "select * from couriers";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Integer ID = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                Float workedHours = resultSet.getFloat(4);
                Float pay = resultSet.getFloat(5);
                couriers.add(new Courier(username, email, workedHours, pay));
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return couriers;
    }
}
