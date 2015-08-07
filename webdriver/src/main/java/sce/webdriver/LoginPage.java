package sce.webdriver;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.LeitorCSV;

/**
 * Hello world!
 *
 */
public class LoginPage extends ObjectPage{
	
	By txNomeUsuarioLocator = By.name("txtRA");
	By txSenhaUsuarioLocator = By.name("txtSenha");
	By btLoginLocator = By.name("botao");
	By lbLabelMesgErro = By.xpath("//div[@id='formulario3']/form/label");

	public final String MENSAGEM_ERRO_LOGIN = "Dados inv?lidos!";
	
	static LeitorCSV massaDados;
	
	/**
	 * Construtor da página.
	 * Caso o driver passado não esteja na página de login, 
	 * gera-se uma mensagem de erro.
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
		//verifico se a página realmente é a página de login
		if (!"Login".equals(driver.getTitle())){
			throw new IllegalStateException("Esta não é a página de login");
		}
		
		//TODO: Parametrizar a origem do arquivo que contem a massa de dados
		massaDados = new LeitorCSV("src/main/java/util/testecsv.csv");
		this.statusAtual = StatusSistema.Esperando_Login;
	}
	
	public LoginPage informarNome(String nomeUsuario){
		driver.findElement(txNomeUsuarioLocator).clear();
		driver.findElement(txNomeUsuarioLocator).sendKeys(nomeUsuario);
		return this;
	}

	public LoginPage informarSenha(String senhaUsuario){
		driver.findElement(txSenhaUsuarioLocator).sendKeys(senhaUsuario);
		return this;
	}
	
	public String getMensagemErroLogin(){
		String retorno = "";
		driver.findElement(lbLabelMesgErro).getText();
		return retorno;
	}
	
	public boolean assertMensagemErroLogin(){
//		return this.getMensagemErroLogin().equals(MENSAGEM_ERRO_LOGIN);
		return false;
	}
	
	public HomePage LoginValido(){
		//obtem a massa de dados do login valido
		Map<String, String> meuRegistro = massaDados.getRecord("1");
		
		//informa os dados do login
		informarNome(meuRegistro.get("usuario"));
		informarSenha(meuRegistro.get("senha"));
		
		//clicar em Login
		driver.findElement(btLoginLocator).submit();
		
		return new HomePage(driver);
	}
	
	public LoginPage LoginInvalido(){
		//obtem a massa de dados do login valido
		Map<String, String> meuRegistro = massaDados.getRecord("2");
		
		//informa os dados do login
		informarNome(meuRegistro.get("usuario"));
		informarSenha(meuRegistro.get("senha"));
		
		//clicar em Login
		driver.findElement(btLoginLocator).submit();

		return new LoginPage(driver);		
	}
	
}
