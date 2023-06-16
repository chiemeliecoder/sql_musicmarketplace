package com.laba.solvd.databases.service;

import com.laba.solvd.databases.dao.AlbumDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import java.util.List;

public class AlbumServiceImpl implements IGenericService<Album> {

  private AlbumDAO albumDAO;

  public AlbumServiceImpl() {
  }

  public AlbumServiceImpl(AlbumDAO albumDAO) {
    this.albumDAO = albumDAO;
  }


  @Override
  public Album create(Album entity, int id) {
    return null;
  }

  @Override
  public List<Album> getAllUsers() {
    return null;
  }
}
