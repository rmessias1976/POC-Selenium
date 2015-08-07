package sce.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ObjectPage {
    

	protected final WebDriver driver;
	protected StatusSistema statusAtual;
//	protected String nomePagina = "";
	
	public ObjectPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.statusAtual=StatusSistema.Esperando_Login;
	}

	/**
	 * Método que verifica o status do teste
	 * Grava uma imagem e um log
	 * 
	 * @param statusEsperado
	 * @return
	 */
	public boolean AssertStatus(StatusSistema statusEsperado){
		GravarEvidencia();
		return statusAtual.equals(statusEsperado);
	}
	
	/**
	 * Grava a Evidência do Teste
	 */
	private void GravarEvidencia() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imgname = UUID.randomUUID().toString();
		try {
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + imgname + ".png"));
			//TODO: DEFINIR UM DIRETÓRIO DE GRAVACAO DAS IMAGENS
		} catch (IOException e) {
			e.printStackTrace();
		} 
		//TODO: GRAVAR LOG DE TESTE
	}
	
}
