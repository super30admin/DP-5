
//idea is to calculate no of unique path made by  bottom right corner block ,add no of path by block above it and block beside it.
//TC:O(m*n)
//SC:O(m*n)
public class UniquePath {
		    public int uniquePaths(int m, int n) {
		        Integer[][] map = new Integer[m][n];
		        //row from 0 to n and col=0 leftmost edge
		        for(int i = 0; i<m;i++){
		            map[i][0] = 1;
		        }
		        //first row edge till end of column
		        for(int j= 0;j<n;j++){
		            map[0][j]=1;
		        }
		        
		        //all the inside blocks.
		        for(int i = 1;i<m;i++){
		            for(int j = 1;j<n;j++){
		                map[i][j] = map[i-1][j]+map[i][j-1];
		            }
		        }
		        return map[m-1][n-1];
		    }
}


