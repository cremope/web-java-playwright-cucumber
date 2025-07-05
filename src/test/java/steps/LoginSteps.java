package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import page.LoginPage;
import utils.ScreenshotUtil;

public class LoginSteps {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    LoginPage loginPage;

    @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(400)
        );
        page = browser.newPage();
        loginPage = new LoginPage(page);
    }

    @After
    public void teardown() {
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
        browser.close();
        playwright.close();
    }

    @Dado("que informo o usuario {string} e a senha {string}")
    public void que_informo_o_usuario_e_a_senha(String usuario, String senha) {
        loginPage.abrirSite("https://cremope.github.io/RCremonez/");
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
    }

    @Quando("clico no botão entrar")
    public void clico_no_botao_entrar() {
        loginPage.clicarEntrar();
    }

    @Então("sistema apresentará uma mensagem de {string}")
    public void sistema_apresentara_uma_mensagem(String mensagemEsperada) {
        loginPage.ValidaMensagem(mensagemEsperada);
    }
}
