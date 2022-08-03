package chapter2_동작파라미터;

import chapter2_동작파라미터.common.Apple;
import chapter2_동작파라미터.common.Color;
import java.util.ArrayList;
import java.util.List;


/**
 *  첫 번쨰 시도, 녹색 사과만 필터링
 *   - 요구사항 변경에 유연하지 않은 코드
 *   - 다른 색을 필터링 하고 싶다면, 코드를 수정해야함
 */
public class Chapter2_1_녹색사과필터링 {
    public static List<Apple> filterGreenApplesList(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
}
