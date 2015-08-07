package sce.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConvenioPage extends ObjectPage {
	By btVoltarLocator = By.name("btnVoltar");
	
	public ConvenioPage(WebDriver driver) {
		super(driver);
		if (!"Controle de Convenio".equals(driver.getTitle())){
			throw new IllegalStateException("Esta não é a página home.");
		}
		this.statusAtual = StatusSistema.Esperando_Acao_Convenio;		
	}

	public HomePage Voltar(){
		driver.findElement(btVoltarLocator).click();
		return new HomePage(driver);
	}
}
