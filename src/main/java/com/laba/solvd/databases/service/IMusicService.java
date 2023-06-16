package com.laba.solvd.databases.service;

import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.UserProfile;
import java.util.List;

public interface IMusicService {

  void performOperation();
  User create(User user);
  List<User> getAllUsers();
  List<Artists> getAllArtists();

}
