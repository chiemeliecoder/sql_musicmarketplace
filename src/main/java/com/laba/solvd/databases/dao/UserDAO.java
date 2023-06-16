package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.model.Purchase;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.UserProfile;
import java.sql.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.*;

public class UserDAO implements IUserDAO {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  public List<Purchase> getPurchase(int purchaseID) {
    List<Purchase> purchases = new ArrayList<>();
    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement( "SELECT purchases.id, purchases.date, purchases.price " +
        "FROM purchases " +
        "JOIN users ON users.purchase_id = purchases.id " +
        "JOIN users ON users.id = purchase.user_id " +
        "WHERE purchases.id = ?")){
      preparedStatement.setInt(1, purchaseID);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        Purchase purchase = new Purchase();
        purchase.setId(resultSet.getInt("id"));
        purchase.setPurchaseDate(resultSet.getDate("date"));
        purchase.setPrice(resultSet.getBigDecimal("price"));

        purchases.add(purchase);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }


    return purchases;
  }

  public User getUserById(int id) throws SQLException {

    Connection connection = CONNECTION_POOL.getConnectionFromPool();

    User user = new User();
    Properties properties = new Properties();
    //example jdbc:mysql://localhost:3306/w3spoint where 3306 is the port number and w3spoint is the database name.
    // Username: Username of MySql database, default is root.  Password: Password of MySql database.
    // "schema" is equivalent to a "database."
    try(InputStream input = new FileInputStream("src/main/resources/db.properties")){
      properties.load(input);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("username"));
      }





    return user;

  }


  @Override
  public void createUser(User user) {
    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("Insert into User (id, username, email, password) VALUES (?, ?, ?, ?)",
        Statement.RETURN_GENERATED_KEYS)){
      preparedStatement.setInt(1, user.getId());
      preparedStatement.setString(2, user.getName());
      preparedStatement.setString(3, user.getEmail());
      preparedStatement.setString(4, user.getPassword());
      



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
  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();

    Connection connection = CONNECTION_POOL.getConnectionFromPool();
    try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER")){
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()){
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("username"));

        users.add(user);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      CONNECTION_POOL.releaseConnectionToPool(connection);
    }
    return users;
  }



  public static void main(String args[]) throws SQLException{
    User use = new UserDAO().getUserById(1);
    System.out.println("User ID: " + use.getId());
    System.out.println("Username: " + use.getName());



    List<User> users = new UserDAO().getAllUsers();

    for (User user : users) {
      System.out.println("User ID: " + user.getId());
      System.out.println("Username: " + user.getName());
    }
    UserDAO userDAO = new UserDAO();

    User newUser = new User();

    newUser.setId(3);
    newUser.setName("JaneDoe");
    newUser.setEmail("janedoe@example.com");
    newUser.setPassword("password123");


    //userDAO.getPurchase(1);
    userDAO.createUser(newUser);






  }


}
