package com.laba.solvd.databases.model;

import java.util.List;
import java.util.Objects;

public class Playlist {

  private int id;

  private String playlistName;

  private User user;
  private List<Track> tracks;

  public Playlist() {
  }

  public Playlist(int id, String playlistName, User user,
      List<Track> tracks) {
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

  public List<Track> getTracks() {
    return tracks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Playlist)) {
      return false;
    }
    Playlist playlist = (Playlist) o;
    return getId() == playlist.getId() && getPlaylistName().equals(playlist.getPlaylistName())
        && getUser().equals(playlist.getUser()) && getTracks().equals(playlist.getTracks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPlaylistName(), getUser(), getTracks());
  }

  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  @Override
  public String toString() {
    return "Playlist{" +
        "id=" + id +
        ", playlistName='" + playlistName + '\'' +
        ", user=" + user +
        ", tracks=" + tracks +
        '}';
  }
}
