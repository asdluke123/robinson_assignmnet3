	import java.util.Random;
	import java.util.Scanner;
public class CAI2 {
		private int userGuess;
		private int num1;
		private int num2;
		Random SecureRandom = new Random();
		public void quiz() {
			int limit = 10;
			setNum1(SecureRandom.nextInt(limit));
			setNum2(SecureRandom.nextInt(limit));
			int flag = 0;
				while(flag == 0) {
				askQuestion();
				readResponse();
				flag = isAnwserCorrect();
				if(flag == 0)
					displayIncorrectResponse();
				}
			displayCorrectResponse();
		}
		
		public void setNum1(int num1) { this.num1 = num1;}
		public void setNum2(int num2) {this.num2 = num2;}
		public int getNum1() {return num1;}
		public int getNum2() {return num2;}
		public void setUserGuess(int userGuess) {this.userGuess = userGuess;}
		public int getUserGuess() {return userGuess;}
		
		public void askQuestion() {
			System.out.print("How much is " + getNum1() + " times " + getNum2() + "?");
			}
		public void readResponse() {
			int flag = 0;
			Scanner input = new Scanner(System.in);
			if(input.hasNextInt()) {
			int user = input.nextInt();
			setUserGuess(user);
			flag++;}
			else {System.out.println("ERROR: Please enter a valid integer number");}
			}
		
		public int isAnwserCorrect() {
			if(getUserGuess() == getNum1() * getNum2() ) 
				return 1;
			else 
				return 0;
		}
		public void displayIncorrectResponse() {
			int limit = 4;
			int rand = SecureRandom.nextInt(limit);
			rand++;
			switch(rand) {
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don’t give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
			}
		}
		public void displayCorrectResponse() {
			int limit = 4;
			int rand = SecureRandom.nextInt(limit);
			rand++;
			switch(rand) {
			case 1:
				System.out.println("Very good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice Work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
			}
		}
	}
