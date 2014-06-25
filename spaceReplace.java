public class spaceReplace {
/*
 * Q1.4: replace the space in a string with %20, the 'true' length of the string is given
 * 		Example: input: "Mr John Smith    " , 13
 * 				 output: "Mr%20John%20Smith"
 * 		idea: 1) Use stringbuffer to construct it
 * 			  2) use charArray (no extra space, but more complex because of char shifting)
 * 2014/05/26
 * 
 * Solution: Scan it twice, 1st count the spaces, 2nd replace
 * 		
 */	
	
	public static void main(String[] args){
		String a = "Mr John Smith    ";
		System.out.println("Input: "+ a);
		System.out.println("Use StringBuffer Output: "+ replace(a));
		System.out.println("Inplace Output: "+ replaceInplace(a));
	}
	
	/*
	 * 1)
	 */
	static String replace(String s){
		StringBuffer output = new StringBuffer();
		int l = s.length();
		for(int i = 0; i < l && output.length()<l; i++){
			if(s.charAt(i)==' '){
				output.append("%20");
			}else{
				output.append(s.charAt(i));
			}
		}
		return output.toString();
	}
	
	/*************************************************************************/
	/*
	 * 2)
	 */
	static String replaceInplace(String s){
		char[] sc = s.toCharArray();
		int tail = findTail(sc);
		for(int i = 0; i < sc.length; i++){
			if(sc[i]==' '){
				for(int j = tail; j >= i+1; j--)
				copy(sc,j,j+2);
			tail+=2;
			sc[i]='%';
			sc[i+1]='2';
			sc[i+2]='0';
			i=i+3;
			}
		}
		return printString(sc);
	}
	
	static String printString(char[] c){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < c.length; i++){
			sb.append(c[i]);
		}
		return sb.toString();
	}
	
	static char[] copy(char[] s, int i, int j){
		s[j] = s[i];
		return s;
	}
	static int findTail(char[] s){
		int tail = s.length;
		for(int i =s.length-1; i > 0; i--){
			if(s[i]!=' '){
				return i;
			}
		}
		return tail;
	}
	
}
