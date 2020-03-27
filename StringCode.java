import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if(str.length()==0)return  0;
		char st = str.charAt(0);
		int res =1;
		int cur=1;
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i)==st){
				cur++;
			}else{
				if(cur>res)res=cur;
				cur=1;
				st = str.charAt(i);
			}
		}
		if(cur>res)res=cur;
		return res;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String res ="";
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
				if(i<str.length()-1){
					int count = str.charAt(i)-'0';
					for(int k=0; k<count; k++){
						res+=str.charAt(i+1);
					}
				}
			}else{
				res+=str.charAt(i);
			}
		}
		return res;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		Set<String> first = new HashSet<String>();
		Set<String> second = new HashSet<String>();
		for(int i=0; i<=a.length()-len; i++) {
			first.add(a.substring(i, i+len));
		}
		for(int i=0; i<=b.length()-len; i++) {
			second.add(b.substring(i, i+len));
		}
		first.retainAll(second);
		if(first.size()>0)return true;
		return false;
	}
}
