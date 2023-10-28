CREATE TABLE if not EXISTS curso (
    id int primary key auto_increment,
    descricao varchar(100) not null
);

INSERT INTO curso (descricao)
values ('Desenvolvimento de Software Multiplataforma'),
    ('Sistemas para Internet'),
    ('Gestão Empresarial');