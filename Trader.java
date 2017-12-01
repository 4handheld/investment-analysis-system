

import java.util.ArrayList;

public class Trader {
ArrayList<Bond> portfolio = new ArrayList<Bond>();
int UserID;

public void defineBonds(int t, double c, String n, int d, double p){//System enables new bonds to be defined.
	portfolio.add(new Bond(t,c,n,d,p));
}

public ArrayList<Bond> getPortfolio(){
	return portfolio;
}


}
