package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.ArtistAchievement;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Genre;
import com.laba.solvd.databases.model.Track;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ArtistDAO implements IGenericDAO<Artists> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public List <ArtistAchievement> getArtistAchievement(int artistID) throws SQLException {
    List<ArtistAchievement> artistAchievements = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();

    Properties properties = new Properties();

    try(InputStream input = new FileInputStream("src/main/resources/db.properties")){
      properties.load(input);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    PreparedStatement preparedStatement = connection.prepareStatement( "SELECT aa.id, aa.title, aa.date " +
        "FROM ARTIST_ACHIEVEMENTS aa " +
        "INNER JOIN ARTISTS a ON aa.artist_id = a.id " +
        "WHERE a.id = ?");

    preparedStatement.setInt(1,artistID);

    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()){
      ArtistAchievement artistAchievement1 = new ArtistAchievement();
      artistAchievement1.setId(resultSet.getInt("id"));
      artistAchievement1.setTitle((resultSet.getString("title")));
      artistAchievement1.setAwardDate(resultSet.getDate("date"));


      artistAchievements.add(artistAchievement1);
    }

    return artistAchievements;
  }


  public List<Album> getAlbum(int albumID) {
    List<Album> albums = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement( "SELECT albums.id, albums.title, albums.date " +
        "FROM albums " +
        "JOIN artist_albums ON artist_albums.album_id = albums.id " +
        "WHERE artist_albums.artist_id = ?")){
      preparedStatement.setInt(1,albumID);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        Album albums1 = new Album();
        albums1.setId(resultSet.getInt("id"));
        albums1.setAlbumName(resultSet.getString("title"));
        albums1.setAlbumDate(resultSet.getDate("date"));

        albums.add(albums1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }
    return albums;
  }

  public List<Genre> getAllGenres(int genreID) {
    List<Genre> genre = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM GENRE")){
      preparedStatement.setInt(1,genreID);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        Genre genre1 = new Genre();
        genre1.setId(resultSet.getInt("id"));
        genre1.setGenreName(resultSet.getString("name"));



        genre.add(genre1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }
    return genre;
  }


  public Artists getById(int id) throws SQLException {

    Connection connection = CONNECTION_POOL.getConnectionFromPool();

    Artists artist = new Artists();
    Properties properties = new Properties();

    try(InputStream input = new FileInputStream("src/main/resources/db.properties")){
      properties.load(input);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }



      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTISTS WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        artist.setId(resultSet.getInt("id"));
        artist.setArtistName(resultSet.getString("name"));
      }

    return artist;

  }

  @Override
  public void create(Artists entity) {
    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artists (id, name) VALUES VALUES (?, ?)",
        Statement.RETURN_GENERATED_KEYS)){
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getArtistName());

      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      while (resultSet.next()){}

    }catch(SQLException e){
      throw new RuntimeException("unable to create user", e);
    }finally {
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }

  }



  @Override
  public List<Artists> getAll() {
    List<Artists> artists = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTISTS")){
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        Artists artist1 = new Artists();
        artist1.setId(resultSet.getInt("id"));
        artist1.setArtistName(resultSet.getString("username"));

        artists.add(artist1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }
    return artists;
  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Artists read(int id) {
    return null;
  }

  @Override
  public void update(Artists entity) {

  }

  @Override
  public void delete(int id) {

  }

//  public static void main(String args[]) throws SQLException {
//    Artists artist = new ArtistDAO().getById(1);
//    System.out.println("Artist ID: " + artist.getId());
//    System.out.println("ArtistName: " + artist.getArtistName());
//
//  }


}
