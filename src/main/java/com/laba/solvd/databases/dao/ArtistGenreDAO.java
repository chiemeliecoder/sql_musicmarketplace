package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.model.ArtistGenre;
import com.laba.solvd.databases.model.Artists;
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

public class ArtistGenreDAO {
  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public ArtistGenre getArtistGenreById(int id) throws SQLException {

    ArtistGenre artistGenre = new ArtistGenre();

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

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTIST_GENRE WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        artistGenre.setId(resultSet.getInt("id"));
      }
    }

    return artistGenre;

  }

  public static void main(String args[]) throws SQLException {
    ArtistGenre artistGenre = new ArtistGenreDAO().getArtistGenreById(1);
    System.out.println("ArtistGenre ID: " + artistGenre.getId());

  }

}
