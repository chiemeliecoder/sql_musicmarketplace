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

======================================================================================
SELECT * FROM musicmarketplace.user_profile;
INSERT INTO user_profile (id, bio, profileimage, location, user_id) VALUES (1, 'John doe is into pop music', 'https://www.shutterstock.com/image-photo/profile-picture-happy-friendly-young-man-1863570355', 'Oregon',1);
UPDATE user SET location = 'New York' WHERE (id = 2);
DELETE FROM user_profile WHERE (id = 1);

-- Left Join
SELECT *
FROM musicmarketplace.user_profile
LEFT JOIN playlist ON musicmarketplace.user_profile.id= musicmarketplace.playlist.userid;

-- Self Join
SELECT *
FROM musicmarketplace.user_profile u1
JOIN musicmarketplace.user_profile u2 ON u1.id = u2.id;

==========================================================================================
SELECT * FROM musicmarketplace.wishlist;
INSERT INTO wishlist (id, userid, albumid) VALUES (1, 1, 1);
UPDATE wishlist SET albumid = 2 WHERE (id = 1);
DELETE FROM wishlist WHERE (id = 1);

-- Find the users who have added more than 1 album to their wishlist
SELECT musicmarketplace.wishlist.userid, COUNT(musicmarketplace.wishlist.albumid) AS album_count
FROM musicmarketplace.wishlist
GROUP BY musicmarketplace.wishlist.userid
HAVING album_count >= 1;
==========================================================================================
SELECT * FROM musicmarketplace.track;
INSERT INTO track (id, title, duration, albumid) VALUES (1, 'Shake It Off', '00:03:39', 1);
UPDATE track SET title = 'Love Story', duration = '00:03:55' WHERE (id = 1);
DELETE FROM track WHERE (id = 1);
ALTER TABLE track ADD COLUMN is_featured BOOLEAN DEFAULT false;
ALTER TABLE track DROP COLUMN is_featured;

-- Count the number of track in each album
SELECT musicmarketplace.album.id, musicmarketplace.album.title, COUNT(musicmarketplace.track.id) AS num_tracks
FROM musicmarketplace.album
JOIN musicmarketplace.track ON musicmarketplace.album.id = musicmarketplace.track.id
GROUP BY musicmarketplace.album.id;

-- Calculate the total duration of track for each artist
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, SEC_TO_TIME(SUM(TIME_TO_SEC(musicmarketplace.track.duration))) AS total_duration
FROM musicmarketplace.artists
JOIN musicmarketplace.album ON musicmarketplace.artists.id = musicmarketplace.album.artistid
JOIN musicmarketplace.track ON musicmarketplace.album.id = musicmarketplace.track.albumid
GROUP BY musicmarketplace.artists.id, musicmarketplace.artists.name;


-- Determine the playlist(s) with a track duration exceeding 4 minutes:
SELECT musicmarketplace.playlist_track.id, SEC_TO_TIME(SUM(TIME_TO_SEC(musicmarketplace.track.duration))) AS total_duration
FROM musicmarketplace.playlist_track
JOIN musicmarketplace.track ON musicmarketplace.playlist_track.idtrack = musicmarketplace.track.id
GROUP BY musicmarketplace.playlist_track.id
HAVING SEC_TO_TIME(SUM(TIME_TO_SEC(musicmarketplace.track.duration))) > TIME ('00:04:00');
===================================================================================================
SELECT * FROM musicmarketplace.album;
INSERT INTO album (id, title, date, artistid) VALUES (1, '1989', '2014-10-27', 1);
UPDATE album SET title = 'Red', date = '2012-10-22' WHERE (id = 1);
DELETE FROM album WHERE (id = 1);
ALTER TABLE album MODIFY COLUMN title VARCHAR(100);
ALTER TABLE album MODIFY COLUMN title VARCHAR(255);
-- Inner Join
SELECT *
FROM musicmarketplace.album
INNER JOIN musicmarketplace.artists ON musicmarketplace.album.artistid = musicmarketplace.artists.id;

-- Find the earliest release date for each artist
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, MIN(musicmarketplace.album.date) AS earliest_release_date
FROM musicmarketplace.artists
JOIN musicmarketplace.album ON  musicmarketplace.artists.id = musicmarketplace.album.id
GROUP BY musicmarketplace.artists.id;

-- Find artists who have released 1 album
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, COUNT(musicmarketplace.album.id) AS num_albums
FROM musicmarketplace.artists
JOIN musicmarketplace.album ON musicmarketplace.artists.id = musicmarketplace.album.id
GROUP BY musicmarketplace.artists.id
HAVING COUNT(musicmarketplace.album.id) >= 1;
================================================================================================
SELECT * FROM musicmarketplace.artist_achievements;
INSERT INTO artist_achievements (id, artistid, title, date) VALUES (1, 1, 'billbord 100', '2014-10-29');
UPDATE artist_achievements SET title = 'Grammy Award' WHERE (id = 1);


-- Determine the artists who have achieved at least 1 achievement
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, COUNT(musicmarketplace.artist_achievements.id) AS achievement_count
FROM musicmarketplace.artists
JOIN musicmarketplace.artist_achievements ON musicmarketplace.artists.id = musicmarketplace.artist_achievements.artistid
GROUP BY musicmarketplace.artists.id, musicmarketplace.artists.name
HAVING achievement_count >= 1;
================================================================================================
SELECT * FROM musicmarketplace.artist_genre;
INSERT INTO artist_genre (id, artistid, genreid) VALUES (1, 1, 1);
DELETE FROM artist_genre WHERE (id = 1);
ALTER TABLE artistgenre RENAME TO Artist_MusicGenre;

SELECT * 
FROM artist_genre
JOIN artists ON artist_genre.artistid = artists.id
JOIN genre ON artist_genre.genreid = genre.id;
================================================================================================
SELECT * FROM musicmarketplace.artists;
INSERT INTO artists (id, name) VALUES (1, 'Taylor Swift');
UPDATE artists SET name = 'Alison Swift' WHERE (id = 1);
DELETE FROM artists WHERE (id = 1);

-- Outer Join
SELECT *
FROM musicmarketplace.artists
LEFT OUTER JOIN musicmarketplace.artist_genre ON musicmarketplace.artists.id = musicmarketplace.artist_genre.artistid;
===============================================================================================
SELECT * FROM musicmarketplace.genre;
INSERT INTO genre (id, name) VALUES (1, 'Pop');
UPDATE genre SET name = 'Pop/Rock' WHERE (id = 1);
DELETE FROM genre WHERE (id = 1);
ALTER TABLE genre DROP COLUMN name;
ALTER TABLE genre ADD COLUMN name VARCHAR(255);

-- Find the total number of track in each genre
SELECT musicmarketplace.genre.id, musicmarketplace.genre.name, COUNT(musicmarketplace.track.id) AS track_count
FROM musicmarketplace.genre
LEFT JOIN musicmarketplace.artist_genre ON musicmarketplace.genre.id = musicmarketplace.artist_genre.genreid
LEFT JOIN musicmarketplace.artists ON musicmarketplace.artist_genre.artistid = musicmarketplace.artists.id
LEFT JOIN musicmarketplace.album ON musicmarketplace.artists.id = musicmarketplace.album.id
LEFT JOIN musicmarketplace.track ON musicmarketplace.album.id = musicmarketplace.track.albumid
GROUP BY musicmarketplace.genre.id, musicmarketplace.genre.name;
===============================================================================================
SELECT * FROM musicmarketplace.playlist_track;
INSERT INTO playlist_track (id, idplaylist, idtrack) VALUES (1, 1, 1);
DELETE FROM playlist_track WHERE (id = 1);

-- Retrieve the playlist with distinct track
SELECT musicmarketplace.playlist_track.id, COUNT(DISTINCT musicmarketplace.playlist_track.idtrack) AS distinct_track_count
FROM musicmarketplace.playlist_track
GROUP BY musicmarketplace.playlist_track.id
HAVING COUNT(DISTINCT musicmarketplace.playlist_track.idtrack) > 0;
================================================================================================
SELECT * FROM musicmarketplace.playlist;
INSERT INTO playlist (id, name, userid) VALUES (1, 'My Favorites', 1);
UPDATE playlist SET name = 'Big Hits' WHERE (id = 1);
DELETE FROM playlist WHERE (id = 1);
-- Right Join
SELECT *
FROM musicmarketplace.playlist
RIGHT JOIN musicmarketplace.track ON musicmarketplace.playlist.id = musicmarketplace.track.id;

-- Determine the number of playlist created by each user:
SELECT musicmarketplace.playlist.userid, COUNT(musicmarketplace.playlist.id) AS playlist_count
FROM musicmarketplace.playlist
GROUP BY musicmarketplace.playlist.userid;
================================================================================================
SELECT * FROM musicmarketplace.purchase;
INSERT INTO purchase (id, userid, trackid, date, price) VALUES (1, 1, 1, '2023-05-25', 9.99);
UPDATE purchase SET price = 7.99 WHERE (id = 1);
DELETE FROM purchase WHERE (id = 1);

-- Calculate the total price of purchase for each user
SELECT userid, SUM(musicmarketplace.purchase.price) AS total_price
FROM musicmarketplace.purchase
GROUP BY musicmarketplace.purchase.userid;

-- Find users who have made at most 3 purchase with a total price less than $100
SELECT musicmarketplace.purchase.userid, COUNT(musicmarketplace.purchase.id) AS num_purchases, SUM(musicmarketplace.purchase.price) AS total_price
FROM musicmarketplace.purchase
GROUP BY musicmarketplace.purchase.userid
HAVING COUNT(musicmarketplace.purchase.id) <= 3 AND SUM(musicmarketplace.purchase.price) < 100;
================================================================================================
SELECT * FROM musicmarketplace.review;
INSERT INTO review (id, userid, albumid, rating, comment) VALUES (1, 1, 1, 5.0, 'Great album!');
UPDATE review SET rating = 4.0 WHERE (id = 1);
DELETE FROM review WHERE (id = 1);

-- Find genres with an average rating greater than 3.5
SELECT musicmarketplace.genre.id, musicmarketplace.genre.name, AVG(musicmarketplace.review.rating) AS avg_rating
FROM musicmarketplace.genre
JOIN musicmarketplace.artist_genre ON musicmarketplace.genre.id = musicmarketplace.artist_genre.genreid
JOIN musicmarketplace.artists ON musicmarketplace.artist_genre.artistid = musicmarketplace.artists.id
JOIN musicmarketplace.album ON musicmarketplace.artists.id = musicmarketplace.album.artistid
JOIN musicmarketplace.review ON musicmarketplace.album.id = musicmarketplace.review.albumid
GROUP BY musicmarketplace.genre.id, musicmarketplace.genre.name
HAVING AVG(musicmarketplace.review.rating) > 3.5;

-- Calculate the highest and lowest rating for each album
SELECT musicmarketplace.review.albumid, MAX(musicmarketplace.review.rating) AS highest_rating, MIN(musicmarketplace.review.rating) AS lowest_rating
FROM musicmarketplace.review
GROUP BY musicmarketplace.review.albumid;
