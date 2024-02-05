package Classes;
import InterfaceGrafica.DialogExcessao;

public class Excessao extends Exception {

	public Excessao (int cod) {
		switch (cod) {
			case 1: //saque
				String erro = "O saldo disponível é inferior ao valor que deseja sacar";
				DialogExcessao de = new DialogExcessao();
				de.edita(erro);
				de.setVisible(true);
				break;
		}
	}
}
