package generics;

import java.util.ArrayList;
import java.util.List;


public class Case_90_BoundedWildCards {
	/**
	 * 
	 * You can use an upper bounded wildcard to relax the restrictions on a
	 * variable. For example, say you want to write a method that works on List
	 * <Integer>, List<Double>, and List<Number>; you can achieve this by using
	 * an upper bounded wildcard.
	 * 
	 * To declare an upper-bounded wildcard, use the wildcard character ('?'),
	 * followed by the extends keyword, followed by its upper bound. Note that,
	 * in this context, extends is used in a general sense to mean either
	 * "extends" (as in classes) or "implements" (as in interfaces).
	 * 
	 * To write the method that works on lists of Number and the subtypes of
	 * Number, such as Integer, Double, and Float, you would specify List<?
	 * extends Number>. The term List<Number> is more restrictive than List<?
	 * extends Number> because the former matches a list of type Number only,
	 * whereas the latter matches a list of type Number or any of its
	 * subclasses.
	 * 
	 * 
	 * An upper bounded wildcard restricts the unknown type to be a specific
	 * type or a subtype of that type and is represented using the extends
	 * keyword. In a similar way, a lower bounded wildcard restricts the unknown
	 * type to be a specific type or a super type of that type.
	 */
	
	public static void main(String args[]) {

        A aObj = new A();
        B bObj = new B();

        //We can add object of same type (A) or its subType is legal
        List<A> list_A = new ArrayList<A>();
        list_A.add(aObj);
        list_A.add(bObj); // A aObj = new B(); //Valid
        //list_A.add(new String()); Compilation error (CE);
        //can't add other type   A aObj != new String();


        //We can add object of same type (B) or its subType is legal
        List<B> list_B = new ArrayList<B>();
        //list_B.add(aObj); CE; can't add super type obj to subclass reference
        //Above is wrong similar like B bObj = new A(); which is wrong
        list_B.add(bObj);



        //Wild card (?) must only come for the reference (left side)
        //Both the below are wrong;   
        //List<? super A> wildCard_Wrongly_Used = new ArrayList<? super A>();
        //List<? extends A> wildCard_Wrongly_Used = new ArrayList<? extends A>();


        //Both <? extends A>; and <? super A> reference will accept = new ArrayList<A>
        List<? super A> list_4__A_AND_SuperClass_A = new ArrayList<A>();
                        list_4__A_AND_SuperClass_A = new ArrayList<Object>();
                      //list_4_A_AND_SuperClass_A = new ArrayList<B>(); CE B is SubClass of A
                      //list_4_A_AND_SuperClass_A = new ArrayList<String>(); CE String is not super of A  
        List<? extends A> list_4__A_AND_SubClass_A = new ArrayList<A>();
                          list_4__A_AND_SubClass_A = new ArrayList<B>();
                        //list_4__A_AND_SubClass_A = new ArrayList<Object>(); CE Object is SuperClass of A


        //With super keyword we can use the same reference to add objects
        //Any sub class object can be assigned to super class reference (A)                  
        list_4__A_AND_SuperClass_A.add(aObj);
        list_4__A_AND_SuperClass_A.add(bObj); // A aObj = new B();
        //list_4__A_AND_SuperClass_A.add(new Object()); // A aObj != new Object(); 
        //list_4__A_AND_SuperClass_A.add(new String()); CE can't add other type

        //We can't put anything into "? extends" structure. 
        //list_4__A_AND_SubClass_A.add(aObj); compilation error
        //list_4__A_AND_SubClass_A.add(bObj); compilation error
        //list_4__A_AND_SubClass_A.add("");   compilation error

        //The Reason is below        
        //List<Apple> apples = new ArrayList<Apple>();
        //List<? extends Fruit> fruits = apples;
        //fruits.add(new Strawberry()); THIS IS WORNG :)

        //Use the ? extends wildcard if you need to retrieve object from a data structure.
        //Use the ? super wildcard if you need to put objects in a data structure.
        //If you need to do both things, don't use any wildcard.


        //Another Solution
        //We need a strong reference(without wild card) to add objects 
        list_A = (ArrayList<A>) list_4__A_AND_SubClass_A;
        list_A.add(aObj);
        list_A.add(bObj);

        list_B = (List<B>) list_4__A_AND_SubClass_A;
        //list_B.add(aObj); compilation error
        list_B.add(bObj);
    }
	
}

class A {}

class B extends A {}