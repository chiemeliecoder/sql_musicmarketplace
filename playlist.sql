SELECT * FROM musicmarketplace.playlist;
INSERT INTO `playlist` (`idplaylist`, `name`, `userid`) VALUES (1, 'My Favorites', 1);
UPDATE `playlist` SET `name` = 'Big Hits' WHERE (`idplaylist` = 1);
DELETE FROM `playlist` WHERE (`idplaylist` = 1);
-- Right Join
SELECT *
FROM `musicmarketplace`.`playlist`
RIGHT JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`playlist`.`idplaylist` = `musicmarketplace`.`track`.`idtrack`;

-- Determine the number of playlists created by each user:
SELECT `musicmarketplace`.`playlist`.`userid`, COUNT(`musicmarketplace`.`playlist`.`idplaylist`) AS playlist_count
FROM `musicmarketplace`.`playlist`
GROUP BY `musicmarketplace`.`playlist`.`userid`;
