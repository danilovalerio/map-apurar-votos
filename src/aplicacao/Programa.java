package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

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
			String linha = br.readLine();
			System.out.println("Linhas do arquivo:");
			while(linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			
			
			
						
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		
		//sc.close();
		
		
		

	}

}
