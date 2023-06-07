SELECT * FROM musicmarketplace.track;
INSERT INTO `track` (`id`, `title`, `duration`, `albumid`) VALUES (1, 'Shake It Off', '00:03:39', 1);
UPDATE `track` SET `title` = 'Love Story', `duration` = '00:03:55' WHERE (`id` = 1);
DELETE FROM `track` WHERE (`id` = 1);
ALTER TABLE `track` ADD COLUMN `is_featured` BOOLEAN DEFAULT false;
ALTER TABLE `track` DROP COLUMN `is_featured`;

-- Count the number of tracks in each album
SELECT `musicmarketplace`.`album`.`id`, `musicmarketplace`.`album`.`title`, COUNT(`musicmarketplace`.`track`.`id`) AS num_tracks
FROM `musicmarketplace`.`album`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`album`.`id` = `musicmarketplace`.`track`.`id`
GROUP BY `musicmarketplace`.`album`.`id`;

-- Calculate the total duration of tracks for each artist
SELECT `musicmarketplace`.`artist`.`id`, `musicmarketplace`.`artist`.`name`, SEC_TO_TIME(SUM(TIME_TO_SEC(`musicmarketplace`.`track`.`duration`))) AS total_duration
FROM `musicmarketplace`.`artist`
JOIN `musicmarketplace`.`album`ON `musicmarketplace`.`artist`.`id` = `musicmarketplace`.`album`.`artistid`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`album`.`id` = `musicmarketplace`.`track`.`albumid`
GROUP BY `musicmarketplace`.`artist`.`id`, `musicmarketplace`.`artist`.`name`;


-- Determine the playlist(s) with a track duration exceeding 4 minutes:
SELECT `musicmarketplace`.`playlist_track`.`id`, SEC_TO_TIME(SUM(TIME_TO_SEC(`musicmarketplace`.`track`.`duration`))) AS total_duration
FROM `musicmarketplace`.`playlist_track`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`playlist_track`.`idtrack` = `musicmarketplace`.`track`.`id`
GROUP BY `musicmarketplace`.`playlist_track`.`id`
HAVING SEC_TO_TIME(SUM(TIME_TO_SEC(`musicmarketplace`.`track`.`duration`))) > TIME ('00:04:00');

