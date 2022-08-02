package chapter2_동작파라미터;

import chapter2_동작파라미터.common.Apple;
import chapter2_동작파라미터.common.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 일곱 번째 시도, 리스트 형식으로 추상화
 * -> 제네릭 타입의 사용?
 * -> 반환값을 추상화화는 자바의 기능을 활용한 것 같음
 *
 *  - 비교하는 기준이 변경되는 요구사항에 유연해짐
 */

public class Chapter2_7_리스트형식으로_추상화 {

    public static <T> List<T> filterList(List<T> inventory,
        Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : inventory) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void run() {
        List<Apple> inventory = List.of(
            new Apple(Color.GREEN, 50),
            new Apple(Color.RED, 111),
            new Apple(Color.GREEN, 13)
        );

        List<Integer> numbers = List.of(1, 2, 3, 4);
        // 제네릭 추상화
        List<Apple> result = filterList(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        List<Integer> numberList = filterList(numbers, (Integer i ) -> i%2 == 0);
    }
}
