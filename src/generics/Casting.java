package generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Casting {
	public static void main(String[] args) {
		SuperClass[] arraySuper = new SuperClass[10];
		arraySuper[0] = new SuperClass();
		arraySuper[1] = new SubClass();
//		arraySuper[2] = new Object(); CE: Type mismatch: cannot convert from Object to SuperClass
//		arraySuper[2] = (SuperClass) new Object();   RE: java.lang.ClassCastException: java.lang.Object cannot be cast to SuperClase
		
		//http://stackoverflow.com/questions/12369957/dealing-with-an-arraystoreexception
		Object[] objArray = new String[10]; //This should be avoided.
		objArray[0] = new String();
		objArray[0] = new Object();//RE: java.lang.ArrayStoreException: java.lang.Object at Casting.main(Casting.java:13)
		
		
		
//		http://stackoverflow.com/questions/18666710/why-are-arrays-covariant-but-generics-are-invariant
		
//		List<SuperClass> superList = new ArrayList<SubClass>(); //CE: Type mismatch: cannot convert from ArrayList<SubClass> to List<SuperClass>
		List<?> superList = new ArrayList<SubClass>();   // Using this we can only read; we cannot write
//		superList.add(new SubClass());     //CE: The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (SubClass)
		
		
		//http://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-arent-javas-generics-implicitly-p/2745301#2745301
		List<? extends SuperClass> superExtendsList = new ArrayList<SubClass>();
		/*
		 * CE:
		 * Multiple markers at this line
			- The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (SubClass)
			- The method add(capture#1-of ? extends SuperClass) in the type List<capture#1-of ? extends SuperClass> is not applicable for the arguments 
	 			(SubClass)
		 *
		 *
		 *superExtendsList.add(new SubClass()); 
		 */
		
		    

		System.out.println(Arrays.toString(arraySuper));
	}
}

class SuperClass {

}

class SubClass extends SuperClass {

}