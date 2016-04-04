package collection;

import java.util.HashSet;

public class PrimitiveAddition {
	public static void main(String[] args) {
		HashSet h = new HashSet();
		for (short i = 0; i < 100; i++) {
			h.add(i); // Stored as Short
			h.remove(i - 1); // Removing as Integer, Hence Nothing removed.
		}
		System.out.println(h);
	}
}
