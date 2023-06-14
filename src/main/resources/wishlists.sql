SELECT * FROM musicmarketplace.wishlist;
INSERT INTO wishlist (id, userid, albumid) VALUES (1, 1, 1);
UPDATE wishlist SET albumid = 2 WHERE (id = 1);
DELETE FROM wishlist WHERE (id = 1);

-- Find the users who have added more than 1 album to their wishlist
SELECT musicmarketplace.wishlist.userid, COUNT(musicmarketplace.wishlist.albumid) AS album_count
FROM musicmarketplace.wishlist
GROUP BY musicmarketplace.wishlist.userid
HAVING album_count >= 1;

