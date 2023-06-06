package com.laba.solvd.databases.dao;

import java.util.List;
import javax.sql.DataSource;

public class GenericDAO<T, ID> extends AbstractGenericDAO<T, ID> {

  public GenericDAO(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public void create(T entity) {

  }

  @Override
  public T read(ID id) {
    return null;
  }

  @Override
  public void update(T entity) {

  }

  @Override
  public void delete(ID id) {

  }

  @Override
  public List<T> getAll() {
    return null;
  }
}
