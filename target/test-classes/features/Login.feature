# language: pt
Funcionalidade: Login
  Eu como usuário do sistema
  Desejo realizar o login no sistema
  Para realizar minhas atividades

  Esquema do Cenário: Realizar login na pagina RCremonez
    Dado que informo o usuario "<usuario>" e a senha "<senha>"
    Quando clico no botão entrar
    Então sistema apresentará uma mensagem de "<mensagem>"
    Exemplos:
      | usuario           | senha  | mensagem                       |
      | admin@teste.com   | teste  | Login bem-sucedido!            |
      |                   |        | Preencha todos os campos.      |
      | admin             | teste  | Usuário inválido               |
      | teste@teste.com   | teste  | Usuário inválido               |
      | admin@teste.com   | test   | Usuário ou senha inválido.     |
      | .                 | .      | Falha Proposital               |