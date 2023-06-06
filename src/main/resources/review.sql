SELECT * FROM musicmarketplace.review;
INSERT INTO `review` (`idreview`, `userid`, `albumid`, `rating`, `comment`) VALUES (1, 1, 1, 5, 'Great album!');
UPDATE `review` SET `rating` = 4 WHERE (`idreview` = 1);
DELETE FROM `review` WHERE (`idreview` = 1);

-- Find genres with an average rating greater than 4
SELECT `musicmarketplace`.`genre`.`idgenre`, `musicmarketplace`.`genre`.`name`, AVG(`musicmarketplace`.`review`.`rating`) AS avg_rating
FROM `musicmarketplace`.`genre`
JOIN `musicmarketplace`.`artistgenre` ON `musicmarketplace`.`genre`.`idgenre` = `musicmarketplace`.`artistgenre`.`genreid`
JOIN `musicmarketplace`.`artist` ON `musicmarketplace`.`artistgenre`.`artistid` = `musicmarketplace`.`artist`.`idartist`
JOIN `musicmarketplace`.`album` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`album`.`artistid`
JOIN `musicmarketplace`.`review` ON `musicmarketplace`.`album`.`idalbum` = `musicmarketplace`.`review`.`albumid`
GROUP BY `musicmarketplace`.`genre`.`idgenre`, `musicmarketplace`.`genre`.`name`
HAVING AVG(`musicmarketplace`.`review`.`rating`) > 4;

-- Calculate the highest and lowest rating for each album
SELECT `musicmarketplace`.`review`.`albumid`, MAX(`musicmarketplace`.`review`.`rating`) AS highest_rating, MIN(`musicmarketplace`.`review`.`rating`) AS lowest_rating
FROM `musicmarketplace`.`review`
GROUP BY `musicmarketplace`.`review`.`albumid`;
