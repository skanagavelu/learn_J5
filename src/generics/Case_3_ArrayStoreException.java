package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * http://stackoverflow.com/questions/12369957/dealing-with-an-arraystoreexception
 * @author ksugumar
 *
 */
public class Case_3_ArrayStoreException {
	public static void main(String[] args) {
		/**
		 * 
		 * The Liskov Substitution Principle (LSP, lsp) is a concept in Object Oriented Programming that states: 
		 * Functions that use pointers or references to base classes 
		 * must be able to use objects of derived classes without knowing it
		 *
		 * So this is fine.
		 * SuperClass ref = new SubClass();
		 */
		
		//Know the difference between reference casting and container holding references.
		
		//And below also fine.
		Object[] objects = new Object[3];
		objects[0] = new String("I am String");
		objects[1] = new Integer(1);
						
		//But problem is here on data integrity. And it is solved from ASE.
		Object[] stringObjects = new String[3];
		stringObjects[0] = new String("I am String");
		stringObjects[1] = new Object(); //ASE: this is something like "SubClass subRef = new SuperClass()"
		//Arrays are always typesafe using through ASE, but collections are not typeSafe, so we need Generics to ensure that atleast at compile time.
		
		
		// It is not an issue with memory allocation, it is an issue with data integrity.
		// The wrong one here is LSP of Object[] stringObjects = new String[3]; and leading to WRONG substitution.
		

		List objectsList = new ArrayList();
		objectsList.add(0, new String("I am String"));
		objectsList.add(1, new Integer(1));
		
		//How to differentiate stringObjectsList from objectsList??? How to ensure data integrity here??
		List stringObjectsList = new ArrayList();
		objectsList.add(0, new String("I am String"));
		objectsList.add(1, new Integer(1));
		
		
		//The solution is
		//
		///////////////////////////////////////////
		///////////////////////////////////////////
		////////      GENERICS         ////////////
		///////////////////////////////////////////
		///////////////////////////////////////////
		//
		//
		// with Type mismatch error and Class Cast Exception
		
		List<Object> objectsListG = new ArrayList<String>(); //Type mismatch: cannot convert from ArrayList<String> to List<Object>
		
		List<String> stringObjectsListG = new ArrayList<String>();
		stringObjectsListG.add(new Object()); //CE The method add(String) in the type List<String> is not applicable for the arguments (Object)
		
		//Reassigning Container(List) and contents of container 
	}
}
