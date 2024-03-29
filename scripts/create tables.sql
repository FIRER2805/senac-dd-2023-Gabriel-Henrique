CREATE SCHEMA `exemplos` ;

use exemplos;

CREATE TABLE `exemplos`.`endereco` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `RUA` VARCHAR(255) NOT NULL,
  `CEP` VARCHAR(8) NOT NULL,
  `BAIRRO` VARCHAR(255) NOT NULL,
  `CIDADE` VARCHAR(255) NOT NULL,
  `ESTADO` VARCHAR(2) NOT NULL,
  `NUMERO` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE);

  CREATE TABLE `exemplos`.`telefone` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DDD` VARCHAR(3) NOT NULL,
  `NUMERO` VARCHAR(9) NOT NULL,
  `ATIVO` TINYINT NOT NULL,
  `MOVEL` TINYINT NOT NULL,
  `ID_CLIENTE` INT NULL,
  PRIMARY KEY (`ID`));

  CREATE TABLE `exemplos`.`cliente` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NOT NULL,
  `CPF` VARCHAR(11) NOT NULL,
  `ATIVO` TINYINT NOT NULL,
  `ID_ENDERECO` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC) VISIBLE,
  INDEX `ID_ENDERECO_idx` (`ID_ENDERECO` ASC) VISIBLE,
  CONSTRAINT `ID_ENDERECO`
    FOREIGN KEY (`ID_ENDERECO`)
    REFERENCES `exemplos`.`endereco` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `exemplos`.`tipo_pessoa`
(
ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
DESCRICAO VARCHAR(50) NOT NULL
);

CREATE TABLE `exemplos`.`pessoa`
(
ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
NOME VARCHAR(255) NOT NULL,
DATA_NASCIMENTO DATE NOT NULL,
SEXO CHAR(1) NOT NULL,
CPF CHAR(11) NOT NULL,
REACAO INT,
TIPO INT NULL,
FOREIGN KEY(TIPO) REFERENCES exemplos.tipo_pessoa(ID) on delete set null
);

create table EstagioPesquisaVacina
(
	id int not null auto_increment primary key,
    descricao varchar(50)
);

create table vacina(
idvacina int auto_increment primary key,
paisDeOrigem varchar(45),
estagioDaPesquisa int,
dataDeInicioDaPesquisa datetime,
pesquisador int null,
foreign key (pesquisador) references exemplos.pessoa(id) on delete set null,
foreign key(estagioDaPesquisa) references exemplos.estagioPesquisaVacina(id) on delete set null
);

insert into tipo_pessoa(descricao) values("Pesquisador");
insert into tipo_pessoa(descricao) values("Voluntários");
insert into tipo_pessoa(descricao) values("Público geral");

insert into EstagioPesquisaVacina(descricao) values("Inicial");
insert into EstagioPesquisaVacina(descricao) values("Teste");
insert into EstagioPesquisaVacina(descricao) values("Aplicaoção em massa");

select * from tipo_pessoa;
select * from pessoa;
select * from vacina;
select * from EstagioPesquisaVacina;

select pessoa.id,
	pessoa.nome,
    pessoa.data_nascimento,
    pessoa.sexo,
    pessoa.cpf,
    tipo_pessoa.descricao
from pessoa left join tipo_pessoa on
pessoa.tipo = tipo_pessoa.id;

-- delete from tipo_pessoa where id = 1;

insert into vacina (paisDeOrigem, estagioDaPesquisa, dataDeInicioDaPesquisa, pesquisador) values ('Brasil', 1, '2023-03-28', 1);

-- drop table vacina;
-- drop table pessoa;
-- drop table tipo_pessoa;
-- drop table EstagioPesquisaVacina;