package java8;

/**
 * @Author Shaiful Islam Palash | kuvic16@gmail.com
 * @CreatedAt: 3/11/2021
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
