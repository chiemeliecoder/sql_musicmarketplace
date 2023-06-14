SELECT * FROM musicmarketplace.playlist_track;
INSERT INTO playlist_track (id, idplaylist, idtrack) VALUES (1, 1, 1);
DELETE FROM playlist_track WHERE (id = 1);

-- Retrieve the playlist with distinct track
SELECT musicmarketplace.playlist_track.id, COUNT(DISTINCT musicmarketplace.playlist_track.idtrack) AS distinct_track_count
FROM musicmarketplace.playlist_track
GROUP BY musicmarketplace.playlist_track.id
HAVING COUNT(DISTINCT musicmarketplace.playlist_track.idtrack) > 0;
