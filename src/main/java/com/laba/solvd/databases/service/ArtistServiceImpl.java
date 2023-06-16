package com.laba.solvd.databases.service;

import com.laba.solvd.databases.dao.AlbumDAO;
import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.service.interfaceservice.IArtistService;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistServiceImpl implements IArtistService {

 private final IGenericDAO genericDAO;
 private final AlbumServiceImpl albumService;

  public ArtistServiceImpl() {
    this.genericDAO = new AlbumDAO();
    this.albumService = new AlbumServiceImpl();
  }

  @Override
  public Artists create(Artists entity) {
    entity.setId(null);
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
  public List<Artists> getAllUsers() {
    return genericDAO.getAll();
  }
}
