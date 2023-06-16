package com.laba.solvd.databases.model;

import java.util.List;
import java.util.Objects;

public class User {

  private int id;

  private String name;

  private String email;
  
  private String password;
  
  private List<Purchase> purchaseList;
  private List<Playlist> playlistList;
  private List<Review> reviewList;
  private List<Wishlist> wishlistList;

  public User() {
  }

  public User(int id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User(List<Purchase> purchaseList,
      List<Playlist> playlistList,
      List<Review> reviewList,
      List<Wishlist> wishlistList) {
    this.purchaseList = purchaseList;
    this.playlistList = playlistList;
    this.reviewList = reviewList;
    this.wishlistList = wishlistList;
  }

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public List<Purchase> getPurchasesList() {
    return purchaseList;
  }

  public void setPurchasesList(List<Purchase> purchaseList) {
    this.purchaseList = purchaseList;
  }



  public List<Playlist> getPlaylistsList() {
    return playlistList;
  }

  public void setPlaylistsList(List<Playlist> playlistList) {
    this.playlistList = playlistList;
  }

  public List<Review> getReviewsList() {
    return reviewList;
  }

  public void setReviewsList(List<Review> reviewList) {
    this.reviewList = reviewList;
  }

  public List<Wishlist> getWishlistsList() {
    return wishlistList;
  }

  public void setWishlistsList(List<Wishlist> wishlistList) {
    this.wishlistList = wishlistList;
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

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", purchaseList=" + purchaseList +
        ", playlistList=" + playlistList +
        ", reviewList=" + reviewList +
        ", wishlistList=" + wishlistList +
        '}';
  }
}
