package sce.webdriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.sonatype.aether.impl.UpdateCheck;

import sce.interfaces.Home;

public class HomeTest extends ExecutionContext implements Home{
	public final static Path MODEL_PATH = Paths.get("sce/webdriver/Home.graphml");

	//WebDriver Objects
	public static WebDriver driver; 
	
	//Object Pages
	protected static LoginPage loginPage; 
	protected static HomePage homePage;
	protected static UsuariosPage usuariosPage;
	protected static EstagioPage estagioPage;
	protected static RelatorioPage relatorioPage;
	protected static ConvenioPage convenioPage;
	protected static EstagioSuperPage estagioSuperPage;
	protected static UploadPage uploadPage;
	protected static BackupPage backupPage;
	protected static EmpresasPage empresasPage;
	
	@Override
	public void e_btnUsuarios() {
		System.out.println("e_btnUsuarios");
		usuariosPage = homePage.Usuarios();
		System.out.println("e_btnUsuarios");
	}
	
	@Override
	public void e_btnBackup() {
		System.out.println("e_btnBackup");
		backupPage = homePage.Backup();
		System.out.println("e_btnBackup");
	}
	
	@Override
	public void v_Menu() {
		System.out.println("v_Menu");
		homePage.AssertStatus(StatusSistema.Esperando_Acao);
		System.out.println("v_Menu");
	}
	
	@Override
	public void v_Relatorios() {
		System.out.println("v_Relatorios");
		relatorioPage.AssertStatus(StatusSistema.Esperando_Acao_Relatorio);
		System.out.println("v_Relatorios");
	}
	
	@Override
	public void e_Sair() {
		System.out.println("e_Sair");
		loginPage = homePage.Sair();
		System.out.println("e_Sair");
	}
	
	@Override
	public void e_RelatoriosVoltar() {
		System.out.println("e_RelatoriosVoltar");
		homePage = relatorioPage.Voltar();
		System.out.println("e_RelatoriosVoltar");
	}
	
	@Override
	public void v_EstagioSupervisionado() {
		System.out.println("v_EstagioSupervisionado");
		estagioSuperPage.AssertStatus(StatusSistema.Esperando_Acao_EstagioSuper);
		System.out.println("v_EstagioSupervisionado");
	}
	
	@Override
	public void e_btnEmpresas() {
		System.out.println("e_btnEmpresas");
		empresasPage = homePage.Empresas();
		System.out.println("e_btnEmpresas");
	}
	
	@Override
	public void e_btnEstagios() {
		System.out.println("e_btnEstagios");
		estagioPage = homePage.Estagios();
		System.out.println("e_btnEstagios");
	}
	
	@Override
	public void e_EstagiosVoltar() {
		System.out.println("e_EstagiosVoltar");
		homePage = estagioPage.Voltar();
		System.out.println("e_EstagiosVoltar");
	}
	
	@Override
	public void e_init() {
		System.out.println("e_init");
		driver.get("http://107.178.218.180/sce-web-ref2/visao/index.jsp");
		loginPage = new LoginPage(driver);
		System.out.println("e_init");
	}
	@Override
	public void v_Upload() {
		System.out.println("v_Upload");
		uploadPage.AssertStatus(StatusSistema.Esperando_Acao_Upload);
		System.out.println("v_Upload");
	}
	@Override
	public void v_Usuarios() {
		System.out.println("v_Usuarios");
		usuariosPage.AssertStatus(StatusSistema.Esperando_Acao_Usuario);
		System.out.println("v_Usuarios");
	}
	@Override
	public void v_Convenios() {
		System.out.println("v_Convenios");
		convenioPage.AssertStatus(StatusSistema.Esperando_Acao_Convenio);
		System.out.println("v_Convenios");
	}
	@Override
	public void v_Empresas() {
		System.out.println("v_Empresas");
		empresasPage.AssertStatus(StatusSistema.Esperando_Acao_Empresa);
		System.out.println("v_Empresas");
	}
	@Override
	public void e_ConveniosVoltar() {
		System.out.println("e_ConveniosVoltar");
		homePage = convenioPage.Voltar();
		System.out.println("e_ConveniosVoltar");
	}
	@Override
	public void e_btnConvenios() {
		System.out.println("e_btnConvenios");
		convenioPage = homePage.Convenios();
		System.out.println("e_btnConvenios");
	}
	@Override
	public void e_UploadVoltar() {
		System.out.println("e_UploadVoltar");
		homePage = uploadPage.Voltar();
		System.out.println("e_UploadVoltar");
	}
	
	@Override
	public void e_btnRelatorios() {
		System.out.println("e_btnRelatorios");
		relatorioPage = homePage.Relatorios();
		System.out.println("e_btnRelatorios");
	}
	
	@Override
	public void v_Login() {
		System.out.println("v_Login");
		loginPage.AssertStatus(StatusSistema.Esperando_Login);
		System.out.println("v_Login");
	}
	
	@Override
	public void e_LoginValido() {
		System.out.println("e_LoginValido");
		homePage =  loginPage.LoginValido();
		System.out.println("e_LoginValido");
	}
	
	@Override
	public void e_EstagioSupVoltar() {
		System.out.println("e_EstagioSupVoltar");
		homePage = estagioSuperPage.Voltar();	
		System.out.println("e_EstagioSupVoltar");
	}
	
	@Override
	public void v_Backup() {
		System.out.println("v_Backup");
		backupPage.AssertStatus(StatusSistema.Esperando_Acao_Backup);
		System.out.println("v_Backup");
	}
	
	@Override
	public void e_BackupVoltar() {
		System.out.println("e_BackupVoltar");
		homePage = backupPage.Voltar();
		System.out.println("e_BackupVoltar");
	}
	
	@Override
	public void e_btnUpload() {
		System.out.println("e_btnUpload");
		uploadPage = homePage.Upload();
		System.out.println("e_btnUpload");
	}
	
	@Override
	public void v_Estagios() {
		System.out.println("v_Estagios");
		estagioPage.AssertStatus(StatusSistema.Esperando_Acao_Estagio);
		System.out.println("v_Estagios");
	}
	
	@Override
	public void e_EmpresasVoltar() {
		System.out.println("e_EmpresasVoltar");
		homePage = empresasPage.Voltar();
		System.out.println("e_EmpresasVoltar");
	}
	@Override
	public void e_btnEstagioSup() {
		System.out.println("e_btnEstagioSup");
		estagioSuperPage = homePage.EstagioSuper();
		System.out.println("e_btnEstagioSup");
	}
	
	@Override
	public void e_UsuariosVoltar() {
		System.out.println("e_UsuariosVoltar");
		homePage = usuariosPage.Voltar();
		System.out.println("e_UsuariosVoltar");
	}
	
    @Test
    public void runFunctionalTest() {

    	//TODO: Implementar um abstractFactory para instanciar diferentes navegadores		
		FirefoxProfile profile = new FirefoxProfile();		
		profile.setPreference("signon.rememberSignons", false);
		profile.setPreference("signon.autofillForms", false);
		profile.setPreference("browser.formfill.enable", false);
		profile.setPreference("services.sync.prefs.sync.browser.formfill.enable", false);
		profile.setPreference("signon.rememberSignons", false);
		profile.setPreference("services.sync.prefs.sync.signon.rememberSignons", false);
		
		driver = new FirefoxDriver(profile);
		
		//TODO: Alguma coisa parece que faz com que o driver fique parado ao final do teste.  Não sei se é pq dá um erro em algum ponto...
        new TestBuilder()
            .setModel(MODEL_PATH)
            .setContext(new HomeTest())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
            .setStart("e_init")
            .execute();
        
        driver.quit();
    }

}
