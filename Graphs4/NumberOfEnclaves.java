import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }


	public static void destroy(int[][] grid,int i,int j){
		int n = grid.length;
		int m = grid[0].length;
		if(i<0 || i == n || j<0 || j==m || grid[i][j] == 0) return;
		//We are a land cell
		grid[i][j] = 0;//I have destroyed this land cell

		destroy(grid,i-1,j);//top nbr
		destroy(grid,i,j-1);//left nbr
		destroy(grid,i+1,j);//bottom nbr
		destroy(grid,i,j+1);//right nbr
	}
	
  public static int numEnclaves(int[][] grid) {
    // your code here
	  int n = grid.length;
	  int m = grid[0].length;
	  //Ill travel on all the boundaries
	  //And destroy all the islands connecting to the
	  //Boundary land cells
		
		//top row
		for(int j = 0;j<m;j++){
			if(grid[0][j] == 1) destroy(grid,0,j);
		}
		//bottom row
		for(int j = 0;j<m;j++){
			if(grid[n-1][j] == 1) destroy(grid,n-1,j);	  
		}
	  //left col
	  for(int i = 0;i<n;i++){
		  if(grid[i][0] == 1) destroy(grid,i,0);
	  }
	  //right col
	  for(int i = 0;i<n;i++){
		  if(grid[i][m-1] == 1) destroy(grid,i,m-1);
	  }
	  //All the unsafe islands are destroyed
	  //Now just count the safe islands
	  int safeCnt = 0;
	  for(int i = 0;i<n;i++) for(int j = 0;j<m;j++){
		  if(grid[i][j] == 1) safeCnt++;
	  }
	  return safeCnt;
  }
}





