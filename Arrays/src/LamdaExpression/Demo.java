package LamdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@FunctionalInterface
interface A {
    public void hello();
}

// this the normal method to implement the interface create a implementation
// class for the interface and implement the method.
class B implements A {
    @Override
    public void hello() {
        System.out.println("Hello Ganesh");
    }
}

// but the above interface is a Functional Interface. Interface which has Single
// Abstract Method is callled ...
// so we can implement it using inner anonymous class.

public class Demo {

    // this is the example of inner anonymous class, where you have created the
    // class inside another class --> (inner), without name-->(anonymous) class

    A hello = new A() {
        @Override
        public void hello() {
            System.out.println("Hello Ganesh");
        }
    };

    // in java 8 new way for writing this was introduced called lambda expression,
    // where dont even have to create inner anonymous class.

    A hi = () -> System.out.println("Hello Ganesh");

    // thats it. but things to considerate is 1. the reference interface should be
    // functional interface then only lambda expression will work.

    /*
     * 
     * 
     * //stream api.
     * 
     * 1. Can use the stream only once after creating it.
     * 
     * 
     */

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 5, 54, 23, 15);

        Stream<Integer> data = nums.stream();

        // data.forEach(num -> System.out.println(num));

        // this line will give an error because stream has already been consumed in
        // above line.
        // data.forEach(num -> System.out.println(num));

        Integer reduce = nums.stream()
                .map(num -> num * 2)
                .reduce(0, (m, n) -> m + n);

        System.out.println(reduce);

    }

}
