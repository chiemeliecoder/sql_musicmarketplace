package com.laba.solvd.databases.service;

import com.laba.solvd.databases.configurations.ConnectionPool;
import com.laba.solvd.databases.dao.AlbumDAO;
import com.laba.solvd.databases.dao.ArtistDAO;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.service.interfaceservice.IArtistService;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistServiceImpl implements IArtistService {

 private final IGenericDAO genericDAO;
 private final AlbumServiceImpl albumService;

  public ArtistServiceImpl() {
    this.genericDAO = new ArtistDAO();
    this.albumService = new AlbumServiceImpl();
  }

  @Override
  public Artists createArt(Artists entity) {
    if (entity == null) {
      throw new IllegalArgumentException("User entity cannot be null");
    }

    //entity.setId(null);
    genericDAO.create(entity);

    if(entity.getAlbums() != null){
      List<Album> albums = entity.getAlbums().stream()
          .map(album -> albumService.create(album, entity.getId())).collect(
              Collectors.toList());
      entity.setAlbums(albums);
    }
    return entity;
  }




  @Override
  public List<Artists> getAllArtists() {
    return genericDAO.getAll();
  }
}
