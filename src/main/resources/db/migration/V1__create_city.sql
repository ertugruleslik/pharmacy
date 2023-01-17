create sequence seq_city_id 
increment by 1 
start 1;

CREATE TABLE public.city (
	id int8 NOT NULL,
	name varchar NOT NULL,
	CONSTRAINT city_name_unique UNIQUE (name),
	CONSTRAINT city_pk PRIMARY KEY (id)
);