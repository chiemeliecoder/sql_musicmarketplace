SELECT * FROM musicmarketplace.artist;
INSERT INTO `artist` (`id`, `name`) VALUES (1, 'Taylor Swift');
UPDATE `artist` SET `name` = 'Alison Swift' WHERE (`id` = 1);
DELETE FROM `artist` WHERE (`id` = 1);

-- Outer Join
SELECT *
FROM `musicmarketplace`.`artist`
LEFT OUTER JOIN `musicmarketplace`.`artist_genre` ON `musicmarketplace`.`artist`.`id` = `musicmarketplace`.`artist_genre`.`artistid`;