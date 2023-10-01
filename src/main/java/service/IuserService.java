package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IuserService {
    void insertUser(User user) throws SQLException, ClassNotFoundException;

    void deleteUser(int id) throws SQLException, ClassNotFoundException;

    List<User> selectAll() throws SQLException, ClassNotFoundException;

    void UpdateUser(User user) throws SQLException, ClassNotFoundException;

    List<User> searchByCountry(String contry) throws SQLException, ClassNotFoundException;
}
