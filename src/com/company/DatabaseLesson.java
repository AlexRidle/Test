package com.company;

import java.sql.*;

public class DatabaseLesson {

    private String userName = "root";
    private String password = "root";
    private String connectionURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    Class.forName("com.mysql.cj.jdbc.Driver");

    public void booksExample() throws SQLException, ClassNotFoundException {
        try(Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = connection.createStatement()){
            statement.execute("drop table if exists Books");
            statement.executeUpdate("create table if not exists Books (id mediumint not null auto_increment, name char(30) not null, primary key (id))");
            statement.executeUpdate("insert into Books (name) values('Inferno')");
            statement.executeUpdate("insert into Books set name = 'Solomon key'");

            ResultSet resultSet = statement.executeQuery("select * from books");
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id") + ": ");
                System.out.println(resultSet.getString(2));

            }

            ResultSet rs2 = statement.executeQuery("select name from books where id = 1");
            while (rs2.next()){
                System.out.println("Book with id 1 is: " + rs2.getString(1));
            }

            String book = "2";
            rs2 = statement.executeQuery("select name from books where id = " + book);
            while(rs2.next()){
                System.out.println("Book with id 2 is: " + rs2.getString("name"));
            }
        }
        System.out.println("");
    }

    public void usersExample() throws SQLException {
        try(Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = connection.createStatement()){
            statement.execute("drop table if exists Users");
            statement.executeUpdate("create table if not exists Users (id mediumint not null auto_increment, name char(30) not null, password char(30) not null, primary key (id))");
            statement.executeUpdate("insert into Users (name, password) values('Max', '123')");
            statement.executeUpdate("insert into Users set name = 'otherGuy', password = '321'");

            String userId = "2";
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
            preparedStatement.setString(1, userId);
            ResultSet rs2 = preparedStatement.executeQuery();
            while(rs2.next()){
                System.out.println("userName: " + rs2.getString("name"));
                System.out.println("userPassword: " + rs2.getString("password"));
            }
        }
        System.out.println("");
    }

    public void blobExample() {
    }

    public void createDatabaseExample() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS testdatabase");
        statement.execute("drop table if exists testdatabase");
        statement.executeUpdate("create table if not exists testdatabase (id mediumint not null auto_increment, name char(30) not null, password char(30) not null, primary key (id))");
        statement.executeUpdate("insert into testdatabase (name, password) values('valera', 'zhmyh')");
    }
}
