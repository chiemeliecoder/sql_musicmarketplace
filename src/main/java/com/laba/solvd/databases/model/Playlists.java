package com.laba.solvd.databases.model;

import java.util.List;
import java.util.Objects;

public class Playlists {

  private int id;

  private String playlistName;

  private User user;
  private List<Tracks> tracks;

  public Playlists() {
  }

  public Playlists(int id, String playlistName, User user,
      List<Tracks> tracks) {
    this.id = id;
    this.playlistName = playlistName;
    this.user = user;
    this.tracks = tracks;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPlaylistName() {
    return playlistName;
  }

  public void setPlaylistName(String playlistName) {
    this.playlistName = playlistName;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Tracks> getTracks() {
    return tracks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Playlists)) {
      return false;
    }
    Playlists playlists = (Playlists) o;
    return getId() == playlists.getId() && getPlaylistName().equals(playlists.getPlaylistName())
        && getUser().equals(playlists.getUser()) && getTracks().equals(playlists.getTracks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPlaylistName(), getUser(), getTracks());
  }

  public void setTracks(List<Tracks> tracks) {
    this.tracks = tracks;
  }

  @Override
  public String toString() {
    return "Playlists{" +
        "id=" + id +
        ", playlistName='" + playlistName + '\'' +
        ", user=" + user +
        ", tracks=" + tracks +
        '}';
  }
}
