package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.ITrackDAO;
import com.laba.solvd.databases.model.Tracks;
import java.sql.SQLException;
import java.util.List;

public class TrackDAO implements ITrackDAO {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

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

  public static void main(String args[]) throws SQLException {

  }
}
