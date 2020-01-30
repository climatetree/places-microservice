--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-01-29 22:32:16

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16416)
-- Name: Eco_Name; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Eco_Name" (
    eco_name_id integer NOT NULL,
    eco_name character varying(100)[] NOT NULL
);


ALTER TABLE public."Eco_Name" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16408)
-- Name: Type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Type" (
    type_id integer NOT NULL,
    type_name character varying(100)[] NOT NULL
);


ALTER TABLE public."Type" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16440)
-- Name: name; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.name (
    name_id integer NOT NULL,
    name character varying(100)[] NOT NULL
);


ALTER TABLE public.name OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16495)
-- Name: name_place; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.name_place (
    name_id integer NOT NULL,
    place_id integer NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.name_place OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16470)
-- Name: place_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.place_info (
    place_id integer NOT NULL,
    type_id integer NOT NULL,
    eco_name_id integer NOT NULL,
    wwf_realm2_id integer NOT NULL,
    wwf_mhtnam_id integer NOT NULL,
    population integer,
    carbon double precision,
    percapcarb double precision,
    popdensity double precision,
    hasc_1 double precision,
    point_x double precision,
    point_y double precision
);


ALTER TABLE public.place_info OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16432)
-- Name: wwf_mhtnam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wwf_mhtnam (
    wwf_mhtnam_id integer NOT NULL,
    wwf_mhtnam character varying(100)[] NOT NULL
);


ALTER TABLE public.wwf_mhtnam OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16424)
-- Name: wwf_realm2; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wwf_realm2 (
    wwf_realm2_id integer NOT NULL,
    wwf_realm2_name character varying(100)[] NOT NULL
);


ALTER TABLE public.wwf_realm2 OWNER TO postgres;

--
-- TOC entry 2717 (class 2606 OID 16423)
-- Name: Eco_Name Eco_Name_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Eco_Name"
    ADD CONSTRAINT "Eco_Name_pkey" PRIMARY KEY (eco_name_id);


--
-- TOC entry 2715 (class 2606 OID 16415)
-- Name: Type Type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Type"
    ADD CONSTRAINT "Type_pkey" PRIMARY KEY (type_id);


--
-- TOC entry 2723 (class 2606 OID 16447)
-- Name: name name_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.name
    ADD CONSTRAINT name_pkey PRIMARY KEY (name_id);


--
-- TOC entry 2727 (class 2606 OID 16499)
-- Name: name_place pfkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.name_place
    ADD CONSTRAINT pfkey PRIMARY KEY (name_id, place_id);


--
-- TOC entry 2725 (class 2606 OID 16474)
-- Name: place_info place_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place_info
    ADD CONSTRAINT place_info_pkey PRIMARY KEY (place_id);


--
-- TOC entry 2721 (class 2606 OID 16439)
-- Name: wwf_mhtnam wwf_mhtnam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wwf_mhtnam
    ADD CONSTRAINT wwf_mhtnam_pkey PRIMARY KEY (wwf_mhtnam_id);


--
-- TOC entry 2719 (class 2606 OID 16431)
-- Name: wwf_realm2 wwf_realm2_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wwf_realm2
    ADD CONSTRAINT wwf_realm2_pkey PRIMARY KEY (wwf_realm2_id);


--
-- TOC entry 2729 (class 2606 OID 16480)
-- Name: place_info eco_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place_info
    ADD CONSTRAINT eco_name_fkey FOREIGN KEY (eco_name_id) REFERENCES public."Eco_Name"(eco_name_id) NOT VALID;


--
-- TOC entry 2732 (class 2606 OID 16500)
-- Name: name_place name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.name_place
    ADD CONSTRAINT name_fkey FOREIGN KEY (name_id) REFERENCES public.name(name_id);


--
-- TOC entry 2733 (class 2606 OID 16505)
-- Name: name_place place_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.name_place
    ADD CONSTRAINT place_fkey FOREIGN KEY (place_id) REFERENCES public.place_info(place_id);


--
-- TOC entry 2728 (class 2606 OID 16475)
-- Name: place_info type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place_info
    ADD CONSTRAINT type_fkey FOREIGN KEY (type_id) REFERENCES public."Type"(type_id);


--
-- TOC entry 2731 (class 2606 OID 16490)
-- Name: place_info wwf_mhtnam_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place_info
    ADD CONSTRAINT wwf_mhtnam_fkey FOREIGN KEY (wwf_mhtnam_id) REFERENCES public.wwf_mhtnam(wwf_mhtnam_id) NOT VALID;


--
-- TOC entry 2730 (class 2606 OID 16485)
-- Name: place_info wwf_realm2_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.place_info
    ADD CONSTRAINT wwf_realm2_fkey FOREIGN KEY (wwf_realm2_id) REFERENCES public.wwf_realm2(wwf_realm2_id) NOT VALID;


-- Completed on 2020-01-29 22:32:16

--
-- PostgreSQL database dump complete
--

