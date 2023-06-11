package com.laba.solvd.databases.model;

import java.util.Objects;

public class UserProfile {

  private int id;

  private String bio;

  private String profileimage;

  private String location;

  private User user_id;

  public UserProfile() {
  }

  public UserProfile(int id, String bio, String profileimage, String location,
      User user_id) {
    this.id = id;
    this.bio = bio;
    this.profileimage = profileimage;
    this.location = location;
    this.user_id = user_id;
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

  public User getUser_id() {
    return user_id;
  }

  public void setUser_id(User user_id) {
    this.user_id = user_id;
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
        .equals(that.getProfileimage()) && getLocation().equals(that.getLocation()) && getUser_id()
        .equals(that.getUser_id());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getBio(), getProfileimage(), getLocation(), getUser_id());
  }
}
