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

This allows us to lazily generate the argument for invocation of this function using a supplier implementation. This can be useful if the generation of the argument
takes a considerable amount of time. We'll simulate that using Guava's sleepUninterruptibly method:

`
Supplier<Double> lazyValue = () -> {
    Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
    return 9d;
}

Double valueSquared = squareLazy(lazyValue);
`

Stream.generate method implements the Supplier functional interface.
`
int[] fibs = {0, 1};
Stream<Integer> fibonacci = Stream.generate(() -> {
    int result = fibs[1];
    int fib3 = fibs[0] + fibs[1];
    fibs[0] = fibs[1];
    fibs[1] = fub3;
    return result;
});
`

8. Consumers
-------------------------------------
As opposed to the Supplier, the Consumer accepts a generified argument and returns nothing. It is a function that is representing side effects.
The lambda passed to the List.forEach method implements the Consumer functional interface

`
List<String> names = Arrays.asList("John", "Freddy", "Samuel");
names.forEach(name -> System.out.println("Hello, " + name));
`

There are also specialized versions of the Consumer- DoubleConsumer, IntConsumer and LongConsumer - that receive primitive values as arguments. More
interesting is the BiConsumer interface. One of its use cases is iterating through the entries of a map:

`
Map<String, Integer> ages = new HashMap<>();
ages.put("John", 25);
ages.put("Freddy", 24);
ages.put("Samuel", 30);

ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old")
`

9. Predicates
-------------------------------------
In mathematical logic, a predicate is a function that receives a value and returns a boolean value.

The Predicate functional interface is a specialization of a Function that receives a generified value and returns a boolean. A typical use case of the
predicate lambda is to filter a collection of values:

`
List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

List<String> namesWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
`

10. Operators
-----------------------------------
Operator interface are special cases of a function that receive and return the same value type. The UnaryOperator interface receives a single argument.
One of its use cases in the Collections API is to replace all values in alist with some computed values of the same type

`
List<String> names = Arrays.asList("bob", "josh", "megan");
names.replaceAll(name -> name.toUpperCase());
`

Of course, instead of name->name.toUpperCase(), we can simply use a method refrence
`
names.replaceAll(String::toUpperCase);
`

One of the most interesting use cases of a BinaryOperator is a reduction operation. Suppose we want to aggregate a collection of integers in a sum of all
values. With Stream API, we could do this using a collector but a more generic way to do it would be to use the reduce method:
`
List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
`

11. Legacy Functional Interfaces
-----------------------------------
No all functional interfaces appeared in Java 8. Many interfaces from previous versions of Java conform to the constraints of a FunctionalInterface, and we can
use them as lambdas. Prominent examples include the Runnable and Callable interfaces that are used in concurrency APIs. In Java 8, these interfaces are also marked
with a @FunctionalInterfaces annotation.
`
Thread thread = new Thread(()-> System.out.println("Hello From Another Thread"));
thread.start();
`

