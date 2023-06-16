package com.laba.solvd.databases.service.interfaceservice;

import com.laba.solvd.databases.model.User;
import java.util.List;

public interface IGenericService<T> {
  T create( T entity, int id);
  List<T> getAllUsers();

}
