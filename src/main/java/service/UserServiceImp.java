package service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements IuserService{
   private String localhost = "localhost:3306";
   private String dbname = "User";
   private String username = "root";
   private String password = "Kamito@123";
   private String Url = "jdbc:mysql://" + localhost + "/" + dbname ;
   private String query_select = "select * from user";
   private String query_delete = "delete from user where id = (?)";
   private String query_insert = "insert into user(name,age,contry) values (?,?,?)";
   private String query_update = "update user set name = ? , age = ? , contry = ? where id = ?";

   public Connection connection() throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection(Url,username,password);
      return connection;
   }
   @Override
   public void insertUser(User user) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      PreparedStatement preparedStatement = connection.prepareStatement(query_insert);
      preparedStatement.setString(1,user.getName());
      preparedStatement.setInt(2,user.getAge());
      preparedStatement.setString(3,user.getContry());
      preparedStatement.executeUpdate();
   }
   @Override
   public void deleteUser(int id) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      PreparedStatement preparedStatement = connection.prepareStatement(query_delete);
      preparedStatement.setInt(1,id);
      preparedStatement.executeUpdate();
   }
   @Override
   public List<User> selectAll() throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query_select);
      List<User> list = new ArrayList<User>();
      while (resultSet.next()){
         int id = resultSet.getInt("id");
         String name = resultSet.getString("name");
         int age = resultSet.getInt("age");
         String contry = resultSet.getString("contry");
         User user = new User(id,name,age,contry);
         list.add(user);
      }
      return list;
   }
   @Override
   public void UpdateUser(User user) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      PreparedStatement preparedStatement = connection.prepareStatement(query_update);
      preparedStatement.setString(1,user.getName());
      preparedStatement.setInt(2,user.getAge());
      preparedStatement.setString(3,user.getContry());
      preparedStatement.setInt(4,user.getId());
      preparedStatement.executeUpdate();
   }
   @Override
   public List<User> searchByCountry(String Contry) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from user where contry = '" + Contry + "'");
      List<User> list = new ArrayList<User>();
      while (resultSet.next()){
         int id = resultSet.getInt("id");
         String name = resultSet.getString("name");
         int age = resultSet.getInt("age");
         String contry = resultSet.getString("contry");
         User user = new User(id,name,age,contry);
         list.add(user);
      }
      return list;
   }
}
