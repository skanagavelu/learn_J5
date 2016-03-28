package generics;

import java.util.List;

public class OverloadAndOverride {

	public void overload(int integerVal) {
		System.out.println("integerVal");
	}

	public void overload(long longVla) {
		System.out.println("longVal");
	}
	
	public void overload(double doubleVal) {
		System.out.println("doubleVal");
	}
	
	public void overload(Integer integerVal) {
		System.out.println("Integer Val");
	}
	
	public static void main(String[] args) {
		OverloadAndOverride obj = new OverloadAndOverride();
		obj.overload(1);  //integerVal
		obj.overload(1L); //longVal
		obj.overload(1D); //doubleVal
		
		X xObj = new X();
		xObj.overload(1); //integer Val
		
		Y yObj = new Y();
		yObj.overload("hello"); //String Val
		
		
		
	}
}

class X {

	public void overload(Integer integerVal) {
		System.out.println("Integer Val");
	}
	
	public void overload(int integerVal) {
		System.out.println("integer Val");
	}
}

class Y extends X {
	public void overload(Object obj) {
		System.out.println("Object Val");
	}
	
	public void overload(String obj) {
		System.out.println("String Val");
	}
}

class Z extends Y {
// CE: Erasure of method overload(List<?>) is the same as another method in type Z
// There is only one possible method can exits here. 	
	
//	public void overload(List obj) {
//		System.out.println("Object Val");
//	}
	
//	public void overload(List<?> obj) {
//		System.out.println("String Val");
//	}
//	
//	public void overload(List<? extends Object> obj) {
//		System.out.println("String Val");
//	}
	
	public void overload(List<? super String> obj) {
		System.out.println("String Val");
	}
}