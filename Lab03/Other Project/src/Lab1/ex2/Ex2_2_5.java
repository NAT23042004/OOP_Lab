package ex2;
import javax.swing.JOptionPane;
public class Ex2_2_5 {
	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, 
				"Please input the first number: ", "Input the first number", 
				JOptionPane.INFORMATION_MESSAGE);
		
		strNum2 = JOptionPane.showInputDialog(null, 
				"Please input the second number: ", "Input the second number", 
				JOptionPane.INFORMATION_MESSAGE);
		
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 + num2;
		System.out.println("Sum of two numbers is: " +  sum);
		double diff = num1 - num2;
		System.out.println("Different of two numbers is: " + diff);
		double product = num1 * num2;
		System.out.println("Product of two numbers is: " + product);
		if(num2 == 0)
		{
			System.out.println("There does not exist quotient of 2 numbers");
		}
		else {
			double quotient = num1 / num2;
			System.out.println("Quotient of two numbers is: " + quotient);
		}
	    System.exit(0);
	}
}
