package matricula.criacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CriarMatricula {

	private List<String> lerMatriculasArquivo() {

		String matricula = "";
		List<String> matriculasNovas = new ArrayList<String>();
		String novaMatricula = "";

		try {

			BufferedReader reader = new BufferedReader(new FileReader("matriculasSemDV.txt"));

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
						novaMatricula = matricula + "-A";
						break;

					case 11:
						novaMatricula = matricula + "-B";
						break;

					case 12:
						novaMatricula = matricula + "-C";
						break;

					case 13:
						novaMatricula = matricula + "-D";
						break;

					case 14:
						novaMatricula = matricula + "-E";
						break;

					case 15:
						novaMatricula = matricula + "-F";
						break;
					}

				} else {
					novaMatricula = matricula + "-" + restoDivisao;
				}

				matriculasNovas.add(novaMatricula);
			}

			reader.close();

		} catch (Exception e) {
			e.getMessage();
		}

		return matriculasNovas;
	}

	public void criarArquivoComMatriculasNovas() {

		File matriculasComDV = new File("matriculasComDV.txt");

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(matriculasComDV));

			List<String> matriculas = this.lerMatriculasArquivo();

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