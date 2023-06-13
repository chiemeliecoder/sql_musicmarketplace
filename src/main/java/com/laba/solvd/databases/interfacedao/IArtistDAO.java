package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Artists;

public interface IArtistDAO extends IGenericDAO<Artists> {
  Artists getArtistById(int id);


}
