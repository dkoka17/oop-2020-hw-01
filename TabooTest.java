// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import junit.framework.TestCase;

import javax.swing.text.TabableView;

public class TabooTest extends TestCase {

    public void testTaboo1(){
        List<String> a = Arrays.asList("a","b","a","b","c");
        Taboo<String> tab = new Taboo<>(a);


        Set<String> st = new HashSet<>();
        st.add("b");
        assertTrue(st.equals(tab.noFollow("a")));

        st = new HashSet<>();
        st.add("a");
        st.add("c");
        assertTrue(st.equals(tab.noFollow("b")));

        st = new HashSet<>();
        assertTrue(st.equals(tab.noFollow("c")));

        a = Arrays.asList("a","a","b","c","c","a","a","a","b","c");
        a= new ArrayList<String>(a);
        List<String> res= Arrays.asList("a","a","c","c","a","a","a","c");
        tab.reduce(a);
        assertEquals(res,a);
    }

    public void testTaboo2(){
        List<Integer> a = Arrays.asList(1,null,300,16,2,16,300);
        Taboo<Integer> tab = new Taboo<>(a);


        Set<Integer> st = new HashSet<>();
        st.add(null);
        assertTrue(st.equals(tab.noFollow(1)));

        st = new HashSet<>();
        st.add(2);
        st.add(300);
        assertTrue(st.equals(tab.noFollow(16)));

        st = new HashSet<>();
        st.add(300);
        assertTrue(st.equals(tab.noFollow(null)));

        a = Arrays.asList(1,null,null,300,16,5,2,1,1,1,2);
        a= new ArrayList<Integer>(a);
        List<Integer> res= Arrays.asList(1,300,5,2,1,1,1,2);
        tab.reduce(a);
        assertEquals(res,a);
    }
}
