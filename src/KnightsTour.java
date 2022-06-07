
/**
 * KnightsTour.java
 * 
 * 
 * 
 * @author Jaylon Kiper
 * 6/6/2022
 */
public class KnightsTour {
	
	//Length and Width of Chess board.
	static int N = 8;
	
	//This function will check if i,j are valid indexes for N*N chessboard 
	static boolean isSafe(int x, int y, int sol[][]) {
		
		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
		
	}//end isSafe function
	
	//This function will print solution matrix sol[N][N].
	static void printSolution(int sol[][]) {
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				
				System.out.print(sol[x][y] + " ");
				
			}//end nested for loop
			
			System.out.println();
			
		}//end for loop
	}//end printSolution function
	
	/* This function solves the Knight Tour problem using Backtracking. 
	 * This function mainly uses solveKTUtil() to solve the problem. It
	 * returns false if no complete tour is possible,
	 * otherwise return true and prints the tour.
	 * Please note that there may be more than one
	 * solutions, this function prints one of the
	 * feasible solutions.*/
	 static boolean solveKT() {
		 
		 int sol[][] = new int[8][8];
		 
		 //Initialization of solution matrix
		 for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					
					sol[x][y] = -1;
					
				}//end nested for loop
			}//end for loop
		 
	 /* xMove[] and yMove[] define next move of Knight.
        xMove[] is for next value of x coordinate
        yMove[] is for next value of y coordinate */
      int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
      int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

      // Initializes knight piece at the first space.
      sol[0][0] = 0;

      //Starts from 0,0 and explore all tours using solveKTUtil()
      if (!KTRecursive(0, 0, 1, sol, xMove, yMove)) {
    	  
          System.out.println("Solution does not exist");
          return false;
      }//end if statement
      else
    	  System.out.println("Board Size: " + N + "x" + N);
          printSolution(sol);
      
      return true;
      
	 }//end solveKT function
	
	 static boolean KTRecursive(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
		 
	 	int k, next_x, next_y;
	 	
        if (movei == N * N)
            return true;
	        
        //Attempts all next moves from the current coordinate x, y.
        for (k = 0; k < 8; k++) {
        	next_x = x + xMove[k];
        	next_y = y + yMove[k];
        	
        if (isSafe(next_x, next_y, sol)) {
        	
            sol[next_x][next_y] = movei;
            
            if (KTRecursive(next_x, next_y, movei + 1, sol, xMove, yMove))
            	
                return true;
            
            else
            	//Backtracking
                sol[next_x][next_y] = -1;
        }
    }

    return false;
	        
	 }//end KTRecursive function
	 
	//Produces Knights Tour code.
	public static void main(String[] args) {
		solveKT();
	}

}
