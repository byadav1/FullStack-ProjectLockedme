package com.lock.file;

import java.util.Scanner;

public class FileRetrieverController {

	private Scanner console;
	private String defaultDirectory = "C:\\Users";
	private FileRetrieverModel retreiver;

	public FileRetrieverController() {
		this.retreiver = new FileRetrieverModel();
		this.console = new Scanner(System.in);

	}

	public void displayUserOptions() {

		int userSelection;
		boolean validInput = false;
		do {
			System.out.print("Please enter 1 to display current directory details \n");
			System.out.print("Please enter 2 to perform add/delete/search operation on directory \n");
			System.out.print("Please enter 3 to exit from the application \n");
			userSelection = this.console.nextInt();
			switch (userSelection) {
			case 1:
				System.out.println("Directory name- " + System.getProperty("user.dir") + " and details are as follow");
				this.retreiver.currentDirectoryDetails();
				validInput = true;
				break;
			case 2:
				System.out.println("Choose to perform add/delete/search operation on directory");
				break;
			case 3:
				System.out.println("GoodBye!! Thank you for using this application");
				validInput = false;
				break;
			default:
				System.out.println("Invalid input");
				validInput = true;
				break;
			}
		} while (validInput);
		
	}

	private void displayFileOpertaionUserOptions() {

		int userSelection;

		System.out.print("Please enter 1 to add a file to the existing directory list \n");
		System.out.print("Please enter 2 to delete a user specified file from the existing directory list.\n");
		System.out.print("Please enter 3 to Search a user specified file from the main directory.\n ");
		userSelection = this.console.nextInt();
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
