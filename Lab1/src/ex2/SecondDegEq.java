package ex2;
import java.lang.Math;
import javax.swing.JOptionPane;
public class SecondDegEq {
	public static void SecondDegEq() {
        double a = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter a: ", "SecondDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));
        double b = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter b: ", "SecondDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));
        double c = Double.parseDouble( JOptionPane.showInputDialog(null, "Enter c: ", "SecondDegEq", 
        		JOptionPane.INFORMATION_MESSAGE));

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            JOptionPane.showMessageDialog(null,
                    "No real solutions.",
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            JOptionPane.showMessageDialog(null,
                    "The equation has one real solution:\n" +
                            "x = " + root,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);

            JOptionPane.showMessageDialog(null,
                    "The equation has two real solutions:\n" +
                            "x1 = " + root1 + "\n" +
                            "x2 = " + root2,
                    "Result",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
