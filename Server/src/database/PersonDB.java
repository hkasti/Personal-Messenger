package database;

import logic.Person;

import java.sql.*;

public class PersonDB {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public PersonDB() throws Exception {
//        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kiarash23");
        String personSqlCreate = "CREATE TABLE IF NOT EXISTS " + "person"
                + "( "
                + "firstName VARCHAR (20),"
                + "lastName VARCHAR(20),"
                + "email VARCHAR(50),"
                + "username VARCHAR(20),"
                + "password VARCHAR(20),"
                + "image VARCHAR(100),"
                + "lastSeen DATE"
                + ")";

        Statement stmt = connection.createStatement();
        stmt.execute(personSqlCreate);
    }

    public static void addPerson(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person values (?,?,?,?, ?,?,?)");
        preparedStatement.setString(1, person.getFirstName());
        preparedStatement.setString(2, person.getLastName());
        preparedStatement.setString(3, person.getEmail());
        preparedStatement.setString(4, person.getUsername());
        preparedStatement.setString(5, person.getPassword());
        preparedStatement.setString(6, person.getProfileImage());
        preparedStatement.setDate(7, new java.sql.Date(person.getLastSeen().getTime()));

        preparedStatement.executeUpdate();
    }

    public void getPersons() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
    }

    public String getPerson(String username) throws Exception {
        preparedStatement = connection.prepareStatement("select * from person where username = ?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        try {
            return resultSet.getString("username");
        }
        catch (Exception e){
            return null;
        }

    }

    public void changePass(Person person, String newPass) throws Exception {
        preparedStatement = connection.prepareStatement("update person set pass = ? where username = ?");
        preparedStatement.setString(1, newPass);
        preparedStatement.setString(2, person.getUsername());
        preparedStatement.executeUpdate();
    }

    public void deletePerson(String username) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person where username = ?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}
