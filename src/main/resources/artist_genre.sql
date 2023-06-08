SELECT * FROM musicmarketplace.artist_genre;
INSERT INTO artist_genre (id, artistid, genreid) VALUES (1, 1, 1);
DELETE FROM artist_genre WHERE (id = 1);
ALTER TABLE artistgenre RENAME TO Artist_MusicGenre;

SELECT * 
FROM artist_genre
JOIN artists ON artist_genre.artistid = artists.id
JOIN genre ON artist_genre.genreid = genre.id;