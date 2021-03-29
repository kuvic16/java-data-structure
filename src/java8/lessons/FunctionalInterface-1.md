Ref: https://www.javatpoint.com/java-8-functional-interfaces

1. Java Functional Intefaces
--------------------
An interface that contains exactly one abstract method is known as functional interface. It can have any number of default,
static methods but can contain only one abstract method. It can also declare methods of object class.

Functional interface is also known as Single Abstract Method Interfaces or SAM Interfaces. It is a new feature in Java,
which helps to achieve functional programming approach.

Example 1:
---------
`
@FunctionalInterface
interface sayable {
    void say(String msg);
}

public class FunctionalInterfaceExample implements sayable{
    public void say(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
        fie.say("Hello there");
    }
}
`

Example 2:
----------
`
@FunctionalInterface
interface sayable {
    void say(String msg); // abstract method

    // It can contain any number of Object class methods.
    int hashCode();
    String toString();
    boolean equals(Object obj);
}

public class FunctionalInterfaceExample2 implements sayable{
    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args){
        FunctionalInterfaceExample2 fie = new FunctionalInterfaceExample2();
        fie.say("Hello there");
    }
}

`

Example 3:
----------------------
A functional interface is extending to a non-functional interface

`
interface Doable {
    default void doIt(){
        System.out.println("Do it now");
    }
}

@FunctionalInterface
interface Sayable extends Doable{
    void say(String msg); // abstract method
}

public class FunctionalInterfaceExample3 implements Sayable{
    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExample3 fie = new FunctionalInterfaceExample3();
        fie.say("Hello there");
        fie.doIt();
    }
}
`

Java Predefined-Functional Interfaces
-------------------------------------
Java provides predefined functional interfaces to deal with functional programming by using lambda and method references. You can also
define your own custom functional interface. Following is the list of functional interface which are placed in java.util.function package.

1. BiConsumer<T,U>: It represents an operation that accepts two input arguments and returns no result.
2. Consumer<T>: It represents an operation that accepts a single argument and returns no result.
3. Function<T,R>: It represents a function that accepts one argument and returns a result.
4. Predicate<T>: It represents a predicate(boolean-valued function) of one argument.
5. BiFunction<T,U,R>: It represents a function that accepts two arguments and returns a result


















