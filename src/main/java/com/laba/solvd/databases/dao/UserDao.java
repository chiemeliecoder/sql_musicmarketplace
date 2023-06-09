package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.User;
import java.sql.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.*;

public class UserDao<T,ID> implements IGenericDAO<T, ID> {

  public User getUserById(int id) throws SQLException {

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

    try(Connection connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"))) {

      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE ID=?");

      preparedStatement.setInt(1,id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("username"));
      }
    }




    return user;

  }

  public static void main(String args[]) throws SQLException{
    User user = new UserDao().getUserById(1);
    System.out.println("User ID: " + user.getId());
    System.out.println("Username: " + user.getName());

  }

  @Override
  public void create(T entity) {

  }

  @Override
  public T read(ID id) {
    return null;
  }

  @Override
  public void update(T entity) {

  }

  @Override
  public void delete(ID id) {

  }

  @Override
  public List<T> getAll() {
    return null;
  }
}
