package com.laba.solvd.databases.model;

import java.util.Objects;

public class UserProfile {

  private int id;

  private String bio;

  private String profileimage;

  private String location;

/**
 * For example, imagine you have an application where users can create an account and fill out their profile information.
 * When a user logs in, you can use their user ID to retrieve their profile information from the user_profiles table
 * and display it on their profile page.
 * Imagine you are building a social media platform where users can create an account, fill out their profile information,
 * and connect with other users. When a user creates an account, their information is stored in the users table.
 * They can then fill out their profile information, which is stored in the user_profiles table.
 *
 * By having the user ID as a foreign key in the user_profiles table,
 * you can easily associate a user with their profile information. For example, when a user logs in to the platform,
 * you can use their user ID to retrieve their profile information from the user_profiles table and display it on their profile page.
 *
 * Additionally, when a user views another user’s profile page, you can use the other user’s ID to retrieve their profile information
 * from the user_profiles table and display it on their profile page.
 * */
  public UserProfile() {
  }

  public UserProfile(int id, String bio, String profileimage, String location){
    this.id = id;
    this.bio = bio;
    this.profileimage = profileimage;
    this.location = location;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getProfileimage() {
    return profileimage;
  }

  public void setProfileimage(String profileimage) {
    this.profileimage = profileimage;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserProfile)) {
      return false;
    }
    UserProfile that = (UserProfile) o;
    return getId() == that.getId() && getBio().equals(that.getBio()) && getProfileimage()
        .equals(that.getProfileimage()) && getLocation().equals(that.getLocation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getBio(), getProfileimage(), getLocation());
  }

  @Override
  public String toString() {
    return "UserProfile{" +
        "id=" + id +
        ", bio='" + bio + '\'' +
        ", profileimage='" + profileimage + '\'' +
        ", location='" + location + '\'' +
        '}';
  }
}
