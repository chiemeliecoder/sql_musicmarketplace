package com.laba.solvd.databases.model;

import java.util.Objects;

public class Wishlist {

  private int id;

  private String name;



  public Wishlist() {
  }

  public Wishlist(int id, String name) {
    this.id = id;
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Wishlist)) {
      return false;
    }
    Wishlist wishlist = (Wishlist) o;
    return getId() == wishlist.getId() && getName().equals(wishlist.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }

  @Override
  public String toString() {
    return "Wishlist{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
