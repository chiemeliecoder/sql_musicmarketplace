package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Playlists;
import com.laba.solvd.databases.model.Tracks;
import java.util.List;

public interface IPlaylistTrackDAO {
  void addTrackToPlaylist(Playlists playlist, Tracks track);
  List<Tracks> getTracksInPlaylist(Playlists playlist);

}
