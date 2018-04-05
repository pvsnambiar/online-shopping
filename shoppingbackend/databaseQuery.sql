CREATE TABLE CATEGORY(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	imageUrl VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);