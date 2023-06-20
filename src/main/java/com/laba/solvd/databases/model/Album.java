package com.laba.solvd.databases.model;


import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Album {

  private int id;

  private String albumName;

  private Date albumDate;

  private List<Track> tracks;

  private Artists artists;

  //constructor


  public Album() {
  }

  public Album(int id, String albumName, Date albumDate,
      List<Track> tracks, Artists artists) {
    this.id = id;
    this.albumName = albumName;
    this.albumDate = albumDate;
    this.tracks = tracks;
    this.artists = artists;
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

  public List<Track> getTracks() {
    return tracks;
  }

  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  public Artists getArtists() {
    return artists;
  }

  public Artists retrieveArtistById(int artId) {
    Artists art = new Artists();
    art.setId(artId);
    return art;
  }

  public void setArtists(Integer artistsId) {
    Artists artists = retrieveArtistById(artistsId);
    this.artists = artists;
  }

  //equals and hashcode


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Album)) {
      return false;
    }
    Album album = (Album) o;
    return getId() == album.getId() && getAlbumName().equals(album.getAlbumName()) && getAlbumDate()
        .equals(album.getAlbumDate()) && getTracks().equals(album.getTracks()) && getArtists()
        .equals(album.getArtists());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getAlbumName(), getAlbumDate(), getTracks(), getArtists());
  }

  @Override
  public String toString() {
    return "Album{" +
        "id=" + id +
        ", albumName='" + albumName + '\'' +
        ", albumDate=" + albumDate +
        ", tracks=" + tracks +
        ", artists=" + artists +
        '}';
  }
}
