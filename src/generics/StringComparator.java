package generics;

import java.util.Set;
import java.util.TreeSet;

public class StringComparator {
public static void main(String[] args) {
	/*
	 * http://stackoverflow.com/questions/900745/java-compareto-for-string-and-integer-arguments/33731518#33731518
	 * This will print ONE, THREE, TWO
	 * 
	 * It is because of the java API code in String class; 
	 * where minimum length of chars among the two string are only compared.
	 */
	Set<String> set = new TreeSet<String>();
	set.add("ONE");
	set.add("TWO");
	set.add("THREE");
	System.out.println(set);
 }
}
