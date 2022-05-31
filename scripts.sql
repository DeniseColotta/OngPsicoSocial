create database ong;

use ong;
create table tipo_doc(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table genero(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table situacion_laboral(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table nivel_estudios(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table cobertura_salud(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table horario_atencion(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table tipo_profesional(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table motivo_consulta(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table resultado_consulta(
id INT auto_increment,
nombre VARCHAR(200) NOT NULL,
primary key (id));

create table zona_residencia(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
primary key (id));

create table persona(
id INT auto_increment,
nombres VARCHAR(50) NOT NULL,
apellidos VARCHAR(50) NOT NULL,
tipo_doc_id INT,
num_doc INT,
fecha_nac date,
edad INT,
genero_id INT,
telefono INT,
email varchar(50),
nacionalidad Varchar(50),
zona_residencia_id INT,
cant_integrantes_familia INT,
situacion_laboral_id INT,
nivel_estudios_id INT,
cobertura_salud_id INT,
primary key (id),
CONSTRAINT fk_persona_tipo_doc
FOREIGN KEY (tipo_doc_id) REFERENCES tipo_doc(id),
CONSTRAINT fk_persona_genero
FOREIGN KEY (genero_id) REFERENCES genero(id),
CONSTRAINT fk_persona_situacion_laboral
FOREIGN KEY (situacion_laboral_id) REFERENCES situacion_laboral(id),
CONSTRAINT fk_persona_nivel_estudios
FOREIGN KEY (nivel_estudios_id) REFERENCES nivel_estudios(id),
CONSTRAINT fk_persona_cobertura_salud
FOREIGN KEY (cobertura_salud_id) REFERENCES cobertura_salud(id),
CONSTRAINT fk_persona_zona_residencia_id
FOREIGN KEY (zona_residencia_id) REFERENCES zona_residencia(id)
);


create table profesional(
id INT auto_increment,
nombres VARCHAR(50) NOT NULL,
apellidos VARCHAR(50) NOT NULL,
tipo_doc_id INT,
num_doc INT,
fecha_nac date,
edad INT,
genero_id INT,
telefono INT,
email varchar(50),
zona_residencia_id INT,
horario_atencion_id INT,
tipo_profesional_id int,
primary key (id),
CONSTRAINT fk_profesional_tipo_doc
FOREIGN KEY (tipo_doc_id) REFERENCES tipo_doc(id),
CONSTRAINT fk_profesional_genero
FOREIGN KEY (genero_id) REFERENCES genero(id),
CONSTRAINT fk_profesional_horario_atencion
FOREIGN KEY (horario_atencion_id) REFERENCES horario_atencion(id),
CONSTRAINT fk_profesional_tipo_profesional
FOREIGN KEY (tipo_profesional_id) REFERENCES tipo_profesional(id),
CONSTRAINT fk_profesional_zona_residencia_id
FOREIGN KEY (zona_residencia_id) REFERENCES zona_residencia(id)

);


create table entrevista_inicial(
id INT auto_increment,
persona_id INT,
fecha date,
motivo_consulta_id INT,
profesional_id INT,
primary key (id),
CONSTRAINT fk_entrevista_inicial_persona
FOREIGN KEY (persona_id) REFERENCES persona(id),
CONSTRAINT fk_entrevista_inicial_motivo_consulta
FOREIGN KEY (motivo_consulta_id) REFERENCES motivo_consulta(id),
CONSTRAINT fk_entrevista_inicial_profesional
FOREIGN KEY (profesional_id) REFERENCES profesional(id)
);


create table entrevista_profesional(
id INT auto_increment,
entrevista_inicial_id INT,
profesional_id INT,
fecha date,
resultado_consulta_id INT,
ampliacion_resultado VARCHAR(500),
primary key (id),
CONSTRAINT fk_entrevista_profesional_entrevista_inicial_id
FOREIGN KEY (entrevista_inicial_id) REFERENCES entrevista_inicial(id),
CONSTRAINT fk_entrevista_profesional_profesional
FOREIGN KEY (profesional_id) REFERENCES profesional(id),
CONSTRAINT fk_entrevista_profesional_resultado_consulta
FOREIGN KEY (resultado_consulta_id) REFERENCES resultado_consulta(id)
);


use ong;
INSERT INTO tipo_doc( nombre)
VALUES
('DNI'),
('LE'),
('LC'),
('PA'),
('CI');

INSERT INTO genero( nombre)
VALUES
('femenino'),
('masculino'),
('no binario'),
('otros');

INSERT INTO tipo_profesional( nombre)
VALUES
('Trabajadora Social'),
('Psicóloga'),
('Abogada'),
('Docente'),
('Recepción');

INSERT INTO situacion_laboral(nombre)
VALUES
('Relación de dependencia'),
('Monotributista/autónoma'),
('Empleo informal/no registrado'),
('Cuenta propista'),
('Desocupada'),
('Jubilada/pensionada');

INSERT INTO nivel_estudios(nombre)
VALUES
('primario incompleto'),
('primario completo'),
('secundario incompleto'),
('secundario completo'),
('universitario incompleto'),
('universitario completo');

INSERT INTO cobertura_salud(nombre)
VALUES
('Sistema Público'),
('Obra Social/Mutual'),
('Prepaga');

INSERT INTO horario_atencion(nombre)
VALUES
('Turno mañana. 9 a 13 hs'),
('Turno tarde. 13 a 18 hs'),
('Turno completo. 9 a 18 hs');

INSERT INTO motivo_consulta(nombre)
VALUES
('Servicio de necesidades básicas'),
('Programa de micro emprendimientos'),
('Cursos de integracion laboral y financiera'),
('Asesoramiento legal'),
('Asesoramiento laboral, salud y educación'),
('Atención Psico-Social');

INSERT INTO resultado_consulta(nombre)
VALUES
('consulta resuelta'),
('consulta parcialmente resuelta'),
('consulta no resuelta'),
('no cumple con los requisitos');



INSERT INTO zona_residencia(nombre)
VALUES
('Ciudad de Buenos Aires'),
('Gran Buenos Aires Norte'),
('Gran Buenos Aires Sur'),
('Gran Buenos Aires Oeste'),
('Resto del país');

 INSERT INTO persona
(id,nombres,apellidos,tipo_doc_id ,num_doc, fecha_nac, edad, genero_id, telefono, email, nacionalidad,zona_residencia_id,cant_integrantes_familia,situacion_laboral_id,nivel_estudios_id ,cobertura_salud_id)
VALUES
('Rosa', 'Pérez',1,457893,'1982-05-03',40,1,11786937,'rperez@gmail.com','argentina', 1, 3, 3,3,1),
('Juana', 'González',3,4578765,'1962-02-07',60,1,11986737,'jgonzalez@gmail.com','argentina', 5, 2, 6,3,2),
('María', 'Pereyra',5,1118765,'1990-10-07',32,1,11986437,'mpereyra@gmail.com','venezolana', 1, 4, 5,3,1),
('Mercedes', 'Lopez',1,4890893,'2000-01-04',22,3,11888937,'mrivarola@gmail.com','argentina', 2, 2, 2,3,2),
('Cecilia', 'Martinez',1,4876565,'1971-05-17',51,1,19876737,'cmartinez@gmail.com','argentina', 3, 2, 5,2,1),
('Lorena', 'Guzman',5,1875465,'1990-08-07',32,1,119346437,'lguzman@gmail.com','venezolana', 4, 4, 5,3,1),
('Clara', 'Salas',1,154832,'1992-09-07',31,1,11988887,'csalas@gmail.com','argentina', 1, 4, 6,3,1),
('Luisa', 'Echeverria',1,44323123,'2002-01-08',20,3,11222237,'lu.echeverria@gmail.com','argentina', 2, 2, 2,2,2),
('Julieta', 'Bruno',1,4345565,'1971-03-27',50,1,19844447,'jbruno@gmail.com','argentina', 3, 2, 5,3,1),
('Guillermina', 'Perez',1,18129875,'1987-08-07',34,4,111235437,'gperez@gmail.com','argentina', 1, 4, 5,3,1),
(11,'María', 'Cruz',5,12343245,'1990-07-03',32,1,119432437,'mzruz@gmail.com','venezolana', 4, 4, 5,3,1),
(12,'Norma', 'Vilchez',1,123432422,'1992-07-09',31,1,113243887,'nvilchez@gmail.com','argentina', 1, 4, 6,3,1),
(13,'Rosa', 'Carreras',1,44432433,'2002-01-23',20,3,11234237,'rcarreras@gmail.com','argentina', 2, 2, 2,2,2),
(14,'Julieta', 'Palacios',1,4767565,'1971-02-21',50,1,4324447,'jpalacios@gmail.com','argentina', 3, 2, 5,3,1),
(15,'Ana', 'Ramirez',1,181324375,'1987-06-18',34,4,1112423437,'aramirez@gmail.com','argentina', 1, 4, 5,3,1);

delete from  persona where id>=21 and id<=25;

select * from persona;

INSERT INTO profesional
(id,nombres,apellidos,tipo_doc_id,num_doc,fecha_nac,edad,genero_id,telefono,email,zona_residencia_id,horario_atencion_id,tipo_profesional_id)
VALUES
(9,'Ana','Díaz',1,7297462,'1984-06-13',37,1,1176587,'adiaz@gmail.com',1, 1,1),
('Lucía','Ferreyra',1,37628462,'1987-08-09',36,1,1167858,'lferreyra@gmail.com',1, 3,3),
('Norma','Paz',1,37645642,'1972-09-11',49,1,1165218,'npaz@gmail.com',3, 3,1),
('Mariana','Gomez',1,3565662,'1985-10-02',36,1,1542423,'mgomez@gmail.com',2, 2,1),
('Gimena','Flores',1,33435662,'1987-02-02',35,1,1134423,'gflores@gmail.com',3, 2,2),
('Sofía','Lozano',1,37355542,'1989-09-01',32,1,116343,'slozano@gmail.com',1, 1,2),
('Celeste','Mancilla',1,37653542,'1989-10-05',32,1,16354,'cmancilla@gmail.com',1, 1,4),
('Marina','Paez',1,375454542,'1982-09-05',39,1,163467,'mpaez@gmail.com',2, 3,5);

delete from  profesional where id>=9 and id<=16;
SET SQL_SAFE_UPDATES = 1;
select * from profesional;

INSERT INTO entrevista_inicial
(persona_id,fecha,motivo_consulta_id,profesional_id)
VALUES
(1,'2022-04-03', 3,8),
(2,'2022-04-03', 1,8),
(3,'2022-04-04', 4,8),
(4,'2022-04-04', 2,8),
(5,'2022-04-04', 5,8),
(6,'2022-04-04', 6,8),
(7,'2022-04-06', 3,8),
(8,'2022-04-06', 1,8),
(9,'2022-04-06', 4,8),
(10,'2022-04-06', 6,8),
(11,'2022-04-10', 2,8),
(12,'2022-04-10', 4,8),
(13,'2022-04-10', 5,8),
(14,'2022-04-10', 6,8),
(15,'2022-04-10', 2,8)
;
select * from entrevista_profesional;
delete from  entrevista_inicial where id>=16 and id<=30;
INSERT INTO entrevista_profesional
(entrevista_inicial_id,profesional_id,fecha,resultado_consulta_id,ampliacion_resultado)
VALUES
(1,7,'2022-04-03',1,'Se inscribe para el curso de integración laboral y financiera'),
(2,1,'2022-04-03',1,' Se realiza evaluación social y se integra al programa de servicios básicos para el retiro de alimentos'),
(3,2,'2022-04-04',1,' Recibe asesoramiento legal para comenzar trámites para regularización migratoria y reunificación familiar'),
(4,3,'2022-04-04',1,' Se realiza evaluación social y se anota para que presente su proyecto para el Programa de microemprendimientos. Realizar seguimiento'),
(5,4,'2022-04-04',2,'Se le brinda información sobre los Centros de Salud más cercanos a su domicilio para tramitar gratuitamente medicación'),
(6,5,'2022-04-04',1,'Recibe contención psicológica por situación de violencia basada en género. Se derivó a institución especializada'),
(7,7,'2022-04-06',1,'Se realiza evaluación social y se anota para que presente su proyecto para el Programa de microemprendimientos. Se le solicita documentación.  Realizar seguimiento'),
(8,1,'2022-04-06',1,'Se inscribe para el curso de integración laboral y financiera'),
(9,2,'2022-04-06',1,' consulta por asesoramiento legal por despido en su trabajo'),
(10,6,'2022-04-06',1,' Solicita entrevista con psicología para consultar por su hijo a quien le indicaron en la escuela realizar un tratamiento psicológico. Se dialoga sobre el caso y se la deriva a institución cercana a su domicilio'),
(11,3,'2022-04-10',1,'Se realiza evaluación social y se anota para que presente su proyecto para el Programa de microemprendimientos.'),
(12,2,'2022-04-10',1,' Recibe asesoramiento legal por acceso a derechos de salud'),
(13,3,'2022-04-10',1,' Se realiza evaluación social y se le brinda información sobre centros educactivos para familiares'),
(14,5,'2022-04-10',2,'Se realiza contención psicológica'),
(15,4,'2022-04-10',1,'Se realiza evaluación social y se anota para que presente su proyecto para el Programa de microemprendimientos.');


select * from entrevista_inicial;
select * from nivel_estudios;

select * from persona;

 -- agrupar por situación laboral
select st.nombre, count(*) as cantidad_personas
from situacion_laboral as st right join persona as p
on p.situacion_laboral_id=st.id
group by situacion_laboral_id;

-- agrupar profesionales por funcion
select tp.nombre as funcion, count(*) as cantidad from profesional as pr,tipo_profesional as tp where pr.tipo_profesional_id=tp.id group by tipo_profesional_id;

-- cuantas entrevistas tuvo cada área profesional
select tpr.nombre, count(*) as personas_atendidas
from  entrevista_profesional as ep left join profesional as pr
on ep.profesional_id=pr.id join tipo_profesional as tpr
on pr.tipo_profesional_id=tpr.id
group by pr.tipo_profesional_id;

Select p.nombres, p.apellidos, g.nombre as género from persona as p, genero as g where p.genero_id = g.id;

-- cuantas personas se atendieron por mes
select month(fecha) as mes, count(persona_id) as Personas_atendidas
from entrevista_inicial
group by month(fecha);

select MONTHNAME(STR_TO_DATE(month(fecha), '%m')) as mes, count(persona_id) as Personas_atendidas from entrevista_inicial group by month(fecha);

-- agrupar a las personas atendidas por zona de residencia
select z.nombre as zona_residencia,count(*) as cantidad_personas_atendidas
from persona as p, zona_residencia as z
where p. zona_residencia_id=z.id
group by zona_residencia_id;

select z.nombre as zona_residencia,count(*) as cantidad_personas_atendidas
from persona as p left join zona_residencia as z
on p. zona_residencia_id=z.id
group by zona_residencia_id;

-- agrupar cuantas personas se atienden por motivo de consulta
select mc.nombre as motivoConsulta, count(*) as cantidad_personas_atendidas
from entrevista_inicial as e, motivo_consulta as mc
where e.motivo_consulta_id= mc.id
group by motivo_consulta_id;

select mc.nombre as motivoConsulta, count(*) as cantidad_personas_atendidas
from entrevista_inicial as e right join motivo_consulta as mc
on e.motivo_consulta_id= mc.id
group by motivo_consulta_id;


-- seleccionar el género de las personas atendidas
select p.nombres, p.apellidos, g.nombre as género
from persona as p left join genero as g
on p.genero_id = g.id;

select p.nombres, p.apellidos, g.nombre as género
from persona as p right join genero as g
on p.genero_id = g.id;



-- agrupar por nivel de estudios.

select ne.nombre, count(*) as cantidad_personas
from nivel_estudios as ne right join persona as p
on p.nivel_estudios_id=ne.id
group by nivel_estudios_id;



select tp.nombre, count(pr.tipo_profesional_id) as cantidad from profesional as pr,tipo_profesional as tp where pr.tipo_profesional_id=tp.id group by tp.nombre;
-- agrupar por cobertura de salud.

select cs.nombre, count(*) as cantidad_personas
from cobertura_salud as cs left join persona as p
on p.cobertura_salud_id=cs.id
group by cobertura_salud_id;

-- seleccionar nombre y apellido de los empleados, tipo de función y horario.
select pr.nombres,pr.apellidos,tpr.nombre as función,ha.nombre as horario
from profesional as pr right join tipo_profesional as tpr
on pr.tipo_profesional_id=tpr.id join horario_atencion as ha
on pr.horario_atencion_id=ha.id;

-- agrupar las personas por nacionalidad.
select situacion_laboral, count(*) as cantidad_personas
from persona
group by situacion_laboral;



use ong;

select * from tipo_profesional;
use ong;
select sl.nombre as situacionLaboral, count(p.id) as cantidadPersonas from persona as p left join situacion_laboral as sl on p.situacion_laboral_id=sl.id group by sl.nombre;

select pr.nombres,pr.apellidos,tpr.nombre as función,ha.nombre as horario from profesional as pr left join tipo_profesional as tpr on pr.tipo_profesional_id=tpr.id join horario_atencion as ha on pr.horario_atencion_id=ha.id;

-- cual es el promedio de edad de las personas consultantes.

select * from entrevista_inicial as ei, persona as p where  ei.persona_id=p.id and  p.nombres like '%mar%';
select * from entrevista_inicial;

select * from persona;

select MONTHNAME(STR_TO_DATE(month(fecha_nac), '%m')) as mes, count(*) as cantidad from persona where month (fecha_nac) = 10 group by month(fecha_nac) order by month(fecha_nac);


select month(fecha_nac) as mes, count(*) as cumplesMes from persona where month (fecha_nac) like '%10%' group by month(fecha_nac)