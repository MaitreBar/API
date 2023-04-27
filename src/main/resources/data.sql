INSERT INTO estabelecimento
(nome, logradouro, numero, cep, cnpj, qt_areas, tipo_comida, tipo_bebida, tipo_musica)
VALUES
('Terraço','Rua terraço','58913019', 0491400, 159753, 5, 'Batata frita com torresmo', 'Choop e torre', 'Jass');

INSERT INTO assento
(disponivel)
VALUES (true);

INSERT INTO usuario
(nome, email, cpf, dt_nasc, rg, senha, tipo_comida, tipo_bebida, tipo_musica)
VALUES
('João', 'joao@email.com', '12345678900', '2000-10-10', '123456789', '123', 'Batata frita com torresmo', 'Choop e torre', 'Jass');

INSERT INTO reserva
(dt_hora_reserva, check_in, dt_hora_check_in, check_out, dt_hora_check_out)
VALUES
('2023-10-10 10:10:10', false, '2023-10-10 10:10:10', false, '2023-10-10 10:10:10');

INSERT INTO estabelecimento_assentos
VALUES (1,1);

INSERT INTO estabelecimento_reservas
VALUES (1,1);

INSERT INTO reserva_assentos
VALUES (1,1);