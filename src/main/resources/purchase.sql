SELECT * FROM musicmarketplace.purchase;
INSERT INTO `purchase` (`id`, `userid`, `trackid`, `date`, `price`) VALUES (1, 1, 1, '2023-05-25', 9.99);
UPDATE`purchase` SET `price` = 7.99 WHERE (`id` = 1);
DELETE FROM `purchase` WHERE (`id` = 1);

-- Calculate the total price of purchases for each user
SELECT `userid`, SUM(`musicmarketplace`.`purchase`.`price`) AS total_price
FROM `musicmarketplace`.`purchase`
GROUP BY `musicmarketplace`.`purchase`.`userid`;

-- Find users who have made at most 2 purchases with a total price less than $100
SELECT `musicmarketplace`.`purchase`.`userid`, COUNT(`musicmarketplace`.`purchase`.`id`) AS num_purchases, SUM(`musicmarketplace`.`purchase`.`price`) AS total_price
FROM `musicmarketplace`.`purchase`
GROUP BY `musicmarketplace`.`purchase`.`userid`
HAVING COUNT(`musicmarketplace`.`purchase`.`id`) <= 3 AND SUM(`musicmarketplace`.`purchase`.`price`) < 100;