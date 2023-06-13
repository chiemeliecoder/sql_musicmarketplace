package com.laba.solvd.databases;

import com.laba.solvd.databases.model.Albums;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlists;
import com.laba.solvd.databases.model.Purchases;
import com.laba.solvd.databases.model.Reviews;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.Wishlists;
import com.laba.solvd.databases.service.MusicService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

  public static void main(String args[]){
    User firstUser = new User();
    firstUser.setName("Sharon");
    firstUser.setId(4);


    Calendar cal = Calendar.getInstance();
    cal.set(2023, Calendar.MARCH, 28);
    Date date = cal.getTime();
    java.sql.Date d = (java.sql.Date) cal.getTime();

    Albums firstAlbum = new Albums();
    firstAlbum.setAlbumName("Lady");
    firstAlbum.setAlbumDate(d);

    Artists firstArtist = new Artists();
    firstArtist.setArtistName("Kenshi Yonezu");

    Playlists firstPlaylist = new Playlists();
    firstPlaylist.setPlaylistName("Japan vs Korean");

    Purchases firstPurchase = new Purchases();
    firstPurchase.setPurchaseDate(date);

    Reviews  firstReview = new Reviews();
    firstReview.setAlbum(firstAlbum);
    firstReview.setComments("Wonderful comeback");

    Wishlists firstWishlist = new Wishlists();
    firstWishlist.setAlbum(firstAlbum);

    MusicService musicService = new MusicService();
    firstUser = musicService.create(firstUser);


    List<User> userList = musicService.getAllUsers();
    System.out.println(userList);
    System.out.println(firstUser);
    System.out.println("check:" + musicService.performOperation());

  }

}
