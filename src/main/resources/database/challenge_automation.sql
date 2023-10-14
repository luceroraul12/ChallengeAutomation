-- crear database
create database Test;
-- crear tablas
create table tipo_producto(
	id serial primary key,
	descripcion varchar not null unique
);

create table producto(
	id serial primary key,
	id_tipo_producto int not null,
	nombre varchar not null,
	precio float8 not null default 0.0,
	constraint producto_tipo_producto_fk foreign key(id_tipo_producto) references tipo_producto(id)
		on delete cascade,
	constraint producto_unico unique(id_tipo_producto, nombre)	
);

create table stock(
	id serial primary key,
	id_producto int not null,
	cantidad int not null default 0,
	constraint stock_producto_fk foreign key(id_producto) references producto(id)
);

-- Delego la actividad de crear la instancia de stock a la base de datos
create or replace function fn_producto_nuevo_stock()
	returns trigger 
	language plpgsql
as $$
begin 
	insert into stock (id_producto) values (new.id);
	return new;
end
$$;

create or replace trigger producto_nuevo_stock_tr
	after insert 
		on producto
	for each row
	execute procedure fn_producto_nuevo_stock();

---- View de stock
create view vw_stock_producto as 
	select 
		p.nombre as nombre_producto, 
		p.precio as precio_producto, 
		s.cantidad as cantidad_producto
		from producto p 
		inner join stock s on s.id_producto = p.id;
	
---- Data inicial
---- Agrego tipos de producto iniciales
insert into tipo_producto (descripcion) values
	('Combustible'),
	('Herramientas'),
	('Materia Prima');

---- Agrego productos iniciales
do $$
	declare tipoCombustible 	int = (select id from tipo_producto where descripcion = 'Combustible');
	declare tipoHerramientas 	int = (select id from tipo_producto where descripcion = 'Herramientas');
	declare tipoMateriaPrima 	int = (select id from tipo_producto where descripcion = 'Materia Prima');
begin 
	insert into producto (id_tipo_producto, nombre, precio) values
		(tipoCombustible, 	'Nafta clasica', 	999.0),
		(tipoCombustible, 	'Nafta super', 		1500),
		(tipoHerramientas, 	'Amoladora', 		7500),
		(tipoHerramientas,	'Taladro', 			9500.75),
		(tipoMateriaPrima, 	'Madera', 			3200),
		(tipoMateriaPrima, 	'Pegamento', 		1000.99);
end $$



