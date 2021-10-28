-- INSERT INTO RESTAURANT
INSERT INTO `booking_restaurant`.`restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES 
('1', 'Burguer Hulk', 'Todo tipo de hamburguesas', 'Calle Puig 4', 'https://i.pinimg.com/originals/b4/25/52/b4255218c9d48caa4b559084665a9e2c.jpg');

INSERT INTO `booking_restaurant`.`restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES 
('2', 'KFC', 'TVenta de los mejores pollos', 'Calle Galindo 5', 'https://laopinion.com/wp-content/uploads/sites/3/2019/12/kfc-abrir-tienda.jpg?quality=80&strip=all&w=1200');

INSERT INTO `booking_restaurant`.`restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES 
('3', 'El Lote Malo', 'La Mexicana más rica', 'Calle De Goya 210', 'https://www.sillasmesas.es/blog/wp-content/uploads/2019/07/decoracion-de-restaurantes-mexicanos-sillas.jpg');

-- INSERT INTO TURN
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (1, 'TURNO_10_00', 1);
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (2, 'TURNO_11_00', 1);
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (3, 'TURNO_12_00', 1);
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (4, 'TURNO_13_00', 1);

INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (5, 'TURNO_10_00', 2);
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (6, 'TURNO_11_00', 2);
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (7, 'TURNO_12_00', 2);
INSERT INTO `booking_restaurant`.`TURN` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES (8, 'TURNO_13_00', 2);

-- INSERT INTO BOARD
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (1, 3, 1, 1);
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (2, 6, 2, 1);
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (3, 2, 3, 1);
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (4, 5, 4, 1);

INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (5, 4, 1, 2);
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (6, 6, 2, 2);
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (7, 4, 3, 2);
INSERT INTO `booking_restaurant`.`BOARD` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES (8, 8, 4, 2);

-- INSERT INTO RESERVATION
INSERT INTO `booking_restaurant`.`RESERVATION` (`ID`, `LOCATOR`, `PERSON`, `DATE`, `TURN`, `RESTAURANT_ID`) VALUES (1, 'Burguer Hulk 6', 6, '2021-08-07', 'TURNO_10_00', 1);
INSERT INTO `booking_restaurant`.`RESERVATION` (`ID`, `LOCATOR`, `PERSON`, `DATE`, `TURN`, `RESTAURANT_ID`) VALUES (2, 'KFC 5', '5', '2022-05-31', 'TURNO_13_00', 2);




