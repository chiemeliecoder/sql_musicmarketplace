package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Wishlists;

public interface IWishlistDAO extends IGenericDAO<Wishlists>{
  Wishlists getWishlistById(int id);

}
