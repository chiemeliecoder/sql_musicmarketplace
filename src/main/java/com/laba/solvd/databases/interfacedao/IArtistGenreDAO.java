package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Genre;
import java.util.List;

public interface IArtistGenreDAO {

  void addGenreToArtist(Artists artist, Genre genre);
  List<Genre> getGenresOfArtist(Artists artist);
}
