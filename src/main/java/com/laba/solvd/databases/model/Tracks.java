package com.laba.solvd.databases.model;

import java.sql.Time;
import java.util.Objects;

public class Tracks {

  private int id;

  private String title;

  private Time duration;

  private Albums album;

  public Tracks() {
  }

  public Tracks(int id, String title, Time duration, Albums album) {
    this.id = id;
    this.title = title;
    this.duration = duration;
    this.album = album;
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
    if (!(o instanceof Tracks)) {
      return false;
    }
    Tracks tracks = (Tracks) o;
    return getId() == tracks.getId() && getTitle().equals(tracks.getTitle()) && getDuration()
        .equals(tracks.getDuration()) && getAlbum().equals(tracks.getAlbum());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getTitle(), getDuration(), getAlbum());
  }
}
