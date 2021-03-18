package java8;

/**
 * @Author Shaiful Islam Palash | kuvic16@gmail.com
 * @CreatedAt: 3/17/2021
 */

/**
 * Accessing fields and static variables
 *
 * In contrast to local variables we have both read and write access to instance fields and static
 * variables from within lambda expressions. This behaviour is well known from anonymous objects.
 */
public class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
    }

}
