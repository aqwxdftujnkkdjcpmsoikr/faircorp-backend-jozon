INSERT INTO BUILDING(id, name, outside_temperature) VALUES(1, 'Home', 12);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(1, 'Entrance', 0, 21.0, 21.5, 1);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(2, 'Bedroom1', 1, 22.0, 19.5, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(3, 'SampleShortRoom', 1, 1);

INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(1, 'ON', 'HeaterEntrance', 1030, 1);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(2, 'ON', 'HeaterNull', null, 3);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(1, 'CLOSED', 'Window E:1', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(2, 'CLOSED', 'Window E:2', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(3, 'OPEN', 'Window R1:1', 2);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(4, 'CLOSED', 'Window SSR:2', 3);