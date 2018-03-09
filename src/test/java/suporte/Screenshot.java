package suporte;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void take(WebDriver navegador,String file) {
		File screenshot =((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(file));
		} catch (IOException e) {
			System.out.println("Houveram problemas para copiar o arquivo para a pasta:"+e.getMessage());
		}
		
	}

}
