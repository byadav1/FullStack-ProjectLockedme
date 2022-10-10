package com.lock.file;

import java.util.Scanner;

/**
 * This class helps interacting with users inputs and handles the models the
 * response the business logic to perform File operation
 * 
 * @author yadav
 * @since 2022-10-01
 */
public class FileRetrieverController {

	private Scanner console;

	private FileRetrieverModel retreiver;

	public FileRetrieverController() {
		this.retreiver = new FileRetrieverModel();
		this.console = new Scanner(System.in);
	}

	/*
	 * This method acts an main menu display for a user
	 */
	public void displayUserOptions() {

		try {
			int userSelection;
			boolean validInput = false;
			do {
				System.out.print("\n################## Main menu ##################\n");
				System.out.print(" Please enter 1 to display current directory details \n ");
				System.out.print("Please enter 2 to perform add/delete/search operation on directory \n ");
				System.out.print("Please enter 3 to exit from the application \n ");
				String userInput = this.console.nextLine();
				if (isValidNumber(userInput)) {
					userSelection = Integer.parseInt(userInput);
					switch (userSelection) {
					case 1:
						System.out.println(
								"Directory name- " + System.getProperty("user.dir") + " and details are as follow");
						this.retreiver.currentDirectoryDetails();
						validInput = true;
						break;
					case 2:
						System.out.println("\n Choose options to perform add/delete/search operation on directory");
						System.out.println("------------------------------------------------------------------");
						displayFileOpertaionUserOptions();

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
				} else {
					System.out.print(" ***Error- Please enter a valid number\n\n");
					validInput = true;
				}

			} while (validInput);
		} catch (Exception e) {
			System.out.println("Errored occured - Failed to perform " + "user operations -->  " + e.getMessage());

		}

	}

	private boolean isValidNumber(String input) {
		try {

			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/*
	 * This method helps displaying an option to perform to file operation
	 */

	private void displayFileOpertaionUserOptions() {
		try {
			int userSelection;
			String inputFileName;
			boolean validInput = false;
			do {
				System.out.print("	Please enter 1 to add a file to the existing directory list \n");
				System.out.print(
						"	Please enter 2 to delete a user specified file from the existing directory list.\n");
				System.out.print("	Please enter 3 to Search a user specified file from the main directory.\n");
				System.out.print("	Please enter 4 to go back to main menu.\n ");
				String userInput = this.console.nextLine();
				if (isValidNumber(userInput)) {
					userSelection = Integer.parseInt(userInput);
					switch (userSelection) {
					case 1:
						System.out.println("Add a file to the existing directory list");
						System.out.print("Enter File Name: ");
						inputFileName = this.console.nextLine().trim();
						retreiver.addFile(inputFileName);
						validInput = true;

						break;

					case 2:
						System.out.println("Delete a user specified file from the existing directory list.");
						System.out.print("Enter File Name to delete: ");
						inputFileName = this.console.nextLine().trim();
						retreiver.deleteFile(inputFileName);
						validInput = true;

						break;

					case 3:
						System.out.println("Search a user specified file from the main directory");
						System.out.print("Enter File Name to search: ");
						inputFileName = this.console.nextLine().trim();
						retreiver.searchFile(inputFileName);
						validInput = true;

						break;
					case 4:
						System.out.println("Main Menu");
						displayUserOptions();
						validInput = false;
						break;
					default:
						System.out.println("Invalid input");
						validInput = true;
					}
				} else {
					System.out.print(" ***Error- Please enter a valid number\n\n");
					validInput = true;
				}
			} while (validInput);
		} catch (Exception e) {
			System.out.println("Errored occured - Failed to perform " + "user operations on add/search/delete file -->  " + e.getMessage());

		}
	}

}
