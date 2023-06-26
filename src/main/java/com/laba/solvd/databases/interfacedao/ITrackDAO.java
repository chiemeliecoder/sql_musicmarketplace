package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Track;
import java.sql.SQLException;
import java.util.List;

public interface ITrackDAO {

  Track getById(int id) throws SQLException;
  void create(Track entity, Integer id);

  /** Retrieve an object that was previously persisted to the database using
   */
  Track read(int id);
  void update(Track entity);
  void delete(int id);
  List<Track> getAll();

}
