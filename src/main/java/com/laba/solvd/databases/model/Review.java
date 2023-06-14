package com.laba.solvd.databases.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Review {

  private int id;

  private BigDecimal ratings;

  private String comments;

  private User user;
  private Album album;

  public Review() {
  }

  public Review(int id, BigDecimal ratings, String comments,
      User user, Album album) {
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
    if (!(o instanceof Review)) {
      return false;
    }
    Review review = (Review) o;
    return getId() == review.getId() && getRatings().equals(review.getRatings()) && getComments()
        .equals(review.getComments()) && getUser().equals(review.getUser()) && getAlbum()
        .equals(review.getAlbum());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getRatings(), getComments(), getUser(), getAlbum());
  }

  @Override
  public String toString() {
    return "Review{" +
        "id=" + id +
        ", ratings=" + ratings +
        ", comments='" + comments + '\'' +
        ", user=" + user +
        ", album=" + album +
        '}';
  }
}
