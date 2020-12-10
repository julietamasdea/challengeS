INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Ned','Morrison','n.morrison@gmail.com','123456','Ned','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Preston','Payne','p.payne@gmail.com','123456','Preston','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Mike','Carroll','m.carroll@gmail.com','123456','Mike','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Ryan','Carroll','r.carroll@gmail.com','123456','Ryan','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Samantha','Wilson','s.wilson@gmail.com','123456','Samantha','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Andrew','Hawkins','a.hawkins@gmail.com','123456','Andrew','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Roman','Taylor','r.taylor@gmail.com','123456','Roman','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Penelope','Harper','p.harper@gmail.com','123456','Penelope','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Chelsea','Gibson','c.gibson@gmail.com','123456','Chelsea','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Adam','Barnes','a.barnes@gmail.com','123456','Adam','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Savana','Adams','s.adams@gmail.com','123456','Savana','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('John','Hill','j.hill@gmail.com','123456','John','ROLE_USER');
INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('Carl','Kelly','c.kelly@gmail.com','123456','Carl','ROLE_USER');INSERT INTO usuario (nombre,apellido,email,password,username,rol) VALUES ('admin','admin','admin@gmail.com','admin','admin','ADMIN');

INSERT INTO evento (nombre, fecha) VALUES ('Fin 2020','2020-12-15');
INSERT INTO evento (nombre, fecha) VALUES ('Navidad','2020-12-24');
INSERT INTO evento (nombre, fecha) VALUES ('Comienzo 2021','2021-01-04');
INSERT INTO evento (nombre, fecha) VALUES ('Vacaciones','2021-01-20');

INSERT INTO evento_usuario (evento_id, usuario_id) VALUES ('1','1');
INSERT INTO evento_usuario (evento_id, usuario_id) VALUES ('1','2');
INSERT INTO evento_usuario (evento_id, usuario_id) VALUES ('1','3');
INSERT INTO evento_usuario (evento_id, usuario_id) VALUES ('2','3');
INSERT INTO evento_usuario (evento_id, usuario_id) VALUES ('2','4');
INSERT INTO evento_usuario (evento_id, usuario_id) VALUES ('2','5');