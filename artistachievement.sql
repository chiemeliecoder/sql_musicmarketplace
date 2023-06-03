SELECT * FROM musicmarketplace.artistachievement;
INSERT INTO `artistachievement` (`idartistachievement`, `artistid`, `title`, `date`) VALUES (1, 1, 'billbord 100', '2014-10-29');
UPDATE `artistachievement` SET `title` = 'Grammy Award' WHERE (`idartistachievement` = 1);


-- Determine the artists who have achieved at least 1 achievement
SELECT `musicmarketplace`.`artist`.`idartist`, `musicmarketplace`.`artist`.`name`, COUNT(`musicmarketplace`.`artistachievement`.`idartistachievement`) AS achievement_count
FROM `musicmarketplace`.`artist`
JOIN `musicmarketplace`.`artistachievement` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`artistachievement`.`artistid`
GROUP BY `musicmarketplace`.`artist`.`idartist`, `musicmarketplace`.`artist`.`name`
HAVING achievement_count >= 1;
