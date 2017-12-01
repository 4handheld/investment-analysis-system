

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GUI {
	private JFrame MainFrame = new JFrame();
	public static void main(String[] args) {
		Investor investor = new Investor();
		Trader trader = new Trader();
		GUI gui = new GUI(investor, trader);
	}
	
	public GUI(Investor investor, Trader trader) {
		JTabbedPane jtp = new JTabbedPane();
		MainFrame.add(jtp);
		JPanel investorPanel = new JPanel();
		JPanel traderPanel = new JPanel();
		
		jtp.add(investorPanel, "Investor Panel");
		jtp.add(traderPanel, "Trader Panel");
		
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setLayout(new FlowLayout());
		MainFrame.setTitle("OSD Group Project");
		
		JButton x = new JButton("Define Bond");//they give term, coupon, name, purchasedate, price
		x.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("purchase bond pressed");
				String result = JOptionPane.showInputDialog("Enter term, coupon, name, purchasedate, price with only a comma between each value");
				String[] r = result.split(",");
				trader.defineBonds(Integer.parseInt(r[0]), Double.parseDouble(r[1]), r[2], Integer.parseInt(r[3]), Double.parseDouble(r[4]));
				investor.purchaseBonds(trader.getPortfolio().get(trader.getPortfolio().size() - 1));
				System.out.println("Added new bond for values: " + result);
				System.out.println("New bond added to investor.");
			}
			
		});
		JButton y = new JButton("Create Payment");
		y.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("create payment pressed");
				String result = JOptionPane.showInputDialog("Enter name of bond, amount, time, term with only a comma between each value");
				String[] r = result.split(",");
				investor.createPayment(r[0], Double.parseDouble(r[1]), Integer.parseInt(r[2]), Integer.parseInt(r[3]));
				System.out.println("Payment successfully created");
			}
		});
		JButton z = new JButton("Show Values");
		z.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("show values pressed");
				String result = JOptionPane.showInputDialog("Enter the inflation rate r, to calculate the sum of discounted payments");
				
				//System.out.print("sum of disc "); System.out.printf("%.2f", investor.getSumDiscounts((Double.parseDouble(result))));
				
				
				for(Bond b : investor.getPortfolio()) {
					System.out.println("Value for bond: " + b.getName() + " = " + b.getValue(Double.parseDouble(result)));
				}
				
			}
		});
		
		JButton macButton = new JButton("Show Macaulay Duration");
		macButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				System.out.println("macaulay button pressed");
				String result = JOptionPane.showInputDialog("Enter the inflation rate r, to calculate the Macaulay duration");
				
				System.out.println(investor.getMacaulay(Double.parseDouble(result)));
			}
		});
		
		JButton irrButton = new JButton("Show Internal Rate of Return");
		irrButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("IRR button pressed");
				System.out.println(investor.getIRR());

			}
		});
		
		JButton payoutButton = new JButton("Show Payouts");
		payoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println("payouts button pressed");
					//System.out.println(investor.getPayment().getAmount());
					for(Bond b : investor.getPortfolio()) {
						System.out.println("Payout for bond: " + b.getName() + " = " + b.getPayout());
					}
			}
		});
		
		traderPanel.add(x); investorPanel.add(y); investorPanel.add(z); investorPanel.add(macButton); investorPanel.add(irrButton); investorPanel.add(payoutButton);
		
		
		
		MainFrame.setVisible(true);
		MainFrame.pack();
	}
}
