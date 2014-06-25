public class setZero {
/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
	and column are set to 0.
	2014/05/27

 */
	
	
	public static void main(String[] args){
		int[][] a = {{1,2,0},{4,5,6},{0,8,9}};
		System.out.println("Input: ");
		print(a);
		System.out.println("Output: ");
		print(set(a));
	}
	
	
	static int[][] set(int[][] x){
		int[] row = new int[x.length];
		int[] col = new int[x[0].length];
		int M = x.length;
		int N = x[0].length;
		for(int i = 0; i < M; i++){
			for( int j = 0; j < N; j++){
				if(x[i][j]==0){
					row[i]=-1;
					col[j]=-1;
				}
			}
		}
		
		for(int i=0;i < row.length;i++){
			if(row[i]==-1)
			Arrays.fill(x[i], 0);
		}
		for(int j=0;j < col.length;j++){
			if(col[j]==-1)
			setCol(x,j);
		}
		
		return x;
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
	
	
	static void setCol(int[][] x,int j){
		//get j th column
		int M = x.length;
		for(int i = 0; i < M; i++){
			x[i][j] = 0;
		}
	}
}
