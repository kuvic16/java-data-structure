package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author Shaiful Islam Palash | kuvic16@gmail.com
 * @CreatedAt: 3/15/2021
 */

class Customer {
    private String name;
    private int points;

    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

public class Filter {
    public static void main(String[] args) {
        Customer palash = new Customer("palash", 1);
        Customer forhad = new Customer("forhad", 2);

        List<Customer> list = Arrays.asList(palash, forhad);
        Optional<Customer> customer = list.stream().filter(c -> c.getName().equalsIgnoreCase("palash")).findAny();
        if(customer.isPresent()) {
            System.out.println(customer.get().getName() + ": " + customer.get().getPoints());
        }

    }
}
