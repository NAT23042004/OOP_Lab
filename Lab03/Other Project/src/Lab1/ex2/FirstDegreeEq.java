package ex2;
import javax.swing.JOptionPane;
public class FirstDegreeEq {
	public static void FirstDegreeEq() {
        double a =   Double.parseDouble( JOptionPane.showInputDialog(null, "Enter a: ", "FirstDegreeEq", 
        		JOptionPane.INFORMATION_MESSAGE));
        double b =  Double.parseDouble( JOptionPane.showInputDialog(null, "Enter b: ", "FirstDegreeEq", 
        		JOptionPane.INFORMATION_MESSAGE));

        if (a == 0) {
            JOptionPane.showMessageDialog(null,
                    "The equation is not a valid first-degree equation.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            double solution = -b / a;
            JOptionPane.showMessageDialog(null,
                    "Solution: " + solution,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
