package com.laba.solvd.databases.service;

import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.interfacedao.IUserProfileDAO;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import com.laba.solvd.databases.service.interfaceservice.IUserService;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements IUserService {

  private final IUserDAO userDAO;
  private final PlaylistServiceImpl playlistService;

  public UserServiceImpl(IUserDAO userDAO,
      PlaylistServiceImpl playlistService) {
    this.userDAO = userDAO;
    this.playlistService = playlistService;
  }

  @Override
  public User create(User entity) {
    entity.setId(null);
    userDAO.createUser(entity);

    if(entity.getPlaylistsList() != null){
      List<Playlist> playlists = entity.getPlaylistsList().stream()
          .map(playlist -> playlistService.create(playlist, entity.getId())).collect(
          Collectors.toList());
      entity.setPlaylistsList(playlists);
    }
    return entity;
  }



  @Override
  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }
}
