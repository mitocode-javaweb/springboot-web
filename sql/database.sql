CREATE TABLE public.usuario
(
    id serial,
    usuario character varying(15) NOT NULL,
    nombres character varying(20) NOT NULL,
    clave text NOT NULL,
    estado character varying(15),
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_uq_usuario UNIQUE (usuario)
)

TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;
    
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('juanpablo', 'Juan Pablo Molina', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('rafael', 'Rafael Simancas', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('pablo', 'Pablo Rodriguez', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('emilio', 'Emilio Caldas', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('augusto', 'Augusto Muñoz', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('yenuri', 'Yenuri Córdova', '123', 'ACTIVO');


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
    
 ALTER TABLE public.usuario
    ADD COLUMN rol character varying(20);