SELECT * FROM musicmarketplace.artists;
INSERT INTO artists (id, name) VALUES (1, 'Taylor Swift');
UPDATE artists SET name = 'Alison Swift' WHERE (id = 1);
DELETE FROM artists WHERE (id = 1);

-- Outer Join
SELECT *
FROM musicmarketplace.artists
LEFT OUTER JOIN musicmarketplace.artist_genre ON musicmarketplace.artists.id = musicmarketplace.artist_genre.artistid;