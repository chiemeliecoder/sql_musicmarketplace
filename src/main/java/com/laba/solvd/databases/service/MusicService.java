package com.laba.solvd.databases.service;

import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.User;
import java.util.List;

public class MusicService implements IMusicService {

  private UserServiceImpl userService;
  private ArtistServiceImpl artistService;



  public MusicService() {
    this.userService = new UserServiceImpl();
    this.artistService = new ArtistServiceImpl();
  }




  @Override
  public void performOperation() {

    System.out.println("loading musicmarketplace...");

  }

  @Override
  public User create(User user) {
    user.setId(null);
    if(userService == null){
      userService.create(user);
    }


    Artists art = new Artists();
    art.setId(null);
    artistService.create(art);

    return user;
  }

  @Override
  public List<User> getAllUsers() {

    return userService.getAllUsers();
  }


  @Override
  public List<Artists> getAllArtists() {
    return getAllArtists();
  }


}


