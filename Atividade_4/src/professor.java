import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
public class professor {
	
	String nome;
	String cpf;
	int Taulas;
	double valorHaula;
	
	
	
	public double calcSal() {
		double sal;
		sal = Taulas * 4.5 * valorHaula;
		sal = sal * 1.05;
		sal = sal + (sal/6);
		return sal;
	}
	
	
}
