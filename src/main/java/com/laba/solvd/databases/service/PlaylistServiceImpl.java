package com.laba.solvd.databases.service;

import com.laba.solvd.databases.dao.PlaylistDAO;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import java.util.List;

public class PlaylistServiceImpl implements IGenericService<Playlist> {


  private final PlaylistDAO playlistDAO;

  public PlaylistServiceImpl(PlaylistDAO playlistDAO) {
    this.playlistDAO = playlistDAO;
  }

  @Override
  public List<Playlist> getAllUsers() {
    return playlistDAO.getAll();
  }

  @Override
  public Playlist create(Playlist entity, int id) {
    return null;
  }


}
