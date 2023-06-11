package com.laba.solvd.databases.model;

import java.util.Objects;

public class ArtistGenre {

  /**
  * the ArtistGenre entity classes not to be directly referenced in the Artist,
  * Genre classes. This approach is known as separation of concerns and can help keep
  * the classes focused on their primary responsibilities.
  **/
  private int id;

  private Artists artist;

  private Genre genre;

  public ArtistGenre() {
  }

  public ArtistGenre(int id, Artists artist, Genre genre) {
    this.id = id;
    this.artist = artist;
    this.genre = genre;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Artists getArtist() {
    return artist;
  }

  public void setArtist(Artists artist) {
    this.artist = artist;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ArtistGenre)) {
      return false;
    }
    ArtistGenre that = (ArtistGenre) o;
    return getId() == that.getId() && getArtist().equals(that.getArtist()) && getGenre()
        .equals(that.getGenre());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getArtist(), getGenre());
  }
}
