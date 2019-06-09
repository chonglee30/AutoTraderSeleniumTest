package com.autotrader.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFile {

	public static ReadFile using() {
		return new ReadFile();
	}
	
	  public Iterator<Object[]> readSearchData(String fileToParse) {	 	
		
		 List<Object[]> searchDataLists = new ArrayList<>();
		
	     BufferedReader br = null;
	     String [] searchData = null;
	     String line;
	     
	     try {
	    	 File csvfile = new File(
	    				getClass().getClassLoader().getResource(fileToParse).getFile());
	    	 br = new BufferedReader(new FileReader(csvfile));
	    	 while ((line = br.readLine()) !=null) {
	    		 searchData=line.split(",");		  		 
	    		 searchDataLists.add(searchData);
	    	 }
	    	 
	     } catch (IOException io) {
	    	 io.printStackTrace();
	     } finally {
	    	 if (br!=null) {
	    		 try {
	    			 br.close();
	    		 } catch (IOException io) {
	    			 io.printStackTrace();
	    		 }
	    	 }
	     }     
	    return searchDataLists.iterator();     
	}
}