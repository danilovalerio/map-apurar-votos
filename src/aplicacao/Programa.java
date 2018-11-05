package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Na contagem de votos de uma eleição, são gerados vários registros de votação 
 * contendo o nome do candidato e a quantidade de votos (formato .csv) que 
 * ele obteve em uma urna de votação. 
 * Você deve fazer um programa para ler os registros de votação 
 * a partir de um arquivo, e daí gerar um relatório consolidado 
 * com os totais de cada candidato.
 */

public class Programa {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		String path = "C:\\Users\\dsilva\\Documents\\eleicoes-simulador.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, String> votos = new HashMap<>();
			
			String linha = br.readLine();
			while(linha != null) {
				String[] campos = linha.split(",");
			
				//verifica se já existe aquela chave
				if(votos.containsKey(campos[0])) {
					//adiciona à chave existe o valor da linha antiga com o valor da linha atual
					votos.put(campos[0], Integer.toString(Integer.parseInt(campos[1]) + 
							Integer.parseInt(votos.get(campos[0]))));
				} else {
					//se não contém a chave adiciona a mesma
					votos.put(campos[0], campos[1]);
				}
				
				//lê a próxima linha
				linha = br.readLine();
			}
			
			System.out.println("Resultado da votação:");
			for(String key : votos.keySet()) {
				System.out.println(key+" : "+votos.get(key));
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		
		//sc.close();
		
		
		

	}

}
