package generics;

public class Case_1_Introduction {
	/**
	 *  Source : https://docs.oracle.com/javase/tutorial/java/generics/
	 *           http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.html
	 *  
	 *  What is an good project? :: test-driven development
	 *  	   
	 *  1. Generics add stability to your code by making more of your bugs detectable at compile time.
	 *     It is for compile time data type integrity.  
	 *  2. Generics won't improve the execution performance.
	 *  3. Mostly dealing with avoiding ClassCastException :: RuntimeException
	 *  
	 *  Synonyms:
	 *  type == classes and interfaces
	 *  generic type == A generic type is a generic class or interface that is parameterized over types. The following Box class will be modified to demonstrate the concept.
	 *  /* types ==  The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types. 
	 *  
	 *  
	 *  Why Use Generics?
	 *  Stronger type checks at compile time:   Early error detection at compile time.
	 *  	A Java compiler applies strong type checking to generic code and issues errors if the code violates type safety. 
	 *  	Fixing compile-time errors is easier than fixing runtime errors, which can be difficult to find.
	 *  
	 *  Elimination of casts:
	 *		The following code snippet without generics requires casting:
			List list = new ArrayList();
			list.add("hello");
			String s = (String) list.get(0);
			---
	 * 		for(int i = 0; i < list.size(); i++) {
	 *           String s = (String) list.get(i);
	 * 		}

	 *      When re-written to use generics, the code does not require casting:
			List<String> list = new ArrayList<String>();
			list.add("hello");
			String s = list.get(0);   // no cast
			---
	 *      for(String s : list) {}		
			
	 *  Enabling programmers to implement generic algorithms restrict to some bounds:
	 *  	By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.
	 *      TreeSet<comparable>  ==  ClassCastException
	 *      
	 *      
	 */
}
