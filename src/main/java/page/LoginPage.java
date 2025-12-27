package page;

import com.microsoft.playwright.Page;
import config.ConfigLoader;
import io.qameta.allure.Allure;
import utils.ScreenshotUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    private final Page page;

    private static final String USER = "#user-name";
    private static final String PASS = "#password";
    private static final String BTN_LOGIN = "#login-button";
    private static final String INVENTORY_LIST = ".inventory_list";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void abrirSite() {
        Allure.step("Navegando para o site SauceDemo");
        String url = ConfigLoader.getUrlSauceDemo();
        page.navigate(url);
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
    }

    public void logar(String usuario, String senha) {
        Allure.step("Realizando login com o usuário: " + usuario);
        page.fill(USER, usuario != null ? usuario : "");
        page.fill(PASS, senha != null ? senha : "");
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
        page.click(BTN_LOGIN);
    }

    public void validarLoginSucesso() {
        Allure.step("Validando se a vitrine de produtos está visível");
        assertTrue(page.isVisible(INVENTORY_LIST), "Erro: Navegação pós-login falhou!");
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
    }

    public void validarMensagemErro(String msg) {
        Allure.step("Validando se a mensagem de erro contém: " + msg);
        String erro = page.textContent("[data-test='error']");
        assertTrue(erro.contains(msg), "Mensagem de erro não encontrada!");
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
    }
}