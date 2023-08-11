package application;

import java.util.Scanner;

import presentation.MemberPage;

public class Program {

	public static void main(String[] args) {
		MemberPage memberPage = new MemberPage();
		
		memberPage.registerOfMembers(new Scanner(System.in));
	}
	
}
