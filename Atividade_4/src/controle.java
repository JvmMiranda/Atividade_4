import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
public class controle {
	private int po = 0;
	private professor[] prof = new professor[5];
	
	public void menu() {
		int op;
		String aux = "Escolha uma opção: \n";
		aux += "1. Cadastrar Professor\n";
		aux += "2. Exibir dados do professor\n";
		aux += "3. Remover professor\n";
		aux += "4. Listar dados dos professores\n";
		aux += "5. Finalizar";
		
		do {
			op = parseInt(showInputDialog(aux));
			if ( op < 1 || op > 6) {
				showMessageDialog(null,"Opção Invalida");
			}else {
				switch(op) {
					case 1:
						cadastrarP();
						break;
					case 2:
						salP();
						break;
					case 3:
						remover();
						break;
					case 4:
						listar();
						break;
				}
			}
		}while( op != 5);
	}
	public void cadastrarP() {

		if(po < prof.length) {
			prof[po] = new professor();
			prof[po].nome = showInputDialog("Nome");
			prof[po].cpf = showInputDialog("CPF");
			for(int i =  0; i < po; i++) {
				if(prof[i].cpf.equals(prof[po].cpf)) {
					showMessageDialog(null, prof[po].cpf+ " inválido");
					return;
				}
			}
			prof[po].Taulas = parseInt(showInputDialog("Total de aulas."));
			prof[po].valorHaula = parseDouble(showInputDialog("Valor da hora aula."));
			po++;
		}
		
	}
	
	public void salP() {
		int indice = pesquisar();
		if(indice != -1) {
			double aux = prof[indice].calcSal();
			showMessageDialog(null, prof[indice].nome + "\n" + prof[indice].cpf + "\n" + aux);
		}
	}
	
	public int pesquisar() {
		int indice = -1;
		String cpf = showInputDialog("CPF para pesquisa");
		for(int i =  0; i < po; i++) {
			if(prof[i].cpf.equals(cpf)) {
				indice = i;
			}
		}
		
		if(indice == -1) {
			showMessageDialog(null, cpf + " Não encontrado");
		}
		return indice;
	}
	
	public void remover(){
		int indice = pesquisar();
		if (indice != -1) {
			for( int i = indice; i < po; i++) {
				prof [i] = prof[i+1];
			}
			po--;
		}
	}
	
	public void listar() {
		String aux = "";
		for(int i =  0; i < po; i++) {
		aux += prof[i].nome + "\n";
		aux += prof[i].cpf + "\n";
		aux += prof[i].calcSal() + "\n";
		aux += "\n";
		}
		showMessageDialog(null, aux);
	}
}
