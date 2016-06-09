package generics;

public class Case_7_Inheritance_SubTyping {
//Look at the three pictures shared in this link 
//https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html
	
	public static void main(String[] args) {
		/*
		 * Case Study 1: What will happen when Sub class is raw implementation
		 * Case Study 1: Result 1: SubClass instance cannot be assigned to SuperClass reference       
		 * - SuperClass8 is a raw type. References to generic type
		 * SuperClass8<T> should be parameterized - Type mismatch: cannot
		 * convert from SubClass8 to SuperClass8
		 */
		SubClass8 subInstnace = new SubClass8();
		SuperClass8 superInstance = subInstnace;
		
		
		//Case Study 1: Result 2: Cannot inherit Type declaration from parent: The type SubClass8 is not generic; it cannot be parameterized with arguments <Integer>
		SubClass8<Integer> instance1 = new SubClass8<Integer>();
		
		SubClass8 instance = new SubClass8();
		//Case Study 1: Result 3: Parent class methods are not visible 
		instance.setPropety(new Integer(10));
		instance.getPropetyClass();
		
		
//		SuperClass8 superInstance = new SuperClass8();
//		superInstance.setPropety(new Integer(5));
//		superInstance.setPropety(new String());
	}
}

//Case Study 1: What will happen when Sub class is raw implementation
class SuperClass8<T extends Number> {
	public T propety;

	public T getPropety() {
		return propety;
	}

	public void setPropety(T propety) {
		this.propety = propety;
	}
	
	public Object getPropetyClass() {
		return propety.getClass();
	}
	
}

class SubClass8 extends SuperClass {
	@Override //Cannot override
	public void setPropety(Object propety) {
		this.propety = propety; //Field also not accessible
	}
}
