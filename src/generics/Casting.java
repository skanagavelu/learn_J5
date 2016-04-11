package generics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Casting is required only when SuperClass reference is assigned to a Subclass.
 * Object t = new String(); NO CASTING required.
 * String t1 = (String)t; CASTING required.
 * 
 * And ClassCastException is runtime exception, since casting is explicitly done by user
 * to avoid compiler check, and even compiler don't know what it can be e.g) non generic List can contain any object
 * Hence only during runtime we can predict the failure of casting.
 * 
 * Hence 
 * 
 * Object x1 = new Object();
 * String x2 = (String)x1; No CE.
 * 
 * 
 * @author ksugumar
 * 
 */
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
//		objArray[0] = new Object();//RE: java.lang.ArrayStoreException: java.lang.Object at Casting.main(Casting.java:13)
		
		
		
//		http://stackoverflow.com/questions/18666710/why-are-arrays-covariant-but-generics-are-invariant
		
		List<SubClass> subClassList = new ArrayList<SubClass>();
//		subClassList.add(new SuperClass()); CE: The method add(SubClass) in the type List<SubClass> is not applicable for the arguments (SuperClass)

		List<SuperClass> superClassList = new ArrayList<SuperClass>();
		superClassList.add(new SuperClass()); 		
		superClassList.add(new SubClass()); 
//		superClassList = (List<SuperClass>) subClassList; CE: Cannot cast from List<SubClass> to List<SuperClass>
		
		
		
		
//		List<SuperClass> superList = new ArrayList<SubClass>(); //CE: Type mismatch: cannot convert from ArrayList<SubClass> to List<SuperClass>
		List subClassDubList = subClassList;
		List<SuperClass> superClassDubList = subClassDubList;
		superClassDubList.add(new SuperClass()); //Corrupting the list with non generic.
				
		
		List<? extends SuperClass> list_4__A_AND_SubClass_A = new ArrayList<SubClass>();
		List<SuperClass> list_A = (ArrayList<SuperClass>)list_4__A_AND_SubClass_A; //Warning: Type safety: Unchecked cast from List<capture#1-of ? extends SuperClass> to ArrayList<SuperClass>
		list_A.add(new SuperClass()); // No exception here, Why? Because you have ignored the warning.
		
		
		
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
		
		//http://stackoverflow.com/questions/2745265/is-listdog-a-subclass-of-listanimal-why-arent-javas-generics-implicitly-p/2745301#2745301
		List<? super SuperClass> superSuperList = new ArrayList<SuperClass>();
		superSuperList.add(new SubClass());
		superSuperList.add(new SubSubClass());
		superSuperList.add(new SuperClass());
//		superSuperList.add(new Object()); CE: The method add(capture#4-of ? super SuperClass) in the type List<capture#4-of ? super SuperClass> is not applicable for the arguments (Object)
//		superSuperList.add(new String()); CE: The method add(capture#3-of ? super SuperClass) in the type List<capture#3-of ? super SuperClass> is not applicable for the arguments (String)
		superSuperList.get(0);
		superSuperList.get(1);
		superSuperList.get(2);
		
		List noGenericList = new ArrayList();
		noGenericList.add(new SubClass());
		noGenericList.add(new SubSubClass());
		noGenericList.add(new SuperClass());
		noGenericList.add(new Object());
		noGenericList.add(new String());
		
		
		
		System.out.println(Arrays.toString(arraySuper));
		System.out.println(superSuperList);
		System.out.println(noGenericList);
	}
}

class SuperClass {

}

class SubClass extends SuperClass {

}

class SubSubClass extends SubClass {

}

class A {}
class B extends A {}

