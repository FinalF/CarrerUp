import java.util.HashMap;
import java.util.Map;

public class permutationCheck {
/*
 * Q1.3: determine whether one string is the permutation of the other
 * idea: Use the hashmap to record the occurence
 * 			a) load info of a to chaeMap
 * 			b) compare charMap to b, reduce the occurence counter everytime it encounters a key
 * 			c) look at the charMap, whether all counters are zeros
 * 	O(n)
 */
	static boolean isPermutation(String a, String b){
		boolean isPer = true;
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		if(a.length()!=b.length()){
			isPer = false;
		}else{
			//record info of a into table
			for(int i = 0; i < a.length(); i++){
				if(charMap.containsKey(a.charAt(i))){
					int count = charMap.get(a.charAt(i));
					charMap.put(a.charAt(i), count+1);
				}else{
					charMap.put(a.charAt(i), 1);
				}
			}
			//compare it with b
			for(int i = 0; i < b.length(); i++){
				if(charMap.containsKey(b.charAt(i))){
					int count = charMap.get(b.charAt(i));
					charMap.put(b.charAt(i), count-1);
				}else{
					charMap.put(b.charAt(i), 1);
					isPer=false;
					break;
				}
			}
			//make the decision
			if(isPer==true){
				for(int count:charMap.values()){
					if(count!=0){
						isPer=false;
						break;
					}
				}
			}
		}
		return isPer;
	}
	
	
	public static void main(String[] args){
		String a = "abcder";
		String b = "edcbva";
		System.out.println("String a is permutation of b? "+isPermutation(a,b));
	}
}
