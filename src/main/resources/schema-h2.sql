CREATE TABLE CUENTA (
    id_cuenta BIGINT AUTO_INCREMENT PRIMARY KEY,
    legajo INT AUTO_INCREMENT(127001,1) UNIQUE NOT NULL,
    razon_social VARCHAR(100),
    tipo_documento VARCHAR(50),
    documento VARCHAR(50),
    saldo numeric(10,2),
    moneda VARCHAR(10),
    id_mov BIGINT
    );


CREATE TABLE MOVIMIENTO(
	id_mov BIGINT AUTO_INCREMENT PRIMARY KEY,
	fecha date NOT NULL,
	tipo VARCHAR(15),
	descripcion VARCHAR(200),
	importe numeric(10,2),
	id_cuenta BIGINT
);


alter table CUENTA add constraint FKcaf6ht0hfw93lwc13ny0sdmvo 
foreign key (id_mov) references MOVIMIENTO(id_mov);

alter table MOVIMIENTO add constraint FKcaf6ht0hfw93lwc13ny0sdmvu 
foreign key (id_cuenta) references CUENTA(id_cuenta);