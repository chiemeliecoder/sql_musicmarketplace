package com.laba.solvd.databases.interfacedao;

import java.util.List;

public interface IGenericDAO<T>  {

  void create(T entity);

  /** Retrieve an object that was previously persisted to the database using
   */
  T read(int id);
  void update(T entity);
  void delete(int id);
  List<T> getAll();

}
