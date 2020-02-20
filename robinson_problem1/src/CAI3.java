	import java.util.Random;
	import java.util.Scanner;
public class CAI3 {
	private int userGuess;
	private int num1;
	private int num2;
	public int count;
	Random SecureRandom = new Random();
	public void quiz() {
		Scanner input = new Scanner(System.in);
		final int limit = 10;
		int flag=0,check=0,choice=0,loop=0;
			while(loop == 0) {
				for(int counter =0 ; counter <10;counter++) {
					setNum1(SecureRandom.nextInt(limit));
					setNum2(SecureRandom.nextInt(limit));
					askQuestion();
					readResponse();
					flag = isAnwserCorrect();
					if(flag == 1) {
						displayCorrectResponse();
						count+= 100;}
					else
						displayIncorrectResponse();
				}
				displayCompletionmessage();
				while(check ==0) {
					choice= input.nextInt();
					if(choice ==1 || choice == 2) {
						check++;}
					else{System.out.println("Please select a valid option.");}
				}
				if(choice == 2) {loop++;}
				count = 0;
				choice = 0	;
				check = 0;
			}
	}
	
	public void setNum1(int num1) { this.num1 = num1;}
	public void setNum2(int num2) {this.num2 = num2;}
	public int getNum1() {return num1;}
	public int getNum2() {return num2;}
	public void setUserGuess(int userGuess) {this.userGuess = userGuess;}
	public int getUserGuess() {return userGuess;}
	public int getScore() {return count / 10;}
	public void askQuestion() {
		System.out.print("How much is " + getNum1() + " times " + getNum2() + "?");
		}
	public void readResponse() {
		Scanner input = new Scanner(System.in);
		int user = input.nextInt();
		setUserGuess(user);
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
	public void displayCompletionmessage() {
		System.out.println("Your percentage was " + getScore() + "%");
		if(getScore() >= 80) {
			System.out.println("Congratulations, you are ready to go to the next level!");
			System.out.println("Would you like to complete another set of questions?\n1-Yes\n2-No");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
			System.out.println("Would you like to complete another set of questions?\n1-Yes\n2-No");}
	}
}