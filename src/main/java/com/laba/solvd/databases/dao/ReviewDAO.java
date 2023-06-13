package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IReviewDAO;
import com.laba.solvd.databases.model.Reviews;
import java.sql.SQLException;
import java.util.List;

public class ReviewDAO implements IReviewDAO {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  @Override
  public void createReview(Reviews review) {

  }

  @Override
  public Reviews getReviewById(int reviewId) {
    return null;
  }

  @Override
  public List<Reviews> getAllReviews() {
    return null;
  }

  public static void main(String args[]) throws SQLException {

  }
}
