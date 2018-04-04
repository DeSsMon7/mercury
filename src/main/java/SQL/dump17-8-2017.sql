--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.6
-- Dumped by pg_dump version 9.5.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: customers_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE customers_customer_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE customers (
    customer_id integer DEFAULT nextval('customers_customer_id_seq'::regclass) NOT NULL,
    customer_firstname character varying(100),
    customer_surname character varying(100),
    customer_email character varying(100)
);


ALTER TABLE customers OWNER TO postgres;

--
-- Name: COLUMN customers.customer_email; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN customers.customer_email IS '
';


--
-- Name: devices_device_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE devices_device_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE devices_device_id_seq OWNER TO postgres;

--
-- Name: devices; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE devices (
    device_id integer DEFAULT nextval('devices_device_id_seq'::regclass) NOT NULL,
    device_type character varying(100),
    device_brand character varying(100),
    device_model character varying(100),
    customer_id integer
);


ALTER TABLE devices OWNER TO postgres;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE employees (
    employee_id integer NOT NULL,
    employee_firstname character varying(100),
    employee_surname character varying(100),
    employee_login character varying(100),
    employee_password character varying(100),
    employee_email character varying(100),
    employee_role character varying(100)
);


ALTER TABLE employees OWNER TO postgres;

--
-- Name: employees_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employees_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employees_employee_id_seq OWNER TO postgres;

--
-- Name: employees_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employees_employee_id_seq OWNED BY employees.employee_id;


--
-- Name: invoices; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE invoices (
    invoice_id integer NOT NULL,
    invoice_date date,
    invoice_price numeric(10,2),
    employee_id integer,
    customer_id integer,
    office_order_id integer
);


ALTER TABLE invoices OWNER TO postgres;

--
-- Name: invoices_invoice_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE invoices_invoice_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE invoices_invoice_id_seq OWNER TO postgres;

--
-- Name: invoices_invoice_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE invoices_invoice_id_seq OWNED BY invoices.invoice_id;


--
-- Name: office_orders_office_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE office_orders_office_order_id_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE office_orders_office_order_id_seq OWNER TO postgres;

--
-- Name: office_orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE office_orders (
    office_order_id integer DEFAULT nextval('office_orders_office_order_id_seq'::regclass) NOT NULL,
    office_order_date date,
    office_order_info character varying(300),
    device_id integer,
    customer_id integer,
    employee_id integer,
    office_order_sum numeric(10,2)
);


ALTER TABLE office_orders OWNER TO postgres;

--
-- Name: COLUMN office_orders.customer_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN office_orders.customer_id IS '
';


--
-- Name: COLUMN office_orders.employee_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN office_orders.employee_id IS '
';


--
-- Name: parts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE parts (
    part_id integer NOT NULL,
    part_info character varying(500),
    part_unit_price numeric(10,2),
    part_instock integer
);


ALTER TABLE parts OWNER TO postgres;

--
-- Name: parts_part_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parts_part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE parts_part_id_seq OWNER TO postgres;

--
-- Name: parts_part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parts_part_id_seq OWNED BY parts.part_id;


--
-- Name: service_parts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE service_parts (
    service_part_id integer NOT NULL,
    part_id integer,
    part_quantity integer,
    part_unit_price numeric(10,2),
    part_total_price numeric(10,2),
    office_order_id integer
);


ALTER TABLE service_parts OWNER TO postgres;

--
-- Name: service_parts_service_part_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE service_parts_service_part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE service_parts_service_part_id_seq OWNER TO postgres;

--
-- Name: service_parts_service_part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE service_parts_service_part_id_seq OWNED BY service_parts.service_part_id;


--
-- Name: services; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE services (
    service_id integer NOT NULL,
    service_description character varying(300),
    service_price numeric(10,2)
);


ALTER TABLE services OWNER TO postgres;

--
-- Name: services_list_service_list_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE services_list_service_list_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE services_list_service_list_id_seq OWNER TO postgres;

--
-- Name: services_list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE services_list (
    service_list_id integer DEFAULT nextval('services_list_service_list_id_seq'::regclass) NOT NULL,
    service_id integer,
    service_price numeric(10,2),
    office_order_id integer
);


ALTER TABLE services_list OWNER TO postgres;

--
-- Name: services_service_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE services_service_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE services_service_id_seq OWNER TO postgres;

--
-- Name: services_service_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE services_service_id_seq OWNED BY services.service_id;


--
-- Name: employee_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees ALTER COLUMN employee_id SET DEFAULT nextval('employees_employee_id_seq'::regclass);


--
-- Name: invoice_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY invoices ALTER COLUMN invoice_id SET DEFAULT nextval('invoices_invoice_id_seq'::regclass);


--
-- Name: part_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parts ALTER COLUMN part_id SET DEFAULT nextval('parts_part_id_seq'::regclass);


--
-- Name: service_part_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY service_parts ALTER COLUMN service_part_id SET DEFAULT nextval('service_parts_service_part_id_seq'::regclass);


--
-- Name: service_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY services ALTER COLUMN service_id SET DEFAULT nextval('services_service_id_seq'::regclass);


--
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY customers (customer_id, customer_firstname, customer_surname, customer_email) FROM stdin;
1	Stoicho	Levkov	stlevkov@gmail.com
2	Radoi	Seimenov	orath@gmail.com
4	Kalata	Sheev	kalata@gmail.com
5	Rumkata		rumkata@gmail.com
6	Stoicho	Levkov	stlevkov@gmail.com
7	Evtim	Iliev	ash@abv.bg
8	asd	asd	asd
\.


--
-- Name: customers_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('customers_customer_id_seq', 8, true);


--
-- Data for Name: devices; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY devices (device_id, device_type, device_brand, device_model, customer_id) FROM stdin;
2	Notebook	Apple	MacPro	5
1	Notebook	Apple	MacPro	4
3	Notebook	Apple	MacPro	1
4	Notepad	Apple	Ipad	1
\.


--
-- Name: devices_device_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('devices_device_id_seq', 4, true);


--
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY employees (employee_id, employee_firstname, employee_surname, employee_login, employee_password, employee_email, employee_role) FROM stdin;
3	Radoi	Seimenov	orath	780d55ebb4b0c01e062b5c7459e33c40591a304c2ab75ddc0de63c5c38bad0af	orath@gmail.com	
1	Evtim	Iliev	ash	701fd6f18a46f7c72397c91b9cb1a6353744b9cca3aa329af5e5e1124b6b8c5a	ash_2@abv.bg	admin
\.


--
-- Name: employees_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employees_employee_id_seq', 3, true);


--
-- Data for Name: invoices; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY invoices (invoice_id, invoice_date, invoice_price, employee_id, customer_id, office_order_id) FROM stdin;
\.


--
-- Name: invoices_invoice_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('invoices_invoice_id_seq', 1, false);


--
-- Data for Name: office_orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY office_orders (office_order_id, office_order_date, office_order_info, device_id, customer_id, employee_id, office_order_sum) FROM stdin;
1	2017-08-04	ne pali	2	2	1	\N
2	2017-08-04	schupen display	3	\N	1	\N
3	2017-08-08	sadsadsad	2	1	3	\N
4	2017-08-08	zxvczvcv	2	1	1	\N
5	\N		3	1	3	\N
\.


--
-- Name: office_orders_office_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('office_orders_office_order_id_seq', 5, true);


--
-- Data for Name: parts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parts (part_id, part_info, part_unit_price, part_instock) FROM stdin;
1	DELL LCD SCREEN CABLE	10.25	47
2	asdasdasd	143.00	123
3	asdasdasdas	13.00	153
4	sfgsfgfsg	14.30	123
5	KINGSTON RAM 4GB	39.99	673
6	ramtest2	9.00	123
7	ramtest3	9.00	155
8	testram4	9.99	16267
\.


--
-- Name: parts_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parts_part_id_seq', 8, true);


--
-- Data for Name: service_parts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY service_parts (service_part_id, part_id, part_quantity, part_unit_price, part_total_price, office_order_id) FROM stdin;
\.


--
-- Name: service_parts_service_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('service_parts_service_part_id_seq', 1, false);


--
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY services (service_id, service_description, service_price) FROM stdin;
\.


--
-- Data for Name: services_list; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY services_list (service_list_id, service_id, service_price, office_order_id) FROM stdin;
\.


--
-- Name: services_list_service_list_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('services_list_service_list_id_seq', 1, false);


--
-- Name: services_service_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('services_service_id_seq', 1, false);


--
-- Name: customers_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY customers
    ADD CONSTRAINT customers_pk PRIMARY KEY (customer_id);


--
-- Name: devices_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY devices
    ADD CONSTRAINT devices_pk PRIMARY KEY (device_id);


--
-- Name: employees_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pk PRIMARY KEY (employee_id);


--
-- Name: invoices_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY invoices
    ADD CONSTRAINT invoices_pk PRIMARY KEY (invoice_id);


--
-- Name: office_orders_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office_orders
    ADD CONSTRAINT office_orders_pk PRIMARY KEY (office_order_id);


--
-- Name: parts_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parts
    ADD CONSTRAINT parts_pk PRIMARY KEY (part_id);


--
-- Name: service_parts_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY service_parts
    ADD CONSTRAINT service_parts_pk PRIMARY KEY (service_part_id);


--
-- Name: services_list_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY services_list
    ADD CONSTRAINT services_list_pk PRIMARY KEY (service_list_id);


--
-- Name: services_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY services
    ADD CONSTRAINT services_pk PRIMARY KEY (service_id);


--
-- Name: devices_customers_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY devices
    ADD CONSTRAINT devices_customers_fk FOREIGN KEY (customer_id) REFERENCES customers(customer_id);


--
-- Name: invoces_employees_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY invoices
    ADD CONSTRAINT invoces_employees_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id);


--
-- Name: invoices_customers_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY invoices
    ADD CONSTRAINT invoices_customers_fk FOREIGN KEY (customer_id) REFERENCES customers(customer_id);


--
-- Name: office_orders_customers_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office_orders
    ADD CONSTRAINT office_orders_customers_fk FOREIGN KEY (customer_id) REFERENCES customers(customer_id);


--
-- Name: office_orders_devices_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office_orders
    ADD CONSTRAINT office_orders_devices_fk FOREIGN KEY (device_id) REFERENCES devices(device_id);


--
-- Name: office_orders_employees_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY office_orders
    ADD CONSTRAINT office_orders_employees_fk FOREIGN KEY (employee_id) REFERENCES employees(employee_id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

