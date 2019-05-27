package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Utils;

public class Bebida {
	
	
private WebDriver driver;
	
	
	//seletores
	By opcaoBebida = By.xpath("//h2[text() = 'Bebidas']");
	By opcaoCoca = By.xpath("//button[@id='add-product-0-btn']");
	By opcaoFanta = By.xpath("//button[@id='add-product-1-btn']");
	By opcaoAgua = By.xpath("//button[@id='add-product-2-btn']");
	By btnTodos = By.xpath("//li[@id='category-all']");
	By btnCategorias = By.xpath("//div[@id='open-categories-btn']");

	
	public Bebida(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void validarPaginaBebidaCarregada() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(opcaoBebida));
		
		Utils.takeScreenshot(driver);
	}
	
	public void addProdutoNoCarrinho() {
		driver.findElement(opcaoCoca).click();
		driver.findElement(opcaoFanta).click();
		driver.findElement(opcaoAgua).click();
		
		Utils.takeScreenshot(driver);		
	}

	public void selecionarCatTodos() {
		driver.findElement(btnCategorias).click();
		driver.findElement(btnTodos).click();
		
		Utils.takeScreenshot(driver);
	}
}
