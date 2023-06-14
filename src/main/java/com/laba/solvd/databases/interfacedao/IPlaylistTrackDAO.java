package com.laba.solvd.databases.interfacedao;

import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.Track;
import java.util.List;

public interface IPlaylistTrackDAO {
  void addTrackToPlaylist(Playlist playlist, Track track);
  List<Track> getTracksInPlaylist(Playlist playlist);

}
