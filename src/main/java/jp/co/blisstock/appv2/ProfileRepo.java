package jp.co.blisstock.appv2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import jp.co.blisstock.appv2.Model.Profile;

@Repository
public class ProfileRepo {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/spring_boot_demo";
    private String user = "root";
    private String password = "kaung8701";

    public ProfileRepo() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public void saveProfile(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public Profile getProfile(String query) throws SQLException {
        Profile profile = new Profile();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            profile.setName(resultSet.getString("name"));
            profile.setAge(resultSet.getInt("age"));
            profile.setGender(resultSet.getString("gender"));
            profile.setOccupation(resultSet.getString("occupation"));
            profile.setEmail(resultSet.getString("email"));
        }
        return profile;
    }
}
