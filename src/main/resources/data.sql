INSERT INTO estabelecimento
(nome, logradouro, email, senha, numero, cep, cnpj, tags, horario_abertura, horario_fechamento)
VALUES
('Terraço','Rua terraço', 'terraco@email.com', '123', '16', '0491400', '159753', 'Batata frita com torresmo, Torre de chopp, Jazz', '16:00', '23:00');

INSERT INTO assento
(disponivel)
VALUES (false);

INSERT INTO assento
(disponivel)
VALUES (false);

INSERT INTO assento
(disponivel)
VALUES (true);

INSERT INTO usuario
(nome, email, cpf, dt_nasc, rg, senha, tags)
VALUES
    ('João', 'joao@email.com', '12345678900', '2000-10-10', '123456789', '123', 'Batata frita com torresmo, Torre de chopp, Jazz');

INSERT INTO usuario
(nome, email, cpf, dt_nasc, rg, senha, tags)
VALUES
    ('Alex', 'alex@email.com', '12345678900', '1995-10-29', '123456789', 'AlexTeste123', 'Batata frita com torresmo, Torre de chopp, Jazz');

INSERT INTO reserva
(dt_reserva, hora_reserva, check_in, dt_hora_check_in, check_out, dt_hora_check_out)
VALUES
    ('2023-10-10', '17:30:00', false, null, false, null);

INSERT INTO reserva
(dt_reserva, hora_reserva, check_in, dt_hora_check_in, check_out, dt_hora_check_out)
VALUES
    ('2023-11-10', '17:30:00', false, null, false, null);

INSERT INTO estabelecimento_assentos
VALUES (1,1);

INSERT INTO estabelecimento_assentos
VALUES (1,2);

INSERT INTO estabelecimento_assentos
VALUES (1,3);

INSERT INTO estabelecimento_reservas
VALUES (1,1);

INSERT INTO estabelecimento_reservas
VALUES (1,2);

INSERT INTO usuario_reservas
VALUES (1,1);

INSERT INTO usuario_reservas
VALUES (2,2);

INSERT INTO reserva_assentos
VALUES (1,1);

INSERT INTO reserva_assentos
VALUES (2,2);