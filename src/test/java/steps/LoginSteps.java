package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import page.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    @Before(order = 1)
    public void initPages() {
        this.loginPage = new LoginPage(Hooks.getPage());
    }

    @Dado("que estou na página de login do SauceDemo")
    public void navegar() {
        loginPage.abrirSite();
    }

    @Quando("tento logar com o usuário {string} e senha {string}")
    public void logar(String usuario, String senha) {
        loginPage.logar(usuario, senha);
    }

    @Então("devo validar o resultado esperado {string}")
    public void validarResultado(String resultado) {
        if (resultado.equals("LOGIN_SUCESSO")) {
            loginPage.validarLoginSucesso();
        } else {
            loginPage.validarMensagemErro(resultado);
        }
    }
}