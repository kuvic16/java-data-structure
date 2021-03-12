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
 *
 *
 * @param <F>
 * @param <T>
 */

@FunctionalInterface
interface Converter<F, T> {
    T convert(F form);
}

class FunctionalIntrfc {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
    }
}
