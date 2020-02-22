
public class SavingsAccount {
	private double annualIntrestRate;
	private double savingsBalance;
	private double monthlyBalance;


	public SavingsAccount(double IntrestRate,double Balance) {
		annualIntrestRate = IntrestRate;
		this.savingsBalance = Balance;
	}
	public void modifyIntrestRate(double newIntrest) {annualIntrestRate = newIntrest;}
	public void calculateMonthlyInterest() {this.savingsBalance+=(this.savingsBalance * annualIntrestRate) /12;}
	public double getMonthlyBalance() {return this.monthlyBalance;}
	public double getSavingsBalance() {return this.savingsBalance;}
	
	public String toString() {
		return String.format("\t%s%n\t%s%.2f","Savings Balance","$",getSavingsBalance());
	}
}