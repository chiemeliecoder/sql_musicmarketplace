SELECT * FROM musicmarketplace.genre;
INSERT INTO `genre` (`idgenre`, `name`) VALUES (1, 'Pop');
UPDATE `genre` SET `name` = 'Pop/Rock' WHERE (`idgenre` = 1);
DELETE FROM `genre` WHERE (`idgenre` = 1);
ALTER TABLE `genre` DROP COLUMN `name`;
ALTER TABLE `genre` ADD COLUMN `name` VARCHAR(255);

-- Find the total number of tracks in each genre
SELECT `musicmarketplace`.`genre`.`idgenre`, `musicmarketplace`.`genre`.`name`, COUNT(`musicmarketplace`.`track`.`idtrack`) AS track_count
FROM `musicmarketplace`.`genre`
LEFT JOIN `musicmarketplace`.`artistgenre` ON `musicmarketplace`.`genre`.`idgenre` = `musicmarketplace`.`artistgenre`.`genreid`
LEFT JOIN `musicmarketplace`.`artist` ON `musicmarketplace`.`artistgenre`.`artistid` = `musicmarketplace`.`artist`.`idartist`
LEFT JOIN `musicmarketplace`.`album` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`album`.`idalbum`
LEFT JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`album`.`idalbum` = `musicmarketplace`.`track`.`albumid`
GROUP BY `musicmarketplace`.`genre`.`idgenre`, `musicmarketplace`.`genre`.`name`;
