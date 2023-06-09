SELECT * FROM musicmarketplace.tracks;
INSERT INTO tracks (id, title, duration, albumid) VALUES (1, 'Shake It Off', '00:03:39', 1);
UPDATE tracks SET title = 'Love Story', duration = '00:03:55' WHERE (id = 1);
DELETE FROM tracks WHERE (id = 1);
ALTER TABLE tracks ADD COLUMN is_featured BOOLEAN DEFAULT false;
ALTER TABLE tracks DROP COLUMN is_featured;

-- Count the number of tracks in each album
SELECT musicmarketplace.albums.id, musicmarketplace.albums.title, COUNT(musicmarketplace.tracks.id) AS num_tracks
FROM musicmarketplace.albums
JOIN musicmarketplace.tracks ON musicmarketplace.albums.id = musicmarketplace.tracks.id
GROUP BY musicmarketplace.albums.id;

-- Calculate the total duration of tracks for each artist
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, SEC_TO_TIME(SUM(TIME_TO_SEC(musicmarketplace.tracks.duration))) AS total_duration
FROM musicmarketplace.artists
JOIN musicmarketplace.albums ON musicmarketplace.artists.id = musicmarketplace.albums.artistid
JOIN musicmarketplace.tracks ON musicmarketplace.albums.id = musicmarketplace.tracks.albumid
GROUP BY musicmarketplace.artists.id, musicmarketplace.artists.name;


-- Determine the playlist(s) with a track duration exceeding 4 minutes:
SELECT musicmarketplace.playlist_track.id, SEC_TO_TIME(SUM(TIME_TO_SEC(musicmarketplace.tracks.duration))) AS total_duration
FROM musicmarketplace.playlist_track
JOIN musicmarketplace.tracks ON musicmarketplace.playlist_track.idtrack = musicmarketplace.tracks.id
GROUP BY musicmarketplace.playlist_track.id
HAVING SEC_TO_TIME(SUM(TIME_TO_SEC(musicmarketplace.tracks.duration))) > TIME ('00:04:00');

