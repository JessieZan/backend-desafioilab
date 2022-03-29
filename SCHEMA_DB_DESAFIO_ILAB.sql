drop database if exists telemetria_entregadores_ifood;
create database telemetria_entregadores_ifood;

drop table if exists rastreamento_pedido, pedido, entregador, cliente;

create table cliente(
  id serial not null primary key,
  nome varchar(50) not null unique,
  senha text not null
);

insert into cliente (nome, senha) values ('Fulano', 'senhaqualquer');
insert into cliente (nome, senha) values ('Ciclano', 'senhaqualquer');
insert into cliente (nome, senha) values ('Belcrano', 'senhaqualquer');

create table entregador(
  id serial not null primary key,
  nome varchar(50) not null,
  email varchar(50) not null unique,
  telefone varchar(12) not null unique,
  senha text not null,
  em_entrega boolean default false
);

insert into entregador (nome, email, telefone, senha) values ('Fakeson','fakeson@email.com','71023456789', 'senhaqualquer');
insert into entregador (nome, email, telefone, senha) values ('Italo_Costa','italo@email.com','71123456789', 'senhaqualquer');
insert into entregador (nome, email, telefone, senha) values ('Jessica_Vargas','jessica@email.com','21123456789', 'senhaqualquer');
insert into entregador (nome,email, telefone,  senha) values ('Julio_Neto','julio@email.com','71987654321', 'senhaqualquer');
insert into entregador (nome,email, telefone,  senha) values ('Bruno','bruno@email.com','11987654321', 'senhaqualquer');
insert into entregador (nome,email, telefone,  senha) values ('Gabrielli_Borges','borges@email.com','12987654321', 'senhaqualquer');

create table pedido(
  id serial not null primary key,
  data_criacao timestamp default current_timestamp,
  valor_total integer not null,
  status varchar(12) not null default 'em_aberto',
  endereco_entrega text not null,
  id_entregador integer default 1,
  id_cliente integer not null,
  constraint fk_cliente foreign key (id_cliente) references cliente(id),
  constraint fk_entregador foreign key (id_entregador) references entregador(id)
);

insert into pedido (valor_total, id_cliente, endereco_entrega) values (23000,1, 'rua da pamonha ,116, brotas, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (29000,2, 'rua das margaridas ,117, jardim das margaridas, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (33000,3, 'rua do teste ,118, calebetão, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (53000,1, 'rua da serenidade ,119, bairro da paz, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (23000,2, 'rua dos coqueiros ,120, brotas, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (72000,3, 'rua da sardinha ,116, centro, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (27000,1, '2 de julho ,121, centro, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (25000,2, 'Avenida 7 ,122, centro, salvador-BA');
insert into pedido (valor_total, id_cliente, endereco_entrega) values (23000,3, 'rua dos queridos ,116, federação, salvador-BA');

create table rastreamento_pedido(
  id serial not null primary key,
  id_entregador integer not null,
  id_pedido integer not null,
  timestamp_vinculado timestamp default current_timestamp,
  coordenadas text not null,
  constraint fk_pedido foreign key (id_pedido) references pedido(id),
  constraint fk_entregador foreign key (id_entregador) references entregador(id)
);
        
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (1, 3, '@-12.9873645,-38.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (2, 2, '@-12.9873645,-38.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (3, 1, '@-12.9873645,-38.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (4, 1, '@-13.4573645,-45.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (5, 3, '@-13.3373645,-43.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (1, 2, '@-13.0273645,-40.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (2, 1, '@-12.9993645,-41.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (3, 3, '@-12.9899645,-37.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (4, 2, '@-12.9873645,-40.5187074');
insert into "rastreamento_pedido" ("id_entregador", "id_pedido", "coordenadas") values (5, 1, '@-12.9853645,-38.5147074');