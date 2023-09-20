package com.example.jspjstl2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private static String localHost = "localhost:3306";
    private static String dbname = "qlbh";
    private static String username = "root";
    private static String password = "Kamito@123";
    private static String URL = "jdbc:mysql://" + localHost + "/" + dbname;

    public static Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,username,password);
        System.out.println("kết nối thành công với database");
        return connection;
    }
    public static List<Stuff> getAll(){
        try {
            Connection connection = connection();
            List<Stuff> list = new ArrayList<>();
            String query = "select * from danhsach";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String prize = resultSet.getString("prize");
                boolean status = resultSet.getBoolean("status");
                String url = resultSet.getString("url");
                Stuff item = new Stuff(id,name,prize,status,url);
                list.add(item);
            }
            connection.close();
            resultSet.close();
            return list;
        }catch (SQLException | ClassNotFoundException e){
           return null;
        }

    }
    public static void AddStuffToDataBase(Stuff stuff){
        try {
            String name = stuff.getName();
            String prize = stuff.getPrize();
            String url = stuff.getUrl();
            Connection connection = connection();
            String query = "insert into giohang(name,prize,url) value (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,prize);
            preparedStatement.setString(3,url);
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }
    public static List<Stuff> getBuy(){
        try {
            Connection connection = connection();
            List<Stuff> list = new ArrayList<>();
            String query = "select * from giohang";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String prize = resultSet.getString("prize");
                String url = resultSet.getString("url");
                Stuff item = new Stuff(id,name,prize,url);
                list.add(item);
            }
            connection.close();
            resultSet.close();
            return list;
        }catch (SQLException | ClassNotFoundException e){
            return null;
        }

    }
    public static void DeleteStuffToDataBase(){
        try {
            Connection connection = connection();
            String query = "truncate table giohang";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }
}
