package generics;


public class Case_X_Miscellaneous {
	public static void main(String[] args) {
		/**
		 * Case Study_1 :
		 * http://stackoverflow.com/questions/13229979/java-nested-generic-type-mismatch
		 * 
		 * Case Study_2 :
		 * http://stackoverflow.com/questions/7376898/map-of-maps-and-generics
		 * 
		 * Case Study_3: type-inferencing
		 * http://stackoverflow.com/questions/11513650/generic-methods-and-type-inferencing-in-java  
		 * 
		 * Case Study_4: Class should directly declared with concrete class name as its type parameter. e.g) class MyClass<String> The type parameter String is hiding the type String
		 * http://stackoverflow.com/questions/10178377/java-generics-the-type-parameter-string-is-hiding-the-type-string
		 * 
		 * Arrays.asList(1,2,3)
		 * 
		 * 
		 */
	}
}



//Case Study_4
interface MyInterface<T> {
	  public void query(T query);
}
class Subclass implements MyInterface<String> {
	 
	 public void query(String queryStr) { 
	    
	  }
}
