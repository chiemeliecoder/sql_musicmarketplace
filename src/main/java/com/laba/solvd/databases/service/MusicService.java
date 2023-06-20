package com.laba.solvd.databases.service;

import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.User;
import java.util.List;

public class MusicService implements IMusicService {

  private UserServiceImpl userService;
  private ArtistServiceImpl artistService;



  public MusicService(PlaylistServiceImpl playlistService) {
    this.userService = new UserServiceImpl(playlistService);
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
    artistService.createArt(art);

    return user;
  }


  @Override
  public int countArtists() {
    List<Artists> allArtists = artistService.getAllArtists();
    return allArtists.size();
  }

  @Override
  public int countUsers() {
    List<User> allUsers = userService.getAllUsers();
    return allUsers.size();
  }


}


