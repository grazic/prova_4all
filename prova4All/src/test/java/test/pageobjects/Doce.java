package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Utils;

public class Doce {
	
	private WebDriver driver;
	
	
	//seletores
	By opcaoDoce = By.xpath("//h2[text() = 'Doces']");
	By opcaoBrigadeiro = By.xpath("//button[@id='add-product-4-btn']");
	By opcaoAlfajor = By.xpath("//button[@id='add-product-5-btn']");
	By btnTodos = By.xpath("//li[@id='category-all']");
	By btnCategorias = By.xpath("//div[@id='open-categories-btn']");
		
	public Doce(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void validarPaginaDocesCarregada() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(opcaoDoce));
	}
	
	public void addProdutoNoCarrinho() {
		driver.findElement(opcaoBrigadeiro).click();
		driver.findElement(opcaoAlfajor).click();
		
		Utils.takeScreenshot(driver);
		
	}
	
	public void selecionarCatTodos() {
		driver.findElement(btnCategorias).click();
		driver.findElement(btnTodos).click();
		
		Utils.takeScreenshot(driver);
	}
}
