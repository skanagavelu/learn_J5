package generics;

import java.util.ArrayList;
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
		
		HideObject hObj = new HideObject();
		Object oObj = (Object) yObj;
//		hObj.overload(oObj); CE: The method overload(X) in the type HideObject is not applicable for the arguments (Object)
		hObj.overload(yObj);  //HideObject Y obj

		xObj = yObj;
		hObj.overload(xObj);  //HideObject X obj
		
		
		
		//Overriding is runtime feature, 
		//so i think Generics don't have impact here.
		GenericBase gBase = new GenericChild();
		gBase.method(new ArrayList()); //Method no generic List called
		
		List gList = new ArrayList();
		gBase.method(gList);           //Method no generic List called
		
		List<Object> gObjectList = gList;
//		gBase.method(gObjectList); CE: The method method(List<String>) in the type GenericBase is not applicable for the arguments (List<Object>)
		
		List<String> gStringList = gList;
		gBase.method(gStringList);    //Method no generic List called
		
		System.out.println("Irrespective of child or parent references; always Overiding happens. ");
		GenericChild gChild = (GenericChild) gBase;
		gChild.method(new ArrayList()); //Method no generic List called
		
		List gCList = new ArrayList();
		gChild.method(gCList);           //Method no generic List called
		
		List<Object> gCObjectList = gCList;
//		gBase.method(gCObjectList); CE: The method method(List<String>) in the type GenericBase is not applicable for the arguments (List<Object>)
		
		List<String> gCStringList = gList;
		gBase.method(gCStringList);    //Method no generic List called
	}
}

class X {

	public void overload(Integer integerVal) {
		System.out.println("Integer Object Val");
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


class HideObject {
	public void overload(X obj) {
		System.out.println("HideObject X obj");
	}
	
	public void overload(Y obj) {
		System.out.println("HideObject Y obj");
	}
}

enum Constants {
	I(){

		@Override
		public int method() {
			return 0;
		}
		
	};
	public abstract int method();
}


class GenericBase {
	public void method(List<String> list){
		System.out.println("Method generic List called");
	}
}

class GenericChild extends GenericBase {
	//Below is valid to use
//	public void method(List<String> list){
//		System.out.println("Method List<String> list");
//	}
	
	public void method(List list){
		System.out.println("Method no generic List called");
	}
}
