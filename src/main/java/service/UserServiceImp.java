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
   private String query_select = "{call showListUser()}";
   private String query_delete = "{call deleteUser(?)}";
   private String query_update = "{call updateUser(?,?,?,?)}";
   private String query_produce_select = "{call getUserById(?)";
   private String query_produce_insert = "{call insertUser(?,?,?)}";
   private String query_permision = "INSERT INTO user_permision(id,permision_id) VALUES(?,?);";


   public Connection connection() throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection(Url,username,password);
      return connection;
   }
   @Override
   public void addUserTransaction(User user , List<Integer> permisionList) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      connection.setAutoCommit(false);
      PreparedStatement preparedStatement = connection.prepareStatement(query_produce_insert,Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,user.getName());
      preparedStatement.setInt(2,user.getAge());
      preparedStatement.setString(3,user.getContry());
      int row = preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      int userId = 0;
      if (resultSet.next()){
         userId = resultSet.getInt(1);
      }
      if (row == 1) {
         PreparedStatement preparedStatement1 = connection.prepareStatement(query_permision);
         for (int permision : permisionList) {
            preparedStatement1.setInt(1, userId);
            preparedStatement1.setInt(2,permision);
         }
         connection.commit();
      }else{
         connection.rollback();
      }

   }
   @Override
   public void insertUser(User user) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      CallableStatement callableStatement = connection.prepareCall(query_produce_insert);
      callableStatement.setString(1,user.getName());
      callableStatement.setInt(2,user.getAge());
      callableStatement.setString(3,user.getContry());
      callableStatement.executeUpdate();
   }
   @Override
   public User getUserById(int id) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      CallableStatement callableStatement = connection.prepareCall(query_produce_select);
      ResultSet resultSet = callableStatement.executeQuery();
      User user = null;
      while (resultSet.next()){
         int userId = resultSet.getInt("id");
         String name = resultSet.getString("name");
         int age = resultSet.getInt("age");
         String country = resultSet.getString("contry");
         user = new User(userId,name,age,country);
      }
      return user;
   }
   @Override
   public void deleteUser(int id) throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      CallableStatement callableStatement = connection.prepareCall(query_delete);
      callableStatement.setInt(1,id);
      callableStatement.executeUpdate();
   }
   @Override
   public List<User> selectAll() throws SQLException, ClassNotFoundException {
      Connection connection = connection();
      CallableStatement callableStatement = connection.prepareCall(query_select);
      ResultSet resultSet = callableStatement.executeQuery();
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
      preparedStatement.setInt(1,user.getId());
      preparedStatement.setString(2,user.getName());
      preparedStatement.setInt(3,user.getAge());
      preparedStatement.setString(4,user.getContry());
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
