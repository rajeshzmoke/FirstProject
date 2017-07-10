import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;

import com.csvreader.CsvReader;



public class TestDemo {

	public static void main(String[] args) {
		String fName = "/home/swapnesh/Downloads/newtorkactive/NetworkActiveViews_341899_20170702_01";

		ArrayList<String> list = new ArrayList<String>();

		String thisLine;
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(fName);
			DataInputStream myInput = new DataInputStream(fis);
			int i = 0;

			while ((thisLine = myInput.readLine()) != null) {
				String strar[] = thisLine.split(",");
				list.add(strar[10]);
				System.out.println("added");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("done adding");
	
		HashSet<String> newlist	=  new HashSet<String>(list);
		for (String string : newlist) 
		{
			System.out.println(string);
			
		}
		

		FileWriter fileWriter = null;
		
		try 
		{

			fileWriter = new FileWriter("/home/swapnesh/Downloads/newtorkactive/uniqueDomain.csv");
			
			for (String st : newlist) {

				fileWriter.append(st);
				fileWriter.append("\n");
				System.out.println("added into csv");
			}
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