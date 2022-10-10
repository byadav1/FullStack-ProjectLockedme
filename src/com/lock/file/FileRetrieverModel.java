package com.lock.file;

import java.io.File;

public class FileRetrieverModel {
	
	
	
	public void currentDirectoryDetails() {
		String dir = System.getProperty("user.dir");
		File curDir = new File(dir);
		
		 File[] filesList = curDir.listFiles();
	        for(File f : filesList){
	            if(f.isDirectory())
	                System.out.println(f.getName());
	            if(f.isFile()){
	                System.out.println(f.getName());
	            }
	        }
	}

}
