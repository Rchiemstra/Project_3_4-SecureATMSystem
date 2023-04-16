package com.example;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class FAIL_Bank {

	private Panel p1;
	private	Panel p2;
	private	Panel p3;
	private	Panel p4;
	private Panel p5;
	private Panel p6;
	private Panel p7;
	private Panel p8;
	private Panel p9;
	private Panel p10;




	private JFrame frame = new JFrame("F.A.I.L. Bank");
	private JPanel panelCont = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	private App app;
	private DB db = new DB();


	private boolean endTransactie;
	private String taalkeuze;


	//maakt de failbank
	public FAIL_Bank(App app) {

		this.app=app;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setUndecorated(true);
		frame.getContentPane().setPreferredSize(screenSize);
		frame.pack();
		panelCont.setLayout(cardLayout);
		maakPanle();
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		while (true) {
			endTransactie = true ;
			doTransactie();
		}
	}


	//maaktde pannelen
	public void maakPanle() {
		p1 = new Panel("1",panelCont,cardLayout,app);
		p2 = new Panel("2",panelCont,cardLayout,app);
		p3 = new Panel("3",panelCont,cardLayout,app);
		p4 = new Panel("4",panelCont,cardLayout,app);
		p5 = new Panel("5",panelCont,cardLayout,app);
		p6 = new Panel("6",panelCont,cardLayout,app);
		p7 = new Panel("7",panelCont,cardLayout,app);
		p8 = new Panel("8",panelCont,cardLayout,app);
		p9 = new Panel("9",panelCont,cardLayout,app);
		p10 = new Panel("10",panelCont,cardLayout,app);


		p1.addPanel();
		p2.addPanel();
		p3.addPanel();
		p3.addPanel();
		p4.addPanel();
		p5.addPanel();
		p6.addPanel();
		p7.addPanel();
		p9.addPanel();
		p8.addPanel();
		p10.addPanel();

	}
	public void taal(String string) {
		p1.setText(string);
		p2.setText(string);
		p3.setText(string);
		p4.setText(string);
		p5.setText(string);
		p6.setText(string);
		p7.setText(string);
		p8.setText(string);
		p9.setText(string);
		p10.setText(string);
	}


	public void sleep() {
		int x = 3000;
		try {
			Thread.sleep(x);
			app.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	//zal altijd deze transactie draaien
	public void doTransactie() {

		//kies een taal
		p8.nextPanel("1");
		kiesTtaal();


		//scna je pas je 
		p1.nextPanel("2");
		String iban = getIBAN();
		if (iban==null) {
			return;
		}

		//Pin scherm
		p2.nextPanel("3");
		String pin =getPin(iban);
		if (pin==null) {
			return;
		}


		while (true) {

			if (!endTransactie) {
				break;
			}
			
			//kies een optie
			p3.nextPanel("4");
			String keuze = getKeuze();
			if (keuze ==null) {
				break;
			}else if (keuze.equals("A")) {
				while (true) {
					
					//Bedrag kiezen
					p4.nextPanel("5");

					String keuze1 = getKeuze1();
					int amount ;

					if (keuze1 ==null) {
						return;

					//snel kiezen 10 euro
					}else if (keuze1.equals("A")) {
						amount= 10;

						boolean withdrawalError = setAmount(iban, amount, pin)	;

						if (withdrawalError) {
							p5.FoutNietGenoegGeld(taalkeuze);
							continue;
						}

						p8.geldUitgeven(taalkeuze, amount);
						p5.nextPanel("8");
						String keuze2= getKeuze2();

						if (keuze2 ==null) {

							
						}else if (keuze2.equals("A")) {
							stopTransactie();
							break;
						}else if (keuze2.equals("B")) {
							stopTransactie();
							break;
						}




					}else if (keuze1.equals("B")) {
						amount= 20;


						boolean withdrawalError = setAmount(iban, amount, pin)	;

						if (withdrawalError) {
							p5.FoutNietGenoegGeld(taalkeuze);
							continue;
						}

						//DB

						p8.geldUitgeven(taalkeuze, amount);
						p5.nextPanel("8");
						String keuze2= getKeuze2();

						if (keuze2 ==null) {

						}else if (keuze2.equals("A")) {
							stopTransactie();
							break;
						}else if (keuze2.equals("B")) {
							stopTransactie();
							break;
						}

					}else if (keuze1.equals("C")) {
						amount= 50;

						boolean withdrawalError = setAmount(iban, amount, pin)	;

						if (withdrawalError) {
							p5.FoutNietGenoegGeld(taalkeuze);
							continue;
						}

						p8.geldUitgeven(taalkeuze, amount);
						p5.nextPanel("8");
						String keuze2= getKeuze2();

						if (keuze2 ==null) {

						}else if (keuze2.equals("A")) {
							stopTransactie();
							break;
						}else if (keuze2.equals("B")) {
							stopTransactie();
							break;
						}

					}else if (keuze1.equals("D")) {
						p5.nextPanel("9");
						amount = getAmount();

						if (amount ==-1) {
							return;
						}else if (amount ==-2) {
							continue;
						}

						boolean withdrawalError = setAmount(iban, amount, pin)	;

						if (withdrawalError) {
							p5.FoutNietGenoegGeld(taalkeuze);
							continue;
						}
						
						p8.geldUitgeven(taalkeuze, amount);
	
						int[] brievenAuto = geldKiezen(amount);
						
						p9.nextPanel("10");
						
						int[] brieven = getBrieven(brievenAuto,amount);
						
						p5.nextPanel("8");

						String keuze2= getKeuze2();

						
						String deBon = null;
						
						if (keuze2 ==null) {

						}else if (keuze2.equals("A")) {
							
							deBon = "j";
						}else if (keuze2.equals("B")) {
							deBon = "n";
						}
						stuurbrieven(iban, brieven, deBon);
						stopTransactie();
						break;
					}else if (keuze1.equals("*")) {
						break;

					}
				}


			}else if (keuze.equals("B")) {
			}else if (keuze.equals("C")) {
				p4.nextPanel("7");

				int amount;
				amount = getAmount1();

				if (amount ==-1) {
					break;
				}else if (amount ==-2) {
					continue;
				}


				String keuze2= getKeuze2();

				if (keuze2 ==null) {
					stopTransactie();		
					break;
				}else if (keuze2.equals("A")) {

					//sleep();
					break;
				}else if (keuze2.equals("B")) {
					continue;
				}

			}

		}

	}


	private void stuurbrieven(String iban,int[] brieven,String deBon ) {
		app.writetoport(iban);
		app.writetoport(String.valueOf(brieven[2]));
		app.writetoport(String.valueOf(brieven[1]));
		app.writetoport(String.valueOf(brieven[0]));
		app.writetoport(deBon);	
	}



	private int[] geldKiezen(int amount) {

		int amount50=0;
		int amount20=0;
		int amount10=0;
		
		while (amount >0) {
			if ((amount/50)>=1) {
				amount50=amount50+1;
				amount=amount-50;
			}else if ((amount/20)>=1) {
				amount=amount-20;
				amount20=amount20+1;
			}else if ((amount/10)>=1) {
				amount=amount-10;
				amount10=amount10+1;
				
			}
		}
		
		int[] brievenAuto = {amount50,amount20,amount10} ; 
		
		p10.brieventext(brievenAuto);
		
		return brievenAuto;
	}


	String[]getText(App app) {
		String[] text = app.isText();
		return text;
	}


	void stopTransactie() {
		endTransactie = false;
	}

	public void kiesTtaal() {
		String[] y =null;

		String x1 =null;
		String x =null;

		taalkeuze = null;
		while (taalkeuze==null) {
			y= getText(app);
			x = y[0]; 
			x1 =y[1];

			if (x!=null) {
				if (x.equals("A")) {
					taal(x);
					taalkeuze = "A";
				}else if (x.equals("B")){

					taal(x);
					taalkeuze = "B";
				}else if (x.equals("C")){
					taal(x);
					taalkeuze = "C";
				}else if (x.equals("D")){
					taal(x);
					taalkeuze = "D";
				}
			}

		}

	}



	public boolean setAmount(String iban, int amount, String pin) {
		boolean withdrawalError = false;
		withdrawalError = db.dbwithdrawal(iban, pin, amount);
		return !withdrawalError;
	}


	String getIBAN() {

		String[] y =null;

		String iban =null;
		String waarde =null;

		boolean ibancorrect = true;

		while (ibancorrect) {
			iban =null;
			while (iban==null) {
				y= getText(app);
				waarde = y[0]; 
				iban =y[1];
				if (waarde!=null) {
					if (waarde.equals("#")) {
						stopTransactie();
						return null;						
					}
				}

			}

			ibancorrect = !(validateIban(iban));

			if (ibancorrect) {
				p2.foutIBAN(taalkeuze,!validateIban(iban),false);
			}
		}
		return iban;
	}



	String getPin(String useriban) {

		p3.passwordField.setText(null);
		List<String> pinValues= new ArrayList<String>();
		String[] y =null;

		String waarde =null;
		String iban =null;

		boolean accept = false;



		if (!db.dbPogingen(useriban)) {
			p3.foutAantalPin(taalkeuze);
			 sleep();
			return null;
		}



		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {

				if (waarde.equals("#")) {
					stopTransactie();
					return null;						
				}else if (waarde.equals("B")||waarde.equals("C")||waarde.equals("D")) {

				}else if (waarde.equals("*")) {
					try {
						pinValues.remove(pinValues.size()-1);
					} catch (Exception e) {
					}				
				}else if (waarde.equals("A")&&pinValues.size()==4) {


					if (db.dbPin(String.join("", pinValues),useriban)) {
						accept = true;
					}else {
						p3.foutPin(taalkeuze);

						if (!db.dbPogingen(useriban)) {
							p3.foutAantalPin(taalkeuze);
							sleep();
							return null;
						}
						pinValues.clear();

					}

				}else if (waarde.equals("A")&&pinValues.isEmpty()) {
					p3.foutGeenPin(taalkeuze);

				}else if (waarde.equals("A")) {
					p3.foutPinTeKlein(taalkeuze);

				}else{
					if (pinValues.size()<4) {
						pinValues.add(waarde);

					}
				}
				p3.passwordField.setText(null);
				p3.passwordField.setText(String.join("", pinValues));

			}

		}

		return String.join("", pinValues);

	}

	int[] getBrieven(int[] brievenAuto, int amount) {

		int[] brieven = brievenAuto;
		String iban =null;
		String waarde =null;

		boolean accept = false;
		String[] y =null;

		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {
				if (waarde.equals("#")) {
					stopTransactie();
					return null;						
				}if (waarde.equals("A")) {
					accept = true;
				} if (waarde.equals("B")) {//50
					
					if(brieven[1]>6) {
						brieven[0] = brieven[0] +1;	
						brieven[1] = brieven[1] -5;
					}if (brieven[2]>5) {
						brieven[0] = brieven[0] +1;	
						brieven[1] = brieven[1] -5;						
					}

				}if (waarde.equals("C")) {//20
					
				}if (waarde.equals("D")) {//10
				
					brieven[2] = brieven[2] +1; 
				}
				p10.brieventext(brieven);
			}

		}
		return brieven;	
	}
	
	

	String getKeuze() {

		String iban =null;
		String waarde =null;

		boolean accept = false;
		String[] y =null;

		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {

				if (waarde.equals("#")) {
					stopTransactie();
					return null;						
				}if (waarde.equals("A")) {
					accept = true;
				} if (waarde.equals("B")) {
					//accept = true;
				}if (waarde.equals("C")) {
					//accept = true;
				}
			}

		}
		return waarde;	
	}

	
	String getKeuze1() {

		String iban =null;
		String waarde =null;

		boolean accept = false;
		String[] y =null;

		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {

				if (waarde.equals("#")) {
					stopTransactie();
					return null;						
				}if (waarde.equals("A")) {
					accept = true;
				} if (waarde.equals("B")) {
					accept = true;
				}if (waarde.equals("C")) {
					accept = true;
				}if (waarde.equals("D")) {
					accept = true;
				}if (waarde.equals("*")) {
					accept = true;
				}
			}

		}
		return waarde;
	}

	String getKeuze2() {
		String iban =null;
		String waarde =null;

		boolean accept = false;
		String[] y =null;

		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {

				if (waarde.equals("#")) {
					stopTransactie();
					return null;						
				}if (waarde.equals("A")) {
					accept = true;
				} if (waarde.equals("B")) {
					accept = true;
				}
			}
		}
		return waarde;
	}

	
	int getAmount() {

		p9.textField.setText("�");
		List<String> amountValues= new ArrayList<String>();
		String[] y =null;

		String iban =null;
		String waarde =null;

		boolean accept = false;

		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {

				if (waarde.equals("#")) {
					stopTransactie();
					return -1;						
				}else if (waarde.equals("C")||waarde.equals("D")) {

				}else if (waarde.equals("B")&& p9.iszichtbaar() ) {
					return -2;

				}else if (waarde.equals("*")) {
					try {
						amountValues.remove(amountValues.size()-1);
					} catch (Exception e) {
					}				
				}else if (waarde.equals("A")&&amountValues.size()>=1) {

					if ((Integer.parseInt(String.join("", amountValues))>200)) {
						p9.foutOverMaxBedrag(taalkeuze);

					}else if(
							(Integer.parseInt(String.join("", amountValues))%10)== 0
							&&
							(Integer.parseInt(String.join("", amountValues)))!=0) {
							accept = true;
					}else {
						p9.foutBedrag(taalkeuze);
					}
				}else if (waarde.equals("A")) {
				}else{
					if (amountValues.size()<3) {
						amountValues.add(waarde);
					}
				}
				p9.textField.setText(null);
				p9.textField.setText("�"+String.join("", amountValues));

				System.out.println(amountValues.size());
			}
		}
		return Integer.parseInt(String.join("", amountValues));
	}

	int getAmount1() {
		p7.textField.setText("�");
		List<String> amountValues= new ArrayList<String>();
		String[] y =null;

		String iban =null;
		String waarde =null;

		boolean accept = false;

		while (!accept) {
			y= getText(app);
			waarde = y[0]; 
			iban =y[1];
			if (waarde!=null) {

				if (waarde.equals("#")) {
					stopTransactie();
					return -1;						
				}else if (waarde.equals("C")||waarde.equals("D")) {

				}else if (waarde.equals("*")&& p5.iszichtbaar() ) {
					return -2;

				}else if (waarde.equals("B")&& p7.iszichtbaar() ) {
					return -2;

				}else if (waarde.equals("*")) {
					try {
						amountValues.remove(amountValues.size()-1);
					} catch (Exception e) {
					}				
				}else if (waarde.equals("A")&&amountValues.size()>=1) {

					if ((Integer.parseInt(String.join("", amountValues))>250)) {
						p9.foutOverMaxBedrag(taalkeuze);

					}else {
						accept = true;
					}
				}else if (waarde.equals("A")) {
					
				}else{
					if (amountValues.size()<3) {
						amountValues.add(waarde);
					}
				}
				p7.textField.setText(null);
				p7.textField.setText("�"+String.join("", amountValues));

				System.out.println(amountValues.size());
			}
		}
		return Integer.parseInt(String.join("", amountValues));
	}

	public boolean validateIban(String iban){
		if (iban ==null) {
			return false;
		}
		iban = iban.toUpperCase();
		String countryCode = iban.substring(0, 2);
		String controlNumber = iban.substring(2, 4);
		String bankCode = iban.substring(4, 8);
		String bankPassNumber = iban.substring(8, 14);
		String countryCodeRotated = ibanUpRot(countryCode);
		String bankCodeRotated = ibanUpRot(bankCode);
		BigInteger validatedIban = new BigInteger(bankCodeRotated + bankPassNumber + countryCodeRotated + controlNumber).mod(new BigInteger("97"));
		if(validatedIban.intValue() != 1){
			return false;
		}
		return true;
	}

	
	public String ibanUpRot(String str){
		String ret = "";
		for(char c : str.toCharArray()){
			ret += c - 64 + 9;
		}
		return ret;
	}
}

