package com.laba.solvd.databases.model;

import java.util.List;
import java.util.Objects;

public class User {

  private int id;

  private String name;

  private String email;
  
  private String password;
  
  private List<Purchases> purchasesList ;
  private List<Playlists> playlistsList;
  private List<Reviews> reviewsList;
  private List<Wishlists> wishlistsList;

  public User() {
  }

  public User(int id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User(List<Purchases> purchasesList,
      List<Playlists> playlistsList,
      List<Reviews> reviewsList,
      List<Wishlists> wishlistsList) {
    this.purchasesList = purchasesList;
    this.playlistsList = playlistsList;
    this.reviewsList = reviewsList;
    this.wishlistsList = wishlistsList;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Purchases> getPurchasesList() {
    return purchasesList;
  }

  public void setPurchasesList(List<Purchases> purchasesList) {
    this.purchasesList = purchasesList;
  }



  public List<Playlists> getPlaylistsList() {
    return playlistsList;
  }

  public void setPlaylistsList(List<Playlists> playlistsList) {
    this.playlistsList = playlistsList;
  }

  public List<Reviews> getReviewsList() {
    return reviewsList;
  }

  public void setReviewsList(List<Reviews> reviewsList) {
    this.reviewsList = reviewsList;
  }

  public List<Wishlists> getWishlistsList() {
    return wishlistsList;
  }

  public void setWishlistsList(List<Wishlists> wishlistsList) {
    this.wishlistsList = wishlistsList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return getId() == user.getId() && getName().equals(user.getName()) && getEmail()
        .equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getPurchasesList()
        .equals(user.getPurchasesList()) && getPlaylistsList().equals(user.getPlaylistsList())
        && getReviewsList().equals(user.getReviewsList()) && getWishlistsList()
        .equals(user.getWishlistsList());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getName(), getEmail(), getPassword(), getPurchasesList(), getPlaylistsList(),
            getReviewsList(), getWishlistsList());
  }


}
