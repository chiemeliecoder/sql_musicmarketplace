package com.laba.solvd.databases.service;

import com.laba.solvd.databases.model.User;
import java.util.List;

public interface IMusicService {

  void performOperation();
  void playSong(String songId);
  void pauseSong(String songId);
  void stopSong(String songId);
  void skipToNextSong();
  void skipToPreviousSong();
  User create(User user);
  List<User> getAllUsers();

}
