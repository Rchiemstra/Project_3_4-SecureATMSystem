package com.example;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Panel  {

	//hier worden alle panles gemaakt

	protected JPanel panelCont;
	protected CardLayout cardLayout;
	protected String panelName;
	protected JPanel panel = new JPanel();
	private App app;	




	LabelTitel T1 ; 
	LabelTitel T2; 
	LabelTitel T3; 
	LabelTitel T4; 
	LabelTitel T5; 
	LabelTitel T6; 
	LabelTitel T7;	
	LabelTitel T8;	
	LabelTitel T9;
	LabelTitel T10;

	LabelOpties lA1 ;
	LabelOpties lB1 ;
	LabelOpties lC1 ;
	LabelOpties lD1 ;
	LabelOpties lS1 ;
	LabelOpties lF1 ;

	LabelOpties lA4 ;
	LabelOpties lB4 ;
	LabelOpties lC4 ;
	LabelOpties lD4 ;

	LabelOpties lD5 ;

	JPasswordField passwordField;
	JTextField textField  ;

	public Panel(String panelName, JPanel panelCont, CardLayout cardLayout, App app) {
		this.app = app;
		this.cardLayout = cardLayout;
		this.panelCont = panelCont;
		this.panelName = panelName;
		this.panel = new JPanel();

		panel.setLayout(null);	

		ActionListener actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//app.writetoport(panelName);
				cardLayout.next(panelCont);

			}

		};

		new LabelBank(panel);
		new LabelTijd(panel);

		//elke pannel ziet er anders uit dat wordt hier dus gemaakt
		if (panelName.equals("1")) {



			new Knop("A",panel,actionListener);
			new Knop("B",panel,actionListener);
			new Knop("C",panel,actionListener);
			new Knop("D",panel,actionListener);

			T1= new LabelTitel("",panel);
			lA1 = new LabelOpties("Engels", "A",panel);
			lB1 = new LabelOpties("Nederlands", "B",panel);
			lC1 = new LabelOpties("Deutsch", "C",panel);
			lD1 = new LabelOpties("Espa�ol", "D",panel);

			setText(null);

		}else if (panelName.equals("2")) {


			new Knop("#",panel,actionListener);


			T2 =new LabelTitel("",panel);
			lS1 = new LabelOpties("", "#",panel);


			setText(null);
		}else if (panelName.equals("3")) {



			passwordField = new JPasswordField();
			passwordField.setBounds((1920/2)-(300/2),(1080/2)-(100/2),300,100);
			passwordField.setBorder(null);
			passwordField.setBackground(Color.WHITE);
			passwordField.setForeground(Color.BLACK);
			passwordField.setFont(new Font("Dialog", Font.BOLD, 75));
			passwordField.setHorizontalAlignment(JPasswordField.CENTER);
			passwordField.setEditable( false );

			panel.add(passwordField);

			T3 = new LabelTitel("",panel);

			new Knop("A",panel,actionListener);
			new Knop("#",panel,actionListener);
			new Knop("*",panel,actionListener);

			lA1 = new LabelOpties("", "A",panel);
			lF1 = new LabelOpties("", "*",panel);
			lS1 = new LabelOpties("", "#",panel);

			setText(null);

		}else if (panelName.equals("4")) {

			new Knop("A",panel,actionListener);
			//new Knop("B",panel,actionListener);
			//new Knop("C",panel,actionListener);
			new Knop("#",panel,actionListener);



			T4 = new LabelTitel("",panel);

			lA4=new LabelOpties("", "A",panel);
			//lB4=new LabelOpties("", "B",panel);
			//lC4=new LabelOpties("", "C",panel);
			lS1 = new LabelOpties("", "#",panel);			


			setText(null);


		}else if (panelName.equals("5")) {

			T5=new LabelTitel("",panel);

			new Knop("A",panel,actionListener);
			new Knop("B",panel,actionListener);
			new Knop("C",panel,actionListener);
			new Knop("D",panel,actionListener);
			new Knop("#",panel,actionListener);
			new Knop("*",panel,actionListener);



			new LabelOpties("�10", "A",panel);
			new LabelOpties("�20", "B",panel);
			new LabelOpties("�50", "C",panel);
			lD5=new LabelOpties("", "D",panel);
			lF1 = new LabelOpties("", "*",panel);
			lS1 = new LabelOpties("", "#",panel);	

			setText(null);

		}else if (panelName.equals("6")) {

			textField = new JTextField();
			textField.setBorder(null);
			textField.setBackground(Color.WHITE);
			textField.setForeground(Color.BLACK);
			textField.setFont(new Font("Dialog", Font.BOLD, 75));
			textField.setBounds((1920/2)-(300/2),(1080/2)-(100/2),300,100);
			panel.add(textField);
			textField.setEditable( false );
			textField.setHorizontalAlignment(JTextField.CENTER);

			new Knop("A",panel,actionListener);
			new Knop("B",panel,actionListener);
			new Knop("#",panel,actionListener);

			T6= new LabelTitel("",panel);
			lA1=new LabelOpties("", "A",panel);
			lB1=new LabelOpties("", "B",panel);
			lS1 = new LabelOpties("", "#",panel);	

			setText(null);

		}else if (panelName.equals("7")) {

			textField = new JTextField();
			textField.setBorder(null);
			textField.setBackground(Color.WHITE);
			textField.setForeground(Color.BLACK);
			textField.setFont(new Font("Dialog", Font.BOLD, 75));
			textField.setBounds((1920/2)-(300/2),(1080/2)-(100/2),300,100);
			panel.add(textField);
			textField.setEditable( false );
			textField.setHorizontalAlignment(JTextField.CENTER);

			new Knop("A",panel,actionListener);
			new Knop("#",panel,actionListener);
			new Knop("*",panel,actionListener);
			new Knop("B",panel,actionListener);


			T7=new LabelTitel("",panel);
			lA1=new LabelOpties("", "A",panel);
			lF1 = new LabelOpties("", "*",panel);
			lS1 = new LabelOpties("", "#",panel);	
			lB1=new LabelOpties("", "B",panel);


			setText(null);

		}else if (panelName.equals("8")) {

			new Knop("A",panel,actionListener);//weg hallen?????!!!!
			new Knop("B",panel,actionListener);

			T8=new LabelTitel("",panel);
			lA1=new LabelOpties("", "A",panel);
			lB1=new LabelOpties("", "B",panel);

			setText(null);
		}else if (panelName.equals("9")) {

			textField = new JTextField();
			textField.setBorder(null);
			textField.setBackground(Color.WHITE);
			textField.setForeground(Color.BLACK);
			textField.setFont(new Font("Dialog", Font.BOLD, 75));
			textField.setBounds((1920/2)-(300/2),(1080/2)-(100/2),300,100);
			panel.add(textField);
			textField.setEditable( false );
			textField.setHorizontalAlignment(JTextField.CENTER);

			new Knop("A",panel,actionListener);
			new Knop("#",panel,actionListener);
			new Knop("*",panel,actionListener);
			new Knop("B",panel,actionListener);

			T9=new LabelTitel("",panel);
			lA1=new LabelOpties("", "A",panel);
			lF1 = new LabelOpties("", "*",panel);
			lS1 = new LabelOpties("", "#",panel);	
			lB1=new LabelOpties("", "B",panel);

			/*

			T9=new LabelTitel("",panel);
			lA1=new LabelOpties("", "A",panel);
			lF1 = new LabelOpties("", "*",panel);
			lS1 = new LabelOpties("", "#",panel);	


			 */
			setText(null);

		}else if (panelName.equals("10")) {


			T10=new LabelTitel("Hallo",panel);

			new Knop("A",panel,actionListener);
			new Knop("B",panel,actionListener);
			new Knop("C",panel,actionListener);
			new Knop("D",panel,actionListener);
			new Knop("#",panel,actionListener);
			new Knop("*",panel,actionListener);


			lA1=new LabelOpties("", "A",panel);
			lB1=new LabelOpties("�10", "B",panel);
			lC1=new LabelOpties("�20", "C",panel);
			lD1=new LabelOpties("�50", "D",panel);

			lF1 = new LabelOpties("", "*",panel);
			lS1 = new LabelOpties("", "#",panel);	

			setText(null);


		}


		//voegt een achtergeond aan de de pannel toe
		try {
			Image img = ImageIO.read(getClass().getResource("./res/bank.png"));
			ImageIcon imageIcon  = new ImageIcon(img);
			JLabel back = new JLabel("",imageIcon,JLabel.CENTER);
			back.setBounds(0, 0, 1920, 1080);

			panel.add(back);		
		} catch (Exception ex) {
			System.out.println(ex);
		}	

	}

	//voegt de pannel toe
	public void addPanel( ) {
		this.panelCont.add(this.panel,this.panelName);
	}

	//hier kan je de volgende pannel laten zien 
	public void nextPanel(String namePanel ) {
		cardLayout.show(panelCont,namePanel );
	}

	//hier kan je kijken of de panel zichtbaar is
	public boolean iszichtbaar() {
		return panel.isShowing();
	}

	// sommig opdrachten worden met een speciefieke text uit gevoerd dat worden door deze fucties gedaan
	public void foutOverMaxBedrag(String string) {

		int amount=200;

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T9.newText("The maximum amount is �"+amount);

		}else if (string.equals("B")) {

			T9.newText("Het maximale bedrag is �" + amount);

		} else if (string.equals("C")) {

			T9.newText("Der H�chstbetrag betr�gt" +amount+ "�");

		}else if (string.equals("D")) {

			T9.newText("El importe m�ximo es de"+amount+"�.");

		}
	}


	public void foutBedrag(String string) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T9.newText("The amount you entered cannot be spent");

		}else if (string.equals("B")) {

			T9.newText("Het bedrag dat u heeft ingevuld kan niet worden uitgeven");

		} else if (string.equals("C")) {

			T9.newText("Der eingegebene Betrag kann nicht ausgegeben werden");

		}else if (string.equals("D")) {

			T9.newText("La cantidad que ingresaste no se puede gastar");

		}
	}


	public void foutIBAN(String string, boolean validateIban, boolean dbIBAN) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			if (dbIBAN) {
				T2.newText("Your IBAN is not in the database");
			}else if (validateIban) {
				T2.newText("Your IBAN does not meet the requirements");
			}


		} if (string.equals("B")) {

			if (dbIBAN) {
				T2.newText("Jouw IBAN staat niet in de database");
			}else if (validateIban) {
				T2.newText("Jouw IBAN voldoet niet aan de voorschriften");
			}

		}if (string.equals("C")) {

			if (dbIBAN) {
				T2.newText("Ihre IBAN befindet sich nicht in der Datenbank");
			}else if (validateIban) {
				T2.newText("Ihre IBAN erf�llt die Anforderungen nicht");
			}

		}if (string.equals("D")) {

			if (dbIBAN) {
				T2.newText("Su IBAN no est� en la base de datos");
			}else if (validateIban) {
				T2.newText("Su IBAN no cumple con los requisitos");
			}


		}
	}


	public void foutPinTeKlein(String string ) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T3.newText("Minimum of 4 numbers");

		} else if  (string.equals("B")) {

			T3.newText("Minimaal 4 numbers");

		}else if  (string.equals("C")) {

			T3.newText("Minimum von 4 Zahlen");

		}else if (string.equals("D")) {

			T3.newText("M�nimo de 4 n�meros.");

		}
	}

	public void foutPin(String string ) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T3.newText("Wrong pin entered");

		}else if (string.equals("B")) {

			T3.newText("Foute pin ingevoerd");

		} else if (string.equals("C")) {

			T3.newText("Falsche PIN eingegeben");

		}else if (string.equals("D")) {

			T3.newText("Pin incorrecto introducido");

		}
	}


	public void foutAantalPin(String string ) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T3.newText("Number of attempts exceeded");

		} if (string.equals("B")) {

			T3.newText("Aantal pogingen overschreden");

		}if (string.equals("C")) {

			T3.newText("Anzahl der Versuche �berschritten");

		}if (string.equals("D")) {

			T3.newText("N�mero de intentos superados");

		}
	}

	public void foutGeenPin(String string ) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T3.newText("No pin entered");

		} if (string.equals("B")) {

			T3.newText("Geen pin ingevuld");

		}if (string.equals("C")) {

			T3.newText("Es wurde kein Pin eingegeben");

		}if (string.equals("D")) {

			T3.newText("No ha ingresado ning�n pin");

		}
	}

	public void FoutNietGenoegGeld(String string ) {

		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T5.newText("<html>"
					+ "Your balance is too low. Choose a different amount"
					+ "</html>");

		} if (string.equals("B")) {

			T5.newText("<html>"
					+ "U saldo is te laag. Kies een andere bedrag"
					+ "</html>");

		}if (string.equals("C")) {

			T5.newText("<html>"
					+ "Ihr Guthaben ist zu niedrig. W�hlen Sie eine andere Menge"
					+ "</html>");

		}if (string.equals("D")) {

			T5.newText("<html>"
					+"Tu saldo es demasiado bajo. Elija una cantidad diferente"
					+ "</html>");

		}


	}

	public void geldUitgeven(String string, int amount ) {


		if (string==null) {
			return;
		}

		if (string.equals("A")) {

			T8.newText("<html>"
					+ "The amount of �"+ amount+" is now being spent."
					+ "<br/>"
					+ "One moment please "
					+ "<br/>"
					+ "<br/>"
					+ "Would you like the receipt?"
					+ "</html>");


		} if (string.equals("B")) {

			T8.newText("<html>"
					+ "Het bedrag van �"+ amount+" wordt nu uitgegeven."
					+ "<br/>Even geduld aub"
					+ "<br/>"
					+ "<br/>"
					+ "Zou u de bon willen?" 
					+ "</html>");

		}if (string.equals("C")) {

			T8.newText("<html>"
					+ "Der Betrag von �"+ amount+" wird jetzt ausgegeben."
					+ "<br/>"
					+ "Einen Moment bitte"
					+ "<br/>"
					+ "<br/>"
					+ " M�chten Sie die Quittung?"
					+ "</html>");


		}if (string.equals("D")) {

			T8.newText("<html>"
					+ "La cantidad de �"+ amount+" ahora se est� gastando."
					+ "<br/>"
					+ "Un momento por favor"
					+ "<br/>"
					+ "<br/>"
					+ "�Te gustar�a el recibo?"
					+ "</html>");

		}

	}

	void brieventext(int[] brieven){

		lB1.newText(brieven[0]+": � 50");
		lC1.newText(brieven[1]+": � 20");
		lD1.newText(brieven[2]+": � 10");

	}





	//Hier zijn alle talen neer gezet

	public void setText(String string) {
		if (string == null) {

			setText("B");

		}else if (string.equals("A")) {


			if (panelName.equals("1")) {

				T1.newText("Select your language");

			}else if (panelName.equals("2")) {

				T2.newText("Scan your debit card");
				lS1.newText("Stop");


			}else if (panelName.equals("3")) {

				T3.newText("Enter your PIN code");
				lA1.newText("Accept");
				lS1.newText("Stop");
				lF1.newText("Correction");

			}else if (panelName.equals("4")) {

				T4.newText("Choose from the following options");

				lA4.newText("Withdrawal");
				//lB4.newText("Balance information");
				//lC4.newText("To donate");

				lS1.newText("Stop");

			}else if (panelName.equals("5")) {

				T5.newText("Withdrawal");
				lS1.newText("Stop");
				lF1.newText("Back");
				lD5.newText("Other amount");

			}else if (panelName.equals("6")) {

				T6.newText("Balance information");
				lA1.newText("Accept");
				lS1.newText("Stop");
				lB1.newText("Back");


			}else if (panelName.equals("7")) {

				T7.newText("To donate");
				lA1.newText("Accept");
				lS1.newText("Stop");
				lF1.newText("Correction");
				lB1.newText("Back");

			}else if (panelName.equals("8")) {


				lA1.newText("Yes");
				lB1.newText("No");


			}else if (panelName.equals("9")) {

				T9.newText("Enter the desired amount");
				lA1.newText("Accept");
				lS1.newText("Stop");
				lF1.newText("Correction");
				lB1.newText("Back");
			}else if (panelName.equals("10")) {
				T10.newText("");
				lA1.newText("Accept");
				lS1.newText("Stop");
				lB1.newText("Back");
				lB1.newText("");
				lC1.newText("");
				lD1.newText("");

			}


		}else if(string.equals("B")) {


			if (panelName.equals("1")) {


				T1.newText("Selecteer uw taal");

			}else if (panelName.equals("2")) {

				T2.newText("Scan uw pinpas");
				lS1.newText("Stop");

			}else if (panelName.equals("3")) {

				T3.newText("Vul uw pincode in");
				lA1.newText("Accepteren");
				lS1.newText("Stop");
				lF1.newText("Correctie");

			}else if (panelName.equals("4")) {

				T4.newText("Kies uit de volgende opties");

				lA4.newText("Opnamen");
				lS1.newText("Stop");

			}else if (panelName.equals("5")) {

				T5.newText("Opnamen");
				lS1.newText("Stop");
				lF1.newText("Terug");
				lD5.newText("Ander bedrag");

			}else if (panelName.equals("6")) {

				T6.newText("Saldo informatie");
				lA1.newText("Accepteren");
				lS1.newText("Stop");
				lB1.newText("Terug");
			}else if (panelName.equals("7")) {

				T7.newText("Doneren");
				lA1.newText("Accepteren");
				lS1.newText("Stop");
				lF1.newText("Correctie");
				lB1.newText("Terug");

			}else if (panelName.equals("8")) {


				lA1.newText("Ja");
				lB1.newText("Nee");


			}else if (panelName.equals("9")) {


				T9.newText("Vul het gewenste bedrag in");
				lA1.newText("Accepteren");
				lS1.newText("Stop");
				lF1.newText("Correctie");
				lB1.newText("Terug");
			}else if (panelName.equals("10")) {
				T10.newText("");
				lB1.newText("");
				lC1.newText("");
				lD1.newText("");
				lA1.newText("Accepteren");
				lS1.newText("Stop");
				lF1.newText("Terug");
			}



		}else if(string.equals("C")) {

			if (panelName.equals("1")) {

				T1.newText("W�hlen Sie eine Sprache aus");


			}else if (panelName.equals("2")) {

				T2.newText("Scannen Sie Ihre Debitkarte");
				lS1.newText("Stoppen");

			}else if (panelName.equals("3")) {

				T3.newText("Geben Sie Ihren PIN-Code ein");
				lA1.newText("akzeptieren");
				lS1.newText("Stoppen");
				lF1.newText("Korrektur");

			}else if (panelName.equals("4")) {

				T4.newText("W�hlen Sie aus den folgenden Optionen");

				lA4.newText("Aufnahmen");
				lS1.newText("Stoppen");

			}else if (panelName.equals("5")) {

				lD5.newText("Aufnahmen");

				T5.newText("Aufnahmen");
				lS1.newText("Stoppen");
				lF1.newText("Zur�ck");
				lD5.newText("Andere Menge");


			}else if (panelName.equals("6")) {

				T6.newText("Informationen zum Gleichgewicht");
				lA1.newText("Akzeptieren");
				lS1.newText("Stoppen");
				lB1.newText("Zur�ck");

			}else if (panelName.equals("7")) {

				T7.newText("Spenden");
				lA1.newText("Akzeptieren");
				lS1.newText("Stoppen");
				lF1.newText("Korrektur");
				lB1.newText("Zur�ck");

			}else if (panelName.equals("8")) {


				lA1.newText("Ja");
				lB1.newText("Nein");


			}else if (panelName.equals("9")) {
				T9.newText("Geben Sie den gew�nschten Betrag ein");
				lA1.newText("akzeptieren");
				lS1.newText("stoppen");
				lF1.newText("Korrektur");
				lB1.newText("Zur�ck");
			}else if (panelName.equals("10")) {
				T10.newText("");
				lA1.newText("akzeptieren");
				lS1.newText("stoppen");
				lF1.newText("Korrektur");
				lA1.newText("");
				lB1.newText("");
				lC1.newText("");
				lD1.newText("");

			}






		}else if(string.equals("D")) {


			if (panelName.equals("1")) {


				T1.newText("Selecciona tu idioma");


			}else if (panelName.equals("2")) {



				T2.newText("Escanea tu tarjeta de d�bito");
				lS1.newText("Parar");

			}else if (panelName.equals("3")) {

				T3.newText("Ingrese su c�digo PIN");
				lA1.newText("Aceptar");
				lS1.newText("Parar");
				lF1.newText("Correccion");

			}else if (panelName.equals("4")) {

				T4.newText("Elija entre las siguientes opciones");

				lA4.newText("Retirada");
				// lB4.newText("<html>Informaci�n<br/>de balance<html>");
				//lC4.newText("Donar");

				lS1.newText("Parar");

			}else if (panelName.equals("5")) {

				lD5.newText("Otra cantidad");

				T5.newText("Retirada");
				lS1.newText("Parar");
				lF1.newText("Espalda");

			}else if (panelName.equals("6")) {

				T6.newText("Informaci�n de balance");
				lA1.newText("Aceptar");
				lS1.newText("Parar");
				lB1.newText("Espalda");

			}else if (panelName.equals("7")) {

				T7.newText("Donar");
				lA1.newText("Aceptar");
				lS1.newText("Parar");
				lF1.newText("Correccion");
				lB1.newText("Espalda");

			}else if (panelName.equals("8")) {


				lA1.newText("Si");
				lB1.newText("No");

			}else if (panelName.equals("9")) {
				T9.newText("Ingrese la cantidad deseada");
				lA1.newText("Aceptar");
				lS1.newText("Parar");
				lF1.newText("Correccion");
				lB1.newText("Espalda");

			}else if (panelName.equals("10")) {
				T9.newText("");
				lA1.newText("");
				lB1.newText("");
				lC1.newText("");
				lD1.newText("");
				lA1.newText("Aceptar");
				lS1.newText("Parar");
				lF1.newText("Correccion");
			}


		}



	}







}
