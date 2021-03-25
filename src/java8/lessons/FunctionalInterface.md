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

In this case, we will calculate a value by applying a function to a key, put inside a map, and also returned from a method call. We may
replace the lambda with a method reference that matches passed and returned value types.

`
Integer value = nameMap.computeIfAbsent("John", String::length);
`

The Function interface also has a default compose method that allows us to combine several functions into one and execute them sequentially

`
Function<Integer, String> intToString = Object::toString;
Function<String, String> quote = s -> "'" + s + "'";

Function<Integer, String> quoteIntToString = quote.compose(intToString);
`

5. Primitive Function Specializations
--------------------------------
Since a primitive type can't be a generic type argument, there are versions of the Function interface for the most used primitive types double, int, long and their combinations in
argument and return types

a) IntFunction, LingFunction, DoubleFunction: arguments are of specified type, return type is parameterized.
b) ToIntFunction, ToLongFunction, ToDoubleFunction: return type is of specified type, arguments are parameterized.
c) DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction: having both argument
and return type defined as primitive types, as specified by their names

`
@FunctionalInterface
public interface ShortToByteFunction {
    byte applyAsByte(short s);
}
`

Now we can write a method that transforms an array of short to an array of byte using a rule defined by a ShortToByteFunction
`
public byte[] transformArray(short[] array, ShortToByteFunction function) {
    byte[] transformedArray = new byte[array.length];
    for(int i=0; i<array.length; i++) {
        transformedArray[i] = function.applyAsByte(array[i]);
    }
    return transformedArray;
}
`

Here's how we could use it to transform an array of shorts to an array of bytes
`
short[] array = {(short) 1, (short) 2, (short) 3};
byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
assertArrayEquals(expectedArray, transformedArray);
`

6. Two-arity function specializations
----------------------------------
To define lambdas with two arguments, we have to use additional interfaces that contain interfaces that contain "Bi" keyword in their
names: BiFunction, ToDoubleBiFunction, ToIntBiFunction, and ToLongBiFunction.

One of the typical examples of using this interface in the standard API is in the Map.replaceAll method, which alows replacing all values
in map with some computed valie.

`
Map<String, Integer> salaries = new HashMap<>();
salaries.put("John", 4000);
salaries.put("Freddy", 3000);
salaries.put("Samuel", 2000);

salaries.replaceAll((name, oldValue) ->
    name.equals("Freddy") ? oldValue : oldValue + 10000);
`

7. Supplier function interface
-----------------------------------
A function which does not take in any argument but produces a value of type T. Hence this functional interface takes in only one generic namely:

* T: denotes the type of the result

The supplier functional interface is yet another Function specialization that does not take any arguments. We typically use it for lazy generation of values.
For instance, let's define a function that squares a double value. It will not receive a value itself.

`
public double squareLazy(Supplier<Double> lazyvalue) {
    return Math.pow(lazyValue.get(), 2);
}
`




