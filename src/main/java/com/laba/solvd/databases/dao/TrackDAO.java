package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.interfacedao.ITrackDAO;
import com.laba.solvd.databases.model.Tracks;
import java.util.List;

public class TrackDAO implements ITrackDAO {

  @Override
  public void create(Tracks entity) {

  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Tracks read(int id) {
    return null;
  }

  @Override
  public void update(Tracks entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Tracks> getAll() {
    return null;
  }

  @Override
  public Tracks getTrackById(int id) {
    return null;
  }
}
