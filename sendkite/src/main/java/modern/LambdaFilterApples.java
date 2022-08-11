package modern;

import modern.domain.Apple;
import modern.domain.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaFilterApples {
    public static void main(String[] args) {
        // 함수형 인터페이스
        Runnable r = () -> System.out.println("hello world!");
         r.run();

        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        Comparator<Apple> byWeight = Comparator.comparingInt(Apple::getWeight);
        inventory.sort(byWeight);
        System.out.println(inventory);

    }
}
