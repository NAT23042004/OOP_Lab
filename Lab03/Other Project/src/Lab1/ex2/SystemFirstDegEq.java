package ex2;
import javax.swing.JOptionPane;
public class SystemFirstDegEq {
	public static void SystemFirstDegEq() {
        double a1 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter a1: ", "SystemFirstDegEq", 
        		JOptionPane.INFORMATION_MESSAGE)); ;
        double b1 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter b1: ", "SystemFirstDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));
        double c1 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter c1: ", "SystemFirstDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));

        double a2 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter a2: ", "SystemFirstDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));
        double b2 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter b2: ", "SystemFirstDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));
        double c2 = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter c2: ", "SystemFirstDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            JOptionPane.showMessageDialog(null,
                    "The system of equations has no unique solution.",
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;

            JOptionPane.showMessageDialog(null,
                    "Solution is x = " + x + " and y = " + y,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
