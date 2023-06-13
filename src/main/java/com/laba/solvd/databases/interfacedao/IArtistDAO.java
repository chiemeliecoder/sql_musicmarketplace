package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Artists;
import java.sql.SQLException;

public interface IArtistDAO extends IGenericDAO<Artists> {
  Artists getArtistById(int id) throws SQLException;


}
