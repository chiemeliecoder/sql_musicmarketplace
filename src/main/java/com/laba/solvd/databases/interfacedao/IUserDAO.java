package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.User;
import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

  User getUserById(int userId) throws SQLException;
  void createUser(User user);
  List<User> getAllUsers();

}
