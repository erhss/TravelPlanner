DROP TABLE IF EXISTS citydb.city;
CREATE TABLE citydb.city(
                            name VARCHAR(250) PRIMARY KEY ,
                            description VARCHAR(250) NOT NULL,
                            weather VARCHAR(250)
);

INSERT INTO city (name, description, weather) VALUES
('Toronto', 'Toronto is the capital city of Ontario', 'updates from api on startup!'),
('Victoria','Victoria is the capital city of British Columbia', 'nothing here matters' ),
('Edmonton','Edmonton is the capital city of Alberta','really' ),
('Quebec', 'Quebec is the capital city of Québec','cool'),
('Fredericton', 'Fredericton is the capital city of New Brunswick',':)');
