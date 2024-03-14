package ex6;
import javax.swing.JOptionPane;
public class Ex6_5 {
	public static void main(String[] args) {
		int size = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter the size of the array",
                "Array Size:",
                JOptionPane.INFORMATION_MESSAGE));
		int[] numericArray = new int[size];
		for (int i = 0; i < size; i++) {
            String input = JOptionPane.showInputDialog(null,
                    "Enter element at index " + i,
                    "Array Input",
                    JOptionPane.INFORMATION_MESSAGE);
            numericArray[i] = Integer.parseInt(input);
        }
		//Sort the array(ascending)
		for (int i = 0; i < size - 1; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (numericArray[j] < numericArray[index]) {
                    index = j;
                }
            }
        
            if (index != i) {
                int temp = numericArray[i];
                numericArray[i] = numericArray[index];
                numericArray[index] = temp;
            }
        }
		//
		String array = "";
		for(int i = 0; i < size; i++) {
			array += numericArray[i] + " ";
		}
		// Sum of the array
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += numericArray[i];
		}
		double avg = (double)(sum / size);
		
		JOptionPane.showMessageDialog(null, 
				"Sorted array: " + array +"\n" +
		       "Sum of array is:" + sum +"\n" +
				"Average: " + avg);
 		
	}
	//Function to swap 2 variables
	public static void swap(int a, int b) {
		int temp;
		temp = b;
		b= a;
		a = temp;
	}
}
