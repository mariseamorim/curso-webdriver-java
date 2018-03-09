package teste;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Genarator;
import suporte.Screenshot;
import suporte.Web;


public class InformacoesUsuarioTest {
	private WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();
	
	@Before
	public void setUp() {
		navegador = Web.createChrome();
		
		// Clicar no link que possui o texto "Sign in"
		navegador.findElement(By.linkText("Sign in")).click();
		
		// Identificando o formulário de Login
		WebElement formularioSingInBox = navegador.findElement(By.id("signinbox"));
		
		// Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "marise.amorim"
		formularioSingInBox.findElement(By.name("login")).sendKeys("marise.amorim");
		
		// Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
		formularioSingInBox.findElement(By.name("password")).sendKeys("123456");
		
		
		// Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		//Clicar em um link que possui a class 'me'
		navegador.findElement(By.className("me")).click();
		
		//Clicar em um link que possui o text 'More data about you'
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
	}
	
	//@Test
	public void testAdicionarUmaInformacaoAdiconalDoUsuario(){
		
		//Clicar no botão atraves do xpath
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		//identificar a popup onde está o formulario com id="addmoredata"
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
		//No combo com nome 'type' escolher a opção 'Phone'
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		
		//No campo com nome 'Phone' digitar o numero'+5511997920225'
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511997920225");
		
		//No link de text de "SAVE" que está na popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		//Na mensagem de id 'toast-container' validar que o texto é "Your contact has been added!"
		
		WebElement menssagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = menssagemPop.getText();
		assertEquals("Your contact has been added!", mensagem);
	}
	@Test
	public void removeContactUser() {
		//Clicar no elemento pelo seu xpath //span[text()="+553344777271"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()='+553344777271']/following-sibling::a")).click();
		
		//confirmar janela javascript
		navegador.switchTo().alert().accept();
		
		//validar se a mensagem apresentada foi "Rest in peace, dear phone!"
		WebElement msg = navegador.findElement(By.id("toast-container"));
		String mes = msg.getText();
		assertEquals("Rest in peace, dear phone!", mes);
		String screenshotFile = "C:\\Users\\Mari\\test-report\\taskit"+ Genarator.dateHourForFile()+test.getMethodName()+".png";
		Screenshot.take(navegador,screenshotFile);
		
		
		
		//Aguardar até 10 segundos para que a janela desapareça
		WebDriverWait aguardar =new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(msg));
		//Fazer logout e clicar no link com nome "logout"
		navegador.findElement(By.linkText("Logout")).click();
	}
	@After
	public void tearDown() {
		navegador.quit();
	}

}

