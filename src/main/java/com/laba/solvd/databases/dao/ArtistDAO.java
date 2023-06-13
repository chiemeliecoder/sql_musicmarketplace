package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IAlbumDAO;
import com.laba.solvd.databases.interfacedao.IArtistDAO;
import com.laba.solvd.databases.model.ArtistAchievements;
import com.laba.solvd.databases.model.Artists;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ArtistDAO implements IArtistDAO {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public Artists getArtistById(int id) throws SQLException {

    Artists artist = new Artists();
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

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTISTS WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        artist.setId(resultSet.getInt("id"));
        artist.setArtistName(resultSet.getString("name"));
      }
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

  public static void main(String args[]) throws SQLException {
    Artists artist = new ArtistDAO().getArtistById(1);
    System.out.println("Artist ID: " + artist.getId());
    System.out.println("ArtistName: " + artist.getArtistName());

  }


}
