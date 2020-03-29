import junit.framework.TestCase;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
		assertEquals(3, Appearances.sameCount(a, a));
		assertEquals(3, Appearances.sameCount(b, b));
	}
	
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
		assertEquals(4, Appearances.sameCount(a, a));

	}

	public void testSameCount3() {
		// basic List<Boolean> cases
		List<Boolean> a = Arrays.asList(true, true, true, true, false);
		List<Boolean> b = Arrays.asList(false, false, true, true, true,true);
		List<Boolean> c = Arrays.asList(true, true, true, true, false);
		assertEquals(1, Appearances.sameCount(a,b));
		assertEquals(2, Appearances.sameCount(a,c));
		assertEquals(2, Appearances.sameCount(a, a));
		assertEquals(2, Appearances.sameCount(b, b));
		assertEquals(2, Appearances.sameCount(c, c));
	}

	public void testSameCount4() {
		// basic List<String> cases
		List<String> a =  Arrays.asList("ab","abbccc","aab","aab","aba");
		List<String> b = Arrays.asList("cccbba","aab","aab","abbccc");
		assertEquals(2, Appearances.sameCount(a, b));
		assertEquals(4, Appearances.sameCount(a, a));
		assertEquals(3, Appearances.sameCount(b, b));
	}

	public void testSameCount5() {
		// basic List<Object> cases
		dog dog1 = new dog("one",1,1,true);
		dog dog2 = new dog("one",1,1,true);
		dog dog3 = new dog("two",1,3,true);
		dog dog4 = new dog("one",1,1,false);
		List<dog> a =  Arrays.asList(dog1,dog2);
		List<dog> b = Arrays.asList(dog1,dog1);
		assertEquals(0, Appearances.sameCount(a, b));
		assertEquals(0, Appearances.sameCount(b, a));
		a =  Arrays.asList(dog1,dog1);
		b = Arrays.asList(dog1,dog1);
		assertEquals(1, Appearances.sameCount(a, b));
		a =  Arrays.asList(dog2,dog3,dog1,dog4,dog4,dog1);
		b = Arrays.asList(dog1,dog1,dog4,dog4,dog4,dog3);
		assertEquals(2, Appearances.sameCount(a, b));
	}
	public class dog{
		private int type;
		private int children;
		private String name;
		private Boolean boy;
		public dog(String name, int type,
				   int children, Boolean boy)
		{
			this.name = name;
			this.boy = boy;
			this.children = children;
			this.type = type;
		}
		@Override
		public int hashCode() {
			return 1;
		}
	}
}
