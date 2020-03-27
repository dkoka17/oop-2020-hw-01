
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	private HashMap<T,Set<T>> hm;
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		hm = new HashMap<>();
		for(int i=0; i<rules.size()-1; i++) {
				if(hm.containsKey(rules.get(i))) {
					hm.get(rules.get(i)).add(rules.get(i+1));
				}else{
					Set<T> st = new HashSet<T>();
					st.add(rules.get(i+1));
					hm.put(rules.get(i), st);
				}
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		if(hm.containsKey(elem)) {
			return hm.get(elem);
		}else {
			Set<T> st = new HashSet<T>();
			return st;
		}
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		int ind =0 ;
		while(ind+1<list.size()){
			if(noFollow(list.get(ind)).contains(list.get(ind+1))) {
				list.remove(ind+1);
			}else {
				ind+=1;
			}
		}
	}
}
