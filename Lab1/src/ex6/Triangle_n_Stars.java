package ex6;
import java.util.Scanner;
public class Triangle_n_Stars{
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		int n = input.nextInt();
		String line[] = new
		String [n];
		for(int i = 0; i < n; i++) {
			line[i] = "";
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2*n - 1;j++) {
				if(j >= n - 1 - i && j <= n - 1 + i) 
					line[i] += '*';
				else line[i] += ' ';
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(line[i]);
		}
	}
}