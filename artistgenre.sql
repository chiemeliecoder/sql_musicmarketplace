SELECT * FROM musicmarketplace.artistgenre;
INSERT INTO `artistgenre` (`idartistgenre`, `artistid`, `genreid`) VALUES (1, 1, 1);
ALTER TABLE `artistgenre` RENAME TO `Artist_MusicGenre`;
SELECT * FROM musicmarketplace.Artist_MusicGenre;
ALTER TABLE `Artist_MusicGenre` RENAME TO `artistgenre`;