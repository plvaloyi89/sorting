import java.util.Arrays;
import java.util.Random;


public class ArrayGen {
	//create array of random numbers here
	//numbers range from 0-10
	int number;
	Integer randomArray[];
	Integer bubbleArray[];
	Integer quickArray[];
	Integer radixArray[];
	Integer mergeArray[];
	Integer insertionArray[];
	Random rand;
// Here the array is set to a size of 10
	public ArrayGen(Integer number)
	{
		this.number = number;
		rand = new Random();
		randomArray = new Integer [10];
		bubbleArray = new Integer[10];
		quickArray = new Integer[10];
		radixArray = new Integer[10];
		mergeArray = new Integer[10];
		insertionArray = new Integer[10];
		arrayLoad();
	}

	 
	


		// test print out the captured number in range 10,000 - 1,000,000
	//If statement checks to see if the value is in the specified region
	public void arrayLoad()
	{
	if(number>=1000){
		for (int i=0; i<randomArray.length; i++)
		{
			int num = rand.nextInt(number)+1;
			randomArray[i]=num;
		}
		for (int loader = 0; loader < randomArray.length; loader++)
		{
			bubbleArray[loader] = randomArray[loader];
			mergeArray[loader] = randomArray[loader];
			quickArray[loader] = randomArray[loader];
			radixArray[loader] = randomArray[loader];
			insertionArray[loader] = randomArray[loader];
		}
	}else{
		System.out.println("Enter a higher number");
	}
	}
	public Integer[] getMergeArray()
	{
		return mergeArray;
	}
	public Integer[] getRadixArray()
	{
		return radixArray;
	}
	public Integer[] getBubbleArray()
	{
		return bubbleArray;
	}
	public Integer[] getQuickArray()
	{
		return quickArray;
	}
	public Integer[] getInsertionArray()
	{
		return insertionArray;
	}
	public int randomArrayLength()
	{
		return randomArray.length;
	}
	// this doesnt work
	public String getRandomArrayInt()
	{
		String array = Arrays.toString(randomArray);
		return array;
	}
}
