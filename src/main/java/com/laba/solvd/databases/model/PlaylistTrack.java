package com.laba.solvd.databases.model;

import java.util.Objects;

public class PlaylistTrack {

  /**
   * the PlaylistTrack entity classes not to be directly referenced in the Playlist, or
   * Track classes.This approach is known as separation of concerns and can help keep
   * the classes focused on their primary responsibilities.*/

  private int id;

  private Playlists playlist;
  private Tracks track;

  public PlaylistTrack() {
  }

  public PlaylistTrack(int id, Playlists playlist, Tracks track) {
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

  public Playlists getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlists playlist) {
    this.playlist = playlist;
  }

  public Tracks getTrack() {
    return track;
  }

  public void setTrack(Tracks track) {
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
}
