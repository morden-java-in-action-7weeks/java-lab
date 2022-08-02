package chapter2_동작파라미터;

import chapter2_동작파라미터.common.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  두 번째 시도, 색을 파라미터화
 *   - 외부에서 받아오는 파라미터로 공통되는 색을 추상화
 *   - 색 비교에는 확장에 제한을 받지않음
 *
 *   -> 그러나, 요구사항의 변경에는 여전히 유연하지 못함
 *   ex) 무게 비교, 모양비교 등등
 */

public class Chapter2_2_색을파라미터화 {
    public static List<Apple> filterGreenApplesList(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // -- 파라미터로 받은 color 로 비교
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
}
