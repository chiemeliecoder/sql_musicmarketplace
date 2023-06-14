package com.laba.solvd.databases.service;

import com.laba.solvd.databases.interfacedao.IGenreDAO;
import com.laba.solvd.databases.interfacedao.IPurchaseDAO;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.model.Genre;
import com.laba.solvd.databases.model.Purchase;
import com.laba.solvd.databases.model.User;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MusicService implements IMusicService {

  private IUserDAO userDAO;
  private IGenreDAO genreDAO;
  private IPurchaseDAO purchaseDAO;




  public MusicService(IUserDAO userDAO, IGenreDAO genreDAO,
      IPurchaseDAO purchaseDAO) {
    this.userDAO = userDAO;
    this.genreDAO = genreDAO;
    this.purchaseDAO = purchaseDAO;
  }

  public MusicService() {
  }

  @Override
  public void performOperation() {

    System.out.println("loading musicmarketplace...");

  }


  @Override
  public User create(User user) {
    user.setId(6);
    userDAO.createUser(user);
    if(user.getPurchasesList() != null){
      List<Purchase> purchases = user.getPurchasesList().stream()
          .map(purchase -> purchaseDAO.getPurchaseById(6))
          .collect(Collectors.toList());
      user.setPurchasesList(purchases);
    }
    return user;
  }


  @Override
  public List<User> getAllUsers() {

    return userDAO.getAllUsers();
  }

  public List<Genre>getMusicByGenre(){
    return genreDAO.getAllGenres();
  }

  public void purchaseMusic(Purchase purchaseUser) {
    Purchase purchase = new Purchase(purchaseUser.getId(), new Date(System.currentTimeMillis()), purchaseUser.getPrice());
    purchaseDAO.createPurchase(purchase);
  }

  public List<Purchase> getUserPurchases() {
    return purchaseDAO.getAllPurchases();
  }
}


