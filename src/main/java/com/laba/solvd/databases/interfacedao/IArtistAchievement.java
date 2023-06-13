package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.ArtistAchievements;
import java.util.List;

public interface IArtistAchievement {
  void createArtistAchievement(ArtistAchievements achievement);
  ArtistAchievements getArtistAchievementById(int achievementId);
  List<ArtistAchievements> getAllArtistAchievements();

}
