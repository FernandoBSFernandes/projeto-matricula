package matricula.comparacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ComparaMatriculas {

	private List<String> lerMatriculasASeremVerificadasDoArquivo() {

		String matricula = "";
		List<String> matriculasVerificadas = new ArrayList<String>();
		String novaMatricula = "";

		try {

			BufferedReader reader = new BufferedReader(new FileReader("matriculasParaVerificar.txt"));

			while ((matricula = reader.readLine()) != null) {
				int multiplicaPrimeiroNumero = Integer.parseInt(matricula.substring(0, 1)) * 5;
				int multiplicaSegundoNumero = Integer.parseInt(matricula.substring(1, 2)) * 4;
				int multiplicaTerceiroNumero = Integer.parseInt(matricula.substring(2, 3)) * 3;
				int multiplicaQuartoNumero = Integer.parseInt(matricula.substring(3, 4)) * 2;

				int somatorio = multiplicaPrimeiroNumero + multiplicaSegundoNumero + multiplicaTerceiroNumero + multiplicaQuartoNumero;
				int restoDivisao = somatorio % 16;

				if ((restoDivisao >= 10) && (restoDivisao <=15)) {

					switch (restoDivisao) {

					case 10:
						novaMatricula = matricula.substring(0, 4) + "-A";
						break;

					case 11:
						novaMatricula = matricula.substring(0, 4) + "-B";
						break;

					case 12:
						novaMatricula = matricula.substring(0, 4) + "-C";
						break;

					case 13:
						novaMatricula = matricula.substring(0, 4) + "-D";
						break;

					case 14:
						novaMatricula = matricula.substring(0, 4) + "-E";
						break;

					case 15:
						novaMatricula = matricula.substring(0, 4) + "-F";
						break;
					}

				} else {
					novaMatricula = matricula.substring(0, 4) + "-" + restoDivisao;
				}

				if(novaMatricula.equals(matricula)) {
					novaMatricula += " verdadeiro";
				} else {
					novaMatricula += " falso";
				}

				matriculasVerificadas.add(novaMatricula);
			}

			reader.close();

		} catch (Exception e) {
			e.getMessage();
		}

		return matriculasVerificadas;
	}

	public void criarArquivoComMatriculasVerificadas() {

		File matriculasVerificadas = new File("matriculasVerificadas.txt");

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(matriculasVerificadas));

			List<String> matriculas = this.lerMatriculasASeremVerificadasDoArquivo();

			matriculas.forEach(matricula -> {
				try{
					writer.write(matricula);
					writer.newLine();
					writer.flush();
				} catch (Exception exception){
					exception.getMessage();
				}
			});

			writer.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
