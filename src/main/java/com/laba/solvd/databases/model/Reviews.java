package com.laba.solvd.databases.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Reviews {

  private int id;

  private BigDecimal ratings;

  private String comments;

  private User user;
  private Albums album;

  public Reviews() {
  }

  public Reviews(int id, BigDecimal ratings, String comments,
      User user, Albums album) {
    this.id = id;
    this.ratings = ratings;
    this.comments = comments;
    this.user = user;
    this.album = album;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public BigDecimal getRatings() {
    return ratings;
  }

  public void setRatings(BigDecimal ratings) {
    this.ratings = ratings;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
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
    if (!(o instanceof Reviews)) {
      return false;
    }
    Reviews reviews = (Reviews) o;
    return getId() == reviews.getId() && getRatings().equals(reviews.getRatings()) && getComments()
        .equals(reviews.getComments()) && getUser().equals(reviews.getUser()) && getAlbum()
        .equals(reviews.getAlbum());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getRatings(), getComments(), getUser(), getAlbum());
  }

  @Override
  public String toString() {
    return "Reviews{" +
        "id=" + id +
        ", ratings=" + ratings +
        ", comments='" + comments + '\'' +
        ", user=" + user +
        ", album=" + album +
        '}';
  }
}
