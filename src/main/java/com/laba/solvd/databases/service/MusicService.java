package com.laba.solvd.databases.service;

import com.laba.solvd.databases.dao.AlbumDAO;
import com.laba.solvd.databases.dao.ArtistDAO;
import com.laba.solvd.databases.dao.PlaylistDAO;
import com.laba.solvd.databases.dao.UserDAO;
import com.laba.solvd.databases.model.User;
import java.util.List;
import org.apache.log4j.Logger;

public class MusicService implements IMusicService {

  private static final Logger logger = Logger.getLogger(MusicService.class);

  private UserDAO userDAO;
  private AlbumDAO albumDAO;
  private ArtistDAO artistDAO;
  private PlaylistDAO playlistDAO;



  public MusicService() {
    this.userDAO = new UserDAO();
    this.albumDAO = new AlbumDAO();
    this.artistDAO = new ArtistDAO();
    this.playlistDAO = new PlaylistDAO();

  }





  @Override
  public void performOperation() {

    logger.info("loading musicmarketplace...");

  }


  @Override
  public User create(User user) {
    user.setId(5);
    user.setEmail("kate@fun.com");
    user.setPassword("kate123");
    user.setName("Kate");
    userDAO.createUser(user);
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }
}


