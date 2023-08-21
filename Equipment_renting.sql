BEGIN;


CREATE TABLE IF NOT EXISTS public.Snowboard
(
    snowboard_id integer NOT NULL,
    rental_id    integer NOT NULL,
    available    boolean NOT NULL,
    length       integer NOT NULL,
    width        integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.Helmet
(
    helmet_id integer NOT NULL,
    rental_id integer NOT NULL,
    size      integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.Rental
(
    rental_id   integer                NOT NULL,
    customer_id integer                NOT NULL,
    date        date                   NOT NULL,
    time_out    time without time zone NOT NULL,
    time_back   time without time zone NOT NULL,
    price       integer                NOT NULL
);

CREATE TABLE IF NOT EXISTS public.Customer
(
    customer_id   integer NOT NULL,
    name          text    NOT NULL,
    surname       text    NOT NULL,
    passport_Info text    NOT NULL,
    phone_number  integer NOT NULL
);


ALTER TABLE IF EXISTS public.Snowboard
    ADD PRIMARY KEY (snowboard_id);

ALTER TABLE IF EXISTS public.Helmet
    ADD PRIMARY KEY (helmet_id);


ALTER TABLE IF EXISTS public.Rental
    ADD PRIMARY KEY (rental_id);


ALTER TABLE IF EXISTS public.Customer
    ADD PRIMARY KEY (customer_id);

ALTER TABLE IF EXISTS public.Snowboard
    ADD FOREIGN KEY (rental_id)
        REFERENCES public.Rental (rental_id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE;


ALTER TABLE IF EXISTS public.Helmet
    ADD FOREIGN KEY (rental_id)
        REFERENCES public.Rental (rental_id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE;


ALTER TABLE IF EXISTS public.Rental
    ADD FOREIGN KEY (customer_id)
        REFERENCES public.Customer (customer_id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE;


DROP TABLE public.Customer;

DROP TABLE public.Helmet;

DROP TABLE public.Rental;
