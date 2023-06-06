SELECT * FROM musicmarketplace.user;
INSERT INTO `user` (`iduser`, `username`, `email`, `password`) VALUES (1, 'JohnDoe', 'johndoe@example.com', 'password123');
UPDATE `user` SET `username` = 'JaneDoe' WHERE (`iduser` = 1);
DELETE FROM `user` WHERE (`iduser` = 1);
ALTER TABLE `user` ADD COLUMN `age` INT;
ALTER TABLE `user` DROP COLUMN `age`;
SELECT * FROM `musicmarketplace`.`user` JOIN `musicmarketplace`.`playlist` ON `musicmarketplace`.`user`.`iduser` = `musicmarketplace`.`playlist`.`userid`
JOIN `musicmarketplace`.`wishlist` ON `musicmarketplace`.`user`.`iduser` = `musicmarketplace`.`wishlist`.`userid`
JOIN `musicmarketplace`.`purchase` ON `musicmarketplace`.`user`.`iduser` = `musicmarketplace`.`purchase`.`userid`
JOIN `musicmarketplace`.`review` ON `musicmarketplace`.`user`.`iduser` = `musicmarketplace`.`review`.`userid`
JOIN `musicmarketplace`.`track` ON `musicmarketplace`.`purchase`.`trackid` = `musicmarketplace`.`track`.`idtrack`
JOIN `musicmarketplace`.`album` ON `musicmarketplace`.`track`.`albumid` = `musicmarketplace`.`album`.`idalbum`
JOIN `musicmarketplace`.`artist` ON `musicmarketplace`.`album`.`artistid` = `musicmarketplace`.`artist`.`idartist`
JOIN `musicmarketplace`.`artistgenre` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`artistgenre`.`artistid`
JOIN `musicmarketplace`.`genre` ON `musicmarketplace`.`artistgenre`.`genreid` = `musicmarketplace`.`genre`.`idgenre`
JOIN `musicmarketplace`.`artistachievement` ON `musicmarketplace`.`artist`.`idartist` = `musicmarketplace`.`artistachievement`.`artistid`;
-- Left Join
SELECT *
FROM `musicmarketplace`.`user`
LEFT JOIN `playlist` ON `musicmarketplace`.`user`.`iduser`= `musicmarketplace`.`playlist`.`userid`;

-- Self Join
SELECT *
FROM `musicmarketplace`.`user` u1
JOIN `musicmarketplace`.`user` u2 ON u1.iduser = u2.iduser;

