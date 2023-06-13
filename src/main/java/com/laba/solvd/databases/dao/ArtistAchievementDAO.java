package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IArtistAchievement;
import com.laba.solvd.databases.model.Albums;
import com.laba.solvd.databases.model.ArtistAchievements;
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
import java.util.List;
import java.util.Properties;

public class ArtistAchievementDAO implements IArtistAchievement {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public ArtistAchievements getAchievementById(int id) throws SQLException {

    ArtistAchievements achievements = new ArtistAchievements();
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

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ARTIST_ACHIEVEMENTS WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        achievements.setId(resultSet.getInt("id"));
        achievements.setTitle(resultSet.getString("title"));
        Date awardDate = resultSet.getDate("date");
        achievements.setAwardDate(awardDate);
      }
    }

    return achievements;

  }

  @Override
  public void createArtistAchievement(ArtistAchievements achievement) {

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artist_achievements (id, artistid, title, date) VALUES  (?, ?, ?,?)",
        Statement.RETURN_GENERATED_KEYS)){
      preparedStatement.setInt(1, achievement.getId());
      preparedStatement.setInt(2,achievement.getArtist().getId());
      preparedStatement.setString(3, achievement.getTitle());
      java.util.Date utilDate = new java.util.Date();
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

      preparedStatement.setDate(4, sqlDate);

      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      while (resultSet.next()){}

    }catch(SQLException e){
      throw new RuntimeException("unable to create album", e);
    }finally {
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }
  }


  @Override
  public List<ArtistAchievements> getAllArtistAchievements() {
    List<Albums> albums = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ALBUMS")){
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        Albums albums1 = new Albums();
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
    return null;
  }

  public static void main(String args[]) throws SQLException{
    ArtistAchievements artistAchievements = new ArtistAchievementDAO().getAchievementById(1);
    System.out.println("Award ID: " + artistAchievements.getId());
    System.out.println("AwardName: " + artistAchievements.getTitle());
    System.out.println("AwardDate:" + artistAchievements.getAwardDate());

  }


}
