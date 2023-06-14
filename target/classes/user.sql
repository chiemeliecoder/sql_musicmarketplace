SELECT * FROM musicmarketplace.user;
INSERT INTO user (id, username, email, password) VALUES (3, 'JaneDoe', 'janedoe@example.com', 'password123');
UPDATE user SET username = 'JaneDoe' WHERE (id = 3);
DELETE FROM user WHERE (id = 3);
ALTER TABLE user ADD COLUMN age INT;
ALTER TABLE user DROP COLUMN age;
SELECT * FROM musicmarketplace.user JOIN musicmarketplace.playlist ON musicmarketplace.user.id = musicmarketplace.playlist.userid
JOIN musicmarketplace.wishlist ON musicmarketplace.user.id = musicmarketplace.wishlist.userid
JOIN musicmarketplace.purchase ON musicmarketplace.user.id = musicmarketplace.purchase.userid
JOIN musicmarketplace.review ON musicmarketplace.user.id = musicmarketplace.review.userid
JOIN musicmarketplace.track ON musicmarketplace.purchase.trackid = musicmarketplace.track.id
JOIN musicmarketplace.album ON musicmarketplace.track.albumid = musicmarketplace.album.id
JOIN musicmarketplace.artists ON musicmarketplace.album.artistid = musicmarketplace.artists.id
JOIN musicmarketplace.artist_genre ON musicmarketplace.artists.id = musicmarketplace.artist_genre.artistid
JOIN musicmarketplace.genre ON musicmarketplace.artist_genre.genreid = musicmarketplace.genre.id
JOIN musicmarketplace.artist_achievements ON musicmarketplace.artists.id = musicmarketplace.artist_achievements.artistid;
-- Left Join
SELECT *
FROM musicmarketplace.user
LEFT JOIN playlist ON musicmarketplace.user.id= musicmarketplace.playlist.userid;

-- Self Join
SELECT *
FROM musicmarketplace.user u1
JOIN musicmarketplace.user u2 ON u1.id = u2.id;

