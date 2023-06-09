SELECT * FROM musicmarketplace.playlists;
INSERT INTO playlists (id, name, userid) VALUES (1, 'My Favorites', 1);
UPDATE playlists SET name = 'Big Hits' WHERE (id = 1);
DELETE FROM playlists WHERE (id = 1);
-- Right Join
SELECT *
FROM musicmarketplace.playlists
RIGHT JOIN musicmarketplace.tracks ON musicmarketplace.playlists.id = musicmarketplace.tracks.id;

-- Determine the number of playlists created by each user:
SELECT musicmarketplace.playlists.userid, COUNT(musicmarketplace.playlists.id) AS playlist_count
FROM musicmarketplace.playlists
GROUP BY musicmarketplace.playlists.userid;