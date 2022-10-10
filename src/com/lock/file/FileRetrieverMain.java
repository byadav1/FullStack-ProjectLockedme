package com.lock.file;

import java.util.Scanner;

public class FileRetrieverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("############## Welcome to LockedMe application ##############");
		System.out.println("-------------------------------------------------------------");
		System.out.println("############## Developed by Bharti yadav ##############");
		displayUserOptions();

	}

	private static void displayUserOptions() {
		
		int userSelection; 
		Scanner console = new Scanner(System.in);	
		System.out.print("Please enter 1 to add a file to the existing directory list \n");
		System.out.print("Please enter 2 to delete a user specified file from the existing directory list.\n");
		System.out.print("Please enter 3 to Search a user specified file from the main directory.\n ");
		userSelection = console.nextInt();		
		switch (userSelection) {
		case 1:
			System.out.println("Add a file to the existing directory list");
			break;

		case 2:
			System.out.println("Delete a user specified file from the existing directory list.");
			break;

		case 3:
			System.out.println("Search a user specified file from the main directory");
			break;

		default:
			System.out.println("Invalid input");
		}
	}

}
