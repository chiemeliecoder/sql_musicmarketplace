package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.interfacedao.IUserProfileDAO;
import com.laba.solvd.databases.model.UserProfile;
import java.sql.SQLException;
import java.util.List;

public class UserProfileDAO implements IUserProfileDAO {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

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

  public static void main(String args[]) throws SQLException{

  }
}
