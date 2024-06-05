CREATE TABLE tt_order
(
    id UUID NOT NULL,
    version BIGINT NOT NULL,
    full_name varchar NOT NULL,
    phone varchar NOT NULL,
    tour varchar NOT NULL,
    guide varchar NOT NULL,
    tour_date date NOT NULL,
    PRIMARY KEY (id)
);
