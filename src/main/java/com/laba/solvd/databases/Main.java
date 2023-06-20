package com.laba.solvd.databases;

import com.laba.solvd.databases.dao.UserDAO;
import com.laba.solvd.databases.interfacedao.IUserDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.Purchase;
import com.laba.solvd.databases.model.Review;
import com.laba.solvd.databases.model.User;
import com.laba.solvd.databases.model.UserProfile;
import com.laba.solvd.databases.model.Wishlist;
import com.laba.solvd.databases.service.ArtistServiceImpl;
import com.laba.solvd.databases.service.IMusicService;
import com.laba.solvd.databases.service.MusicService;
import com.laba.solvd.databases.service.PlaylistServiceImpl;
import com.laba.solvd.databases.service.UserServiceImpl;
import com.laba.solvd.databases.service.interfaceservice.IUserService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.log4j.Logger;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class);

  public static void main(String args[]){

    // Create instances of dependencies
    PlaylistServiceImpl playlistService = new PlaylistServiceImpl();

    // Create an instance of UserServiceImpl
    UserServiceImpl userService = new UserServiceImpl(playlistService);

    ArtistServiceImpl artistService = new ArtistServiceImpl();

    // Create an instance of MusicService
    MusicService musicService = new MusicService(playlistService);

    // Call the methods of MusicService
    musicService.performOperation();

    int maxId = userService.getMaxUserId();

    // Create a new user
    User newUser = new User();
    newUser.setId(maxId + 1);
    newUser.setName("hannah Doe");
    newUser.setEmail("hannah@example.com");
    newUser.setPassword("password009");

    UserProfile userProfile = new UserProfile();
    userProfile.setId(2);
    userProfile.setBio("I like cute anime music");
    userProfile.setProfileimage("https://cdn.shopify.com/s/files/1/0416/8083/0620/files/ecomm-CHGAL-Core2021_367x353px_07-CN_1000x.png?v=1614324462");
    userProfile.setLocation("London");

    newUser.setUserProfile(userProfile.getId());



    // Call the create method
//    User createdUser = userService.create(newUser);
//    System.out.println("Created user: " + createdUser);


    // Get all users
    List<User> allUsers = userService.getAllUsers();
    System.out.println("All users: " + allUsers);

    int maxArtId = artistService.getMaxArtistId();
    Artists newArtist = new Artists();
    newArtist.setId(maxArtId + 1);
    newArtist.setArtistName("E ve");

    Album album = new Album();
    album.setId(2);
    newArtist.setAlbum(album.getId());

//    Artists createdArtist = artistService.createArt(newArtist);
//    System.out.println("Created artist: " + createdArtist);

    List<Artists> allArtists = artistService.getAllArtists();
    System.out.println("All artists: " + allArtists);

    int userCount = musicService.countUsers();
    System.out.println("Number of users: " + userCount);

    int artistCount = musicService.countArtists();
    System.out.println("Total number of artists: " + artistCount);


    logger.info("end of information");

//    Calendar cal = Calendar.getInstance();
//    cal.set(2023, Calendar.MARCH, 28);
//    Date date = cal.getTime();
//    java.sql.Date d = new java.sql.Date(date.getTime());
//
//
//
//    Album firstAlbum = new Album();
//    firstAlbum.setAlbumName("Lady");
//    firstAlbum.setAlbumDate(d);
//
//    Artists firstArtist = new Artists();
//    firstArtist.setArtistName("Kenshi Yonezu");
//
//    Playlist firstPlaylist = new Playlist();
//    firstPlaylist.setPlaylistName("Japan vs Korean");
//
//    Purchase firstPurchase = new Purchase();
//    firstPurchase.setPurchaseDate(d);
//
//    Review firstReview = new Review();
//    firstReview.setComments("Wonderful comeback");
//
//    Wishlist firstWishlist = new Wishlist();
//    firstWishlist.setName("Mieta");




  }

}
