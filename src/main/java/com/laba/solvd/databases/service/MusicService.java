package com.laba.solvd.databases.service;

import com.laba.solvd.databases.model.User;
import java.util.List;

public class MusicService implements IMusicService {

  private IMusicService musicService;
  private UserServiceImpl userService;
  private ArtistServiceImpl artistService;



  public MusicService(IMusicService musicService,
      UserServiceImpl userService, ArtistServiceImpl artistService) {
    this.musicService = musicService;
    this.userService = userService;
    this.artistService = artistService;
  }

  public MusicService(){

  }


  @Override
  public void performOperation() {

    System.out.println("loading musicmarketplace...");

  }

  @Override
  public User create(User user) {

    return null;
  }

  @Override
  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }


}


