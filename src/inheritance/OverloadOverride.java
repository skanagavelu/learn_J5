package inheritance;
/**
 * http://howtodoinjava.com/object-oriented/method-overloading-and-overriding-rules-in-java/
 * @author ksugumar
 *
 */
public class OverloadOverride {
	public static void main(String[] args) {

	}
}


class SuperClass1 {
	public Object call(Object obj){
		return null;
	}
}

class SubClass1 extends SuperClass1{
	//Below is overloading
	/*
	 * The method argument list in overridden and 
	 * overriding methods must be exactly same If they don’t match, 
	 * you will end up with an overloaded method.
	 */
	public Object call(String obj){
		return null;
	}
}