SELECT * FROM musicmarketplace.artist;
INSERT INTO `artist` (`idartist`, `name`) VALUES (1, 'Taylor Swift');
UPDATE `artist` SET `name` = 'Alison Swift' WHERE (`idartist` = 1);
DELETE FROM `artist` WHERE (`idartist` = 1);

-- Outer Join
SELECT *
FROM `musicmarketplace`.`artist`
LEFT OUTER JOIN `musicmarketplace`.`artistgenre` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`artistgenre`.`artistid`;