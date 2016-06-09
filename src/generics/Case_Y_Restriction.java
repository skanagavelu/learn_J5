package generics;

public class Case_Y_Restriction {
	/**
	 * 
	 * Case Study_1: Cannot Instantiate Generic Types with Primitive Types
	 * 
	 * class Pair<K, V> {
	 * 		private K key;
	 * 		private V value;
	 * 		public Pair(K key, V value) {
	 * 			this.key = key;
	 * 			this.value = value;
	 * 		}
	 * }
	 * 
	 * When creating a Pair object, you cannot substitute a primitive type for the type parameter K or V:

	 * Pair<int, char> p = new Pair<>(8, 'a');  // compile-time error
	 * You can substitute only non-primitive types for the type parameters K and V:

	 * Pair<Integer, Character> p = new Pair<>(8, 'a');
	 * Note that the Java compiler autoboxes 8 to Integer.valueOf(8) and 'a' to Character('a'):

	 * Pair<Integer, Character> p = new Pair<>(Integer.valueOf(8), new Character('a'));
	 * 
	 * 
	 * 
	 * *************************
	 * Case Study_2: Cannot Create Instances of Type Parameters
	 * 
	 * You cannot create an instance of a type parameter. For example, the following code causes a compile-time error:
	 * 
	 *  public static <E> void append(List<E> list) {
	 * 		E elem = new E();  // compile-time error
	 * 		list.add(elem);
	 *  }
	 * 
	 * Refer https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html for workaround.
	 * 
	 * 
	 * 
	 * 
	 * ************************
	 * Case Study_3: Cannot Declare Static Fields Whose Types are Type Parameters
	 *	
	 * public class MobileDevice<T> {
     *		private static T os; //Not allowed
	 * }
	 * 
	 * 
	 * 
	 * ************************
	 * Case Study_4: Cannot Use Casts or instanceof with Parameterized Types
	 * 
	 * Because the Java compiler erases all type parameters in generic code, 
	 * you cannot verify which parameterized type for a generic type is being used at runtime:
	 * 
	 * public static <E> void rtti(List<E> list) {
	 * 		if (list instanceof ArrayList<Integer>) {  // compile-time error
	 * 		...
	 * 
	 * 
	 * List<Integer> li = new ArrayList<>();
	 * List<Number>  ln = (List<Number>) li;  // compile-time error
	 * 
	 * 
	 * List<String> l1 = ...;
	 * ArrayList<String> l2 = (ArrayList<String>)l1;  // OK
	 *
	 * 
	 * 
	 *************************
	 * Case Study_5: Cannot Create Arrays of Parameterized Types
	 * 
	 * You cannot create arrays of parameterized types. For example, the following code does not compile:
	 * List<Integer>[] arrayOfLists = new List<Integer>[2];  // compile-time error
	 * 
	 * The following code illustrates what happens when different types are inserted into an array:
	 * Object[] strings = new String[2];
	 * strings[0] = "hi";   // OK
	 * strings[1] = 100;    // An ArrayStoreException is thrown.
	 * 
	 * If you try the same thing with a generic list, there would be a problem:
	 * Object[] stringLists = new List<String>[];  // compiler error, but pretend it's allowed
	 * stringLists[0] = new ArrayList<String>();   // OK
	 * stringLists[1] = new ArrayList<Integer>();  // An ArrayStoreException should be thrown,
	 * 											   // but the runtime can't detect it.
	 * 
	 * 
	 * ************************
	 * Case Study_6: Cannot Create, Catch, or Throw Objects of Parameterized Types
	 * 
	 * A generic class cannot extend the Throwable class directly or indirectly. For example, the following classes will not compil
	 * 
	 * class MathException<T> extends Exception { /* ...  }    // compile-time error
	 * class QueueFullException<T> extends Throwable { /* ...  // compile-time error
	 * 
	 * 	try {
   	 *		doSomeStuff();
	 * 	} catch (SomeException<Integer> e) {
   	 * 		// ignore that
	 * 	} catch (SomeException<String> e) {
   	 * 		crashAndBurn()
	 * 	}
	 * 
	 * The below is valid
	 * public static <T extends Exception> void handleException(T ex) {}
	 * 
	 *
	 * You can, however, use a type parameter in a throws clause:
	 *
	 * class Parser<T extends Exception> {
     *		public void parse(File file) throws T {     // OK
     *    	// ...
     *	}
	 * }
	 *
	 *
	 *
	 **************************
	 * Case Study_7: Cannot Overload a Method Where the Formal Parameter Types of Each Overload Erase to the Same Raw Type
	 *
	 *	public class Example {
     *		public void print(Set<String> strSet) { }
     *		public void print(Set<Integer> intSet) { }
	 *	}
	 *
	 * The overloads would all share the same classfile representation and will generate a compile-time error.
	 *
	 *	public class Example <T> {
     *		public void print(Set<T> strSet) { }
     *		public void print(Set<?> intSet) { }
	 *	}
	 *
	 * But the below is possible 
	 *
 	 ***************************
	 *
	 * 
	 * All types, except enum types, anonymous inner classes and exception
	 * classes, can be generic. 
	 * 
	 * Almost all reference types can be generic. This
	 * includes classes, interfaces, nested (static) classes, nested interfaces,
	 * inner (non-static) classes, and local classes.
	 * 
	 * 
	 * 
	 */
	
//	Case Study_4:
	public static void main(String[] args) {
		Test<String> ref = new SubTest<String> ();
		SubTest<String> subRef = (SubTest<String>) ref;
	}
	
	public static <T extends Exception> void handleException(T ex) {}
}




class Test<Q> {}
class SubTest<Q> extends Test<Q> {}
