--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `bitsplease`.`endereco` DROP FOREIGN KEY `fk_endereco_user1`;

ALTER TABLE `bitsplease`.`especialidade` DROP PRIMARY KEY;

ALTER TABLE `bitsplease`.`paciente` DROP PRIMARY KEY;

ALTER TABLE `bitsplease`.`medico` DROP PRIMARY KEY;

ALTER TABLE `bitsplease`.`user` DROP PRIMARY KEY;

ALTER TABLE `bitsplease`.`medico_has_especialidade` DROP PRIMARY KEY;

ALTER TABLE `bitsplease`.`medico_has_especialidade` DROP INDEX `bitsplease`.`fk_medico_has_especialidade_especialidade1_idx`;

ALTER TABLE `bitsplease`.`medico_has_especialidade` DROP INDEX `bitsplease`.`fk_medico_has_especialidade_medico1_idx`;

ALTER TABLE `bitsplease`.`telefone` DROP INDEX `bitsplease`.`fk_telefone_user1_idx`;

ALTER TABLE `bitsplease`.`endereco` DROP INDEX `bitsplease`.`fk_endereco_user1_idx`;

ALTER TABLE `bitsplease`.`medico` DROP INDEX `bitsplease`.`fk_medico_user1_idx`;

DROP TABLE `bitsplease`.`user`;

DROP TABLE `bitsplease`.`medico_has_especialidade`;

DROP TABLE `bitsplease`.`paciente`;

DROP TABLE `bitsplease`.`medico`;

DROP TABLE `bitsplease`.`telefone`;

DROP TABLE `bitsplease`.`endereco`;

DROP TABLE `bitsplease`.`especialidade`;

CREATE TABLE `bitsplease`.`paciente` (
	`user_id` INT NOT NULL,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;

CREATE TABLE `bitsplease`.`medico` (
	`crm` VARCHAR(7),
	`uf` VARCHAR(2),
	`pais` VARCHAR(2),
	`user_id` INT NOT NULL,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;

CREATE TABLE `bitsplease`.`user` (
	`id` INT NOT NULL,
	`nome` VARCHAR(255),
	`sobrenome` VARCHAR(255),
	`email` VARCHAR(255),
	`senha` BLOB,
	`tipo` TINYINT,
	`situacao` TINYINT,
	`cpf` VARCHAR(11),
	`data_nascimento` DATE,
	`criacao` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `bitsplease`.`medico_has_especialidade` (
	`medico_user_id` INT NOT NULL,
	`especialidade_id` INT NOT NULL,
	PRIMARY KEY (`medico_user_id`,`especialidade_id`)
) ENGINE=InnoDB;

CREATE TABLE `bitsplease`.`telefone` (
	`numero` VARCHAR(11),
	`tipo` TINYINT,
	`user_id` INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `bitsplease`.`endereco` (
	`cep` VARCHAR(11),
	`estado` VARCHAR(2),
	`cidade` VARCHAR(28),
	`bairro` VARCHAR(100),
	`rua` VARCHAR(100),
	`numero` SMALLINT,
	`complemento` VARCHAR(50),
	`tipo` TINYINT,
	`user_id` INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `bitsplease`.`especialidade` (
	`id` INT NOT NULL,
	`descricao` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE INDEX `fk_medico_has_especialidade_especialidade1_idx` ON `bitsplease`.`medico_has_especialidade` (`especialidade_id` ASC);

CREATE INDEX `fk_endereco_user1_idx` ON `bitsplease`.`endereco` (`user_id` ASC);

CREATE INDEX `fk_medico_user1_idx` ON `bitsplease`.`medico` (`user_id` ASC);

CREATE INDEX `fk_medico_has_especialidade_medico1_idx` ON `bitsplease`.`medico_has_especialidade` (`medico_user_id` ASC);

CREATE INDEX `fk_telefone_user1_idx` ON `bitsplease`.`telefone` (`user_id` ASC);

ALTER TABLE `bitsplease`.`user` ADD PRIMARY KEY (`id`);

ALTER TABLE `bitsplease`.`endereco` ADD CONSTRAINT `fk_endereco_user1` FOREIGN KEY (`user_id`)
	REFERENCES `bitsplease`.`user` (`id`);

