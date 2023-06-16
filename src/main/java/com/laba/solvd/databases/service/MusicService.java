package com.laba.solvd.databases.service;

import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.interfacedao.IGenreDAO;
import com.laba.solvd.databases.interfacedao.IPurchaseDAO;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.interfacedao.IUserProfileDAO;
import com.laba.solvd.databases.model.Genre;
import com.laba.solvd.databases.model.Purchase;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.UserProfile;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MusicService implements IMusicService {

  private IUserDAO userDAO;
  private IGenericDAO genreDAO;
  private IPurchaseDAO purchaseDAO;






  @Override
  public void performOperation() {

    System.out.println("loading musicmarketplace...");

  }

  @Override
  public User create(User user, int id) {

    return null;
  }

  @Override
  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }


}


