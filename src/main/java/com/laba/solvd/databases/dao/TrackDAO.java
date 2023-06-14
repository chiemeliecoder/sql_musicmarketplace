package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Track;
import java.sql.SQLException;
import java.util.List;

public class TrackDAO implements IGenericDAO<Track> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();


  public Track getById(int id) throws SQLException {
    Track track = new Track();
    return track;
  }

  @Override
  public void create(Track entity) {

  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Track read(int id) {
    return null;
  }

  @Override
  public void update(Track entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Track> getAll() {
    return null;
  }



  public static void main(String args[]) throws SQLException {

  }
}
