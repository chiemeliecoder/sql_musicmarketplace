package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Genre;
import java.util.List;

public interface IGenreDAO {
  void createGenre(Genre genre);
  Genre getGenreById(int id);
  List<Genre> getAllGenres();

}
