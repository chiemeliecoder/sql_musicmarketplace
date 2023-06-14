package com.laba.solvd.databases.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Purchase {

  private int id;

  private Date purchaseDate;

  private BigDecimal price;

  private User user;
  private Track track;

  public Purchase() {
  }


  public Purchase(int id, Date purchaseDate, BigDecimal price,
      User user, Track track) {
    this.id = id;
    this.purchaseDate = purchaseDate;
    this.price = price;
    this.user = user;
    this.track = track;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Track getTrack() {
    return track;
  }

  public void setTrack(Track track) {
    this.track = track;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Purchase)) {
      return false;
    }
    Purchase purchase = (Purchase) o;
    return getId() == purchase.getId() && getPurchaseDate().equals(purchase.getPurchaseDate())
        && getPrice().equals(purchase.getPrice()) && getUser().equals(purchase.getUser())
        && getTrack().equals(purchase.getTrack());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPurchaseDate(), getPrice(), getUser(), getTrack());
  }

  @Override
  public String toString() {
    return "Purchase{" +
        "id=" + id +
        ", purchaseDate=" + purchaseDate +
        ", price=" + price +
        ", user=" + user +
        ", track=" + track +
        '}';
  }
}
