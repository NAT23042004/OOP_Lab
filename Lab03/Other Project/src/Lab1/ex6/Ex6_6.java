package ex6;
import javax.swing.JOptionPane;
public class Ex6_6 {
	public static void main(String[] args) {
		int size = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter the size of the matrix",
                "Matrix Size: ",
                JOptionPane.INFORMATION_MESSAGE));
		int [] [] matrix1 = new int [size][size];
		int [] [] matrix2 = new int [size][size];
		int [] [] sumMatrix = new int [size][size];
		String result = "";
		// Read matrix 1 and 2
 		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				 String input = JOptionPane.showInputDialog(null,
		                    "Enter element at row " + i +" column "+ j,
		                    "Array Input",
		                    JOptionPane.INFORMATION_MESSAGE);
		            matrix1[i][j] = Integer.parseInt(input);
			}
		}
 		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				 String input = JOptionPane.showInputDialog(null,
		                    "Enter element at row " + i +" column "+ j,
		                    "Array Input",
		                    JOptionPane.INFORMATION_MESSAGE);
		            matrix2[i][j] = Integer.parseInt(input);
			}
		}
 		//
 		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				 sumMatrix[i][j]= matrix1[i][j] + matrix2[i][j];
			}
		}
 		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				result  += sumMatrix[i][j] + " ";
			}
			result += '\n';
		}
 		//show the sum Matrix
 		     JOptionPane.showMessageDialog(null, "Sum matrix is: \n"+ result
 		    		 , "Result", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, result);
		
	}
}
