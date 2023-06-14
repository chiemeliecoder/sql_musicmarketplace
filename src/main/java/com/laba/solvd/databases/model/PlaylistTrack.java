package com.laba.solvd.databases.model;

import java.util.Objects;

public class PlaylistTrack {

  /**
   * the PlaylistTrack entity classes not to be directly referenced in the Playlist, or
   * Track classes.This approach is known as separation of concerns and can help keep
   * the classes focused on their primary responsibilities.*/

  private int id;

  private Playlist playlist;
  private Track track;

  public PlaylistTrack() {
  }

  public PlaylistTrack(int id, Playlist playlist, Track track) {
    this.id = id;
    this.playlist = playlist;
    this.track = track;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public Track getTrack() {
    return track;
  }

  public void setTrack(Track track) {
    this.track = track;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PlaylistTrack)) {
      return false;
    }
    PlaylistTrack that = (PlaylistTrack) o;
    return getId() == that.getId() && getPlaylist().equals(that.getPlaylist()) && getTrack()
        .equals(that.getTrack());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPlaylist(), getTrack());
  }

  @Override
  public String toString() {
    return "PlaylistTrack{" +
        "id=" + id +
        ", playlist=" + playlist +
        ", track=" + track +
        '}';
  }
}
