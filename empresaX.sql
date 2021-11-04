--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.7

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: empresa; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA empresa;


ALTER SCHEMA empresa OWNER TO postgres;

--
-- Name: permiso_id_permiso_sec; Type: SEQUENCE; Schema: empresa; Owner: postgres
--

CREATE SEQUENCE empresa.permiso_id_permiso_sec
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE empresa.permiso_id_permiso_sec OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: permiso; Type: TABLE; Schema: empresa; Owner: postgres
--

CREATE TABLE empresa.permiso (
    id integer DEFAULT nextval('empresa.permiso_id_permiso_sec'::regclass) NOT NULL,
    nombre_empleado character varying(50) NOT NULL,
    apellidos_empleado character varying(50) NOT NULL,
    tipo_permiso integer NOT NULL,
    fecha_permiso timestamp without time zone NOT NULL
);


ALTER TABLE empresa.permiso OWNER TO postgres;

--
-- Name: tipo_permiso_id_sec; Type: SEQUENCE; Schema: empresa; Owner: postgres
--

CREATE SEQUENCE empresa.tipo_permiso_id_sec
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE empresa.tipo_permiso_id_sec OWNER TO postgres;

--
-- Name: tipo_permiso; Type: TABLE; Schema: empresa; Owner: postgres
--

CREATE TABLE empresa.tipo_permiso (
    id integer DEFAULT nextval('empresa.tipo_permiso_id_sec'::regclass) NOT NULL,
    descripcion character varying(30) NOT NULL
);


ALTER TABLE empresa.tipo_permiso OWNER TO postgres;

--
-- Data for Name: permiso; Type: TABLE DATA; Schema: empresa; Owner: postgres
--

COPY empresa.permiso (id, nombre_empleado, apellidos_empleado, tipo_permiso, fecha_permiso) FROM stdin;
\.


--
-- Data for Name: tipo_permiso; Type: TABLE DATA; Schema: empresa; Owner: postgres
--

COPY empresa.tipo_permiso (id, descripcion) FROM stdin;
1	Enfermedad
2	diligencias
3	otros
\.


--
-- Name: permiso_id_permiso_sec; Type: SEQUENCE SET; Schema: empresa; Owner: postgres
--

SELECT pg_catalog.setval('empresa.permiso_id_permiso_sec', 13, true);


--
-- Name: tipo_permiso_id_sec; Type: SEQUENCE SET; Schema: empresa; Owner: postgres
--

SELECT pg_catalog.setval('empresa.tipo_permiso_id_sec', 3, true);


--
-- Name: permiso Permiso_pkey; Type: CONSTRAINT; Schema: empresa; Owner: postgres
--

ALTER TABLE ONLY empresa.permiso
    ADD CONSTRAINT "Permiso_pkey" PRIMARY KEY (id);


--
-- Name: tipo_permiso TipoPermiso_pkey; Type: CONSTRAINT; Schema: empresa; Owner: postgres
--

ALTER TABLE ONLY empresa.tipo_permiso
    ADD CONSTRAINT "TipoPermiso_pkey" PRIMARY KEY (id);


--
-- Name: permiso id_tipo_permiso_fk; Type: FK CONSTRAINT; Schema: empresa; Owner: postgres
--

ALTER TABLE ONLY empresa.permiso
    ADD CONSTRAINT id_tipo_permiso_fk FOREIGN KEY (tipo_permiso) REFERENCES empresa.tipo_permiso(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

