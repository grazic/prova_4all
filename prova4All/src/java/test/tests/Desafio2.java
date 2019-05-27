package test.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import support.Connect;
import support.Utils;
import test.pageobjects.Bebida;
import test.pageobjects.Carrinho;
import test.pageobjects.Doce;
import test.pageobjects.Home;

public class Desafio2 {

	private static WebDriver driver;

	@Test(description = "002 - Dasafio 2")
	public void desafio2() {

		String mensagemPedidoFinalizado = "Pedido realizado com sucesso!".trim().toUpperCase();
		String valorTotal = "R$ 36,00".trim().toUpperCase();

		// Instancia páginas
		Connect pConnect = new Connect();

		// Chama método openChrome
		driver = pConnect.openChrome();

		Home pHome = new Home(driver);
		Doce pDoce = new Doce(driver);
		Carrinho pCarrinho = new Carrinho(driver);
		Bebida pBebida = new Bebida(driver);

		// Valida página Home carregada
		pHome.validarPaginaHomeCarregada();

		// Clica categoria Bebida e valida página Bebida carregada
		pHome.cliqueCategoriaBebidas();
		pBebida.validarPaginaBebidaCarregada();

		// Adiciona todos os produtos no carrinho
		pBebida.addProdutoNoCarrinho();

		// Seleciona categoria Todos
		pBebida.selecionarCatTodos();

		// Valida pagina Home carregada
		pHome.validarPaginaHomeCarregada();

		// Adiciona produto risolis médio
		pHome.addProduto();

		// Clica no carrinho
		pHome.cliqueCarrinho();

		// Valida página Carrinho carregada
		pCarrinho.validarPaginaCarrinhoCarregada();

		// Aumenta quantidade de risolis
		pCarrinho.aumentarQtdRisolis();

		// Diminui qunatidade de risolis
		pCarrinho.diminuirQtdRisolis();

		// Valida valor total
		assertEquals(pCarrinho.getValorTotal().trim().toUpperCase(), valorTotal.trim().toUpperCase());

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
