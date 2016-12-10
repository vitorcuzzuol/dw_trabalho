/* Executar os comandos na ordem que estão escritos. */


CREATE DATABASE sistema_aeroporto;

USE sistema_aeroporto;

/*Essa tabela guardará as passagens compradas. Nela teremos o número do documento da reserva (id_reserva) e o CPF do usuário. 
  Com ela, saberemos se o usuário possui algum vôo agendado.  */
  
CREATE TABLE reservas(
	id_reserva INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id_reserva),
    cpf_usuario INT
)	ENGINE=INNODB;



/*	Nessa tabela teremos os dados do usuário. Os créditos iremos definir aleatoriamente. No ato do cadastro, o usuário não poderá setar os créditos. 
	Para acessar os dados desse usuário, usaremos o CPF, que é o identificador único dele. */

CREATE TABLE dados_usuario(
    cpf INT NOT NULL,
    PRIMARY KEY (cpf),
    nome VARCHAR(64),
    endereco VARCHAR(400),
    data_nasc DATE,
    telefone INT,
    creditos INT
)	ENGINE=INNODB;

        
/* A ideia dessa tabela é ter as poltronas numeradas, com cada respectiva classe e preço. A classe e o preço são chaves estrangeiras e buscam essas informações na tabela classes.*/
CREATE TABLE poltronas(
    id_poltrona INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id_poltrona),
    classe VARCHAR(64),
	preco INT
)   ENGINE=INNODB;

/* Aqui guardaremos as informações dos voôs. Sobre a data e a hora, o formato DATETIME armazena ambos os dados.*/
CREATE TABLE voos_sistema(
	data_ida DATETIME,
    data_volta DATETIME,
    duracao INT,
    num_paradas INT
)   ENGINE=INNODB;

/* Esse comando faz com que o campo cpf_usuario seja do tipo FK, referenciando a tabela de dados do usuário, na coluna CPF. Rodar depois de ter criado a tabela "reservas". 
   Não criei diretamente o campo sendo chave estrangeira porque deu erro.	 	*/
ALTER TABLE `reservas` ADD CONSTRAINT  `fk_cpf_usuario` FOREIGN KEY (`cpf_usuario`) REFERENCES `dados_usuario` (`cpf`);  

