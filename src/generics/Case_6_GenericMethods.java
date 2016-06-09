package generics;

import java.util.Arrays;
import java.util.List;

public class Case_6_GenericMethods {
/**
 * Generic methods are methods that introduce their own type parameters. 
 * 
 * This is similar to declaring a generic type, 
 * 	but the type parameter's scope is limited to the method where it is declared. 
 * 
 * Static and non-static generic methods are allowed, as well as generic class constructors.
 * 
 * The syntax for a generic method includes a type parameter, inside angle brackets, and appears before the method's return type.
 */
	

//	 class Car<T> {
//		    // T stands for "Type"
//		    private T t;
//
	        //This is not generic method
//		    public void set(T t) { this.t = t; }
//		    public T get() { return t; }
//		}
	
	public static void main(String[] args) {}
}


class MyClass<T> {
	
	// Non-generic method
	// Case Study_1 : Type parameter on instance method
	private void justPrint(T a) {
		System.out.println(a);
	}

	// Non-generic method
	// Case Study_2 : Type parameter as return type
	private T justReturn(T a) {
		return a;
	}
	
	// READ FIRST Case Study_3 :
	// Generic method
	// Case Study_5 : Type parameter on instance method
	//<T> is overriding the T declared at Class level;
	private <T> T GenericMethod1(T a) {
		return  a;
	}
	
	// Generic method
	// Case Study_5 : Type parameter on instance method
	//<T> is overriding the T declared at Class level;
	private <T> T GenericMethod2(Object a) {
		return (T) a;
	}
	
	// Generic constructor
	//Case Study_6 : generic class constructors
	public <Z> MyClass(Z t) {
	    
	}
}



// Generic methods mostly used on utility methods of a non generic class or on static methods.

// Case Study_3 : Type parameter on static method
class Util /* <K, V> */ {
	
	// Generic static method
	// Case Study_3 :Static method always needs explicit <T> declaration; It wont derive from class level Class<T>
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

	// Generic method
	// Case Study_4 : Type parameter on instance method
	public <T> T myMethod1(Object a) {
		return (T) a;
	}
	
	// Case Study_7  
	//	<T> T property;
	

	// Case Study_8 : Overloading :: Erasure of method myMethod2(List<T>) is the same as another method in type Util
	//Overloading and Overriding will be discussed later in this chapter.
//    public void foo(List<String> a){
//
//    }
//    public void foo(List<Integer> b){
//
//    }
//    public void foo(List<Long> b){
//
//    }
	  //Case Study_8 : Solution_1: when both are from same interface 
//    public void foo(List<Number> b){
//
//    }
	//Case Study_8 : Solution_2: when both are from different interface 
    public <T> void foo(List<T> b){
    	if(b.get(0) instanceof String) {
    		//call fooString()
    	}
    }
	
    
    
    
    //Case Study_9 : Recall implementation of Arrays.asList
    List<Integer> ints = Arrays.asList(1,2,3);  // ==  Arrays.asList(new Integer[] { new Integer(1), new Integer(2), new Integer(3)})
}

class Pair<K, V> {
	public K getKey() {	return null;}
	public V getValue() {return null;}
}

