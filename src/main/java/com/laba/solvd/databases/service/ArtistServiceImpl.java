package com.laba.solvd.databases.service;

import com.laba.solvd.databases.interfacedao.IGenericDAO;
import com.laba.solvd.databases.model.Album;
import com.laba.solvd.databases.model.Artists;
import com.laba.solvd.databases.model.Playlist;
import com.laba.solvd.databases.service.interfaceservice.IGenericService;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistServiceImpl implements IGenericService<Artists> {

 private final IGenericDAO genericDAO;
 private final AlbumServiceImpl albumService;

  public ArtistServiceImpl(IGenericDAO genericDAO,
      AlbumServiceImpl albumService) {
    this.genericDAO = genericDAO;
    this.albumService = albumService;
  }

  @Override
  public Artists create(Artists entity, int id) {
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
