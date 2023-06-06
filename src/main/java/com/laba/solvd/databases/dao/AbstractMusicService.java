package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.interfacedao.IMusicService;

public abstract class AbstractMusicService implements IMusicService {

  protected IGenericDAO<?, ?> dao;

  public AbstractMusicService(IGenericDAO<?, ?> dao) {
    this.dao = dao;
  }

}
