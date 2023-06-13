package com.laba.solvd.databases.model;


import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Albums {

  private int id;

  private String albumName;

  private Date albumDate;


  private Artists artist;
  private List<Tracks> tracks;

  //constructor


  public Albums() {
  }

  public Albums(int id, String albumName, Date albumDate,
      Artists artist, List<Tracks> tracks) {
    this.id = id;
    this.albumName = albumName;
    this.albumDate = albumDate;
    this.artist = artist;
    this.tracks = tracks;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAlbumName() {
    return albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  public Date getAlbumDate() {
    return albumDate;
  }

  public void setAlbumDate(Date albumDate) {
    this.albumDate = albumDate;
  }

  public Artists getArtist() {
    return artist;
  }

  public void setArtist(Artists artist) {
    this.artist = artist;
  }

  //equals and hashcode


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Albums)) {
      return false;
    }
    Albums albums = (Albums) o;
    return getId() == albums.getId() && getAlbumName().equals(albums.getAlbumName())
        && getAlbumDate()
        .equals(albums.getAlbumDate()) && artist.equals(albums.artist) && tracks
        .equals(albums.tracks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getAlbumName(), getAlbumDate(), artist, tracks);
  }

  @Override
  public String toString() {
    return "Albums{" +
        "id=" + id +
        ", albumName='" + albumName + '\'' +
        ", albumDate=" + albumDate +
        ", artist=" + artist +
        ", tracks=" + tracks +
        '}';
  }
}
