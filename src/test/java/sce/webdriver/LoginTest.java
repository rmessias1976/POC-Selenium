package sce.webdriver;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import sce.interfaces.Login;
import util.LeitorCSV;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginTest extends ExecutionContext implements Login {
	
	public final static Path MODEL_PATH = Paths.get("sce/webdriver/Login.graphml");
	
	//WebDriver Objects
	public static WebDriver driver; 
	
	//Object Pages
	protected static LoginPage loginPage; 
	protected static HomePage homePage;
	
	@Override
	public void e_init() {
		// TODO Parametrizar a tela inicial do serviço
		driver.get("http://107.178.218.180/sce-web-ref2/visao/index.jsp");
		loginPage = new LoginPage(driver);
		System.out.println("e_init");
	}	
	
	@Override
	public void v_Menu() {
		homePage.AssertStatus(StatusSistema.Esperando_Acao);
		System.out.println("v_Menu");
	}

	@Override
	public void e_LoginInvalido() {
		// TODO Auto-generated method stub
		loginPage.LoginInvalido();
		System.out.println("e_LoginInvalido = " + loginPage.assertMensagemErroLogin());
	}

	@Override
	public void v_Login() {
		// TODO Auto-generated method stub
		loginPage.AssertStatus(StatusSistema.Esperando_Login);
		System.out.println("v_Login");		
	}

	@Override
	public void e_Sair() {
		// TODO Auto-generated method stub
		homePage.Sair();
		System.out.println("e_sair");
	}

	@Override
	public void e_LoginValido() {
		homePage =  loginPage.LoginValido();
		System.out.println("e_LoginValido");
	}
	
    @Test
    public void runFunctionalTest() {

    	//TODO: Implementar um abstractFactory para instanciar diferentes navegadores
		driver = new FirefoxDriver();
    			
		//TODO: Alguma coisa parece que faz com que o driver fique parado ao final do teste.  Não sei se é pq dá um erro em algum ponto...
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new LoginTest())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
            .setStart("e_init")
            .execute();
        
        driver.quit();
    }


}
