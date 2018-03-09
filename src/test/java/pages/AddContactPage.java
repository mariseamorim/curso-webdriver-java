package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {

	public AddContactPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	public AddContactPage escolherTypeContact(String type) {
		WebElement campoType = navegador.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		
		return this;
	}
	public AddContactPage writeContact(String contato) {
		navegador.findElement(By.name("contact")).sendKeys(contato);
		return this;
	}
	public MePage clicarSalvar() {
		navegador.findElement(By.linkText("SAVE")).click();
		
		return new MePage(navegador);
	}
   public MePage addContact(String type,String contact) {
	   escolherTypeContact(type);
	   writeContact(contact);
	   clicarSalvar();
	   return new MePage(navegador);
   }
}
