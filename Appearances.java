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
		Set<Integer> setA = new HashSet<Integer>();
		HashMap<T,Integer> hmB=new HashMap<T,Integer>();
		Set<Integer> setB = new HashSet<Integer>();

		for( T elem : a){
			if(setA.contains(elem.hashCode())&&hmA.containsKey(elem)) {
				hmA.replace(elem, hmA.get(elem)+1);
			}else {
				setA.add(elem.hashCode());
				hmA.put(elem, 1);
			}
		}
		for( T elem : b) {
			if(setB.contains(elem.hashCode())&&hmB.containsKey(elem)) {
				hmB.replace(elem, hmB.get(elem)+1);
			}else {
				setB.add(elem.hashCode());
				hmB.put(elem, 1);
			}
		}
		for (HashMap.Entry<T,Integer> entry : hmA.entrySet()) {
			if (setB.contains(entry.getKey().hashCode())) {
				if (entry.getValue() == hmB.get(entry.getKey())) result++;
			}
		}
		return result;
	}
	
}
