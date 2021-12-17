package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("realiza o login")
    public void realiza_o_login() {
        leiloesPage = loginPage.realizaLoginComoFulano();
    }

    @Entao("é redirecionado para a pagina de leiloes")
    public void é_redirecionado_para_a_pagina_de_leiloes() {
        assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }

    @Dado("o usuario invalido")
    public void o_usuario_invalido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("tenta se logar")
    public void tenta_se_logar() {
        loginPage.realizaLoginComo("fulano", "xpto");
    }

    @Entao("continua na pagina de login")
    public void continua_na_pagina_de_login() {
        assertTrue(loginPage.estaNaPaginaDeLoginComErro());
        browser.clean();
    }

}
