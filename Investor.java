import java.util.ArrayList;

public class Investor {

	private ArrayList<Bond> portfolio=new ArrayList<>();//an array list of bonds that the investor purchased
	//private Payment payment;
	private Bond newBonds;
	

	
	public void purchaseBonds(Bond bond){//System enables new bonds to be added to investor’s portfolio.
		newBonds = bond;
		portfolio.add(bond);
	}
	
/*	public void createPayment(){
		payment=new Payment(portfolio);
	}*/
	
	public boolean createPayment(String bondName, double amount, int time, int term) {
//		Bond bond = null;
		for(Bond b : portfolio) {
			if (b.getName().equals(bondName)) {
				//bond = b;
				b.addPayment(amount, time, term);
				return true;
			}
		}
		return false;
		/*if(bond != null) {
			bond.addPayment(amount, time, term);
			return true;
		}else {
			return false;
		}*/
	}
	
	ArrayList<Bond> getPortfolio(){
		return portfolio;
	}
	
/*	Payment getPayment(){
		return payment;
	}*/
	
	Bond getNewBonds(){
		return newBonds;
	}
	
	public double getMacaulay(double r) { //gets mac duration for the last bond that was added
		return newBonds.getMacD(r);
	}
	
	public double getIRR() {
		return newBonds.getIRR();
	}
	
	public double getSumDiscounts(double r) {
		int disc = 0;
		for(Bond b: portfolio) {
			disc+=b.getValue(r);
		}
		return disc;
	}
}
