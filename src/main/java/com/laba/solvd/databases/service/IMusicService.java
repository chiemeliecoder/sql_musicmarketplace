package com.laba.solvd.databases.service;

import com.laba.solvd.databases.model.User;
import java.util.List;

public interface IMusicService {

  void performOperation();
  User create(User user, int id);
  List<User> getAllUsers();

}
