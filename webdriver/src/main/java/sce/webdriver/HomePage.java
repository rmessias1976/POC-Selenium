package sce.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ObjectPage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		if (!"Controle de Estagio".equals(driver.getTitle())){
			throw new IllegalStateException("Esta não é a página home.");
		}
		this.statusAtual = StatusSistema.Esperando_Acao;
	}

	By btUsuariosLocator = By.name("btnUsuario");
	By btEmpresasLocator = By.name("btnEmpresa");
	By btEstagiosLocator = By.name("btnEstagio");
	By btRelatoriosLocator = By.name("btnRelatorio");
	By btConveniosLocator = By.name("btnConvenio");
	By btEstagioSupsLocator = By.name("btnEstagioSupervisionado");
	By btUploadLocator = By.name("btnUpload");
	By btBackupLocator = By.name("btnBackup");
	By btSairLocator = By.name("btnSair");
	
	public LoginPage Sair(){
		driver.findElement(btSairLocator).click();
		return new LoginPage(driver);
	}
	
	public UsuariosPage Usuarios(){
		driver.findElement(btUsuariosLocator).click();
		return new UsuariosPage(driver);
	}
	
	public EmpresasPage Empresas(){
		driver.findElement(btEmpresasLocator).click();
		return new EmpresasPage(driver);
	}
	
	public EstagioPage Estagios(){
		driver.findElement(btEstagiosLocator).click();
		return new EstagioPage(driver);
	}
	public RelatorioPage Relatorios(){
		driver.findElement(btRelatoriosLocator).click();
		return new RelatorioPage(driver);
	}
	public EstagioSuperPage EstagioSuper(){
		driver.findElement(btEstagioSupsLocator).click();
		return new EstagioSuperPage(driver);
	}
	public UploadPage Upload(){
		driver.findElement(btUploadLocator).click();
		return new UploadPage(driver);
	}
	public BackupPage Backup(){
		driver.findElement(btBackupLocator).click();
		return new BackupPage(driver);
	}	
	public ConvenioPage Convenios(){
		driver.findElement(btConveniosLocator).click();
		return new ConvenioPage(driver);		
	}
	
}
