package generics;

import java.util.ArrayList;
import java.util.List;

public class Case_8_BoundedType {
/**
 * Let call   T       as Any Type
 *            Integer as Specific type argument
 * then To declare a bounded type parameter, list the type parameter's name, followed by the extends keyword, followed by its upper bound, which in this example is Number.
 *            T extends Number  as Bounded (upper) type
 *            T super Number "T super" is INVALID. This is not supported at class level. But will be useful with wildcard ("? super") in a method 
 *                           There is no meaning to use this, since java wont support ChildClassRef with ParentClassObject 
 *             
 *            ?       as Unknown type /Wild card type, This also not used at class level. 
 *             
 */
	

}

//Case Study: 1 :: Declaration of bounded type in a class
class Counter <T extends Number> { //<T super Number> {
	T counter;
	public void incrementByOne(){
		//++counter;
	}
	
	public void set(T t) {
        this.counter = t;
    }
	
	//Case Study: 2 :: Declaration of bounded type in a method
	public <U extends Integer> void inspect(U u){
	        System.out.println("T: " + counter.getClass().getName());
	        System.out.println("U: " + u.getClass().getName());
	}
	
	//Case Study: 2 :: Declaration of bounded type in a generic method
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T thisElement) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(thisElement) > 0)
	            ++count;
	    return count;
	}
	
	public static void main(String[] args) {
		//Case Study: 3 :: Use case of all its sub class of Number can use this class.
		Counter<Long> longCounter = new Counter<Long>();
		longCounter.set(new Long(10));
		longCounter.set(new Integer(10));
		
		
		Counter<Number> numberCounter = new Counter<Number>();
		numberCounter.set(new Integer(10));
		
		numberCounter.inspect(new Integer(10));
//		integerBox.inspect("some text"); // error: this is still String! Not an Integer or derivative class of Integer. 
    }
	
	
	public static void addNumbers(List<? super Integer> list) {
	    for (int i = 1; i <= 10; i++) {
	    	list.add(i);
//	        list.add(new Object());
	    }
	    list = new ArrayList<Object>();
	}
}



/*
 * Multiple Bounds
 * 
 * The preceding example illustrates the use of a type parameter with a single
 * bound, but a type parameter can have multiple bounds:
 * 
 * <T extends B1 & B2 & B3> A type variable with multiple bounds is a subtype of
 * all the types listed in the bound. If one of the bounds is a class, it must
 * be specified first. For example:
 * 
 	Class A { /* ...
 	}

	interface B {
	/* ...  
	}

	interface C {
	/* ...  }

	class D<T extends A & B & C> {
	/* ...  }
	 * 
	
	If bound
	A is
	not specified first,
	you get
	a compile-
	time error:

	class D <T extends B & A & C> { /* ...  } // compile-time error
*/
