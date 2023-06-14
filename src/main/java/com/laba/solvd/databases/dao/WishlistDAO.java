package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Wishlist;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class WishlistDAO implements IGenericDAO<Wishlist> {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public Wishlist getById(int id) throws SQLException {

    Wishlist wishlist = new Wishlist();

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

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM WISHLISTS WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        wishlist.setId(resultSet.getInt("id"));
      }
    }

    return wishlist;

  }

  @Override
  public void create(Wishlist entity) {

  }

  /**
   * Retrieve an object that was previously persisted to the database using
   *
   * @param id
   */
  @Override
  public Wishlist read(int id) {
    return null;
  }

  @Override
  public void update(Wishlist entity) {

  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Wishlist> getAll() {
    return null;
  }

  public static void main(String args[]) throws SQLException {
    Wishlist wishlist = new WishlistDAO().getById(1);
    System.out.println("Wishlist ID: " + wishlist.getId());

  }


}
