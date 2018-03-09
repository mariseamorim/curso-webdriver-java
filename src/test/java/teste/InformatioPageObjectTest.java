package teste;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import suporte.Web;

public class InformatioPageObjectTest {
	private WebDriver navegador;
	
	@Before
	public void setUp() {
		navegador = Web.createChrome();
	}
	@Test
	public void testAdicionarUmaInformacaoAdiconalDoUsuario() {
		String textToast = new LoginPage(navegador)
			.clickSignIn()
			.fazerLogin("marise.amorim", "123456")
			.clicarMe()
			.clicarAbaMoreDataAboutYou()
			.clicarButtonMoreDataAboutYou()
			.addContact("Phone", "+5511992310324")
			.capturarTextToast();
		
	   assertEquals("Your contact has been added!", textToast);
	}
	;
	@After
	public void tearDown() {
		navegador.quit();
	}
	
	

}
