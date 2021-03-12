package java8;

/**
 * @Author Shaiful Islam Palash | kuvic16@gmail.com
 * @CreatedAt: 3/11/2021
 */

/**
 * What is functional programming?
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
