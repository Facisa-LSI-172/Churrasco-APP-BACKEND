create database meuchurrascoDB;

-- LOCAL -
create table local(
	id_local serial,
	latitude varchar(50),
	longitude varchar(50),
	constraint id_localPk primary key (id_local)
);

COMMENT on column public.local.latitude is 'Latitude do local';
COMMENT on column public.local.longitude is 'Longitude do local';


-- USUÁRIO --
create table usuario(
	id_usuario serial,
	nome varchar(100),
	email varchar(100),
	constraint id_usuarioPk primary key (id_usuario)
);

COMMENT on column public.usuario.nome is 'Nome do usuario';
COMMENT on column public.usuario.email is 'Email do usuário';


--CONTRIBUICAO --
create table contribuicao(
	id_contribuicao serial,
	id_usuario int,
	nome varchar(100),
	constraint id_contribuicaoPk primary key (id_contribuicao),
	constraint id_usuarioFk foreign key (id_usuario) references usuario(id_usuario)
);

COMMENT on column public.contribuicao.nome is 'Nome da contribuicao';
COMMENT on column public.contribuicao.id_usuario is 'Id do usuário contribuidor';

-- EVENTO --
create table evento(
	id_evento serial,
	id_local int,
	id_usuario int,
	nome varchar(100),
	data_evento Date,
	descricao text,
	constraint id_eventoPk primary key (id_evento),
	constraint id_localFk foreign key (id_local) references local(id_local),
	constraint id_usuarioFk foreign key (id_usuario) references usuario(id_usuario)
);

COMMENT on column public.evento.nome is 'Nome do evento';
COMMENT on column public.evento.id_local is 'Id do local do evento';
COMMENT on column public.evento.id_usuario is 'Id do usuário organizador';
COMMENT on column public.evento.data_evento is 'Data do evento';
COMMENT on column public.evento.descricao is 'Descrição do evento';
COMMENT on column public.evento.nome is 'Nome do evento';


-- EVENTO_USUARIO --
create table evento_usuario(
	id_evento_usuario serial,
	id_evento int,
	id_usuario int,
	constraint id_evento_usuarioPk primary key (id_evento_usuario),
	constraint id_eventoFk foreign key (id_evento) references evento(id_evento),
	constraint id_usuarioFk foreign key (id_usuario) references usuario(id_usuario)
);

COMMENT on column public.evento_usuario.id_evento is 'Id do evento';
COMMENT on column public.evento_usuario.id_usuario is 'Id do usuário';


