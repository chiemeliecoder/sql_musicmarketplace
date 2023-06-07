SELECT * FROM musicmarketplace.artist_achievement;
INSERT INTO `artist_achievement` (`id`, `artistid`, `title`, `date`) VALUES (1, 1, 'billbord 100', '2014-10-29');
UPDATE `artist_achievement` SET `title` = 'Grammy Award' WHERE (`id` = 1);


-- Determine the artists who have achieved at least 1 achievement
SELECT `musicmarketplace`.`artist`.`id`, `musicmarketplace`.`artist`.`name`, COUNT(`musicmarketplace`.`artist_achievement`.`id`) AS achievement_count
FROM `musicmarketplace`.`artist`
JOIN `musicmarketplace`.`artist_achievement` ON `musicmarketplace`.`artist`.`id` = `musicmarketplace`.`artist_achievement`.`artistid`
GROUP BY `musicmarketplace`.`artist`.`id`, `musicmarketplace`.`artist`.`name`
HAVING achievement_count >= 1;