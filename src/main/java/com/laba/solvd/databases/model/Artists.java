package com.laba.solvd.databases.model;

import java.util.List;
import java.util.Objects;

public class Artists {

  private int id;

  private String artistName;

  private List<Albums> albums;
  private List<Genre> genres;
  private List<ArtistAchievements> achievements;

  public Artists() {
  }

  public Artists(int id, String artistName,
      List<Albums> albums, List<Genre> genres,
      List<ArtistAchievements> achievements) {
    this.id = id;
    this.artistName = artistName;
    this.albums = albums;
    this.genres = genres;
    this.achievements = achievements;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public List<Albums> getAlbums() {
    return albums;
  }

  public void setAlbums(List<Albums> albums) {
    this.albums = albums;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public List<ArtistAchievements> getAchievements() {
    return achievements;
  }

  public void setAchievements(
      List<ArtistAchievements> achievements) {
    this.achievements = achievements;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Artists)) {
      return false;
    }
    Artists artists = (Artists) o;
    return getId() == artists.getId() && getArtistName().equals(artists.getArtistName())
        && getAlbums().equals(artists.getAlbums()) && getGenres().equals(artists.getGenres())
        && getAchievements().equals(artists.getAchievements());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getArtistName(), getAlbums(), getGenres(), getAchievements());
  }
}
