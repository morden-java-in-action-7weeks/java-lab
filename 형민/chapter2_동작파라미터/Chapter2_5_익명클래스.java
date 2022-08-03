package chapter2_동작파라미터;

import chapter2_동작파라미터.common.Apple;
import chapter2_동작파라미터.common.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 다섯 번째 시도, 익명 클래스 사용
 * - 구현체를 계속 만들어야되는게 귀찮다!!
 * - 바로바로 사용하고 싶따! 해서 나온게 익명 클래스
 *
 *
 * - 말그대로 이름이 없고 인터페이스를 바로 구현해서, 인스턴스로 사용하는 것
 *  (하지만 매우 지저분해짐)
 */

public class Chapter2_5_익명클래스 {

    public static List<Apple> filterApplesList(List<Apple> inventory,
        ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 익명클래스 구현
    public void run() {
        List<Apple> inventory = List.of(
            new Apple(Color.GREEN, 50),
            new Apple(Color.RED, 111),
            new Apple(Color.GREEN, 13)
        );

        List<Apple> apples = filterApplesList(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
    }
}
