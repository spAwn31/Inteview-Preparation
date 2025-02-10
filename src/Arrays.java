
public class Arrays {
	public static void main(String arr[]) {
		System.out.println("Hello world!");
		String[] arrOne = new String[5];
		arrOne[0] = "Subrat";
		arrOne[1] = "Saurabh";
		arrOne[2] = "Aditya";
		arrOne[3] = "Dhiraj";
		arrOne[4] = "Rahul";
		String[] arrTwo = {"subrat", "saurabh", "aditya", "dhiraj", "rahul"};
		int[] intArr = {178,989,9321,213,321};
		System.out.println("Maximum number in the array is : " + maxValue(intArr));
		//for loop
		for(int i = 0; i < arrOne.length; i++)
			System.out.println("ArrayOne value at index - " + i + " : " + arrOne[i]);
		//for-each loop
		for(String arrValue : arrTwo)
			System.out.println("ArrayTwo Values are : " + arrValue);
	}
	
	//find maximum value in an integer array
	public static int maxValue(int[] inputArr) {
		int maximux = inputArr[0];
		for(int number : inputArr)
			if(number > maximux)
				maximux = number;
		return maximux;
		
	}
}
