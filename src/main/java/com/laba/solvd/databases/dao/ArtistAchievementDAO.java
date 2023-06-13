package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.model.Albums;
import com.laba.solvd.databases.model.ArtistAchievements;
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

public class ArtistAchievementDAO {

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

  public static void main(String args[]) throws SQLException{
    ArtistAchievements artistAchievements = new ArtistAchievementDAO().getAchievementById(1);
    System.out.println("Award ID: " + artistAchievements.getId());
    System.out.println("AwardName: " + artistAchievements.getTitle());
    System.out.println("AwardDate:" + artistAchievements.getAwardDate());

  }

}
