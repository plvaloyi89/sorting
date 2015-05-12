import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.Timer;
public class QuickSort implements Runnable {
	Integer[]data;
	Timer t;
	long passedTime;
	public QuickSort(Integer[] quickArray) {
		// TODO Auto-generated constructor stub
		data =quickArray;


		 t = new Timer(0, null);

	}

	//-----------------------------------------------------------
	private static <Integer extends Comparable<Integer>>
			void swap(Integer[] data, int index1, int index2)
		{
			Integer temp = data[index1];
			data[index1] = data[index2];
			data[index2] = temp;
		}

//-----------------------------------------------------------
		public static <Integer extends Comparable<Integer>>
			void quickSort(Integer[] data)
		{
			quickSort(data, 0, data.length - 1);
		}
//----------------------------------------------------------
		private static <Integer extends Comparable<Integer>>
			void quickSort(Integer[] data, int min, int max)
		{
			if (min < max)
			{
				// create partitions
				int indexofpartition = partition(data, min, max);

				// sort the left partition (lower values)
				quickSort(data, min, indexofpartition - 1);

				// sort the right partition (higher values)
				quickSort(data, indexofpartition + 1, max);
			}
		}
//-------------------------------------------------------------
		private static <Integer extends Comparable<Integer>>
			int partition(Integer[] data, int min, int max)
		{
			Integer partitionelement;
			int left, right;
			int middle = (min + max) / 2;

			// use the middle data value as the partition element
			partitionelement = data[middle];
			// move it out of the way for now
			swap(data, middle, min);

			left = min;
			right = max;
//LISTEN HERE
			while (left < right)
			{
				// search for an element that is > the partition element
				while (left < right && data[left].compareTo(partitionelement) <= 0)
					left++;
//LISTEN HERE
				// search for an element that is < the partition element
				while (data[right].compareTo(partitionelement) > 0)
					right--;
//LISTEN HERE
				// swap the elements
				if (left < right)
					swap(data, left, right);
			}

			// move the partition element into place
			swap(data, min, right);
//LISTEN HERE
			return right;
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
			String output = "QuickSort" + getTime();
			File f = new File("src/output.dat");

			FileWriter fw;
			try {
				fw = new FileWriter(f,true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(output);        // Writing to the file
				bw.newLine();
				bw.close();                       // Close the BufferedWriter
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
	quickSort(data);
	t.stop();
	long elapsedTime=System.nanoTime() - startTime;
	setTime(elapsedTime);
	filePrint();
	
	}


	}//ends BubbleSort.java