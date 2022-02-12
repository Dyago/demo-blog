INSERT INTO author (name,email,phone,birthDate) 
VALUES ( 'Dyago Diaz', 'dyago@bootcamp.pe','912376689','1992-07-28');


INSERT INTO author (name,email,phone,birthDate) 
VALUES ( 'Luis Alfaro', 'luis@bootcamp.pe','987876765','2010-02-09');

INSERT INTO blog (name,description,url,status, author_id) 
VALUES ( 'Blog de Pelis', 'Espacio para colaboracion en peliculas','https://www.blogdepelis.io/','ACTIVO', 1);

INSERT INTO blog (name,description,url,status, author_id) 
VALUES ( 'Blog de Comida', 'Espacio para colaboracion en comida','https://www.comida.io/','INACTIVO', 1);

INSERT INTO post (title,createDate,status,content, blog_id) 
VALUES ( 'Titanic', '2021-02-10','BORRADOR','Pelicula ganadora de 11 oscar', 1);

