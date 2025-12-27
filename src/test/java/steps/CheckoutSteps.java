package steps;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import page.LoginPage;
import page.CheckoutPage;

public class CheckoutSteps {
    private LoginPage loginPage;
    private CheckoutPage checkoutPage;

    @Before(order = 1)
    public void initPages() {
        Page page = Hooks.getPage();
        this.loginPage = new LoginPage(page);
        this.checkoutPage = new CheckoutPage(page);
    }

    @Quando("realizo login com o usuário {string} e senha {string}")
    public void loginNoCheckout(String usuario, String senha) {
        loginPage.abrirSite();
        loginPage.logar(usuario, senha);
    }

    @Quando("adiciono o produto {string} ao carrinho")
    public void addProduto(String prod) {
        checkoutPage.adicionarProduto(prod);
    }

    @Quando("prossigo para o checkout preenchendo {string}, {string} e {string}")
    public void preencherDados(String nome, String sobrenome, String cep) {
        checkoutPage.iniciarCheckout(nome, sobrenome, cep);
    }

    @Então("a compra deve ser finalizada com sucesso")
    public void finalizar() {
        checkoutPage.finalizar();
        checkoutPage.validarCompraFinalizada();
    }

    @Então("devo ver o erro de checkout {string}")
    public void validarErro(String msg) {
        checkoutPage.validarErroCheckout(msg);
    }
}