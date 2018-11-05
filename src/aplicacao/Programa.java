package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Na contagem de votos de uma elei��o, s�o gerados v�rios registros de vota��o 
 * contendo o nome do candidato e a quantidade de votos (formato .csv) que 
 * ele obteve em uma urna de vota��o. 
 * Voc� deve fazer um programa para ler os registros de vota��o 
 * a partir de um arquivo, e da� gerar um relat�rio consolidado 
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
			
				//verifica se j� existe aquela chave
				if(votos.containsKey(campos[0])) {
					//adiciona � chave existe o valor da linha antiga com o valor da linha atual
					votos.put(campos[0], Integer.toString(Integer.parseInt(campos[1]) + 
							Integer.parseInt(votos.get(campos[0]))));
				} else {
					//se n�o cont�m a chave adiciona a mesma
					votos.put(campos[0], campos[1]);
				}
				
				//l� a pr�xima linha
				linha = br.readLine();
			}
			
			System.out.println("Resultado da vota��o:");
			for(String key : votos.keySet()) {
				System.out.println(key+" : "+votos.get(key));
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		
		//sc.close();
		
		
		

	}

}
