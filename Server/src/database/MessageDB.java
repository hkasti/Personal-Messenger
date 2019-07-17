package database;

import logic.Message;
import logic.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MessageDB {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public MessageDB() throws Exception {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "kiarash23");
        String personSqlCreate = "CREATE TABLE IF NOT EXISTS " + "message"
                + "( "
                + "fromUser VARCHAR (20),"
                + "toUser VARCHAR(20),"
                + "content VARCHAR(500),"
                + "isFile BOOLEAN,"
                + "sentTime DATE"
                + ")";

        Statement stmt = connection.createStatement();
        stmt.execute(personSqlCreate);
    }

    public void getPersons() throws Exception {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
    }

    public ArrayList<Map<String, Object>> getAllMessages(String username1, String username2) throws SQLException, IOException {
        String query = "select * from message where (" +
                "(toUser= '" + username1 + "' and fromUser='" + username2 + "')" +
                " or " +
                "(toUser='" + username2 + "' and fromUser='" + username1 + "')" +
                ")";
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Map<String, Object>> reslutList = new ArrayList<>();
        System.out.println(query);
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            String date = resultSet.getTime("sentTime").toString();
            String content = resultSet.getString("content");
            Boolean isFile = resultSet.getBoolean("isFile");
            map.put("date", date);
            if (isFile) {
                File file = new File(content);
                map.put("text", null);
                map.put("file", Files.readAllBytes(file.toPath()));
            } else {
                map.put("text", content);
                map.put("files", null);
            }
            reslutList.add(map);
        }
        return reslutList;
    }

    public static void addMessage(Message message) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into message values (?,?,?,?,?)");
        preparedStatement.setString(1, message.getFrom());
        preparedStatement.setString(2, message.getTo());
        preparedStatement.setString(3, message.getContent());
        preparedStatement.setBoolean(4, message.isFile());
        preparedStatement.setDate(5, new java.sql.Date(message.getTime().getTime()));

        preparedStatement.executeUpdate();
    }
}
