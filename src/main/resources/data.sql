INSERT INTO estabelecimento
(nome, logradouro, numero, cep, cnpj, qt_areas, tipo_comida, tipo_bebida, tipo_musica)
VALUES
('Terrço','Rua terraço','58913019', 0491400, 159753, 5, 'Boa', 'Liquida', 'Audivel');

insert into assento
(disponivel)
values (true);

insert into usuario
(nome, email, cpf, dt_nasc, rg, senha, tipo_comida, tipo_bebida, tipo_musica)
values
('João', 'joao@email.com', '12345678900', '2000-10-10', '123456789', '123', 'boa', 'alcool', 'rock');

insert into reserva
(dt_hora_reserva, check_in, dt_hora_check_in, check_out, dt_hora_check_out)
values
('2023-10-10 10:10:10', false, '2023-10-10 10:10:10', false, '2023-10-10 10:10:10');

insert into estabelecimento_assentos values (1,1);
insert into estabelecimento_reservas values (1,1);
insert into reserva_assentos values (1,1);