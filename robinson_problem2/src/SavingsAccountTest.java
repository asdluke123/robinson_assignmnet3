public class SavingsAccountTest {

	public static void main(String[] args) {
		  
		SavingsAccount saver1 = new SavingsAccount(0.04,2000.00);
		SavingsAccount saver2 = new SavingsAccount(0.04,3000.00);
		
		System.out.println("Saver1 starting balance and intrest rate: $" + saver1.getSavingsBalance() +", %4");
		System.out.println("Saver2 first annual balance: $" + saver2.getSavingsBalance() +", %4");
		for(int count = 1;count <=12 ;count++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.println("Month "+count+"\nSaver 1");
			System.out.println(saver1.toString());
			System.out.println("Saver 2");
			System.out.println(saver2.toString());
		}
			saver1.modifyIntrestRate(0.05);
			saver2.modifyIntrestRate(0.05);
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.println("Saver1 balance after one month of a 0.5 intrest change\n " + saver1.toString());
			System.out.println("Saver2 balance after one month of a 0.5 intrest change\n " + saver2.toString());
			
		}
}
