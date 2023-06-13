package com.laba.solvd.databases.service;

import com.laba.solvd.databases.dao.AlbumDAO;
import com.laba.solvd.databases.dao.ArtistDAO;
import com.laba.solvd.databases.dao.PlaylistDAO;
import com.laba.solvd.databases.dao.UserDAO;
import com.laba.solvd.databases.model.Playlists;
import com.laba.solvd.databases.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class MusicService implements IMusicService {

  private UserDAO userDAO;
  private AlbumDAO albumDAO;
  private ArtistDAO artistDAO;
  private PlaylistDAO playlistDAO;
  // Inject other necessary DAO interfaces


  public MusicService() {
    this.userDAO = new UserDAO();
    this.albumDAO = new AlbumDAO();
    this.artistDAO = new ArtistDAO();
    this.playlistDAO = new PlaylistDAO();

  }





  @Override
  public void performOperation() {
    System.out.println("Performing a music operation...");
  }

  @Override
  public void playSong(String songId) {
    System.out.println("Playing song with ID: " + songId);

  }

  @Override
  public void pauseSong(String songId) {
    System.out.println("Pausing song with ID: " + songId);

  }

  @Override
  public void stopSong(String songId) {
    System.out.println("Stopping song with ID: " + songId);

  }

  @Override
  public void skipToNextSong() {
    System.out.println("Skipping to the next song");
  }

  @Override
  public void skipToPreviousSong() {
    System.out.println("Skipping to the previous song");
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