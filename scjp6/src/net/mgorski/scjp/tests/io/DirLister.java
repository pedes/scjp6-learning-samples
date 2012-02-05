package net.mgorski.scjp.tests.io;

import java.io.File;
import java.io.FileFilter;

public class DirLister {

	public static void main(String[] args) {
		
		String path = "C:\\test1";
		list(path);
	}
	
	static void list(String path){
		
		File fileObject = new File(path);
		if (fileObject.exists()){
			
			if (fileObject.isDirectory()){
				System.out.println("Dir-->" + fileObject.getAbsolutePath());
				File allFiles[] = fileObject.listFiles(new MyFileLister());
				for (File aFile : allFiles){
					
					list(aFile.getAbsolutePath());
				}
			}else{
				System.out.println("File-->" + fileObject.getAbsolutePath());
			}
		}
	}
}

class MyFileLister implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		return pathname.getAbsolutePath().endsWith(".bmp");
	}
	
}

