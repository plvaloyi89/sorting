import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;

import javax.swing.Timer;


public class MergeSort implements Runnable{
	Integer[]data;
	Timer t;
	long passedTime;
	
	
	public MergeSort(Integer[] mergeArray)
	{
		t = new Timer(0, null);
		data= mergeArray;
	

	}
/**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
	public <Integer extends Comparable<Integer>>
		void mergeSort(Integer[] data)
	{
		mergeSort(data, 0, data.length - 1);
	}
	
    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the index of the first element 
     * @param max  the index of the last element
     */
	private static <Integer extends Comparable<Integer>>
		void mergeSort(Integer[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid+1, max);
			merge(data, min, mid, max);
		}
	}
	
	/**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray 
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
	@SuppressWarnings("unchecked")
	private static <Integer extends Comparable<Integer>>
		void merge(Integer[] data, int first, int mid, int last)
	{
		Integer[] temp = (Integer[])(new Comparable[data.length]);
		
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
				//System.out.println("tempArray index:"+temp[index]);
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
		//System.out.println("mergeArray After Sort"+ Arrays.toString(data));
		
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
		String output = "MergeSort" + getTime()+"\n";
		
		File f = new File("src/output.dat");

		FileWriter fw;
		try {
			fw = new FileWriter(f,true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(output);        // Writing to the file
			bw.newLine();
			//bw.flush();
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
		//System.out.println("Started Merge Run Method");
		//System.out.println("mergeArray Before Sort"+ Arrays.toString(data));
		t.start();
		long startTime= System.nanoTime();
		mergeSort(data);
		t.stop();
		long elapsedTime=System.nanoTime() - startTime;
		setTime(elapsedTime);
		filePrint();
	}


}