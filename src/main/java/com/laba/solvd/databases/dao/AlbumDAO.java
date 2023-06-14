package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class AlbumDAO implements IGenericDAO<Album> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public Album getById(int id) throws SQLException {

    Album albums = new Album();
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


  @Override
  public void create(Album album) {
    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("Insert into Albums (id, title, date, artistid) VALUES  (?, ?, ?,?)",
        Statement.RETURN_GENERATED_KEYS)){
      preparedStatement.setInt(1, album.getId());
      preparedStatement.setString(2, album.getAlbumName());
      //preparedStatement.setDate(3, (Date) album.getAlbumDate());
      java.util.Date utilDate = new java.util.Date();
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

      preparedStatement.setDate(3, sqlDate);
      preparedStatement.setInt(4, album.getArtist().getId());
      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      while (resultSet.next()){}

    }catch(SQLException e){
      throw new RuntimeException("unable to create album", e);
    }finally {
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }

  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Album read(int id) {
    return null;
  }

  @Override
  public void update(Album entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Album> getAll() {
    List<Album> albums = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALBUMS")){
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        Album albums1 = new Album();
        albums1.setId(resultSet.getInt("id"));
        albums1.setAlbumName(resultSet.getString("title"));
        albums1.setAlbumDate(resultSet.getDate("date"));
        Artists art = new Artists();
        art.setId(1);
        albums1.setArtist(art);


        albums.add(albums1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }
    return albums;
  }


  public static void main(String args[]) throws SQLException{
    Album album = new AlbumDAO().getById(1);
    System.out.println("Album ID: " + album.getId());
    System.out.println("Albumname: " + album.getAlbumName());
    System.out.println("AlbumDate:" + album.getAlbumDate());

    Calendar cal = Calendar.getInstance();
    cal.set(2023, Calendar.MARCH, 28);
    java.util.Date date = cal.getTime();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

    AlbumDAO albumDAO = new AlbumDAO();

    Album newAlbum = new Album();
    newAlbum.setId(4);
    newAlbum.setAlbumName("Lady");
    newAlbum.setAlbumDate(sqlDate);

    Artists art = new Artists();
    art.setId(1);
    newAlbum.setArtist(art);


    albumDAO.create(newAlbum);

    List<Album> albumsList = new AlbumDAO().getAll();

    for (Album a : albumsList) {
      System.out.println("User ID: " + a.getId());
      System.out.println("Username: " + a.getAlbumName());
      System.out.println("Albumdate: " + a.getAlbumDate());
      System.out.println("artistid: " + a.getArtist());
    }

  }

}
