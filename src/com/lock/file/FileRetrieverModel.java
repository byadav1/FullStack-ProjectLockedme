package com.lock.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class helps writing the business logic to perform File operation
 * 
 * @author yadav
 * @since 2022-10-01
 */
public class FileRetrieverModel {

	private File curentDir;
	private boolean isFileFound;

	/*
	 * Default Constructor to initialize the class variable
	 */
	public FileRetrieverModel() {
		String dir = System.getProperty("user.dir");
		this.isFileFound = false;
		this.curentDir = new File(dir);
	}

	/*
	 * This method help Display the current directory details
	 */
	public void currentDirectoryDetails() {

		List<String> listfileName = Arrays.asList(curentDir.list());
		Collections.sort(listfileName, String.CASE_INSENSITIVE_ORDER);
		if (!curentDir.exists()) {
			System.out.println(curentDir + " .Directory does not exist");
			return;
		} else if (listfileName.size() <= 0) {
			System.out.println(curentDir + " .Directory is empty");
			return;
		}
		for (String f : listfileName) {
			System.out.println(f);
		}
		System.out.println("----------------------------------------------------");

	}

	/*
	 * This method help adding the file to the current directory
	 * 
	 * @param - name of the file
	 * 
	 * @see IOException
	 */
	public void addFile(String name) {
		try {
			File myObj = new File(name);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("An error occurred while writing the file");
		}
		System.out.println("----------------------------------------------------");
	}

	/*
	 * This method help deleting the file to the current directory
	 * 
	 * @param - name of the file
	 * 
	 * @see NoSuchFileException ,IOException
	 */
	public void deleteFile(String name) {

		try {

			Files.delete(Paths.get(this.curentDir + "\\" + name));
			System.out.println("File Deleted successfully.");

		} catch (NoSuchFileException e) {
			throw new IllegalArgumentException("No such file/directory exists");
		} catch (IOException e) {
			throw new IllegalArgumentException("Invalid permissions.");
		}

	}

	/*
	 * This method help searching the file to the current directory
	 * 
	 * @param - name of the file
	 * 
	 * @see NoSuchFileException ,IOException
	 */
	public void searchFile(String searchfilename) {

		performSearch(this.curentDir, searchfilename);
		if (isFileFound) {
			System.out.println("File found");

		} else {
			System.out.println("File not found");
		}
		this.isFileFound = false;
	}

	/*
	 * Helper method help searching the file to the current directory
	 * 
	 * @param - Directory to search
	 * 
	 * @param - name of the file
	 * 
	 * @see NoSuchFileException ,IOException
	 */
	private void performSearch(File searchdirectory, String searchfilename) {
		try {
			if (isFileFound) {
				return;
			}
			File[] files = searchdirectory.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					if (file.getName().equals(searchfilename)) {
						isFileFound = true;
						break;
					}
					continue;
				}
				if (file.isDirectory()) {
					performSearch(file, searchfilename);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

}
