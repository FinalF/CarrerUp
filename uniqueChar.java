import java.util.HashSet;
import java.util.Set;

public class uniqueChar {
/*
 * Q1.1 determine whether the characters in a string are 
 * all unique
 * idea: 1) brute force ---> O(n^2)
 * 		 2) use set, put encountered char to the set ----> O(n)
 * 2014/05/26
 */
	public static boolean isUnique(String s){
		boolean isUnique = true;
		Set<Character> charSet = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++){
			char x = s.charAt(i);
			if(charSet.contains(x)){
				return false;

			}else{
				charSet.add(x);
			}
		}
		return isUnique;
		
	}
	
	public static void main(String[] args){
		String s = "abskdoeifjf";
		System.out.println("This string has all char unique? "+isUnique(s));
	}
	
	
	
	
}
