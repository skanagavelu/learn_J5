package generics;

import java.util.List;

public class Case_91_TypeErasure {
    
    public Case_91_TypeErasure() {
        super();
    }
    
    public static int count(Object[] anArray, Object elem) {
        int cnt = 0;
        for (/*synthetic*/ Object[] arr$ = anArray, len$ = arr$.length, i$ = 0; i$ < len$; ++i$) {
            Object e = arr$[i$];
            if (e.equals(elem)) ++cnt;
        }
        return cnt;
    }
    /*synthetic*/ {
    }
    /*synthetic*/ {
    }
    /*synthetic*/ {
    }
    
    public static void drawUpperBound(Case_91_TypeErasure$Shape shape) {
    }
    
    public static void drawUpperBound(List shape) {
    }
    
    public static void drawUpperBound1(List shape) {
    }
    
    public static void drawLowerBound1(List shape) {
    }
    
    public static void main(String[] args) {
        MyNode mn = new MyNode();
        Node n = mn;
        n.setData("Hello");
        Integer x = (Integer)mn.data;
    }
}
