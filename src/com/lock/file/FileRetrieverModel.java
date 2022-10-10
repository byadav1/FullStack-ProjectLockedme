package com.lock.file;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileRetrieverModel {

	public void currentDirectoryDetails() {
		String dir = System.getProperty("user.dir");
		File curDir = new File("C:\\Users");
		// File[] filesList = curDir.listFiles();
		List<String> listfileName = Arrays.asList(curDir.list());
		Collections.sort(listfileName, String.CASE_INSENSITIVE_ORDER);

		for (String f : listfileName) {
			System.out.println(f);
		}
		System.out.println("----------------------------------------------------");
	}

}
