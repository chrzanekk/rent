INSERT INTO landlords(name) VALUES ('Jan Kowalski');
INSERT INTO landlords(name) VALUES ('Zbigniew Nowak');
INSERT INTO landlords(name) VALUES ('Mateusz Bratek');

INSERT INTO tenants(name) VALUES ('Jakub Zastawski');
INSERT INTO tenants(name) VALUES ('Michał Górski');
INSERT INTO tenants(name) VALUES ('Łukasz Morski');

INSERT INTO rent_objects(NAME, unit_price, AREA, description, landlord_id)
	VALUES ('Obiekt nr 1',
				55.00,
				100.23,
				'Jedno pomieszczenie, jedna łazienka',
				(SELECT id FROM landlords WHERE name = 'Jan Kowalski')
	);
INSERT INTO rent_objects(NAME, unit_price, AREA, description, landlord_id)
	VALUES ('Obiekt nr 2',
				 65.00,
				 122.67,
				 'Jedno pomieszczenie, jedna łazienka',
				 (SELECT id FROM landlords WHERE name = 'Zbigniew Nowak')
	 );
INSERT INTO rent_objects(NAME, unit_price, AREA, description, landlord_id)
	VALUES ('Obiekt nr 3',
				34.00,
				85.00,
				'Jedno pomieszczenie, jedna łazienka',
				(SELECT id FROM landlords WHERE name = 'Mateusz Bratek')
	);
INSERT INTO rent_objects(NAME, unit_price, AREA, description, landlord_id)
	VALUES ('Obiekt nr 4',
				55.00,
				77.00,
				'Jedno pomieszczenie, jedna łazienka, kuchnia',
				(SELECT id FROM landlords WHERE name = 'Jan Kowalski')
	);
INSERT INTO rent_objects(NAME, unit_price, AREA, description, landlord_id)
	VALUES ('Obiekt nr 5',
				91.00,
				135.00,
				'Dwa pomieszczenia, jedna łazienka, kuchnia',
				(SELECT id FROM landlords WHERE name = 'Zbigniew Nowak')
	);
INSERT INTO rent_objects(NAME, unit_price, AREA, description, landlord_id)
	VALUES ('Obiekt nr 6',
				89.00,
				156.00,
				'Trzy pomieszczenia, jedna łazienka, kuchnia',
				(SELECT id FROM landlords WHERE name = 'Mateusz Bratek')
	);



INSERT INTO reservations (rental_start, rental_end, tenant_id, rent_object_id, rental_cost)
	VALUES ('2022-04-11',
				'2022-06-11',
				(SELECT id FROM tenants WHERE name = 'Jakub Zastawski'),
				(SELECT id FROM rent_objects WHERE NAME = 'Obiekt nr 1'),
				 11025.30
	);

INSERT INTO reservations (rental_start, rental_end, tenant_id, rent_object_id, rental_cost)
	VALUES ('2022-03-28',
				'2022-05-28',
				(SELECT id FROM tenants WHERE name = 'Michał Górski'),
				(SELECT id FROM rent_objects WHERE NAME = 'Obiekt nr 2'),
				 15947.10
	);

INSERT INTO reservations (rental_start, rental_end, tenant_id, rent_object_id, rental_cost)
	VALUES ('2022-03-28',
				'2022-06-28',
				(SELECT id FROM tenants WHERE name = 'Łukasz Morski' ),
				(SELECT id FROM rent_objects WHERE NAME = 'Obiekt nr 3'),
				 8670.00
	);

INSERT INTO reservations (rental_start, rental_end, tenant_id, rent_object_id, rental_cost)
	VALUES ('2022-04-01',
				'2022-07-01',
				(SELECT id FROM tenants WHERE name = 'Łukasz Morski'),
				(SELECT id FROM rent_objects WHERE NAME = 'Obiekt nr 4'),
				 12705.00
	);

INSERT INTO reservations (rental_start, rental_end, tenant_id, rent_object_id, rental_cost)
	VALUES ('2022-07-02',
				'2022-10-02',
				(SELECT id FROM tenants WHERE name = 'Michał Górski'),
				(SELECT id FROM rent_objects WHERE NAME = 'Obiekt nr 4'),
				 12705.00
	);

INSERT INTO reservations (rental_start, rental_end, tenant_id, rent_object_id, rental_cost)
	VALUES ('2022-04-01',
				'2022-05-01',
				(SELECT id FROM tenants WHERE name = 'Jakub Zastawski'),
				(SELECT id FROM rent_objects WHERE NAME = 'Obiekt nr 5'),
				 12285.00
	);