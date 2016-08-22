public class reverser{


public static void main(String[] argv){
	String arg = argv[0];
	String[] st = arg.split("\\s+");
	String newst = "";
	
	for(int i=st.length-1;i>=0;i--){
		newst += (st[i] + " ");
	}
	System.out.println(newst);
}




}









