package generics;

import java.util.LinkedList;
import java.util.Queue;


public class GenericTypeDeclarationOnVariables {

	//The below is not possible.
	//Means we cannot directly declare variable with type declaration.
	//We need to declare type variable at class level or method level then use that in the variable level.
	private static void levelOrderTraversal1() {
//		Queue<T extends Comparable<T>> q = new LinkedList();  CE: T cannot be resolved to a type
	}
	
	//The solution.
	private static <T extends Comparable<T>> void levelOrderTraversal2() {
		Queue<T> q = new LinkedList();
	}
}
