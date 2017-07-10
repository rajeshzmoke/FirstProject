# FirstProject
Finding the unique variables and their repetitions from a required column


import java.awt.List;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

public class Dummy

{
	public static void main(String[] args) throws IOException 
	{
		
		String fName = "/home/swapnesh/Downloads/newtorkactive/NetworkActiveViews_341899_20170702_01";

		ArrayList<String> list = new ArrayList<String>();

		String thisLine;
		
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
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for (String string : list) {
        	if(map.containsKey(string)) {
                map.put(string, map.get(string)+1);
              }
              else{ map.put(string, 1); }
		}
        
       /* Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }*/
      /*  
        String eol = System.getProperty("\n");

        try (FileWriter writer = new FileWriter("somefile.csv")) {
          for (Map.Entry<String, Integer> entry : map.entrySet()) {
            writer.append(entry.getKey())
                  .append(',')
                  .append(entry.getValue())
                  .append(eol);
          }
        } catch (IOException ex) {
          ex.printStackTrace(System.err);
        }        
       */

        
        

		FileWriter fileWriter = null;
		
		try 
		{

			fileWriter = new FileWriter("/home/swapnesh/Downloads/newtorkactive/OccuranceOfDomain.csv");
			

			Iterator it = map.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        

				fileWriter.append((String) pair.getKey());
				System.out.println(pair.getKey()+" "+pair.getValue());
				fileWriter.append(",");
				fileWriter.append(""+pair.getValue());
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
