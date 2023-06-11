package com.laba.solvd.databases.model;

import java.util.Objects;

public class Wishlists {

  private int id;

  private User user;
  private Albums album;

  public Wishlists() {
  }

  public Wishlists(int id, User user, Albums album) {
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

  public Albums getAlbum() {
    return album;
  }

  public void setAlbum(Albums album) {
    this.album = album;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Wishlists)) {
      return false;
    }
    Wishlists wishlists = (Wishlists) o;
    return getId() == wishlists.getId() && getUser().equals(wishlists.getUser()) && getAlbum()
        .equals(wishlists.getAlbum());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUser(), getAlbum());
  }
}
