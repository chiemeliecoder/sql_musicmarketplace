package com.laba.solvd.databases.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Purchases {

  private int id;

  private Date purchaseDate;

  private BigDecimal price;

  private User user;
  private Tracks track;

  public Purchases() {
  }


  public Purchases(int id, Date purchaseDate, BigDecimal price,
      User user, Tracks track) {
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

  public Tracks getTrack() {
    return track;
  }

  public void setTrack(Tracks track) {
    this.track = track;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Purchases)) {
      return false;
    }
    Purchases purchases = (Purchases) o;
    return getId() == purchases.getId() && getPurchaseDate().equals(purchases.getPurchaseDate())
        && getPrice().equals(purchases.getPrice()) && getUser().equals(purchases.getUser())
        && getTrack().equals(purchases.getTrack());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPurchaseDate(), getPrice(), getUser(), getTrack());
  }

  @Override
  public String toString() {
    return "Purchases{" +
        "id=" + id +
        ", purchaseDate=" + purchaseDate +
        ", price=" + price +
        ", user=" + user +
        ", track=" + track +
        '}';
  }
}
