package com.laba.solvd.databases.model;

import java.util.Date;

public class ArtistAchievements {

  private int id;

  private String title;

  private Date awardDate;

  public ArtistAchievements() {
  }

  public ArtistAchievements(int id, String title, Date awardDate) {
    this.id = id;
    this.title = title;
    this.awardDate = awardDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getAwardDate() {
    return awardDate;
  }

  public void setAwardDate(Date awardDate) {
    this.awardDate = awardDate;
  }
}
