package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Utils;

public class Carrinho {

	private WebDriver driver;

	public Carrinho(WebDriver driver) {
		this.driver = driver;
	}

	// seletores
	By labelFinalizarPedido = By.xpath("//h2[text() = 'Finalizar Pedido']");
	By opcaoMaisBrigadeiro = By.xpath("//div[@id = 'add-product-4-qtd']");
	By btnFinalizarCompra = By.xpath("//button[@id='finish-checkout-button']");
	By labelPedidoSucesso = By.xpath("//h2[text() = 'Pedido realizado com sucesso!']");
	By btnFechar = By.xpath("//button[text() = 'Fechar']");
	By opcaoMaisRisolis = By.xpath("//div[@id = 'add-product-3-qtd']");
	By opcaoMenosRisolis = By.xpath("//div[@id = 'remove-product-3-qtd']");
	By valorTotal = By.xpath("//p[@id = 'subtotal-price']");

	public void validarPaginaCarrinhoCarregada() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(labelFinalizarPedido));

		Utils.takeScreenshot(driver);

	}

	public void aumentarQtdBrigadeiro() {

		for (int i = 0; i < 3; i++) {
			driver.findElement(opcaoMaisBrigadeiro).click();

			Utils.takeScreenshot(driver);
		}

	}

	public void cliqueFinalizarCompra() {
		driver.findElement(btnFinalizarCompra).click();

		Utils.takeScreenshot(driver);
	}

	public boolean mensagemPedidoFinalizado() {
		return driver.findElement(labelPedidoSucesso).isDisplayed();

	}

	public String getMensagemPedidoFinalizado() {
		return driver.findElement(labelPedidoSucesso).getText();

	}

	public void fecharJanela() {
		driver.findElement(btnFechar).click();

		Utils.takeScreenshot(driver);

	}

	public void aumentarQtdRisolis() {

		for (int i = 0; i < 8; i++) {
			driver.findElement(opcaoMaisRisolis).click();
		}

		Utils.takeScreenshot(driver);

	}

	public void diminuirQtdRisolis() {

		for (int i = 0; i < 4; i++) {
			driver.findElement(opcaoMenosRisolis).click();

		}
		
		Utils.takeScreenshot(driver);

	}

	public boolean validarValorTotal() {
		return driver.findElement(valorTotal).isDisplayed();

	}

	public String getValorTotal() {
		return driver.findElement(valorTotal).getText();

	}

}
