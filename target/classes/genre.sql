SELECT * FROM musicmarketplace.genre;
INSERT INTO genre (id, name) VALUES (1, 'Pop');
UPDATE genre SET name = 'Pop/Rock' WHERE (id = 1);
DELETE FROM genre WHERE (id = 1);
ALTER TABLE genre DROP COLUMN name;
ALTER TABLE genre ADD COLUMN name VARCHAR(255);

-- Find the total number of tracks in each genre
SELECT musicmarketplace.genre.id, musicmarketplace.genre.name, COUNT(musicmarketplace.tracks.id) AS track_count
FROM musicmarketplace.genre
LEFT JOIN musicmarketplace.artist_genre ON musicmarketplace.genre.id = musicmarketplace.artist_genre.genreid
LEFT JOIN musicmarketplace.artists ON musicmarketplace.artist_genre.artistid = musicmarketplace.artists.id
LEFT JOIN musicmarketplace.albums ON musicmarketplace.artists.id = musicmarketplace.albums.id
LEFT JOIN musicmarketplace.tracks ON musicmarketplace.albums.id = musicmarketplace.tracks.albumid
GROUP BY musicmarketplace.genre.id, musicmarketplace.genre.name;
