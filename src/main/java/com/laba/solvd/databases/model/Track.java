package com.laba.solvd.databases.model;

import java.sql.Time;
import java.util.Objects;

public class Track {

  private int id;

  private String title;

  private Time duration;



  public Track() {
  }

  public Track(int id, String title, Time duration) {
    this.id = id;
    this.title = title;
    this.duration = duration;

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

  public Time getDuration() {
    return duration;
  }

  public void setDuration(Time duration) {
    this.duration = duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Track)) {
      return false;
    }
    Track track = (Track) o;
    return getId() == track.getId() && getTitle().equals(track.getTitle()) && getDuration()
        .equals(track.getDuration());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getTitle(), getDuration());
  }

  @Override
  public String toString() {
    return "Track{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", duration=" + duration +
        '}';
  }
}
