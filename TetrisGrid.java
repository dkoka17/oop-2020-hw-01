//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean grid[][];
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {

		this.grid = new boolean[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for(int k=0; k<grid[0].length; k++){
				this.grid[i][k]=grid[i][k];
			}
		}
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int deleteLines=0;
		for(int i=0; i<grid[0].length; i++) {
			boolean delete=true;
			for(int k=0; k<grid.length; k++) {
				if(!grid[k][i])delete=false;
			}
			if(delete){
				deleteLines++;
			}else{
				for(int k=0; k<grid.length; k++) {
					grid[k][i-deleteLines]=grid[k][i];
				}
			}
		}
		for(int i=grid[0].length-deleteLines; i<grid[0].length; i++) {
			for(int k=0; k<grid.length; k++) {
				grid[k][i]=false;
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
