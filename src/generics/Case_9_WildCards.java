package generics;

import java.util.ArrayList;
import java.util.List;

public class Case_9_WildCards<?> {
	
/**
 * 
 * In generic code, the question mark (?), is called (unbounded) wildcard, represents an unknown type.
 * An unbound type can be useful when your method doesn't really care about the actual type.
 * 
 * T is to deal with in the class/method syntax; finally that will be converted to valid type argument once it is instantiated.
 * ? is to deal with unknown type arguments passed to a method.
 * 
 * T can be stand alone in method signature.  method (T input)
 * ? can not. always associated with generic type.  method (? input) is wrong. ==> method (Box<?> input) is valid.
 * 
 * 
 * This (?) unknown wildcard is only useful to get value from collection OR access methods which is not dealing Type Param.
 *                                     Not for put.  
 *                                     
 * It is mostly for dealing with unknown/bounded instances of Generic types and its sub types.
 * List<?> reference = new ArrayList<String> (); 
 * List<?> reference = new ArrayList<Integer> ();
 * List<?> reference = new ArrayList<Object> ();
 * So to deal with different hierarchy which is not possible with T.
 * 
 * T is dealing with same hierarchy.
 * List<String> ref  = new ArrayList<String>();
 * List<String> ref != new ArrayList<Integer> ();
 * 
 * List<T> ref = new ArrayList<String>();  CE: Should remember T can't be used like this. 
 * 
 * List<? extends String> reference = new ArrayList<String> ();
 * 
 * It is used at method levels and within a method context. Not at class level declaration like T did.
 * Means Class Box<?> {} is invalid.                                     
 */
	
    //Case Study_1: The wildcard is never used as a direct type argument for a generic method invocation
    public static <?> void inspect3(? u){} //Means you cant define it like <T> in generic method
	
    //Case Study_1: But it can be used with generic type (class with type parameter)
	public static <T> void inspect4(List<?> u, List<T> v){
		 
    //Case Study_2: This is mostly to satisfy any unknown generic type to dealt with
		 u = new ArrayList<Integer>();
		 u = new ArrayList<Object>();
		 u = new ArrayList<String>();
	
		 v = new ArrayList<Integer>(); //Looks like this is final to other.
		 v = new ArrayList<T>();
		 
    //Case Study_3: The wildcard is never used as a type argument on a a generic class 
	//class Inspect<?>{}
		 
		 
	//Case Study_4: How List<?> differs from List<Object>[which is nothing but List<T> of method argument and instantiated with Object.]. this will provide option to work with any type of generic method. 
	// The main difference is that the first line compiles but the second does not:
			 List<?> list = new ArrayList<String> ();
			 //List<Object> list1 = new ArrayList<String> ();
	//You can insert an Object, or any subtype of Object, into a List<Object>. But you can only insert null into a List<?>.
			 //list.add("Hello"); //Can't access method which is dealing with Type param. See below example.
			 list.add(null);
			 
			 //This is something like below
			 MyCustomIntegerType<?> unknownRef = new MyCustomIntegerType<Integer>();
//			 unknownRef.print(new Integer(10)); //The method print(capture#5-of ?) in the type MyCustomIntegerType<capture#5-of ?> is not applicable for the arguments (Integer)
			 unknownRef.get();
			 

	//Case Study_5: How List<?> differs from List raw type.		 
			 List list9 = new ArrayList<String> ();
			 list9.add("aString");
			 list9.add(10);
	 }
	 
	 
	//Case Study_6: Both are same :: <? extends Number> vs <T extends Number> :: Both are same.
	//What is difference here?
	public static <T> void inspect1(List<T> u){}
	public static void inspect2(List<?> u){}
   // http://stackoverflow.com/questions/11497020/java-generics-wildcard-extends-number-vs-t-extends-number
   
   
	 
//	 Not for session:
//	 public static void inspect1(MyCustomIntegerType<? extends String> u){
//		 u = new MyCustomIntegerType<String> ();
////		 u = new MyCustomIntegerType<Integer> ();
//	 }
//	 class MyCustomIntegerType<Integer> {}
}

class MyCustomIntegerType<T> {
	T ref;
	 public void print(T input){
		 System.out.println(input);
	 }
	 
	 public T get(){
		 return ref;
	 }
}
