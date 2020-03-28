// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		boolean found =false;
		int left=grid.length, right=0,up=grid[0].length,down=0;
		for(int i=0; i<grid.length; i++) {
			for(int k=0; k<grid[0].length; k++) {
				if(grid[i][k]==ch) {
					found =true;
					if(i<left)left=i;
					if(i>right)right=i;
					if(k<up)up=k;
					if(k>down)down=k;
				}
			}
		}
		if(!found)return 0;
		return ((right-left+1)*(down-up+1));
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		if(grid.length<2||grid[0].length<2)return 0;
		int result =0;
		for(int i=1; i<grid.length; i++) {
			for(int k=1; k<grid[0].length; k++) {
				if (Character.toLowerCase(grid[i][k])>=' '||(Character.toLowerCase(grid[i][k])>='a'&&Character.toLowerCase(grid[i][k])<='z')){
					if(isIt(i,k))result++;
				}
			}
		}
		return result;

	}
	private boolean isIt(int x, int y) {
		int left=0, right=0,up=0,down=0;
		int i=x-1;
		while(i>=0&&grid[i][y]==grid[x][y]) {
			up++;
			i--;
		}
		if(up<1)return false;
		i=x+1;
		while(i<grid.length&&grid[i][y]==grid[x][y]) {
			down++;
			i++;
		}
		if(down<1)return false;
		i=y-1;
		while(i>=0&&grid[x][i]==grid[x][y]) {
			left++;
			i--;
		}
		if(left<1)return false;
		i=y+1;
		while(i<grid[0].length&&grid[x][i]==grid[x][y]) {
			right++;
			i++;
		}
		if(right<1)return false;
		if(right==left&&left==up&&up==down)return true;

		return false;
	}
	
}
