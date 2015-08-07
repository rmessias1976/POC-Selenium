package sce.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackupPage extends ObjectPage {
	By btVoltarLocator = By.name("btnVoltar");
	
	public BackupPage(WebDriver driver) {
		super(driver);
		if (!"Backup".equals(driver.getTitle())){
			throw new IllegalStateException("Esta não é a página home.");
		}
		this.statusAtual = StatusSistema.Esperando_Acao_Backup;		
	}

	public HomePage Voltar(){
		driver.findElement(btVoltarLocator).click();
		return new HomePage(driver);
	}
}
