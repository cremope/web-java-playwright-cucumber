# web-java-playwright-cucumber

Projeto de automação de testes web utilizando Playwright e Cucumber, executando via GitHub Actions e relatório do GitHub Pages.

## Dependências
- JDK: 17
- Apache Maven: 3.6.3
- Playwright: 1.51.0
- Cucumber: 7.20.1
- JUnit: 5.11.3
- Allure Report: 2.29.0

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
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/develop/screenshots/Allure_Overview.PNG" width="400" /> 
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/develop/screenshots/Allure_Suites_OK.PNG" width="400" />
<img src="https://github.com/cremope/web-java-playwright-cucumber/blob/develop/screenshots/Allure_Suites_NOK.PNG" width="400" /> 
