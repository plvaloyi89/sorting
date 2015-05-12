import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.Timer;
public class BubbleSort implements Runnable {
	Integer[]data;
	Timer t;
	long passedTime;
	public BubbleSort(Integer[] bubbleArray) {
		// TODO Auto-generated constructor stub
	data= bubbleArray;

	t = new Timer(0, null);

	}

//-------------------------------------------------
private static <Integer extends Comparable<Integer>>
		void swap(Integer[] data, int index1, int index2)
	{
		Integer temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

//--------------------------------------------------
public static < Integer extends Comparable<Integer>>
			void bubbleSort(Integer[] data)
{
	int position, scan;
	Integer temp;
//LISTEN HERE
	for (position =  data.length - 1; position >= 0; position--)
		{
//LISTEN HERE
	    	for (scan = 0; scan <= position - 1; scan++)
	        	{
//LISTEN HERE
	            	if (data[scan].compareTo(data[scan+1]) > 0)
	                    swap(data, scan, scan + 1);
	            }
	        }
//LISTEN HERE
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
	String output = "BubbleSort" + getTime();
	File f = new File("src/output.dat");

	FileWriter fw;
	try {
		fw = new FileWriter(f,true);
		BufferedWriter bw = new BufferedWriter(fw);
	
		bw.write(output);        // Writing to the file
		bw.newLine();
		bw.flush();                       // Close the BufferedWriter
		bw.close();
		fw.close();   // Close the FileWriter
	} catch (IOException e) {
		// TODO Auto-generted catch block
		e.printStackTrace();
	}
}
@Override
public void run() {
	// TODO Auto-generated method stub
	bubbleSort(data);
	t.start();
	long startTime= System.nanoTime();
	bubbleSort(data);
	t.stop();
	long elapsedTime=System.nanoTime() - startTime;
	setTime(elapsedTime);
	filePrint();
}
}
