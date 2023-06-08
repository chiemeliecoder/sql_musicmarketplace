SELECT * FROM musicmarketplace.wishlists;
INSERT INTO wishlists (id, userid, albumid) VALUES (1, 1, 1);
UPDATE wishlists SET albumid = 2 WHERE (id = 1);
DELETE FROM wishlists WHERE (id = 1);

-- Find the users who have added more than 1 albums to their wishlist
SELECT musicmarketplace.wishlists.userid, COUNT(musicmarketplace.wishlists.albumid) AS album_count
FROM musicmarketplace.wishlists
GROUP BY musicmarketplace.wishlists.userid
HAVING album_count >= 1;

