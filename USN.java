package ceartivedirectory;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class USN {

	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		String fName = "/home/swapnesh/Downloads/newtorkactive/NetworkActiveViews_341899_20170702_01";

		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, HashSet<String>> map  = new HashMap<String, HashSet<String>>();
		ArrayList<String> hash = new ArrayList<String>();
		String line =  null;
		int count = 0;

		try {
			/*FileInputStream fis = new FileInputStream(fName);
			DataInputStream myInput = new DataInputStream(fis);*/
			
			BufferedReader br = new BufferedReader(new FileReader("/home/swapnesh/Downloads/newtorkactive/NetworkActiveViews_341899_20170702_01"));
			
			int j = 0;

			while((line=br.readLine())!=null)	
			{
				String strar[] = line.split(",");
				for(int i = 0;i<strar.length;i++)
				{
				if (strar[i].contains("usn"))
				{
					list.add(strar[i]);
					System.out.println("added");
				}
			}
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*for (String string : list) 
		{
			System.out.println(string);
		}*/
		

		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("done adding");

		FileWriter fileWriter = null;
		
		try 
		{

			
			

			for (String string : list) 
			{
				/*fileWriter.append(string);
				fileWriter.append("\n");*/
				
				String[] newarr = string.split(";");
						
						for (int i = 0; i < newarr.length; i++) 
						{
							System.out.println(newarr[i]);
							if(newarr[i].contains("usn=zerohedge"))
							{
								count++;
								hash.add(newarr[i]);
							}
								
							
						}
						
				
		        
				
			}
			
			
			/*fileWriter = new FileWriter("/home/swapnesh/Downloads/newtorkactive/usnKeys.csv");
			for (String string : hash)
			{
				fileWriter.append(string);
				fileWriter.append("\n");
			}*/
			
		}catch (Exception e) {
			e.printStackTrace();
		  
		}finally {

			/*try {
				fileWriter.flush();

				fileWriter.close();

			} catch (IOException e) {

				System.out
						.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();

			}*/

		}
		
		
		
		for (String string : hash) {
			System.out.println(string);
		}
		
		System.out.println("operation succesfull");
		System.out.println(count);
		System.out.println(hash.size());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
	}

	

	    
	    

		
		}


