package java8;

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
        Customer john = new Customer("Johnn", 15);
    }
}
