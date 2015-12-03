package test;

import scala.Function;
import scala.Function1;

/**
 * Created by Silent on 15.11.2015.
 */
public class JavaService {
    public String message() {
        return "JavaService message";
    }

    public void foo() {
        Main.main(null);
    }

    public static void main(String[] args) {
        System.out.println("JavaService.main");
        new JavaService().foo();
    }

    public void doScalaF(Function1<String, String> a) {
        System.out.println("a = " + a);
        System.out.println(a.apply("in java!!"));
    }

}
