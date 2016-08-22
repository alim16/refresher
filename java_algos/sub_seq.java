public class sub_seq{


public static void main(String[] args){
	int length = 0;
	int[] arr = new int[] {1,4,1,4,2,1,3,5,6,2,3,7};
	int[] arr2 = new int[] {3,1,4,1,5,9,2,6,5,3,5};
	int[] arr3 = new int[] {2,7,1,8,2,8,1};
	
	length = subseqLength(arr);
	System.out.println("the length is: " + length);

}

//calculates the length of the longest subsequence 
public static int subseqLength(int[] someArray){
	int temp_seq = 0;
	int longest = 0;
	int prev = 0;
	for(int i = 0; i < someArray.length-1; i++){	
		
		if(prev < someArray[i]){
			//System.out.println(someArray[i]+" is more than: "+prev);
			temp_seq = temp_seq + 1;
		}else {
			if(longest < temp_seq){
			longest = temp_seq;
			}
			temp_seq = 0;
			//System.out.println(someArray[i]+" is less than: "+prev);
		}
		prev = someArray[i];
	}
		

	return longest + 1;
}


}










