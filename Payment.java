import java.util.ArrayList;

public class Payment {

	private double amount=0;//sum of payments
	private int time = 0;
	private double term = 0;
	//private double discounted=0;//sum of discounted payments (value)
	//private ArrayList<Bond> portfolio;
	
	public Payment(double amount, int time, double term) {
		this.amount = amount;
		this.time = time;
		this.term = term;
	}
	

	
	double getAmount(){
		return amount;
	}
	
	int getTime() {
		return time;
	}
	
	double getTerm(){
		return term;
	}
	
	/*public Payment(ArrayList<Bond> p){
		portfolio=p;
	}
	
	
	private void computeAmount(){
		amount = 0;
		for(Bond b:portfolio){
			amount+=b.getPayout();
		}
	}
	
	double getAmount(){
		computeAmount();
		return amount;
	}
	
	private void computeDiscounted(double r){//System should compute the pay out of all bonds: sum of payments.
		discounted = 0;
		for(Bond b:portfolio){
			discounted+=b.getValue(r);
		}
	}
	
	double getDiscounted(double r){//System should compute bond values: sum of discounted payments, using inflation rate r
		computeDiscounted(r);
		return discounted;
	}*/

}
