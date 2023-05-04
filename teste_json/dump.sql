DROP DATABASE IF EXISTS teste_json;
CREATE DATABASE teste_json;

\c teste_json;

CREATE TABLE orders (
    id serial PRIMARY KEY,
    info json NOT NULL
);
