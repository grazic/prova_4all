package support;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Utils {
	
	static int screenshotCount = 0;
	
	//Método para tirar screenshot
	//Para visualizar as imagens, atualizar o projeto após execução. Na pasta src/screenshot será exibida as imagens
	public static void takeScreenshot(WebDriver driver) {	
		
		TakesScreenshot driverScr = (TakesScreenshot)driver;
		byte[] scr = driverScr.getScreenshotAs(OutputType.BYTES);
		try {
			Files.write(scr, new File("src/screenshot" + screenshotCount + ".png"));
			screenshotCount++;
			// FileUtils.copyFile(scrFile, new File(
			// "C:\\Users\\graziela.cerentini\\eclipse-workspace\\studyingAutomation\\studyingAutomation\\screenshot"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
