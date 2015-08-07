package sce.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstagioSuperPage extends ObjectPage {
	By btVoltarLocator = By.name("btnVoltar");
	
	public EstagioSuperPage(WebDriver driver) {
		super(driver);
		if (!"Controle de Estagio".equals(driver.getTitle())){
			throw new IllegalStateException("Esta não é a página home.");
		}
		this.statusAtual = StatusSistema.Esperando_Acao_EstagioSuper;		
	}

	public HomePage Voltar(){
		driver.findElement(btVoltarLocator).click();
		return new HomePage(driver);
	}
}
