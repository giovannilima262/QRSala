create table if not exists sala (ID int primary key, NOME varchar(30), NOME_PROFESSOR varchar(30), HORARIO_INICIO varchar(10), HORARIO_FIM varchar(10), DIASEMANA int);
insert into sala (ID, NOME, NOME_PROFESSOR, HORARIO_INICIO, HORARIO_FIM, DIASEMANA) values(1,'204B', 'Mario Jorge', '7:00', '9:30', 1);
insert into sala (ID, NOME, NOME_PROFESSOR, HORARIO_INICIO, HORARIO_FIM, DIASEMANA) values(2,'204B', 'Claudio Neiva', '9:50', '12:30', 1);
insert into sala (ID, NOME, NOME_PROFESSOR, HORARIO_INICIO, HORARIO_FIM, DIASEMANA) values(3,'202B', 'Arnaldo Bispo', '10:0', '11:30', 2);