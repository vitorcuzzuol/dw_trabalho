/* Executar os comandos na ordem que estão escritos. */


CREATE DATABASE sistema_aeroporto_JPA2_Hibernate;

USE sistema_aeroporto_JPA2_Hibernate;

/*Essa tabela guardará as passagens compradas. Nela teremos o número do documento da reserva (id_reserva) e o CPF do usuário. 
  Com ela, saberemos se o usuário possui algum vôo agendado.  */
  



/*	Nessa tabela teremos os dados do usuário. Os créditos iremos definir aleatoriamente. No ato do cadastro, o usuário não poderá setar os créditos. 
	Para acessar os dados desse usuário, usaremos o CPF, que é o identificador único dele. */

CREATE TABLE usuario(
	idUsuario int NOT NULL AUTO_INCREMENT,
  /*  PRIMARY KEY (idUsuario),*/
    cpf varchar(11),
  /*  PRIMARY KEY (cpf),*/
    nome VARCHAR(64),
    endereco VARCHAR(400),
    dataNasc DATE,
    telefone INT,
    PRIMARY KEY(idUsuario,cpf)
)	ENGINE=INNODB;

CREATE TABLE aviao(
    idAviao INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (idAviao),
    quantidadePoltronas INT
)   ENGINE=INNODB;

CREATE TABLE classe(
	idClasse int  NOT NULL AUTO_INCREMENT,
  /*  PRIMARY KEY (idClasse),*/
    descricaoClasse varchar(30),
  /*  PRIMARY KEY (descricaoClasse),*/
    preco double,
    PRIMARY KEY(idClasse,descricaoClasse)
)   ENGINE=INNODB; 

        
/* A ideia dessa tabela é ter as poltronas numeradas, com cada respectiva classe e preço. A classe e o preço são chaves estrangeiras e buscam essas informações na tabela classes.*/
CREATE TABLE poltrona(
    idPoltrona INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (idPoltrona),
    idAviao INT,
	FOREIGN KEY (idAviao)
    REFERENCES aviao(idAviao)
    ON DELETE CASCADE,
    /*classe VARCHAR(64),*/
    /*preco INT,*/
    idClasse INT,
	FOREIGN KEY (idClasse)
    REFERENCES classe(idClasse)
    ON DELETE CASCADE,

    statusPoltrona BOOLEAN
)   ENGINE=INNODB;


/* Aqui guardaremos as informações dos voôs. Sobre a data e a hora, o formato DATETIME armazena ambos os dados.*/
CREATE TABLE voo(
	idVoo INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (idVoo),
    idAviao INT,
    FOREIGN KEY (idAviao)
    REFERENCES aviao(idAviao)
    ON DELETE CASCADE,
 	dataIda DATETIME,
    duracao INT,
    numParadas INT
) ENGINE=INNODB;  

CREATE TABLE reserva(
	idReserva int NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (idReserva),
    idUsuario int,
    FOREIGN KEY (idUsuario)
    REFERENCES usuario(idUsuario)
    ON DELETE CASCADE,
    idVoo int,
    FOREIGN KEY (idVoo)
	REFERENCES voo(idVoo)
    ON DELETE CASCADE,
    idAviao int,
    FOREIGN KEY (idAviao)
    REFERENCES aviao(idAviao)
    ON DELETE CASCADE,
    idPoltrona int,
    FOREIGN KEY (idPoltrona)
    REFERENCES poltrona(idPoltrona),
    checkin boolean
    )ENGINE=INNODB;
    
    
ALTER TABLE `sistema_aeroporto`.`voo` 
ADD COLUMN `origem` VARCHAR(45) NULL AFTER `numParadas`,
ADD COLUMN `destino` VARCHAR(45) NOT NULL AFTER `origem`;    
    
/* Esse comando faz com que o campo cpf_usuario seja do tipo FK, referenciando a tabela de dados do usuário, na coluna CPF. Rodar depois de ter criado a tabela "reservas". 
   Não criei diretamente o campo sendo chave estrangeira porque deu erro.	 	*/
/*ALTER TABLE `reservas` ADD CONSTRAINT  `fk_cpf_usuario` FOREIGN KEY (`cpf_usuario`) REFERENCES `dados_usuario` (`cpf`);  */


/*selecionar poltronar do aviao*/
select * from poltrona
inner join aviao on
aviao.idAviao = poltrona.idAviao
where aviao.idAviao = 2;

/* selecionar as poltronas vazias de cada avião*/
select * from poltrona
inner join aviao on
aviao.idAviao = poltrona.idAviao
where aviao.idAviao = 2
and poltrona.statusPoltrona = 0;

/*trigger para controlar o status da poltrona automaticamente*/
DELIMITER $$
CREATE TRIGGER Tgr_reserva_poltrona AFTER INSERT 
ON reserva
FOR EACH ROW 
BEGIN 
UPDATE poltrona SET poltrona.statusPoltrona = 1 
WHERE poltrona.idAviao = new.idAviao and poltrona.idPoltrona = new.idPoltrona;

end$$
