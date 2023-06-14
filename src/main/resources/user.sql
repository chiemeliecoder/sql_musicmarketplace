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

