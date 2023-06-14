package com.laba.solvd.databases;

import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.Purchase;
import com.laba.solvd.databases.model.Review;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.Wishlist;
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



    Album firstAlbum = new Album();
    firstAlbum.setAlbumName("Lady");
    firstAlbum.setAlbumDate(d);

    Artists firstArtist = new Artists();
    firstArtist.setArtistName("Kenshi Yonezu");

    Playlist firstPlaylist = new Playlist();
    firstPlaylist.setPlaylistName("Japan vs Korean");

    Purchase firstPurchase = new Purchase();
    firstPurchase.setPurchaseDate(date);

    Review firstReview = new Review();
    firstReview.setAlbum(firstAlbum);
    firstReview.setComments("Wonderful comeback");

    Wishlist firstWishlist = new Wishlist();
    firstWishlist.setAlbum(firstAlbum);

    MusicService musicService = new MusicService();
    firstUser = musicService.create(firstUser);


    List<User> userList = musicService.getAllUsers();
    System.out.println(userList);
    System.out.println(firstUser);


  }

}
