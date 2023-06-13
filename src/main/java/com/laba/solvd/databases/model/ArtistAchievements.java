package com.laba.solvd.databases.model;

import java.util.Date;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ArtistAchievements)) {
      return false;
    }
    ArtistAchievements that = (ArtistAchievements) o;
    return getId() == that.getId() && getTitle().equals(that.getTitle()) && getAwardDate()
        .equals(that.getAwardDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getTitle(), getAwardDate());
  }

  @Override
  public String toString() {
    return "ArtistAchievements{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", awardDate=" + awardDate +
        '}';
  }
}
