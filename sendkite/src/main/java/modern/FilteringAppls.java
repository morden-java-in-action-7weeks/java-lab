package modern;

import modern.domain.Apple;
import modern.domain.Color;
import modern.util.formatter.AppleFormatter;
import modern.util.formatter.ApplePrintFormatter;
import modern.util.formatter.ApplePrintWeightFormatter;
import modern.util.predicator.AppleGreenColorPredicate;
import modern.util.predicator.AppleHeavyWeightPredicate;
import modern.util.predicator.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringAppls {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));
        // 01
        List<Apple> apples = filterGreenApples(inventory);
        System.out.println("01. 그린 애플 필터링= " + apples);
        // 02-1
        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println("02-1. color 를 파라미터로 초록사과= " + greenApples);
        System.out.println("02-1. color 를 파라미터로 빨간사과= " + redApples);
        // 02-2
        List<Apple> heavyApples = filterApplesByWeight(inventory, 150);
        System.out.println("02-2. 무거운 사과= " + heavyApples);
        // 03
        greenApples = filterApples(inventory, Color.GREEN, 0, true);
        heavyApples = filterApples(inventory, null, 150, false);
        System.out.println("03. 초록사과= " + greenApples);
        System.out.println("03. 무거운 사과= " + heavyApples);

        // 04. 동작파라미터화 전략 패턴 -> 객체가 동작을 결정
        System.out.println("04. 초록 사과= " + filterApples(inventory, new AppleGreenColorPredicate()));
        System.out.println("04. 무거운 사과= " + filterApples(inventory, new AppleHeavyWeightPredicate()));

        // Quiz 2-1 prettyPrintApple
        prettyPrintApple(inventory, new ApplePrintFormatter());
        prettyPrintApple(inventory, new ApplePrintWeightFormatter());
    }

    private static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    // 04. 동작파라미터화
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // ex.01
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    // ex.02-1
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    // ex.02-2
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (apple.getWeight() > (weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    // ex.03 가능한 모든 파라미터 입력 + 구분 flag 사용
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }
}
