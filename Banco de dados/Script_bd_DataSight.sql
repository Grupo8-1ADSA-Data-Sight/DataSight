CREATE DATABASE dataSight;
USE dataSight;

CREATE TABLE Empresa(
	idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
	Razap_Social VARCHAR(45) NOT NULL,
    CNPJ CHAR(14) NOT NULL,
	Telefone CHAR(15),
    email VARCHAR(45) NOT NULL
);

CREATE TABLE Endereco(
	idEndereco INT PRIMARY KEY AUTO_INCREMENT,
    Logradouro VARCHAR(45) NOT NULL,
    Numero INT NOT NULL,
    fkEmpresa INT NOT NULL,
    CONSTRAINT fk_idEmpresa FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa)
);

CREATE TABLE Maquina(
	idMaquina INT PRIMARY KEY AUTO_INCREMENT,
    Numero_do_patrimonio CHAR(7) NOT NULL,
    Numero_do_rack INT NOT NULL,
    Setor VARCHAR(40) NOT NULL,
    fkEmpresa INT NOT NULL,
    CONSTRAINT fk_idEmpresaMaq FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa)
);

CREATE TABLE Usuario(
	idUsuario INT PRIMARY KEY AUTO_INCREMENT,
	nome varchar(45) NOT NULL NOT NULL,
	CPF CHAR(11) NOT NULL,	
    email VARCHAR(45) NOT NULL,
    senha CHAR(16) NOT NULL,
    fkEmpresa INT NOT NULL,
    CONSTRAINT fk_idEmpresaUser FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa)
);

CREATE TABLE Tipo_Usuario(
	idTipoUsuario INT PRIMARY KEY AUTO_INCREMENT,
    fkEmpresa INT NOT NULL,
    fkMaquina INT NOT NULL,
    fkUsuario INT NOT NULL,
    CONSTRAINT fk_idEmpresaTPU FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    CONSTRAINT fk_idMaquinaTPU FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina),
    CONSTRAINT fk_idUsuarioTPU FOREIGN KEY (fkUsuario) REFERENCES Usuario(idUsuario),
    Cargo CHAR(3) NOT NULL
);

CREATE TABLE CPU_Maquina(
	idCPU INT PRIMARY KEY AUTO_INCREMENT,
    qtdUtilizado DOUBLE NOT NULL,
    Tempo_de_Atividade TIME NOT NULL,
    Velocidade_em_Ghz DOUBLE NOT NULL,
    Data_Leitura DATETIME NOT NULL,
    fkEmpresa INT NOT NULL,
    fkMaquina INT NOT NULL,
    CONSTRAINT fk_idEmpresaCPU FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    CONSTRAINT fk_idMaquinaCPU FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
);
CREATE TABLE HD(
	idHD INT PRIMARY KEY AUTO_INCREMENT,
    Tempo_de_Atividade TIME NOT NULL,
    Taxa_Transferencia_de_Dados DOUBLE NOT NULL,
    Data_Leitura DATETIME NOT NULL,
    fkEmpresa INT NOT NULL,
    fkMaquina INT NOT NULL,
    CONSTRAINT fk_idEmpresaHD FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    CONSTRAINT fk_idMaquinaHD FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
);

CREATE TABLE RAM(
	idRAM INT PRIMARY KEY AUTO_INCREMENT,
    Uso_da_Memoria DOUBLE NOT NULL,
    TOTAL_de_Memoria DOUBLE NOT NULL,
    Data_Leitura DATETIME NOT NULL,
    fkEmpresa INT NOT NULL,
    fkMaquina INT NOT NULL,
    CONSTRAINT fk_idEmpresaRAM FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    CONSTRAINT fk_idMaquinaRAM FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
);

CREATE TABLE Rede(
	idCPU INT PRIMARY KEY AUTO_INCREMENT,
    Taxa_de_Transferencia DOUBLE NOT NULL,
    Frequencia_de_Quedas DOUBLE NOT NULL,
    Minimo_Taxa_de_Upload DOUBLE NOT NULL,
    Maximo_Taxa_de_Upload DOUBLE NOT NULL,
    Minimo_Taxa_de_Download DOUBLE NOT NULL,
    Maximo_Taxa_de_Download DOUBLE NOT NULL,
    Data_Leitura DATETIME NOT NULL,
    fkEmpresa INT NOT NULL,
    fkMaquina INT NOT NULL,
    CONSTRAINT fk_idEmpresaRED FOREIGN KEY (fkEmpresa) REFERENCES Empresa(idEmpresa),
    CONSTRAINT fk_idMaquinaRED FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
);
