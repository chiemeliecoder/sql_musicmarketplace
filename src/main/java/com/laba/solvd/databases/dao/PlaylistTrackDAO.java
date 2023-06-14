package com.laba.solvd.databases.dao;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.interfacedao.IPlaylistTrackDAO;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.model.Track;
import java.sql.SQLException;
import java.util.List;

public class PlaylistTrackDAO implements IPlaylistTrackDAO {

  private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

  @Override
  public void addTrackToPlaylist(Playlist playlist, Track track) {

  }

  @Override
  public List<Track> getTracksInPlaylist(Playlist playlist) {
    return null;
  }

  public static void main(String args[]) throws SQLException {

  }
}
