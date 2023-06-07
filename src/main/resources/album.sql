SELECT * FROM musicmarketplace.album;
INSERT INTO `album` (`id`, `title`, `date`, `artistid`) VALUES (1, '1989', '2014-10-27', 1);
UPDATE `album` SET `title` = 'Red', `date` = '2012-10-22' WHERE (`idalbum` = 1);
DELETE FROM `album` WHERE (`id` = 1);
ALTER TABLE `album` MODIFY COLUMN `title` VARCHAR(100);
ALTER TABLE `album` MODIFY COLUMN `title` VARCHAR(255);
-- Inner Join
SELECT *
FROM `musicmarketplace`.`album`
INNER JOIN `musicmarketplace`.`artist` ON `musicmarketplace`.`album`.`artistid`= `musicmarketplace`.`artist`.`idartist`;

-- Find the earliest release date for each artist
SELECT `musicmarketplace`.`artist`.`idartist`, `musicmarketplace`.`artist`.`name`, MIN(`musicmarketplace`.`album`.`date`) AS earliest_release_date
FROM `musicmarketplace`.`artist`
JOIN `musicmarketplace`.`album` ON  `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`album`.`id`
GROUP BY `musicmarketplace`.`artist`.`idartist`;

-- Find artists who have released 1 album
SELECT `musicmarketplace`.`artist`.`idartist`, `musicmarketplace`.`artist`.`name`, COUNT(`musicmarketplace`.`album`.`id`) AS num_albums
FROM `musicmarketplace`.`artist`
JOIN `musicmarketplace`.`album` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`album`.`id`
GROUP BY `musicmarketplace`.`artist`.`idartist`
HAVING COUNT(`musicmarketplace`.`album`.`id`) >= 1;