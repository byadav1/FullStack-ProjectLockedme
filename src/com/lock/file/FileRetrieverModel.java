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

	public void currentDirectoryDetails() {
		String dir = System.getProperty("user.dir");
		File curDir = new File(dir);
		// File[] filesList = curDir.listFiles();
		List<String> listfileName = Arrays.asList(curDir.list());
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
		String dir = System.getProperty("user.dir");
		File curDir = new File(dir);
		 System.out.println(Paths.get(curDir+"\\" + name ));
		try {
			
			Files.delete(Paths.get(curDir+"\\" + name));
			 System.out.println("File Deleted successfully.");
           
        }
        catch (NoSuchFileException e) {
            System.out.println(
                "No such file/directory exists");
        }        
        catch (IOException e) {
            System.out.println("Invalid permissions.");
        }
       
	}
	public void searchFile() {
	
	}

}
