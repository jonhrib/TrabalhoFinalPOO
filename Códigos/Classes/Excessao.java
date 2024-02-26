package Classes;
import InterfaceGrafica.DialogExcessao;

public class Excessao extends Exception {

	public Excessao (int cod) {
		switch (cod) {
			case 1: //saque
				String erro = "O saldo disponível é inferior ao valor que deseja sacar.";
				DialogExcessao de = new DialogExcessao();
				de.edita(erro);
				de.setVisible(true);
				break;
			case 2: //deposito
				String erro2 = "O valor digitado deve ser maior que 0.";
				DialogExcessao de2 = new DialogExcessao();
				de2.edita(erro2);
				de2.setVisible(true);
				break;
			case 3: //senhagerente
				String erro3 = "A senha do gerente está incorreta.";
				DialogExcessao de3 = new DialogExcessao();
				de3.edita(erro3);
				de3.setVisible(true);
				break;
			case 4: //senhagerente
				String erro4 = "O saldo não é suficiente.";
				DialogExcessao de4 = new DialogExcessao();
				de4.edita(erro4);
				de4.setVisible(true);
				break;
		}
	}
}
