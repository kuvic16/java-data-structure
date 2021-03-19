Ref: https://www.baeldung.com/java-8-functional-interfaces

1. Lambdas in Java 8
--------------------
Java 8 brought a powerful new syntactic improvement in the form of lambda expressions. A lambda is an anonymous function that
we can handle as a first-class citizen. For instance, we can pass it to or return it from a method.

Before Java 8, we would usually create a class for every case where we needed to encapsulate a single piece of
functionality. This implied a lot of unnecessary boilerplate code to define something that served as a primitive function
representation.

2. Functional Interfaces
-----------------------
It's recommended that all functional interfaces have an information @FunctionalInterface annotation. This clearly communicates
the purpose of the interface and also allows a compiler to generate an error if the annotated interface does not satisfy the
conditions. Any interface with a SAM(Single abstract method) is a functional interface. and its implementation may be treated
as lambda expressions.
Note that Java 8's default methods are not abstract and do no count; a functional interface may still have multiple default
methods. We can observe this by looking at the Function's documentation.

3. Functions
-----------------------
The most simple and general case of a lambda is functional interface with a method that receives one value and returns another.
This function of a single argument is represented by the "function" interface, which is parameterized by the types if its argument
and a return value:

`
public interface Function<T, R> {...}
`

One of the usage of the "Function" type in the standard library is the Map.computeIfAbsent method. This method returns a value from a
map by key. but calculates a value if a key is not already present in a map. To calculate a value it uses the passed Function
implementation

`
Map<String, Integer> nameMap = new HashMap<>();
Integer value = nameMap.computeIfAbsent("John", s-> s.length());
`
