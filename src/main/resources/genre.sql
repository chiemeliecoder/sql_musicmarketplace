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
