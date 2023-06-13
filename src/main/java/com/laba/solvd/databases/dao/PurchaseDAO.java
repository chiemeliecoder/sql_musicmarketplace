package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.interfacedao.IPlaylistDAO;
import com.laba.solvd.databases.model.Playlists;
import java.util.List;

public class PurchaseDAO implements IPlaylistDAO {

  @Override
  public void create(Playlists entity) {

  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Playlists read(int id) {
    return null;
  }

  @Override
  public void update(Playlists entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Playlists> getAll() {
    return null;
  }
}
