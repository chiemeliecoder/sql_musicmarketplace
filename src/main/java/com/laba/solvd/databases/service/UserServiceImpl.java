package com.laba.solvd.databases.service;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.dao.UserDAO;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.interfacedao.IUserProfileDAO;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import com.laba.solvd.databases.service.interfaceservice.IUserService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements IUserService {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
  private final IUserDAO userDAO;
  private final PlaylistServiceImpl playlistService;

  public UserServiceImpl( PlaylistServiceImpl playlistService) {
    this.userDAO = new UserDAO();;
    this.playlistService = playlistService;
  }



  @Override
  public User create(User entity) {
    if (entity == null) {
      throw new IllegalArgumentException("User entity cannot be null");
    }

    // Validate user input
    if (entity.getName() == null || entity.getName().isEmpty()) {
      throw new IllegalArgumentException("User name cannot be empty");
    }


    //entity.setId(null);
    userDAO.createUser(entity);



    if(entity.getPlaylistsList() != null){
      List<Playlist> playlists = entity.getPlaylistsList().stream()
          .map(playlist -> playlistService.create(playlist, entity.getId())).collect(
          Collectors.toList());
      entity.setPlaylistsList(playlists);
    }
    return entity;
  }

  public int getMaxUserId() {
    // Add the necessary logic to retrieve the maximum user ID from the database
    int maxId = 0;

    // Retrieve the maximum ID using a database query
    try (Connection connection = CONNECTION_POOL.getConnectionFromPool();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM User")) {
      if (resultSet.next()) {
        maxId = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      throw new RuntimeException("Unable to get the maximum user ID", e);
    }

    return maxId;
  }


  @Override
  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }
}
