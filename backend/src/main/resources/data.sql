INSERT INTO tb_usuario (nome,email,cpf,matricula,curso,senha,professor) VALUES ('Victor','vcp@ufv.br','12525022542',6021,'Sistemas','00000',false);
INSERT INTO tb_usuario (nome,email,cpf,matricula,curso,senha,professor) VALUES ('Eduardo','dudu@ufv.br','82012085254',6022,'Sistemas','11111',true);
INSERT INTO tb_usuario (nome,email,cpf,matricula,curso,senha,professor) VALUES ('Michel','michel@ufv.br','12525022542',6023,'Engenharia','22222',false);

INSERT INTO tb_notificacao (titulo) VALUES ('Rachel curtiu sua publicação');
INSERT INTO tb_notificacao (titulo) VALUES ('A UFV já disponibilizou o edital 2022');
INSERT INTO tb_notificacao (titulo) VALUES ('As aulas presenciais terão retorno depois de abril');

INSERT INTO tb_usuario_notificacao(visualizado,usuario_id, notificacao_id) VALUES (true,1,1);
INSERT INTO tb_usuario_notificacao(visualizado,usuario_id, notificacao_id) VALUES (true,1,2);
INSERT INTO tb_usuario_notificacao(visualizado,usuario_id, notificacao_id) VALUES (false,2,1);
INSERT INTO tb_usuario_notificacao(visualizado,usuario_id, notificacao_id) VALUES (true,2,2);
INSERT INTO tb_usuario_notificacao(visualizado,usuario_id, notificacao_id) VALUES (false,2,3);
INSERT INTO tb_usuario_notificacao(visualizado,usuario_id, notificacao_id) VALUES (true,3,3);