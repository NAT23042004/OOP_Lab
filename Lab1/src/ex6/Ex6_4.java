package ex6;
import javax.swing.JOptionPane;
public class Ex6_4 {
	public static void main(String[] args) {
		String month,year;
		while(true) {
		month = JOptionPane.showInputDialog(null,
				"Input the month",
				"Please enter the month",
				JOptionPane.INFORMATION_MESSAGE);
		year = JOptionPane.showInputDialog(null, "Input the year", "Please enter the year",
				JOptionPane.INFORMATION_MESSAGE);
		//Check whether year is valid or not
		if(isNumeric(year)) {
			int Year = Integer.parseInt(year);
			if(Year < 0) continue;
			else {
				//Check month and print number days of month
				
				switch(month) {
				case "January": case "Jan": case "Jan.": case "1":
		        case "March" : case "Mar" : case "Mars": case "3":
		        case "May" : case "May." : case "5":
		        case "July" : case "Jul" : case "Jul.": case "7":
		        case "August" : case "Aug" : case "Aug.": case "8":
		        case "October" : case "Oct" : case "Oct.": case "10":
		        case "December" : case "Dec" : case "Dec.": case "12":
		            JOptionPane.showMessageDialog(null, "The month "+month+" has 31 days in the year "+year);
		            break;
		        case "April" : case "Apr" : case "Apr.": case "4":
		        case "June" : case "Jun" : case "Jun.": case "6":
		        case "September" : case "Sep" : case "Sep.": case "9":
		        case "November" : case "Nov" : case "Nov.": case "11":
		            JOptionPane.showMessageDialog(null, "The month"+ month+" has 30 days in the year "+year);
		            break;
		        case "February" : case "Feb" : case "Feb.": case "2":
		        if(isLeapYear(Year)) {
		        	JOptionPane.showMessageDialog(null, "February has 29 days in the year "+year+" has 29 days");
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "February has 29 days in the year "+year+" has 28 days");
		        }
		        break;
					default:
						{JOptionPane.showMessageDialog(null, "Invalid month, please enter again");
						continue;
						}
				
				}
				break;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid year, please enter again");
		}
		
		}

	}
	/* Check whether year is a number or not
	 * 
	 */
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	// Function check Leap year
	 public static boolean isLeapYear(int year) {
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	    }
}