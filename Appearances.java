import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		int result=0;
		HashMap<T,Integer> hmA=new HashMap<T,Integer>();
		HashMap<T,Integer> hmB=new HashMap<T,Integer>();
		for( T elem : a) {
			if(hmA.containsKey(elem)) {
				hmA.replace(elem, hmA.get(elem)+1);
			}else {
				hmA.put(elem, 1);
			}
		}
		for( T elem : b) {
			if(hmB.containsKey(elem)) {
				hmB.replace(elem, hmB.get(elem)+1);
			}else {
				hmB.put(elem, 1);
			}
		}
		for (HashMap.Entry<T,Integer> entry : hmA.entrySet()) {
			if(entry.getValue()==hmB.get(entry.getKey()))result++;
		}
		return result;
	}
	
}
