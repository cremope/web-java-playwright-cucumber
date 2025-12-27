# web-java-playwright-cucumber

Projeto de automação de testes E2E (End-to-End) utilizando Java, Playwright e Cucumber, com execução via GitHub Actions e publicação de relatórios no GitHub Pages. Testaremos a aplicação:

[SauceDemo (Swag Labs)](https://www.saucedemo.com/)

## Dependências
- JDK: 17
- Apache Maven: 3.13.0
- Playwright: 1.51.0
- Cucumber: 7.20.1
- JUnit: 5.11.3
- Allure Report: 2.29.0

## Estrutura do Projeto
- Features: Cenários de negócio escritos em Gherkin (BDD).
- Steps: Implementação da lógica de teste utilizando Playwright.
- Page Objects: Encapsulamento de seletores e interações da interface.
- Hooks: Gerenciamento do ciclo de vida do browser

## Estrutura de pastas
```
web-java-playwright-cucumber/
├── .github/workflows/          # Configuração do Pipeline (CI/CD)
├── ScreenShots/                # Evidências visuais para o README
├── src/
│   ├── main/java/
│   │   ├── config/             # Carregamento de propriedades (ConfigLoader)
│   │   └── page/               # Classes de Page Object Model (POM)
│   └── test/
│       ├── java/
│       │   ├── runners/        # Classe de execução do JUnit/Cucumber (TestRunner)
│       │   ├── steps/          # Definições dos passos e Hooks
│       └── resources/
│           ├── config/         # Arquivos de configuração (.properties)
│           └── features/       # Especificações de teste em Gherkin (.feature)
|
├── pom.xml                     # Gerenciador de dependências e plugins
└── README.md                   # Documentação do projeto
```
## Instalação
Baixando as dependências

```bash
  cd web-java-playwright-cucumber
  mvn install
```

## Rodando os testes
Para rodar os testes, rode o seguinte comando

```bash
  mvn clean verify test
```

## Alternando variáveis (CLI):
```bash
Sem headless:
  mvn test -Dheadless=false
Com headless:
  mvn test -Dheadless=true
```
Obs: Padrão do projeto é rodar com headless (true)

## Relatório dos testes
Gerar o Allure Report

```bash
  allure serve target/allure-results
  allure serve --sigle-file target/allure-results
```

Apagar o Allure Report de execuções anteriores

```bash
  allure generate --clean --output target/allure-results
```

Para visualizar o relatório de testes [Clique aqui](https://cremope.github.io/web-java-playwright-cucumber/)

## ScreenShots
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Overview.png" width="400" /> 
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Suites.png" width="400" />
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Suites_2.png" width="400" />
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Suites_3.png" width="400" />
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Suites_4.png" width="400" />
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Suites_5.png" width="400" />
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/main/ScreenShots/Allure_Suites_6.png" width="400" />

