package com.lock.file;

/**
 * This is an entry point of Locked me application
 * 
 * @author Bharti yadav
 * @since 2022-10-01
 * 
 */
public class FileRetrieverMain {

	/*
	 * Start point of an application
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("############## Welcome to LockedMe application ##############");
			System.out.println("-------------------------------------------------------------");
			System.out.println("############## Developed by Bharti yadav ##############");
			FileRetrieverController controller = new FileRetrieverController();
			controller.displayUserOptions();
		} catch (Exception e) {
			System.out.println("Application error occured -->  " + e.getMessage());
		}
	}

}
