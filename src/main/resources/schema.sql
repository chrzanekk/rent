CREATE TABLE landlords(
	id INT AUTO_INCREMENT,
	first_name VARCHAR(15) NOT NULL,
	second_name VARCHAR(50) NOT NULL,
	create_date datetime default now(),
	modify_date datetime,
	remove_date datetime,
	PRIMARY KEY (id)
);

CREATE TABLE tenants(
	id INT AUTO_INCREMENT,
	first_name VARCHAR(15) NOT NULL,
	second_name VARCHAR(50) NOT NULL,
	create_date datetime default now(),
	modify_date datetime,
	remove_date datetime,
	PRIMARY KEY(id)
);


CREATE TABLE rent_objects (
	id INT AUTO_INCREMENT,
	NAME VARCHAR(100) NOT NULL,
	unit_price DECIMAL(10,2) NOT NULL,
	AREA FLOAT(10) NOT NULL,
	description VARCHAR(1000),
	landlord_id INT NOT NULL,
	create_date DATETIME default now(),
	modify_date DATETIME,
	remove_date DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY (landlord_id) REFERENCES landlords(id)
);

CREATE TABLE reservations(
	id INT AUTO_INCREMENT,
	rental_start DATE NOT NULL,
	rental_end DATE NOT NULL,
	tenant_id INT NOT NULL,
	rent_object_id INT NOT NULL,
	rental_cost DECIMAL(10,2) NOT NULL,
	create_date DATETIME default now(),
	modify_date DATETIME,
	remove_date DATETIME,
	PRIMARY KEY (id),
	FOREIGN KEY (tenant_id) REFERENCES tenants(id),
	FOREIGN KEY (rent_object_id) REFERENCES rent_objects(id)
);