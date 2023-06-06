package com.laba.solvd.databases.interfacedao;

import java.util.List;

public interface IGenericDAO<T, ID>  {

  void create(T entity);

  /** Retrieve an object that was previously persisted to the database using
   */
  T read(ID id);
  void update(T entity);
  void delete(ID id);
  List<T> getAll();

}
