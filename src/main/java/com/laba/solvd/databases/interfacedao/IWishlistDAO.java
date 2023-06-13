package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Wishlists;
import java.sql.SQLException;

public interface IWishlistDAO extends IGenericDAO<Wishlists>{
  Wishlists getWishlistById(int id) throws SQLException;

}
