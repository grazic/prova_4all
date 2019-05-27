package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Utils;

public class Home {

	private WebDriver driver;

	// Seletores
	By header4All = By.xpath("//img[@class = 'brand-logo sc-dxgOiQ fvppk']");
	By btnCategoria = By.xpath("//div[@id='open-categories-btn']");
	By popupCategoria = By.xpath("//ul[@class = 'sc-eNQAEJ bBoBAk']");
	By btnDoces = By.xpath("//li[@id='category-1']");
	By btnTodos = By.xpath("//li[@id='category-all']");
	By btnCategorias = By.xpath("//div[@id='open-categories-btn']");
	By btnCarrinho  = By.xpath("//button[@id = 'cart-btn']");
	By btnBebidas = By.xpath("//li[@id='category-0']");
	By btnRisolis = By.xpath("//button[@id='add-product-3-btn']");

	
	public Home(WebDriver driver) {
		this.driver = driver;	
	}

	public void validarPaginaHomeCarregada() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(header4All));
		
		Utils.takeScreenshot(driver);
	}
	

	public void validarCategoriaCarregada() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(popupCategoria));
		
		Utils.takeScreenshot(driver);
	}
	
	public void cliqueCategoriaDoces() {
		driver.findElement(btnCategorias).click();
		driver.findElement(btnDoces).click();
		
		Utils.takeScreenshot(driver);
		
	}	
	
	public void cliqueCarrinho() {
		driver.findElement(btnCarrinho).click();
		
	}
	
	public void cliqueCategoriaBebidas() {
		driver.findElement(btnCategorias).click();
		driver.findElement(btnBebidas).click();
		
	}
	
	public void addProduto() {
		driver.findElement(btnRisolis).click();
		
	}
	
}
