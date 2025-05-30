package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {

    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    public static final String URL_LEILOES = "http://localhost:8080/leiloes";

    public LeiloesPage(WebDriver browser) {
        super(browser);
    }

    public CadastroLeilaoPage carregarFormulario() {
        browser.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement linhaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        return colunaNome.getText().equals(nome)
                && colunaDataAbertura.getText().equals(data)
                && colunaValorInicial.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_LEILOES);
    }
}
