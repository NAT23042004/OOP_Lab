package ex2;
import javax.swing.JOptionPane;
import ex2.FirstDegreeEq;
import ex2.SystemFirstDegEq;
import ex2.SecondDegEq;
public class  Ex2_2_6{
    public static void main (String[] args) {
    	
    	 SecondDegEq secondDegSol = new SecondDegEq();
         SystemFirstDegEq systemFirstDegSol = new SystemFirstDegEq();
         FirstDegreeEq firstDegSol = new FirstDegreeEq();
         
        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "Choose the type of equation to solve:\n" +
                            "1. First-Degree Equation \n" +
                            "2. System of First-Degree Equations\n" +
                            "3. Second-Degree Equation \n" +
                            "4. Exit",
                    "Equation Solver Menu",
                    JOptionPane.INFORMATION_MESSAGE);

            switch (choice) {
                case "1":
                	 firstDegSol.FirstDegreeEq();
                    break;
                case "2":
                	systemFirstDegSol.SystemFirstDegEq();
                    break;
                case "3":
                	secondDegSol.SecondDegEq();
                    break;
                case "4":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid choice. Please enter again.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}