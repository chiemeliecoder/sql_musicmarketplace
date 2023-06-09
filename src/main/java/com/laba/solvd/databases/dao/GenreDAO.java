package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Genre;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class GenreDAO {

  public Genre getGenreById(int id) throws SQLException {

    Genre genre = new Genre();
    Properties properties = new Properties();

    try(InputStream input = new FileInputStream("src/main/resources/db.properties")){
      properties.load(input);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try(Connection connection = DriverManager
        .getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"))) {

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GENRE WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        genre.setId(resultSet.getInt("id"));
        genre.setGenreName(resultSet.getString("name"));
      }
    }

    return genre;

  }

  public static void main(String args[]) throws SQLException {
    Genre genre = new GenreDAO().getGenreById(1);
    System.out.println("Award ID: " + genre.getId());
    System.out.println("genreName: " + genre.getGenreName());

  }
}
