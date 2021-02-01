CREATE TABLE comex_port_db.register (
	id int unsigned NOT NULL AUTO_INCREMENT,
	name VARCHAR(80),
	email VARCHAR(80),
	date_of_birth datetime,
	UNIQUE KEY `id` (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;
