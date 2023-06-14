SELECT * FROM musicmarketplace.review;
INSERT INTO review (id, userid, albumid, rating, comment) VALUES (1, 1, 1, 5.0, 'Great album!');
UPDATE review SET rating = 4.0 WHERE (id = 1);
DELETE FROM review WHERE (id = 1);

-- Find genres with an average rating greater than 3.5
SELECT musicmarketplace.genre.id, musicmarketplace.genre.name, AVG(musicmarketplace.review.rating) AS avg_rating
FROM musicmarketplace.genre
JOIN musicmarketplace.artist_genre ON musicmarketplace.genre.id = musicmarketplace.artist_genre.genreid
JOIN musicmarketplace.artists ON musicmarketplace.artist_genre.artistid = musicmarketplace.artists.id
JOIN musicmarketplace.album ON musicmarketplace.artists.id = musicmarketplace.album.artistid
JOIN musicmarketplace.review ON musicmarketplace.album.id = musicmarketplace.review.albumid
GROUP BY musicmarketplace.genre.id, musicmarketplace.genre.name
HAVING AVG(musicmarketplace.review.rating) > 3.5;

-- Calculate the highest and lowest rating for each album
SELECT musicmarketplace.review.albumid, MAX(musicmarketplace.review.rating) AS highest_rating, MIN(musicmarketplace.review.rating) AS lowest_rating
FROM musicmarketplace.review
GROUP BY musicmarketplace.review.albumid;