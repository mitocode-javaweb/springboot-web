CREATE TABLE public.usuario
(
    id serial,
    usuario character varying(15) NOT NULL,
    nombres character varying(20) NOT NULL,
    clave text NOT NULL,
    estado character varying(15),
    rol character varying(20),
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_uq_usuario UNIQUE (usuario)
)

TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;
    
INSERT INTO public.usuario(usuario, nombres, clave, estado, rol) VALUES ('juanpablo@mitocodenetwork.com', 'Juan Pablo Molina', '$2a$10$4d9NyW52h2SqhkejV26o8uzf8oGKE210mKhiiZfnHLn.yeD72IDda', 'ACTIVO', 'USER');
INSERT INTO public.usuario(usuario, nombres, clave, estado, rol) VALUES ('rafael@mitocodenetwork.com', 'Rafael Simancas', '$2a$10$4d9NyW52h2SqhkejV26o8uzf8oGKE210mKhiiZfnHLn.yeD72IDda', 'BLOQUEADO', 'USER');
INSERT INTO public.usuario(usuario, nombres, clave, estado, rol) VALUES ('pablo@mitocodenetwork.com', 'Pablo Rodriguez', '$2a$10$4d9NyW52h2SqhkejV26o8uzf8oGKE210mKhiiZfnHLn.yeD72IDda', 'ACTIVO', 'ADMIN');
INSERT INTO public.usuario(usuario, nombres, clave, estado, rol) VALUES ('emilio@mitocodenetwork.com', 'Emilio Caldas', '123', 'ACTIVO', 'USER');
INSERT INTO public.usuario(usuario, nombres, clave, estado, rol) VALUES ('augusto@mitocodenetwork.com', 'Augusto Muñoz', '123', 'ACTIVO', 'USER');
INSERT INTO public.usuario(usuario, nombres, clave, estado, rol) VALUES ('yenuri@mitocodenetwork.com', 'Yenuri Córdova', '123', 'ACTIVO', 'USER');



CREATE TABLE public.categoria
(
    id serial,
    nombre character varying(25) NOT NULL,
    descripcion text NOT NULL,
    imagen bytea,
    estado character varying(15) NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
);

ALTER TABLE public.categoria
    OWNER to postgres;
    
CREATE TABLE public.producto
(
    id bigserial,
    nombre_corto character varying(20) NOT NULL,
    nombre_extenso character varying(75),
    descripcion_corta character varying(50) NOT NULL,
    descripcion_extensa text,
    cantidad integer NOT NULL,
    id_categoria integer,
    CONSTRAINT producto_pkey PRIMARY KEY (id),
    CONSTRAINT producto_categoria_fkey FOREIGN KEY (id_categoria)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.producto
    OWNER to postgres;
    

CREATE TABLE public.producto_mensaje
(
    id bigserial NOT NULL,
    nombre_usuario character varying NOT NULL,
    fecha date NOT NULL,
    mensaje text,
    id_producto integer,
    CONSTRAINT producto_mensaje_pkey PRIMARY KEY (id),
    CONSTRAINT producto_mensaje_producto_fkey FOREIGN KEY (id_producto)
        REFERENCES public.producto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.producto_mensaje
    OWNER to postgres;
    