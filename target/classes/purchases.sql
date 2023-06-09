SELECT * FROM musicmarketplace.purchases;
INSERT INTO purchases (id, userid, trackid, date, price) VALUES (1, 1, 1, '2023-05-25', 9.99);
UPDATE purchases SET price = 7.99 WHERE (id = 1);
DELETE FROM purchases WHERE (id = 1);

-- Calculate the total price of purchases for each user
SELECT userid, SUM(musicmarketplace.purchases.price) AS total_price
FROM musicmarketplace.purchases
GROUP BY musicmarketplace.purchases.userid;

-- Find users who have made at most 3 purchases with a total price less than $100
SELECT musicmarketplace.purchases.userid, COUNT(musicmarketplace.purchases.id) AS num_purchases, SUM(musicmarketplace.purchases.price) AS total_price
FROM musicmarketplace.purchases
GROUP BY musicmarketplace.purchases.userid
HAVING COUNT(musicmarketplace.purchases.id) <= 3 AND SUM(musicmarketplace.purchases.price) < 100;