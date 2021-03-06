package java8;

/**
 * @Author Shaiful Islam Palash | kuvic16@gmail.com
 * @CreatedAt: 3/11/2021
 */

/**
 * What is functional programming?
 * @source: https://www.geeksforgeeks.org/functional-programming-in-java-with-examples/
 * -----------------------------------
 * It is a declarative style of programming rather than imperative. The basic objective of this style of programming is to
 * make code more concise, less complex, more predictable, and easier to test compared to the legacy style of coding.
 * Functional programming deals with certain key concepts such as *pure function*, *immutable state*, *assignment-less*
 * programming.
 *
 * **pure function**
 * A function is called pure function if it always returns the same result for same argument values and it has no side effects
 * like modifying an argument (or global variable) or outputting something. The only result of calling a pure function is the
 * return value. Examples of pure functions are strlen(), pow(), sqrt() etc. Examples of impure functions are printf(), rand(),
 * time(), etc.
 *
 * **immutable state**
 * State is simply information about something held in memory. Immutable objects(for which none of the state can be changed)
 * become important when you are dealing with concurrency, the ability for more than one processor in your computer to operate
 * on that object at the same time. Immutability guarantees that you can rely on the state to be stable and valid for the
 * object's lifetime.
 *
 * **Functional programming vs Purely functional programming**
 * Pure functional programming languages don't allow any mutability in its nature whereas a functional style language provides
 * higher-order functions but often permits mutability at the risk of we failing to do the right things, which put a burden on us
 * rather than protecting us. So, in general, we can say if a language provides higher-order function it is functional style
 * language. Java is a functional style language and the language like Haskell is a purely functional programming language.
 *
 * **Higher-order functions**
 * In functional programming, functions are to be considered as first-class citizens. That is, so far in the legacy syle of coding,
 * we can do below stuff with objects.
 * 1. We can pass objects to a function
 * 2. We can create objects within functions
 * 3. We can return objects from a function
 * 4. We can pass a function to a function
 * 5. We can create a function within function
 * 6. We can return a function from a function
 *
 * **Pure functions**
 * A function is called pure function if it always returns the same result for same argument values and it has no side effects like
 * modifying an argument (or global variable) or outputting something.
 *
 * **Lambda expressions**
 * A Lambda expression is an anonymous method that has mutability at very minimum and it has only a parameter list and a body.
 * The return type is always inferred based on the context. Also, make note, Lambda expression is:
 *
 * (parameter) -> body
 *
 * In its simple form, a lambda could be represented as a comma-seprated list of parameters, the -> symbol and the body.
 *
 *
 * @param <F>
 * @param <T>
 */

@FunctionalInterface
interface Converter<F, T> {
    T convert(F form);
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

class Person {
    String firstName;
    String lastName;

    Person(){}
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

class FunctionalIntrfc {


    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("123");
        System.out.println(converted1);

        Something something = new Something();
        Converter<String, String> converter2 = something::startsWith;
        String converted2 = converter2.convert("Java");
        System.out.println(converted2);

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Shaiful", "Islam");
        System.out.println(person.firstName);
        System.out.println(person.lastName);

        /**
         * Lambda Scopes
         * -------------
         * Accessing outer scope variables from lambda expressions is very similar to anonymous objects.
         * You can access final variables from the local outer scope as well as instance fields and static
         * variables.
         */
        final int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));


        int num1 = 1;
        Converter<Integer, String> stringConverter1 = (from) -> String.valueOf(from + num1);
        System.out.println(stringConverter.convert(2));
        //num1 = 3;
        System.out.println(num1);

    }
}
