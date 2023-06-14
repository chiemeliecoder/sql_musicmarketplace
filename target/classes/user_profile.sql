SELECT * FROM musicmarketplace.user_profile;
INSERT INTO user_profile (id, bio, profileimage, location, user_id) VALUES (1, 'John doe is into pop music', 'https://www.shutterstock.com/image-photo/profile-picture-happy-friendly-young-man-1863570355', 'Oregon',1);
UPDATE user SET location = 'New York' WHERE (id = 2);
DELETE FROM user_profile WHERE (id = 1);

-- Left Join
SELECT *
FROM musicmarketplace.user_profile
LEFT JOIN playlist ON musicmarketplace.user_profile.id= musicmarketplace.playlist.userid;

-- Self Join
SELECT *
FROM musicmarketplace.user_profile u1
JOIN musicmarketplace.user_profile u2 ON u1.id = u2.id;