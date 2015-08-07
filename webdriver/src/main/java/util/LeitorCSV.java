package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeitorCSV {
	private static String caminhoArquivoCSV = "";
	private static Map<String, String> maps;
	
	public LeitorCSV(String caminhoArquivoCSV) {
		super();
		this.caminhoArquivoCSV = caminhoArquivoCSV;
		this.LeRegistrosArquivo();
	} 
	
	public void LeRegistrosArquivo() {
		BufferedReader br = null;
		String line = "";
		String lineSplitter = "&";
		try {	 
			maps = new HashMap<String, String>();
			br = new BufferedReader(new FileReader(this.caminhoArquivoCSV));
			while ((line = br.readLine()) != null) {
				String[] campos = line.split(lineSplitter);
				maps.put(campos[0], campos[1]);
			}	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getLinhaArquivo(String idRegistro){
		return maps.get(idRegistro);
	}
	
	public Map<String, String> getRecord(String idRegistro){
		String recordSplitter = "#";
		Map<String, String> resultado = new HashMap<String, String>();
		String linha = this.getLinhaArquivo(idRegistro);
		String[] campos = linha.split(recordSplitter);
		for (String campo : campos) {
			String dado[] = campo.split("=");
			resultado.put(dado[0], dado[1]);
		}
		return resultado;
	}
}
