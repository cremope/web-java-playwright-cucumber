package page;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import utils.ScreenshotUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPage {
    private final Page page;
    private static final String PRODUTO = "//div[contains(@class,'inventory_item_name') and normalize-space()='%s']";
    private static final String BTN_CARRINHO = ".shopping_cart_link";
    private static final String BTN_CHECKOUT = "#checkout";
    private static final String INPUT_FIRST_NAME = "#first-name";
    private static final String INPUT_LAST_NAME = "#last-name";
    private static final String INPUT_POSTAL_CODE = "#postal-code";
    private static final String BTN_CONTINUE = "#continue";
    private static final String BTN_FINISH = "#finish";
    private static final String COMPLETE_HEADER = ".complete-header";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void adicionarProduto(String nomeProduto) {
        Allure.step("Adicionando o produto ao carrinho: " + nomeProduto);

        String xpathProduto = String.format(PRODUTO, nomeProduto);

        page.locator(xpathProduto)
                .locator("xpath=../../..//button")
                .click();
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
    }

    public void iniciarCheckout(String nome, String sobrenome, String cep) {
        Allure.step("Iniciando checkout para: " + nome + " " + sobrenome + " e CEP: " + cep);
        page.click(BTN_CARRINHO);
        page.click(BTN_CHECKOUT);
        page.fill(INPUT_FIRST_NAME, nome);
        page.fill(INPUT_LAST_NAME, sobrenome);
        page.fill(INPUT_POSTAL_CODE, cep);
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
        page.click(BTN_CONTINUE);
    }

    public void finalizar() {

        Allure.step("Finalizando a compra no botão Finish");
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
        page.click(BTN_FINISH);
    }

    public void validarCompraFinalizada() {
        Allure.step("Validando tela de agradecimento pós-compra");
        assertTrue(page.isVisible(COMPLETE_HEADER), "A compra não foi finalizada!");
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
    }

    public void validarErroCheckout(String msg) {
        Allure.step("Validando erro checkout: " + msg);
        String erro = page.textContent("[data-test='error']");
        assertTrue(erro.contains(msg));
        ScreenshotUtil.capturarEAnexar(page, "Evidencia");
    }
}