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
        assertTrue(st.equals(tab.noFollow(null)));

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
        List<Integer> a = Arrays.asList(1,null,null,300,16,2,null,16,300);
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
        st.add(16);
        assertTrue(st.equals(tab.noFollow(null)));

        a = Arrays.asList(1,null,null,300,16,5,2,1,1,1,2);
        a= new ArrayList<Integer>(a);
        List<Integer> res= Arrays.asList(1,300,5,2,1,1,1,2);
        tab.reduce(a);
        assertEquals(res,a);
    }
    public void testTaboo3(){

        dog dog1 = new dog("one",1,1,true);
        dog dog2 = new dog("one",1,1,true);
        dog dog3 = new dog("two",1,3,true);
        dog dog4 = new dog("one",1,1,false);

        List<dog> a =  Arrays.asList(dog1,dog1,dog2,dog3,dog2,dog4);
        Taboo<dog> tab = new Taboo<>(a);


        Set<dog> st = new HashSet<>();
        st.add(dog2);
        assertTrue(st.equals(tab.noFollow(dog1)));

        st = new HashSet<>();
        st.add(dog3);
        st.add(dog4);
        assertTrue(st.equals(tab.noFollow(dog2)));

        st = new HashSet<>();
        st.add(dog2);
        assertTrue(st.equals(tab.noFollow(dog3)));

        st = new HashSet<>();
        assertTrue(st.equals(tab.noFollow(dog4)));

        a = Arrays.asList(dog1,dog2,dog4,dog1,dog3,dog2,dog1);
        a= new ArrayList<dog>(a);
        List<dog> res= Arrays.asList(dog1,dog4,dog1,dog3,dog1);
        tab.reduce(a);
        assertEquals(res,a);
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
