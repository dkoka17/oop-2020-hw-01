
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;
import junit.framework.TestResult;

public class CharGridTest extends TestCase {


	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
		};


		CharGrid cg = new CharGrid(grid);

		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
		assertEquals(1, cg.charArea('y'));
		assertEquals(1, cg.charArea('x'));

		grid = new char[][] {
				{'a'}
		};


		cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('a'));
		assertEquals(0, cg.charArea('b'));
		assertEquals(0, cg.countPlus());

		grid = new char[][] {
				{'a','a'},
				{'a','a'}
		};


		cg = new CharGrid(grid);

		assertEquals(4, cg.charArea('a'));

		grid = new char[][] {
				{'a','a'}
		};


		cg = new CharGrid(grid);

		assertEquals(2, cg.charArea('a'));
		assertEquals(0, cg.charArea('n'));
		assertEquals(0, cg.countPlus());

		grid = new char[][] {
				{'a','a','a'}
		};


		cg = new CharGrid(grid);

		assertEquals(3, cg.charArea('a'));
		assertEquals(0, cg.charArea('n'));
		assertEquals(0, cg.countPlus());

		grid = new char[][] {
				{'a'},
				{'a'},
				{'a'}
		};


		cg = new CharGrid(grid);

		assertEquals(3, cg.charArea('a'));
		assertEquals(0, cg.charArea('n'));
		assertEquals(0, cg.countPlus());

	}


	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));

		grid = new char[][] {
				{'c', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', 'a'}
		};

		cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('a'));
		assertEquals(0, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(1, cg.countPlus());

		grid = new char[][] {
				{'c', '@', ' '},
				{' ', '*', '{'},
				{' ', '@', 'a'}
		};

		cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('a'));
		assertEquals(0, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.countPlus());

		grid = new char[][] {
				{'c', 'a', ' '},
				{'a', ' ', 'b'},
				{' ', 'c', 'a'}
		};

		cg = new CharGrid(grid);

		assertEquals(9, cg.charArea('a'));
		assertEquals(1, cg.charArea('b'));
		assertEquals(6, cg.charArea('c'));
	}

	public void testcountPlus0() {

		char[][] grid = new char[][] {
				// small grid
				{'x','a'},
				{'x','a'},
				{'y','y'},
				{'x','s'},
				{'x','s'},
		};


		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}

	public void testcountPlus1() {
		char[][] grid = new char[][] {
				{'x','a', 'y', ' ','x'},
				{'x','a', 'y', ' ','x'},
				{'y','y', 'y', 'y','y'},
				{'x','s', 'y', 'z','x'},
				{'x','s', 'y', 'z','x'},
		};


		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	public void testcountPlus2() {
		//on top left
		char[][] grid = new char[][] {
				{'a', 'y', ' ','x'},
				{'y', 'y', 'y',' '},
				{'s', 'y', 'z','x'},
				{'s', 'y', 'z','x'},
		};


		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}

	public void testcountPlus3() {
		//on down right
		char[][] grid = new char[][] {
				{'a', 'w', ' ','x'},
				{'y', 'i', 'y',' '},
				{'s', 'y', 'y','y'},
				{'s', ' ', 'y','x'},
		};


		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	public void testcountPlus4() {
		//same char in line
		char[][] grid = new char[][] {
				{'x','a', 'y', ' ','x','o',' ','x'},
				{'x','a', 'y', ' ','x',' ','x','q'},
				{'y','y', 'y', 'y','y','x','y','x'},
				{' ',' ', 'y', ' ',' ',' ','x','n'},
				{' ',' ', 'y', ' ',' ',' ',' ',' '},
		};


		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	public void testcountPlus5() {
		//same char in line
		char[][] grid = new char[][] {
				{'x','a', 'y', ' ','x','o',' ','x'},
				{'x','a', 'y', ' ','x',' ',' ','q'},
				{'y','y', 'y', 'y','y',' ','x','x'},
				{' ',' ', 'y', ' ',' ','x','x','x'},
				{' ',' ', 'y', ' ',' ',' ','x',' '},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());

		grid = new char[][] {
				{'x','a', 'y', ' ','x','x',' ','x'},
				{'a','a', 'a', 'x','x','x',' ','q'},
				{'y','a', 'y', 'x','x','x','x','x'},
				{' ',' ', 'y', ' ',' ','x','x','x'},
				{' ',' ', 'y', ' ',' ','x','x',' '},
		};
		cg = new CharGrid(grid);
		assertEquals(4, cg.countPlus());
	}

	public void testcountPlus6() {
		//same char in line
		char[][] grid = new char[][] {
				{'x','a', 'y', ' ','x','o',' ','x'},
				{'x','a', 'y', ' ','x',' ',' ','q'},
				{'y','y', 'y', 'y',' ',' ','x','x'},
				{' ',' ', 'y', ' ',' ','x','x',' '},
				{' ',' ', 'y', ' ',' ',' ','x',' '},
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());

		grid = new char[][] {
				{'x','a', 'y', ' ','x','o',' ','x'},
				{'a','a', 'a', ' ','x',' ',' ','q'},
				{'y','a', 'y', 'y',' ',' ','x','x'},
				{' ','y', 'y', 'y',' ','x','x','x'},
				{' ',' ', 'y', ' ',' ',' ','x',' '},
		};
		cg = new CharGrid(grid);
		assertEquals(3, cg.countPlus());

		grid = new char[][] {
				{'x','x', 'x', 'x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x'},
		};
		cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());

		grid = new char[][] {
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
		};
		cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());

		grid = new char[][] {
				{'x',' ', 'x', 'x','x','x','x','x','x'},
				{' ',' ', ' ', 'x','x','x','x','x','x'},
				{'x',' ', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x','x','x'},
				{'x','x', 'x', 'x','x','x','x',' ','x'},
				{'x','x', 'x', 'x','x','x',' ',' ',' '},
				{'x','x', 'x', 'x','x','x','x',' ','x'},
		};
		cg = new CharGrid(grid);
		assertEquals(3, cg.countPlus());

	}
}
