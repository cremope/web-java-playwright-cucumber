package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static void capturarEAnexar(Page page, String nomeArquivo) {
        try {
            Path path = Paths.get("target/allure-results", nomeArquivo + ".png");
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(path)
                    .setFullPage(true));
            anexarPrint(path, nomeArquivo);
        } catch (Exception e) {
            System.err.println("Erro ao capturar ou anexar screenshot: " + e.getMessage());
        }
    }

    @Attachment(value = "{nome}", type = "image/png")
    private static byte[] anexarPrint(Path path, String nome) throws Exception {
        return Files.readAllBytes(path);
    }
}
