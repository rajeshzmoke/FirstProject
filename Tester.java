package ceartivedirectory;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Tester 
{
	public static void main(String[] args)
	{
		int count = 0;

		String fName = "/home/swapnesh/Downloads/newtorkactive/creativedirectory.csv";

		ArrayList<String> list = new ArrayList<String>();

		String thisLine;
		
		try {
			FileInputStream fis = new FileInputStream(fName);
			DataInputStream myInput = new DataInputStream(fis);
			int i = 0;

			while ((thisLine = myInput.readLine()) != null) {
				String strar[] = thisLine.split(" ");
				list.add(strar[0]);
				System.out.println();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("done adding");
        
        HashMap<String,String> map = new HashMap<String,String>();
        
        for (String string : list) 
        {
        	String[] split = string.split("=");
        	System.out.println(count);
        	System.out.println(string);
        	count++;
        	if(split.length==2) 
        	{
        		map.put(split[0], split[1]);
        	}
        //	if(split[0]==null && split[1]==null || split[0].contains(" ") && split[1].contains(" ") || split[0].contains("\n") && split[1].contains("\n") || split[0].contains("\r") && split[1].contains("\r"))
        	//{
        		
        	//}
        //	else
        //	map.put(split[0], split[1]);
		}
		
	System.out.println(map);
	
	FileWriter fileWriter = null;
	
	try 
	{

		fileWriter = new FileWriter("/home/swapnesh/Downloads/newtorkactive/uniqueKeyOfCustomDirectory.csv");
		

		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        

			fileWriter.append((String) pair.getKey());
			System.out.println(pair.getKey()+" "+pair.getValue());
			fileWriter.append("\n");
			System.out.println("added into csv");
	        
/*		        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
*/		    }
		
		
	}catch (Exception e) {
		e.printStackTrace();
	  
	}finally {

		try {
			fileWriter.flush();

			fileWriter.close();

		} catch (IOException e) {

			System.out
					.println("Error while flushing/closing fileWriter !!!");
			e.printStackTrace();

		}

	}
	
	System.out.println("operation succesfull");
}


    
    

	
	}


