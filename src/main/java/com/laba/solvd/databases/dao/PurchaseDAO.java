package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Playlist;
import java.sql.SQLException;
import java.util.List;

public class PurchaseDAO implements IGenericDAO<Playlist> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  @Override
  public void create(Playlist entity) {

  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Playlist read(int id) {
    return null;
  }

  @Override
  public void update(Playlist entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Playlist> getAll() {
    return null;
  }

  public static void main(String args[]) throws SQLException {

  }
}
