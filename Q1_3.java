package Practice;

import java.util.Scanner;

public class Q1_3 {
/*Given two strings, write a method to decide 
if one is a permutation of the other.
*/
	
/*
 Idea:
 Extract each character in the one String (A), find its identical char in the other String (B);
 Record its index number, and use another array to record indexes of chars in B, which have been 
 matched.
 */
	static String A;
	static String B;
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the first String: ");
		A = in.next();
		System.out.println("Please input the second String: ");
		B = in.next();
		
		System.out.println("The strings you input are: A: " + A
							+ "\nB: " +B);
		
		int la = A.length();
		int lb = B.length();
		int record[] = new int[lb];
		if(la!=lb){ 
			System.out.println("These two Strings are not permutation"); 
			System.exit(0);
		}
		else{			
		while(la>0){
			
			int dupindex = B.indexOf(A.charAt(la-1));
			if (dupindex==-1){System.out.println("These two Strings are not permutation");
								System.exit(1);}
			else{
				while(record[dupindex] == -1){
					if(dupindex+1<=lb){
					dupindex = B.substring(dupindex+1).indexOf(A.charAt(la-1));
					}
					else{
					System.out.println("These two Strings are not permutation");
					System.exit(2);
					}
					}
				record[dupindex] = -1;
				la-=1;
			}		
		}
		System.out.println("These two Strings are permutation");
//		for(int i=1;i<lb;i++)
//		System.out.print(record[i]);
		}
	}
	
	
}

Please input the first String: 
12345abc
Please input the second String: 
b24ac531
The strings you input are: A: 12345abc
B: b24ac531
These two Strings are permutation
//-1-1-1-1-1-1-1


