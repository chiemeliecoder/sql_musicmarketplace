SELECT * FROM musicmarketplace.playlisttrack;
INSERT INTO `playlisttrack` (`idplaylisttrack`, `idplaylist`, `idtrack`) VALUES (1, 1, 1);
DELETE FROM `playlisttrack` WHERE (`idplaylist` = 1);

-- Retrieve the playlist with distinct tracks
SELECT `musicmarketplace`.`playlisttrack`.`idplaylist`, COUNT(DISTINCT `musicmarketplace`.`playlisttrack`.`idtrack`) AS distinct_track_count
FROM `musicmarketplace`.`playlisttrack`
GROUP BY `musicmarketplace`.`playlisttrack`.`idplaylist`
HAVING COUNT(DISTINCT `musicmarketplace`.`playlisttrack`.`idtrack`) > 0;
