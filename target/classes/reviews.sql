SELECT * FROM musicmarketplace.reviews;
INSERT INTO reviews (id, userid, albumid, rating, comment) VALUES (1, 1, 1, 5.0, 'Great album!');
UPDATE reviews SET rating = 4.0 WHERE (id = 1);
DELETE FROM reviews WHERE (id = 1);

-- Find genres with an average rating greater than 3.5
SELECT musicmarketplace.genre.id, musicmarketplace.genre.name, AVG(musicmarketplace.reviews.rating) AS avg_rating
FROM musicmarketplace.genre
JOIN musicmarketplace.artist_genre ON musicmarketplace.genre.id = musicmarketplace.artist_genre.genreid
JOIN musicmarketplace.artists ON musicmarketplace.artist_genre.artistid = musicmarketplace.artists.id
JOIN musicmarketplace.albums ON musicmarketplace.artists.id = musicmarketplace.albums.artistid
JOIN musicmarketplace.reviews ON musicmarketplace.albums.id = musicmarketplace.reviews.albumid
GROUP BY musicmarketplace.genre.id, musicmarketplace.genre.name
HAVING AVG(musicmarketplace.reviews.rating) > 3.5;

-- Calculate the highest and lowest rating for each album
SELECT musicmarketplace.reviews.albumid, MAX(musicmarketplace.reviews.rating) AS highest_rating, MIN(musicmarketplace.reviews.rating) AS lowest_rating
FROM musicmarketplace.reviews
GROUP BY musicmarketplace.reviews.albumid;