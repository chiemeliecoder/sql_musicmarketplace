package com.laba.solvd.databases;

import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.Purchase;
import com.laba.solvd.databases.model.Review;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.Wishlist;
import com.laba.solvd.databases.service.ArtistServiceImpl;
import com.laba.solvd.databases.service.IMusicService;
import com.laba.solvd.databases.service.MusicService;
import com.laba.solvd.databases.service.PlaylistServiceImpl;
import com.laba.solvd.databases.service.UserServiceImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

  public static void main(String args[]){
    User firstUser = new User();
    firstUser.setName("Sharon");
    firstUser.setId(7);


    Calendar cal = Calendar.getInstance();
    cal.set(2023, Calendar.MARCH, 28);
    Date date = cal.getTime();
    java.sql.Date d = new java.sql.Date(date.getTime());



    Album firstAlbum = new Album();
    firstAlbum.setAlbumName("Lady");
    firstAlbum.setAlbumDate(d);

    Artists firstArtist = new Artists();
    firstArtist.setArtistName("Kenshi Yonezu");

    Playlist firstPlaylist = new Playlist();
    firstPlaylist.setPlaylistName("Japan vs Korean");

    Purchase firstPurchase = new Purchase();
    firstPurchase.setPurchaseDate(d);

    Review firstReview = new Review();
    firstReview.setComments("Wonderful comeback");

    Wishlist firstWishlist = new Wishlist();
    firstWishlist.setName("Mieta");




    UserServiceImpl userService = new UserServiceImpl();
    userService.create(firstUser);

    ArtistServiceImpl artistService = new ArtistServiceImpl();
    artistService.create(firstArtist);

    IMusicService musicService = new MusicService(userService,artistService);

    //firstUser = userService.create(firstUser);

    System.out.println(userService.getAllUsers());

    List<User> userList = musicService.getAllUsers();
    //System.out.println(userList);
    //System.out.println(firstUser);

//    User createdUser = musicService.create(firstUser);
//    System.out.println("Created user: " + createdUser);


  }

}
