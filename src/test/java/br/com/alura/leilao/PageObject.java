package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers2/chromedriver.exe");
        this.browser = Objects.isNull(browser) ? new ChromeDriver() : browser;
    }

    public void fechar() {
        this.browser.quit();
    }
}
