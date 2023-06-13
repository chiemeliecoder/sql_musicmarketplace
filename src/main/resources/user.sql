SELECT * FROM musicmarketplace.user;
INSERT INTO user (id, username, email, password) VALUES (3, 'JaneDoe', 'janedoe@example.com', 'password123');
UPDATE user SET username = 'JaneDoe' WHERE (id = 3);
DELETE FROM user WHERE (id = 3);
ALTER TABLE user ADD COLUMN age INT;
ALTER TABLE user DROP COLUMN age;
SELECT * FROM musicmarketplace.user JOIN musicmarketplace.playlists ON musicmarketplace.user.id = musicmarketplace.playlists.userid
JOIN musicmarketplace.wishlists ON musicmarketplace.user.id = musicmarketplace.wishlists.userid
JOIN musicmarketplace.purchases ON musicmarketplace.user.id = musicmarketplace.purchases.userid
JOIN musicmarketplace.reviews ON musicmarketplace.user.id = musicmarketplace.reviews.userid
JOIN musicmarketplace.tracks ON musicmarketplace.purchases.trackid = musicmarketplace.tracks.id
JOIN musicmarketplace.albums ON musicmarketplace.tracks.albumid = musicmarketplace.albums.id
JOIN musicmarketplace.artists ON musicmarketplace.albums.artistid = musicmarketplace.artists.id
JOIN musicmarketplace.artist_genre ON musicmarketplace.artists.id = musicmarketplace.artist_genre.artistid
JOIN musicmarketplace.genre ON musicmarketplace.artist_genre.genreid = musicmarketplace.genre.id
JOIN musicmarketplace.artist_achievements ON musicmarketplace.artists.id = musicmarketplace.artist_achievements.artistid;
-- Left Join
SELECT *
FROM musicmarketplace.user
LEFT JOIN playlists ON musicmarketplace.user.id= musicmarketplace.playlists.userid;

-- Self Join
SELECT *
FROM musicmarketplace.user u1
JOIN musicmarketplace.user u2 ON u1.id = u2.id;

