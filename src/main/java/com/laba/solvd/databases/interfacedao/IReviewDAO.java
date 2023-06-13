package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Reviews;
import java.util.List;

public interface IReviewDAO {

  void createReview(Reviews review);
  Reviews getReviewById(int reviewId);
  List<Reviews> getAllReviews();
}
