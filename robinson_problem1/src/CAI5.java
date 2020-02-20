import java.util.Random;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class CAI5 {
private double userGuess;
private double num1;
private double num2;
public int count;
private int difficulty;
private int problemType;
private int mixQuestion;
Scanner input = new Scanner(System.in);
Random SecureRandom = new Random();
public void quiz() {
	int flag=0,check=0,choice=0,loop=0;
		while(loop == 0) {
			readDifficulty();
			readProblemType();
			for(int counter =0 ; counter <10;counter++) {
				MixCheck();
				generateQuestionArgument();
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
public double getNum1() {return num1;}
public double getNum2() {return num2;}
public void setUserGuess(double userGuess) {this.userGuess = userGuess;}
public double getUserGuess() {return userGuess;}
public int getScore() {return count / 10;}
public void setDifficulty(int difficulty) {this.difficulty = difficulty;}
public int getDifficulty() {return difficulty;}
public void setProblemType(int problemType) {this.problemType = problemType;}
public int getProblemType() {return problemType;}
public void setMixQuestion(int mixQuestion) {this.mixQuestion = mixQuestion;}
public int getMixQuestion() {return mixQuestion;}
public void askQuestion() {
	switch(getProblemType()) {
	case 1:
		System.out.printf("How much is %.0f plus %.0f ?",getNum1(),getNum2());
		break;
	case 2:
		System.out.printf("How much is %.0f times %.0f ?",getNum1(),getNum2());
		break;
	case 3:
		System.out.printf("How much is %.0f minus %.0f ?",getNum1(),getNum2());
		break;
	case 4:
		System.out.printf("How much is %.0f divided by %.0f to the nearest hundreth place?",getNum1(),getNum2());
		break;
	case 5:
		if(getMixQuestion() == 1) {System.out.printf("How much is %.0f plus %.0f ?",getNum1(),getNum2());}
			else if(getMixQuestion() == 2) {System.out.printf("How much is %.0f times %.0f ?",getNum1(),getNum2());}
				else if(getMixQuestion() == 3) {System.out.printf("How much is %.0f minus %.0f ?",getNum1(),getNum2());}
					else if(getMixQuestion() == 4) {System.out.printf("How much is %.0f divided by %.0f to the nearest hundreth place?",getNum1(),getNum2());}
	}
}
public void readResponse() {
	double user = input.nextDouble();
	setUserGuess(user);
	}

public int isAnwserCorrect() {
	int correct = 0;
	switch(getProblemType()) {
		case 1:
			if(getUserGuess() == getNum1() + getNum2()) {correct = 1;}
			break;
		case 2:
			if(getUserGuess() == getNum1() * getNum2()) {correct = 1;}
			break;
		case 3:
			if(getUserGuess() == getNum1() - getNum2()){correct = 1;}
			break;
		case 4:
			if(getNum2() == 0) {
				System.out.println("ERROR: AUTOMATIC CORRECT ANWSER");
				correct =1;
				break;
			}
			if(getUserGuess() == roundAnwser(getNum1() / getNum2())) {correct = 1;}
			break;
		case 5:
			switch(getMixQuestion()) {
			case 1:
				if(getUserGuess() == getNum1() + getNum2()) {correct = 1;}
				break;
			case 2:
				if(getUserGuess() == getNum1() * getNum2()) {correct = 1;}
				break;
			case 3:
				if(getUserGuess() == getNum1() - getNum2()) {correct = 1;}
				break;
			case 4:
				if(getNum2() == 0) {
					System.out.println("ERROR: AUTOMATIC CORRECT ANWSER");
					correct =1;
					break;
				}
				if(getUserGuess() == roundAnwser(getNum1() / getNum2())) {correct = 1;}
				break;
			}
	}
	return correct;
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
public void readDifficulty() {
	int i = 0;
	while(i == 0) {
		System.out.println("Enter a diffculty level 1-4");
		int difficulty = input.nextInt();
		if(difficulty< 1 || difficulty >4) {
			System.out.println("Please pick a vald level.");}
		else {
			setDifficulty(difficulty);
			i++;}	
	}
}
public void generateQuestionArgument() {
	int limit = 0;
	switch(getDifficulty()) {
		case 1:
			limit = 10;
			setNum1(SecureRandom.nextInt(limit));
			if(getProblemType() == 4) {
				int j=0;
				while(j==0) {
				j = SecureRandom.nextInt(limit);
				}
				setNum2(j);
			j = SecureRandom.nextInt(limit);
			}
			else
				setNum2(SecureRandom.nextInt(limit));
			break;
	
		case 2:
			limit = 100;
			setNum1(SecureRandom.nextInt(limit));
			if(getProblemType() == 4) {
				int j=0;
				while(j==0) {
				j = SecureRandom.nextInt(limit);
				}
				setNum2(j);
			j = SecureRandom.nextInt(limit);
			}
			else
				setNum2(SecureRandom.nextInt(limit));
			break;
		case 3:
			limit = 1000;
			setNum1(SecureRandom.nextInt(limit));
			if(getProblemType() == 4) {
				int j=0;
				while(j==0) {
				j = SecureRandom.nextInt(limit);
				}
				setNum2(j);
			j = SecureRandom.nextInt(limit);
			}
			else
				setNum2(SecureRandom.nextInt(limit));
			break;
		case 4:
			limit = 10000;
			setNum1(SecureRandom.nextInt(limit));
			if(getProblemType() == 4) {
				int j=0;
				while(j==0) {
				j = SecureRandom.nextInt(limit);
				}
				setNum2(j);
			j = SecureRandom.nextInt(limit);
			}
			else
				setNum2(SecureRandom.nextInt(limit));
			break;
	}
}
public void readProblemType() {
	int i = 0;
	while(i == 0) {
		System.out.println("What type of problems would you like to do?\n1-Addition\n2-Multiplication"
				+ "\n3-Subtraction\n4-Division\n5-Mix of all");
		int problemType = input.nextInt();
		if(problemType< 1 || problemType >5) {
			System.out.println("Please pick a vald level.");}
		else {
			setProblemType(problemType);
			i++;}	
	}
}
public void MixCheck() {
	if(getProblemType() == 5) {
		int limit = 5;
		int mixQuestion = SecureRandom.nextInt(limit);
		mixQuestion++;
		setMixQuestion(mixQuestion);
	}
}
public static double roundAnwser(double value) {
    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(2, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}
