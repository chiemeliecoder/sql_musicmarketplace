package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Tracks;


public interface ITrackDAO extends IGenericDAO<Tracks>{
  Tracks getTrackById(int id);

}
