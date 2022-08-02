package chapter2_동작파라미터;

import chapter2_동작파라미터.common.Apple;
import chapter2_동작파라미터.common.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * 여섯 번째시도 : 람다 표현식 사용
 *
 *  이런, 지저분해지는 문제를 해결하기 위해 나옴
 *  즉, 람다 표현식은 동작 파라미터화 때무에 나왔다!
 */

public class Chapter2_6_람다표현식 {

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

        //람다로 깔끔해짐
        List<Apple> result = filterApplesList(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
    }
}
