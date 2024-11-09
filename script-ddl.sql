CREATE DATABASE trabalho_final;

CREATE TABLE vacinas (
    id INT PRIMARY KEY,
    titulo VARCHAR(60),
    descricao VARCHAR(200),
    doses INT,
    periodicidade INT,
    intervalo INT
);

CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    nome VARCHAR(60),
    data_nascimento DATE,
    sexo VARCHAR(1),
    logradouro VARCHAR(60),
    numero INT,
    setor VARCHAR(40),
    cidade VARCHAR(40),
    uf VARCHAR(2)
);


CREATE TABLE agendas (
    id INT PRIMARY KEY,
    data DATE,
    hora TIME,
    situacao VARCHAR(10),
    data_situacao DATE,
    observacoes VARCHAR(200),
    usuario_id INT,
    vacina_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (vacina_id) REFERENCES vacinas(id)
);

CREATE TABLE alergias (
    id INT PRIMARY KEY,
    nome VARCHAR(40)
);

CREATE TABLE usuarios_alergias (
    id_usuario INT,
    id_alergia INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_alergia) REFERENCES alergias(id)
);


