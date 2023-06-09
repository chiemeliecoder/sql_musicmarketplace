SELECT * FROM musicmarketplace.artist_achievements;
INSERT INTO artist_achievements (id, artistid, title, date) VALUES (1, 1, 'billbord 100', '2014-10-29');
UPDATE artist_achievements SET title = 'Grammy Award' WHERE (id = 1);


-- Determine the artists who have achieved at least 1 achievement
SELECT musicmarketplace.artists.id, musicmarketplace.artists.name, COUNT(musicmarketplace.artist_achievements.id) AS achievement_count
FROM musicmarketplace.artists
JOIN musicmarketplace.artist_achievements ON musicmarketplace.artists.id = musicmarketplace.artist_achievements.artistid
GROUP BY musicmarketplace.artists.id, musicmarketplace.artists.name
HAVING achievement_count >= 1;