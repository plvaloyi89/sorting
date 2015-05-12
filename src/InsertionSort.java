import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Timer;


public class InsertionSort implements Runnable {

	Timer t;
	Integer[] Data;
	long passedTime;
	 public InsertionSort(Integer[] insertionArray) {
		// TODO Auto-generated constructor stub
		 t = new Timer(0, null);
		 Data=insertionArray;
	}

	public static <Integer extends Comparable<Integer>> 
		void insertionSort(Integer[] data)
{
  for (int index = 1; index < data.length; index++)
  {
      Integer key = data[index];
      int position = index;
			
      // shift larger values to the right 
      while (position > 0 && data[position-1].compareTo(key) > 0)
      {
          data[position] = data[position-1];
          position--;
      }
			
      data[position] = key;
      
  }
 
}
	public void setTime(long elapsedTime)
	{
		  passedTime=elapsedTime;
	}
	public long getTime()
	{
		return passedTime;
	}
	public void filePrint()
	{
		String output = "InsertionSort" + getTime();
		File f = new File("src/output.dat");

		FileWriter fw;
		try {
			fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);
			//bw.newLine();
			bw.write(output);        // Writing to the file
			bw.newLine();
			//bw.flush();
			//fw.flush();
			bw.close();   // Close the BufferedWriter
			

			fw.close();   // Close the FileWriter
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		t.start();
		long startTime= System.nanoTime();
		insertionSort(Data);
		t.stop();
		long elapsedTime=System.nanoTime() - startTime;
		setTime(elapsedTime);
		filePrint();
	
	}

	
	
}
