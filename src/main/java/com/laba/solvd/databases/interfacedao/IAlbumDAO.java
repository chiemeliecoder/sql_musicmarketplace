package com.laba.solvd.databases.interfacedao;



import com.laba.solvd.databases.model.Albums;
import java.sql.SQLException;

public interface IAlbumDAO extends IGenericDAO<Albums> {
  Albums getAlbumById(int id) throws SQLException;
}
