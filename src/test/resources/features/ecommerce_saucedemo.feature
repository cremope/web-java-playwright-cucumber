# language: pt
Funcionalidade: Validar ecommerce SauceDemo

  Contexto:
    Dado que estou na página de login do SauceDemo

  @login
  Esquema do Cenário: Validar Login e Navegação
    Quando tento logar com o usuário "<usuario>" e senha "<senha>"
    Então devo validar o resultado esperado "<resultado>"

    Exemplos:
      | usuario         | senha          | resultado                                           |
      | standard_user   | secret_sauce   | LOGIN_SUCESSO                                       |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out. |
      | standard_user   | senha_errada   | Epic sadface: Username and password do not match    |
      |                 |                | Epic sadface: Username is required                  |

  @checkout
  Cenário: Fluxo de Checkout Completo
    Quando tento logar com o usuário "standard_user" e senha "secret_sauce"
    E adiciono o produto "Sauce Labs Backpack" ao carrinho
    E prossigo para o checkout preenchendo "Joao", "Silva" e "12345"
    Então a compra deve ser finalizada com sucesso

  @checkout_negativo
  Cenário: Validar erro no checkout - CEP ausente
    Quando tento logar com o usuário "standard_user" e senha "secret_sauce"
    E adiciono o produto "Sauce Labs Backpack" ao carrinho
    E prossigo para o checkout preenchendo "Joao", "Silva" e ""
    Então devo ver o erro de checkout "Error: Postal Code is required"