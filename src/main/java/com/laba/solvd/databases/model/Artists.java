package com.laba.solvd.databases.model;

import java.util.List;
import java.util.Objects;

public class Artists {

  private int id;

  private String artistName;

  private Album album;

  private List<Album> albums;
  private List<Genre> genres;
  private List<ArtistAchievement> achievements;

  public Artists() {
  }

  public Artists(int id, String artistName, Album album,
      List<Album> albums, List<Genre> genres,
      List<ArtistAchievement> achievements) {
    this.id = id;
    this.artistName = artistName;
    this.album = album;
    this.albums = albums;
    this.genres = genres;
    this.achievements = achievements;
  }

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public Album retrieveAlbumById(int albumId) {
    Album album = new Album();
    album.setId(albumId);
    return album;
  }

  public Album getAlbum() {
    return album;
  }

  public void setAlbum(Integer albumID) {
    Album album = retrieveAlbumById(albumID);
    this.album = album;
  }

  public List<Album> getAlbums() {
    return albums;
  }

  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  public List<ArtistAchievement> getAchievements() {
    return achievements;
  }

  public void setAchievements(
      List<ArtistAchievement> achievements) {
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
        && getAlbum()
        .equals(artists.getAlbum()) && getAlbums().equals(artists.getAlbums()) && getGenres()
        .equals(artists.getGenres()) && getAchievements().equals(artists.getAchievements());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getArtistName(), getAlbum(), getAlbums(), getGenres(), getAchievements());
  }

  @Override
  public String toString() {
    return "Artists{" +
        "id=" + id +
        ", artistName='" + artistName + '\'' +
        ", album=" + album +
        ", albums=" + albums +
        ", genres=" + genres +
        ", achievements=" + achievements +
        '}';
  }
}
