INSERT INTO Place_Info (place_id, population, carbon, percapcarb, popdensity, point_x, point_y) VALUES (0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0),
	    (1, .95, 2.0, 3.0, 4.0, 5.0, 6.0),
		(2, 1.25, 2.0, 3.0, 4.0, 5.0, 6.0),
		(3, 1.0, 2.0, 3.0, 3.8, 5.0, 6.0),
		(4, 1.0, 2.0, 3.0, 5.01, 5.0, 6.0),
    	(5, .94, 2.0, 3.0, 4.0, 5.0, 6.0),
    	(6, 1.26, 2.0, 3.0, 4.0,  5.0, 6.0),
    	(7, 1.0, 2.0, 3.0, 3.79,  5.0, 6.0),
    	(8, 1.0, 2.0, 3.0, 5.01, 5.0, 6.0);
    	
INSERT INTO NAME (name_id, name) VALUES
(1, 'Manchester'),
(2, 'Manila'),
(3, 'New Zealand'),
(4, 'New Hampshire'),
(5, 'Boston'),
(6, 'India');

INSERT INTO NAME_PLACE (name_id, place_id) VALUES
(1, 1),
(1, 2),
(3, 4),
(4, 3),
(5, 3),
(6, 5),
(2,7);