SELECT * FROM musicmarketplace.wishlist;
INSERT INTO `wishlist` (`idwishlist`, `userid`, `albumid`) VALUES (1, 1, 1);
UPDATE `wishlist` SET `albumid` = 2 WHERE (`idwishlist` = 1);
DELETE FROM `wishlist` WHERE (`idwishlist` = 1);

-- Find the users who have added more than 1 albums to their wishlist
SELECT `musicmarketplace`.`wishlist`.`userid`, COUNT(`musicmarketplace`.`wishlist`.`albumid`) AS album_count
FROM `musicmarketplace`.`wishlist`
GROUP BY `musicmarketplace`.`wishlist`.`userid`
HAVING album_count >= 1;
