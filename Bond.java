import java.util.ArrayList;

public class Bond {
	
	private double term;//number of years to expiry
	private double coupon;//percentage of investment paid to investor at regular intervals
	private String name;
	private int purchaseDate;
	private double price;
	private ArrayList<Payment> listOfPayments;
	
	public Bond(int t, double c, String n,int d, double p){
		term=t;
		coupon=c;
		name=n;
		purchaseDate=d;
		price=p;//assume investment=100
		listOfPayments = new ArrayList<Payment>();
	}
	
	void addPayment(double amount, int time, int term) {
		listOfPayments.add(new Payment(amount, time, term));
	}
	
	double getPayout(){//compute the pay out of this bond
		return (coupon/100*100*1*listOfPayments.get(0).getTerm())+100;
	}
	
	double getDiscount(double r, Payment pay){//System computes discount for each payment, and hence value of bond.
		double disc=0;
		for(int i=1;i<=(1*pay.getTerm());i++){
			disc+=(coupon/100*100)/Math.pow((1+r), i);
		}
		return disc+(100/Math.pow((1+r), (1*pay.getTerm())));
	}
	
	double getValue(double r){//System computes discount for each payment, and hence value of bond.
		double value=0;
		for(Payment p : listOfPayments) {
			value+= getDiscount(r, p);
		}
		return value;
	}
	
	double getMacD(double r){//For each bond, system should calculate its Macaulay duration for rate r
		double md=0;
		for(int i=1;i<=(1*term);i++){
			md+=i*coupon/100*100/Math.pow((1+r), i);
		}
		return (md+(term*100/Math.pow((1+r),term)))/getValue(r);
	}
	
	double getIRR(){//For each bond, system should compute its internal rate of return
		double irr=0;
		double s1=0;
		double s2=0;
		if(price-getValue(irr)>0){
			s1=price-getValue(irr);
		}else if(price-getValue(irr)<0){
			s1=getValue(irr)-price;
		}else{
			s1=0;
		}
		if(price-getValue(irr+0.0000001)>0){
			s2=price-getValue(irr+0.0000001);
		}else if(price-getValue(irr+0.0000001)<0){
			s2=getValue(irr+0.0000001)-price;
		}else{
			s2=0;
		}
		while(irr<1){
			if(s1>=s2){
				s1=s2;
				irr=irr+0.0000001;
				if(price-getValue(irr)>0){
					s2=price-getValue(irr);
				}else if(price-getValue(irr)<0){
					s2=getValue(irr)-price;
				}else{
					s2=0;
				}
			}else if(s2>s1){
				break;
			}
		}
		return irr;
	}
	
	public String getName() {
		return name;
	}
	
}
