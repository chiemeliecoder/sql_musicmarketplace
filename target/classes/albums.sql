SELECT * FROM musicmarketplace.album;
INSERT INTO album (id, title, date, artistid) VALUES (1, '1989', '2014-10-27', 1);
UPDATE album SET title = 'Red', date = '2012-10-22' WHERE (id = 1);
DELETE FROM album WHERE (id = 1);
ALTER TABLE album MODIFY COLUMN title VARCHAR(100);
ALTER TABLE album MODIFY COLUMN title VARCHAR(255);
-- Inner Join
SELECT *
FROM musicmarketplace.album
INNER JOIN musicmarketplace.artists ON musicmarketplace.album.artistid = musicmarketplace.artists.id;

-- Find the earliest release date for each artist
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, MIN(musicmarketplace.album.date) AS earliest_release_date
FROM musicmarketplace.artists
JOIN musicmarketplace.album ON  musicmarketplace.artists.id = musicmarketplace.album.id
GROUP BY musicmarketplace.artists.id;

-- Find artists who have released 1 album
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, COUNT(musicmarketplace.album.id) AS num_albums
FROM musicmarketplace.artists
JOIN musicmarketplace.album ON musicmarketplace.artists.id = musicmarketplace.album.id
GROUP BY musicmarketplace.artists.id
HAVING COUNT(musicmarketplace.album.id) >= 1;