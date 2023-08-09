package application;

import java.util.Scanner;

import presentation.HomePage;

public class Program {

	public static void main(String[] args) {
		HomePage homePage = new HomePage();
		
		homePage.screenWriter(new Scanner(System.in));
	}
	
}
