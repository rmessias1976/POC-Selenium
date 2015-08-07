package util;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class LeitorCSVTest {

	private static LeitorCSV leitor;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		leitor = new LeitorCSV("src/main/java/util/testecsv.csv");
	}

	@Test
	public void testRun() {
		leitor.LeRegistrosArquivo();
		System.out.println(leitor.getLinhaArquivo("1"));
		fail("Not yet implemented");
	}
	
	@Test
	public void testRun2() {
		leitor.LeRegistrosArquivo();
		Map<String, String> meuDado = leitor.getRecord("1");
		System.out.println(meuDado.get("usuario"));
		System.out.println(meuDado.get("senha"));
		fail("Not yet implemented");
	}
}
