public class stringCompression {
/*
 * Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the orig-
inal string, your method should return the original string.
2014/05/27

	Idea:
		Use a StringBuffer to construct the compressed string, if it is shorter
		than the original, return it.
 */
		static String sCompression(String s){
			StringBuffer tmp = new StringBuffer();
			int count = 0;
			char current = s.charAt(0);
			int i = 0;
			while(i < s.length()){
				if(s.charAt(i)==current){
					count++;
				}else{
					tmp.append(current);
					tmp.append(count);
					current = s.charAt(i);
					count = 1;
				}
				i++;
			}
			tmp.append(current);
			tmp.append(count);
			if(tmp.toString().length() > s.length()){
				return s;
			}else{
				return tmp.toString();
			}
		}
		
		
		public static void main(String[] args){
			String a = "aabcccccaaa";
			System.out.println("Input: "+ a);
			System.out.println("Compressed Output: "+ sCompression(a));
		}
}
