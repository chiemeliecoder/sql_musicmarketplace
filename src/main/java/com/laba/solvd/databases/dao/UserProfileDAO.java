package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.interfacedao.IUserProfileDAO;
import com.laba.solvd.databases.model.UserProfile;
import java.sql.SQLException;
import java.util.List;

public class UserProfileDAO implements IUserProfileDAO {

  @Override
  public UserProfile getUserProfileById(int userId) throws SQLException {
    return null;
  }

  @Override
  public void createUser(UserProfile user) {

  }

  @Override
  public List<UserProfile> getAllUsersProfiles() {
    return null;
  }
}
