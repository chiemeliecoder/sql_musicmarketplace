package com.laba.solvd.databases.model;

public class Reviews {

  private int id;

  private Double ratings;

  private String comments;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getRatings() {
    return ratings;
  }

  public void setRatings(Double ratings) {
    this.ratings = ratings;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}
