SELECT * FROM musicmarketplace.albums;
INSERT INTO albums (id, title, date, artistid) VALUES (1, '1989', '2014-10-27', 1);
UPDATE albums SET title = 'Red', date = '2012-10-22' WHERE (id = 1);
DELETE FROM albums WHERE (id = 1);
ALTER TABLE albums MODIFY COLUMN title VARCHAR(100);
ALTER TABLE albums MODIFY COLUMN title VARCHAR(255);
-- Inner Join
SELECT *
FROM musicmarketplace.albums
INNER JOIN musicmarketplace.artists ON musicmarketplace.albums.artistid = musicmarketplace.artists.id;

-- Find the earliest release date for each artist
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, MIN(musicmarketplace.albums.date) AS earliest_release_date
FROM musicmarketplace.artists
JOIN musicmarketplace.albums ON  musicmarketplace.artists.id = musicmarketplace.albums.id
GROUP BY musicmarketplace.artists.id;

-- Find artists who have released 1 album
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, COUNT(musicmarketplace.albums.id) AS num_albums
FROM musicmarketplace.artists
JOIN musicmarketplace.albums ON musicmarketplace.artists.id = musicmarketplace.albums.id
GROUP BY musicmarketplace.artists.id
HAVING COUNT(musicmarketplace.albums.id) >= 1;