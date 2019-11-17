package test.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import support.Connect;
import support.Utils;
import test.pageobjects.Carrinho;
import test.pageobjects.Doce;
import test.pageobjects.Home;

public class Desafio1 {

	private static WebDriver driver;

	@Test(description = "001 - Dasafio 1")
	public void desafio1() {

		String mensagemPedidoFinalizado = "Pedido realizado com sucesso!".trim().toUpperCase();

		// Instancia páginas
		Connect pConnect = new Connect();

		// Chama método openChrome
		driver = pConnect.openChrome();

		Home pHome = new Home(driver);
		Doce pDoce = new Doce(driver);
		Carrinho pCarrinho = new Carrinho(driver);

		// Valida página Home carregada
		pHome.validarPaginaHomeCarregada();

		// Valida box e clica em categoria de Doces
		pHome.validarCategoriaCarregada();
		pHome.cliqueCategoriaDoces();

		// Valida página Doce carregada
		pDoce.validarPaginaDocesCarregada();

		// Adiciona todos os produtos no carrinho
		pDoce.addProdutoNoCarrinho();

		// Seleciona categoria Todos
		pDoce.selecionarCatTodos();

		// Valida pagina Home carregada
		pHome.validarPaginaHomeCarregada();

		// Clica no carrinho
		pHome.cliqueCarrinho();

		// Valida página Carrinho carregada
		pCarrinho.validarPaginaCarrinhoCarregada();

		// Aumenta quantidade
		pCarrinho.aumentarQtdBrigadeiro();

		// Clica no botão Finalizar Compra
		pCarrinho.cliqueFinalizarCompra();

		// Valida mensagem de sucesso
		assertEquals(pCarrinho.getMensagemPedidoFinalizado().trim().toUpperCase(),
				mensagemPedidoFinalizado.trim().toUpperCase());

		Utils.takeScreenshot(driver);

		// Fechar janela
		pCarrinho.fecharJanela();

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}
}
