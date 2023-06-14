package com.laba.solvd.databases.model;

import java.util.Objects;

public class Wishlist {

  private int id;

  private User user;
  private Album album;

  public Wishlist() {
  }

  public Wishlist(int id, User user, Album album) {
    this.id = id;
    this.user = user;
    this.album = album;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Album getAlbum() {
    return album;
  }

  public void setAlbum(Album album) {
    this.album = album;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Wishlist)) {
      return false;
    }
    Wishlist wishlist = (Wishlist) o;
    return getId() == wishlist.getId() && getUser().equals(wishlist.getUser()) && getAlbum()
        .equals(wishlist.getAlbum());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUser(), getAlbum());
  }

  @Override
  public String toString() {
    return "Wishlist{" +
        "id=" + id +
        ", user=" + user +
        ", album=" + album +
        '}';
  }
}
