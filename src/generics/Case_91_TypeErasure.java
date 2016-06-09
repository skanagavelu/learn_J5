package generics;

import java.util.List;

/**
 * Source:
 * http://stackoverflow.com/questions/313584/what-is-the-concept-of-erasure-in-
 * generics-in-java javac -XD-printflat -d output_dir SomeFile.java
 * 
 * @author ksugumar
 *
 */
public class Case_91_TypeErasure {
	/**
	 * Generics were introduced to the Java language to provide tighter type
	 * checks at compile time and to support generic programming.
	 * 
	 * At compile-time, the compiler has full type information available but
	 * this information is intentionally dropped in general when the byte code
	 * is generated, in a process known as type erasure.
	 * 
	 * To implement generics, the Java compiler applies type erasure to:
	 * 
	 * 	1) Replace all type parameters in generic types with their bounds or Object
	 *     if the type parameters are unbounded. The produced bytecode, therefore,
	 *     contains only ordinary classes, interfaces, and methods.
	 * 
	 * From:
	 * class Pair<K, V> { 
	 * 		public K getKey() 	{ return null;} 
	 * 		public V getValue() {return null;} 
	 * }
	 * 
	 * class Node<T extends Comparable<T>> {
	 * 		private T data;
	 * }
	 * 
	 * To
	 * class Pair {
	 * 		public Object getKey() { return null; }
	 * 		public Object getValue() { return null; } 
	 * }
	 * 
	 * class Node {
	 * 		private Comparable data;
	 * }
	 * 
	 * 
	 * 	2) Insert type casts if necessary to preserve type safety. 
	 * 
	 * From:
	 * 		List<String> list = new ArrayList<String>();
     * 		list.add("Hi");
	 *		String x = list.get(0);
	 *
	 * To:
	 *		List list = new ArrayList();
	 *		list.add("Hi");
	 *		String x = (String) list.get(0);
	 * 
	 * 
	 * 	3) Generate bridge methods to preserve polymorphism in extended generic types. 
	 * 
	 * 	public class Node {
     *     public Object data;
     *
     *     public void setData(Object data) {
     *			System.out.println("Node.setData");
     *			this.data = data;
     *	   }
	 * 	}
	 * 
	 * 	public class MyNode extends Node {
	 *  	public void setData(Integer data) {
	 *  		System.out.println("MyNode.setData");
	 *  		super.setData(data);
	 *  	}
	 *  
	 *      // Bridge method generated by the compiler
	 *      public void setData(Object data) {
	 *      	setData((Integer) data);
	 *      }
	 *  }
	 * 
	 * 
	 * Type erasurs that no new classes are created for parameterized types;
	 * 		consequently, generics incur no runtime overhead.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * Erasure of Generic Methods
	 */
	public static <T> int count(T[] anArray, T elem) {
	    int cnt = 0;
	    for (T e : anArray)
	        if (e.equals(elem))
	            ++cnt;
	        return cnt;
	}
	
//	Because T is unbounded, the Java compiler replaces it with Object:
//
//		public static int count(Object[] anArray, Object elem) {
//		    int cnt = 0;
//		    for (Object e : anArray)
//		        if (e.equals(elem))
//		            ++cnt;
//		        return cnt;
//		}
	
	
	
	class Shape { /* ... */ }
	class Circle extends Shape { /* ... */ }
	class Rectangle extends Shape { /* ... */ }
	
	public static <T extends Shape> void drawUpperBound(T shape) { /* ... */ }
	
//	Invalid Syntax
//	public static <T super Shape> void drawLowerBound(T shape) { /* ... */ }
	
	public static <T extends Shape> void drawUpperBound(List<T> shape) { /* ... */ }
//	Invalid Syntax
//	public static <T super Shape> void drawLowerBound(List<T> shape) { /* ... */ }
	
	
	//This will collide with drawUpperBound after erasure performed. Hence named added with 1 at the end.
	public static void drawUpperBound1(List<? extends Shape> shape) { /* ... */ }
	public static void drawLowerBound1(List<? super Shape> shape) { /* ... */ }
	
	
	
	
	
	//Not for session
	public static void main(String[] args) {
		//Not for session
		MyNode mn = new MyNode(); 
		Node n = mn; // A raw type - compiler throws an unchecked warning
		n.setData("Hello");     
		Integer x = mn.data;    // Causes a ClassCastException to be thrown.
	}
	


}


class Node<T> {
	public T data;

	public void setData(T data) {
		System.out.println("Node.setData");
		this.data = data;
	}
}

class MyNode extends Node<Integer> {
	@Override
	public void setData(Integer data) {
		System.out.println("MyNode.setData");
		super.setData(data);
	}
}