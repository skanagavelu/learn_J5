package generics;

import java.util.List;

public class Case_4_GenericsTypes <VELU, ON, GENRICS, SESSION, 1> {
	/**
	 * 
	 * A generic type is a generic class or interface that is parameterized over
	 * types.
	 * 
	 * This is to ensure type safety on its getters and setters of its properties. 
	 * 
	 * A generic class is defined with the following format: 
	 * class name<T1, T2, ..., Tn> { /* ... * / }
	 * 
	 * The type parameter section, delimited by angle brackets (<>), follows the
	 * class name. It specifies the type parameters (also called type variables)
	 * T1, T2, ..., and Tn.
	 * 
	 * The most commonly used type parameter names are: 
	 * E - Element (used extensively by the Java Collections Framework) 
	 * K - Key 
	 * N - Number 
	 * T - Type 
	 * V - Value 
	 * S,U,V etc. - 2nd, 3rd, 4th types
	 * 
	 * 
	 * LinkedList<E> is a generic type. 
	 * 
	 * It has a type parameter E that
	 * represents the type of the elements stored in the list. Instead of just
	 * using a LinkedList, not saying anything about the type of elements the
	 * list contains, we can use a LinkedList<String> or a LinkedList<Integer>,
	 * thereby specifying that we mean a list of strings or integral values
	 * respectively.
	 * 
	 * String and Integer are the respective actual type arguments.
	 * 
	 * 
	 */
	
	
	
//	public class Box {
//	    private Object object;
//
//	    public void set(Object object) { this.object = object; }
//	    public Object get() { return object; }
//	}

	
//	What is wrong with? I can't hold/deal with only specific type and subtypes meaning => "Box of Mangos" It is always "Box of Fruits"	
//	What is wrong with declaring specific type like "private Mango t"; Now this can't be widely used meaning cant use this class for Apples.	
	
	/**
	 * Example (of a generic type):
	 * Generic version of the Box class.
	 * @param <T> the type of the value being boxed
	 * 
	 * Box of Type parameter T"
	 * 
	 * This is solid proof on T; once T is known (as part of initialization) to some class 
	 * then all its methods and variable only accept that type or its sub type.
	 * 
	 * Class is for code reuse; now do code reuse with type safety.
	 * 
	 */
//	public class Box<T> {
//	    // T stands for "Type"
//	    private T t;
//	
//	
//	    private static T t;    INVALID
//      private T t = new T(); INVALID
//	
//	
//	    public void set(T t) { this.t = t; }
//	    public T get() { return t; }
//	}
	
	
	
	/**
	 * Type Parameter and Type Argument Terminology: Many developers use the
	 * terms "type parameter" and "type argument" interchangeably, but these
	 * terms are not the same. When coding, one provides type arguments in order
	 * to create a parameterized type. Therefore, the T in Foo<T> is a type
	 * parameter and the String in Foo<String> f is a type
	 * argument/parameterized type. This lesson observes this definition when
	 * using these terms.
	 * 
	 * 
	 * 
	 * A generic type is a type with formal type parameters. A parameterized
	 * type is an instantiation of a generic type with actual type arguments.
	 */
	
	/**
	 * Invoking and Instantiating a Generic Type
	 * 
	 * "Box of Integer", which is how Box<Integer> is read.
	 * Box<Integer> integerBox = new Box<Integer>();
	 * 
	 * Example (of a parameterized type):
	 * Box<Integer> integerBox = new Box<>(); //The Diamond in Java SE 7
	 * 
	 * List stringList = new ArrayList<String>();
	 * stringList.add(new Integer(10)); // will be successful.
	 * 
	 * 
	 * 
	 */
	
}


class Test<T> {
    // T stands for "Type"
    private T t1;
    private static T t2;    //INVALID
    private T t3 = new T(); //INVALID. Object will be created at RunTime, and at runtime T is not available and added as Object for reference.
    private T t4 = (T) t1.getClass().newInstance(); //Provided no arg constructor
    private List<T> t5 = new java.util.ArrayList<T>();

}
