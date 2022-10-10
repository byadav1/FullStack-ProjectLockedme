package com.lock.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileRetrieverModel {

	private File curentDir;
	private boolean isFileFound;

	public FileRetrieverModel() {
		String dir = System.getProperty("user.dir");
		this.isFileFound = false;
		this.curentDir = new File(dir);
	}

	public void currentDirectoryDetails() {

		// File[] filesList = curDir.listFiles();
		List<String> listfileName = Arrays.asList(curentDir.list());
		Collections.sort(listfileName, String.CASE_INSENSITIVE_ORDER);

		for (String f : listfileName) {
			System.out.println(f);
		}
		System.out.println("----------------------------------------------------");
	}

	public void addFile(String name) {
		try {
			File myObj = new File(name);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------");
	}

	public void deleteFile(String name) {

		try {

			Files.delete(Paths.get(this.curentDir + "\\" + name));
			System.out.println("File Deleted successfully.");

		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}

	}

	public void searchFile(String searchfilename) {

		performSearch(this.curentDir, searchfilename);
		if (isFileFound) {
			System.out.println("File found");

		} else {
			System.out.println("File not found");
		}
		this.isFileFound = false;
	}

	private void performSearch(File searchdirectory, String searchfilename) {
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
	}

}
