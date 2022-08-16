package chapter2_동작파라미터;

import chapter2_동작파라미터.common.Apple;
import java.util.ArrayList;
import java.util.List;

/**
 *  네 번째 시도, 추상적 조건으로 필터링
 *  - 외부에서 어떤 조건을 받아올거라면, 그 조건을 추상화
 *
 *  -> 메서도가 다양한 동작을 받아서, 내부에서 수행할 수 있도록 함
 *  -> 메서도는, 내부 로직만 신경쓰면 됨 (결합도 분리)
 */

public class Chapter2_4_추상조건으로_필터링 {
    public static List<Apple> filterGreenApplesList(List<Apple> inventory, ApplePredicate applePredicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 비교 조건은, 파라미터로 받는 predicate 에 책임 위임
            if(applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}

class AppleHeavyPredicate implements ApplePredicate{

    public boolean test(Apple apple) {
        //무게 비교
        return false;
    }
}


class AppleColorPredicate implements ApplePredicate{

    public boolean test(Apple apple) {
        //색상 비교
        return false;
    }
}