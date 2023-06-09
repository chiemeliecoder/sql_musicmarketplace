package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.model.Albums;
import com.laba.solvd.databases.model.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AlbumDAO {

  public Albums getAlbumById(int id) throws SQLException {

    Albums albums = new Albums();
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

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALBUMS WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        albums.setId(resultSet.getInt("id"));
        albums.setAlbumName(resultSet.getString("title"));
        Date albumDate = resultSet.getDate("date");
        albums.setAlbumDate(albumDate);
      }
    }

    return albums;
  }


  public static void main(String args[]) throws SQLException{
    Albums album = new AlbumDAO().getAlbumById(1);
    System.out.println("Album ID: " + album.getId());
    System.out.println("Albumname: " + album.getAlbumName());
    System.out.println("AlbumDate:" + album.getAlbumDate());

  }

}
