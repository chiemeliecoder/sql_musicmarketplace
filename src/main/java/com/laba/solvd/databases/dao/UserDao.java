package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.model.User;
import com.sun.jdi.connect.spi.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {

  public User getUserById() throws SQLException {

    User user = new User();
    //example jdbc:mysql://localhost:3306/w3spoint where 3306 is the port number and w3spoint is the database name.
    // Username: Username of MySql database, default is root.  Password: Password of MySql database.
    // "schema" is equivalent to a "database."
    try(InputStream input = new FileInputStream("src/main/resources/db.properties")){

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
      e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
      e.printStackTrace();
    }

    try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicmarketplace", "user", "password")){

    }catch{

    }




    return user;

  }

  public static void main(String args[]){

  }

}
