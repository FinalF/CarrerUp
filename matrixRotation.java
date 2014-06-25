public class matrixRotation {
/*
 * Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place?
2014/05/27
 
 *		idea: a) transpose it first
 *			  b) then switch columns of two border sides -----> O(n^2)
 *
 */
	
	
	public static void main(String[] args){
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Input: ");
		print(a);
		System.out.println("Output: ");
		print(rotate(a));
	}
	
	static void print(int[][] x){
		int N = x.length;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}
	
	static void swapCol(int[][] x, int a, int b){
		int N = x.length;
		int tmp = 0;
		for(int i=0; i < N; i++){
			tmp = x[i][a];
			x[i][a] = x[i][b];
			x[i][b] = tmp;
		}
	}
	
	
	static int[][] rotate(int[][] x){
		int N = x.length;
		//rotate row and col
		for(int i = 0; i < N-1; i++){
			for(int j = i+1; j < N; j++){
				int tmp = 0;
				tmp = x[i][j];
				x[i][j] = x[j][i];
				x[j][i] = tmp;
			}
		}
		//col switch
		for(int i = 0; i < N; i++){
			if(N-1-i > i){
				swapCol(x,i,N-1-i);
			}else{
				break;
			}
		}
		return x;
	}
}
