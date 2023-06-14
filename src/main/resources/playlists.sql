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