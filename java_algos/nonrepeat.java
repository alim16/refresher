import java.util.Hashtable;
import java.util.Collections;
import java.util.ArrayList;
public class nonrepeat{

	public static void main(String[] argv){
		Hashtable<Character, Integer> count = new Hashtable<Character,Integer>();	
		String st = argv[0];
		for(int i = 0; i< st.length(); i++){
			System.out.println(st.charAt(i));
			Character c = st.charAt(i); 
			if(!(count.containsKey(c))){
				count.put(c,1);
				System.out.println("value is: "+count.get(c));
			}else{
				count.put(c,count.get(c)+1);
				System.out.println("value is: "+count.get(c));
			}	
		}
		ArrayList<Character> keys = Collections.list(count.keys());
		for(int i= 0; i<keys.size(); i++){
			if(count.get(keys.get(i))==1){
			System.out.println("non repeat value is: " + keys.get(i));
			break;
			}
		}
	//System.out.println(count.get('l'));

	}

}







