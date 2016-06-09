package generics;

public class Case_5_RawTypes {
	
/**
 * A raw type is the name of a generic class or interface without any type arguments. 
 */
	
//	For example, given the generic Box class:
//	public class Box<T> {
//	    public void set(T t) { /* ... */ }
//	    // ...
//	}
	
//	To create a parameterized type of Box<T>, you supply an actual type argument for the formal type parameter T:
//
//		Box<Integer> intBox = new Box<>();
	
	
//	If the actual type argument is omitted, you create a raw type of Box<T>:
//
//		Box rawBox = new Box();
//		Therefore, Box is the raw type of the generic type Box<T>.
//	
//	However, a non-generic class or interface type is not a raw type.
//	
//	BaseVector is not a raw type.
//	BaseVector /* <BaseId> */

	
	
	//The problems on using RawTypes
	public static void main(String[] args) {
		Box<String> stringBox = new Box<>();
		
		//All the below are valid but with warnings
		Box rawBox = stringBox;  //Box is a raw type. References to generic type Box<T> should be
		
		//TODO: How to add @SuppressWarnings here
		rawBox.set(8); //Type safety: The method set(Object) belongs to the raw type Box. References to generic type Box<T> should be parameterized
		
		@SuppressWarnings("unchecked")
		Box<Integer> intBox1 =  rawBox; //Type safety: The expression of type Box needs unchecked conversion to conform to Box<Integer>
		
		@SuppressWarnings("unchecked")
		Box<Integer> intBox2 = (Box<Integer>) rawBox; //Type safety: Unchecked cast from Box to Box<Integer>
	}
	
}

class Box<T> {
	// T stands for "Type"
	private T t;


	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}
