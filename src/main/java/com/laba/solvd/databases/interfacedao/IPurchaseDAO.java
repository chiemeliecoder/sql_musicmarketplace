package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Purchases;
import java.util.List;

public interface IPurchaseDAO {
  void createPurchase(Purchases purchase);
  Purchases getPurchaseById(int purchaseId);
  List<Purchases> getAllPurchases();

}
