INSERT INTO tb_usuario (cpf, curso, email, matricula, nome, senha, tipo_contribuidor) VALUES ('25012025456', 'Sistemas de Informação', 'vpc@ufv.br', 5973, 'Victor Paiva', 'vpcastro00', 0);
INSERT INTO tb_usuario (cpf, curso, email, matricula, nome, senha, tipo_contribuidor) VALUES ('85214565788', 'Engenharia de Dados', 'rachel@ufv.br', 4444, 'Rachel Reis', 'rachel200', 1);
INSERT INTO tb_usuario (cpf, curso, email, matricula, nome, senha, tipo_contribuidor) VALUES ('25668445223', 'Sistemas de Informação', 'dudu@ufv.br', 6021, 'Eduardo Nunes', 'dudu85', 0);

INSERT INTO tb_trabalho (area, descricao, titulo, avaliacao) VALUES ('Tecnologia da Informação', 'Melhor trabalho do Brasil', 
'Rede Social para TCC - PaperTree', 5);
INSERT INTO tb_trabalho (area, descricao, titulo, avaliacao) VALUES ('Tecnologia da Informação', 'Não é o melhor trabalho do Brasil', 
'Script para detecção de vírus', 2);
INSERT INTO tb_trabalho (area, descricao, titulo, avaliacao) VALUES ('Tecnologia da Informação', 'Não é o melhor trabalho do Brasil', 
'Software para calcular melhores rotas', 1);

INSERT INTO tb_trabalho_contribuidores (trabalho_fk, contribuidores_fk) VALUES (1, 1);
INSERT INTO tb_trabalho_contribuidores (trabalho_fk, contribuidores_fk) VALUES (1, 3);
INSERT INTO tb_trabalho_contribuidores (trabalho_fk, contribuidores_fk) VALUES (1, 2);
INSERT INTO tb_trabalho_contribuidores (trabalho_fk, contribuidores_fk) VALUES (2, 2);

INSERT INTO tb_notificacao (titulo) VALUES ('Rachel curtiu sua publicação');
INSERT INTO tb_notificacao (titulo) VALUES ('A UFV já disponibilizou o edital 2022');
INSERT INTO tb_notificacao (titulo) VALUES ('As aulas presenciais terão retorno depois de abril');

INSERT INTO tb_postagem (trabalho_fk) VALUES (1);
INSERT INTO tb_postagem (trabalho_fk) VALUES (2);
INSERT INTO tb_postagem (trabalho_fk) VALUES (3);
 
INSERT INTO tb_usuario_postagem_salva (usuario_fk, postagem_salva_fk) VALUES (1, 1);
INSERT INTO tb_usuario_postagem_salva (usuario_fk, postagem_salva_fk) VALUES (1, 2);
INSERT INTO tb_usuario_postagem_salva (usuario_fk, postagem_salva_fk) VALUES (3, 3);

INSERT INTO tb_comentario (texto, usuario_fk, postagem_fk) VALUES ('Parabens pelo TCC', 1, 1);
INSERT INTO tb_comentario (texto, usuario_fk, postagem_fk) VALUES ('Parabens pelo TCC', 1, 2);
INSERT INTO tb_comentario (texto, usuario_fk, postagem_fk) VALUES ('Parabens pelo TCC', 3, 3);

INSERT INTO tb_curtida (usuario_fk, postagem_fk, comentario_fk) VALUES (1, 1, 2);
INSERT INTO tb_curtida (usuario_fk, postagem_fk, comentario_fk) VALUES (1, 1, 3);
INSERT INTO tb_curtida (usuario_fk, postagem_fk, comentario_fk) VALUES (3, 2, 1);

INSERT INTO tb_usuario_notificacao (visualizado, notificacao_id, usuario_id) VALUES (false, 1, 1);
INSERT INTO tb_usuario_notificacao (visualizado, notificacao_id, usuario_id) VALUES (false, 2, 1);
INSERT INTO tb_usuario_notificacao (visualizado, notificacao_id, usuario_id) VALUES (false, 3, 2);
