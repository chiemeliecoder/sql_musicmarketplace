SELECT * FROM musicmarketplace.track;
INSERT INTO `track` (`idtrack`, `title`, `duration`, `albumid`) VALUES (1, 'Shake It Off', '00:03:39', 1);
UPDATE `track` SET `title` = 'Love Story', `duration` = '00:03:55' WHERE (`idtrack` = 1);
DELETE FROM `track` WHERE (`idtrack` = 1);
ALTER TABLE `track` ADD COLUMN `is_featured` BOOLEAN DEFAULT false;
ALTER TABLE `track` DROP COLUMN `is_featured`;

-- Count the number of tracks in each album
SELECT `idalbum`, `musicmarketplace`.`album`.`title`, COUNT(`musicmarketplace`.`track`.`idtrack`) AS num_tracks
FROM `musicmarketplace`.`album`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`album`.`idalbum` = `musicmarketplace`.`track`.`idtrack`
GROUP BY `musicmarketplace`.`album`.`idalbum`;

-- Calculate the total duration of tracks for each artist
SELECT `musicmarketplace`.`artist`.`idartist`, `musicmarketplace`.`artist`.`name`, SEC_TO_TIME(SUM(TIME_TO_SEC(`musicmarketplace`.`track`.`duration`))) AS total_duration
FROM `musicmarketplace`.`artist`
JOIN `musicmarketplace`.`album`ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`album`.`artistid`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`album`.`idalbum` = `musicmarketplace`.`track`.`albumid`
GROUP BY `musicmarketplace`.`artist`.`idartist`, `musicmarketplace`.`artist`.`name`;


-- Determine the playlist(s) with a track duration exceeding 4 minutes:
SELECT `musicmarketplace`.`playlisttrack`.`idplaylist`, SEC_TO_TIME(SUM(TIME_TO_SEC(`musicmarketplace`.`track`.`duration`))) AS total_duration
FROM `musicmarketplace`.`playlisttrack`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`playlisttrack`.`idtrack` = `musicmarketplace`.`track`.`idtrack`
GROUP BY `musicmarketplace`.`playlisttrack`.`idplaylist`
HAVING SEC_TO_TIME(SUM(TIME_TO_SEC(`musicmarketplace`.`track`.`duration`))) > TIME ('00:04:00');

