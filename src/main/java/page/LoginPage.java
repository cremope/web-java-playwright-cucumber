package page;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final String inputUsuario = "#usuario";
    private final String inputSenha = "#senha";
    private final String btnEntrar = "#btn-entrar";
    private final String lblMensagem = "#mensagem";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void abrirSite(String url) {
        this.page.navigate(url);
    }

    public void preencherUsuario(String usuario) {
        page.fill(inputUsuario, usuario);
    }

    public void preencherSenha(String senha) {
        page.fill(inputSenha, senha);
    }

    public void clicarEntrar() {
        page.click(btnEntrar);
    }

    public void ValidaMensagem(String mensagemEsperada) {
        page.waitForSelector("#mensagem");
        String mensagemTela = page.textContent(lblMensagem).trim();
        if (!mensagemTela.equals(mensagemEsperada)) {
            throw new AssertionError("Mensagem esperada: '" + mensagemEsperada + "' Mensagem encontrada: '" + mensagemTela + "'");
        }
    }
}