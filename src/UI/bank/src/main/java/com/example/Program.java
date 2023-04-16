package com.example;

public class Program {
	//hier wordt het programma gestart
	public Program() {
		App app = new App();
		FAIL_Bank bank = new FAIL_Bank(app);
	}

	public static void main(String[] args) {	
		new Program();
	}

}
