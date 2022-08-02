package chapter2_동작파라미터;

import chapter2_동작파라미터.common.Apple;
import chapter2_동작파라미터.common.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *  세 번쨰 시도, 가능한 모든 속성으로 필터링
 *   - 가능한 모든 경우를 생각하고 필터링
 *
 *   -> 가장 쓰레기 코드
 */

public class Chapter2_3_가능한_모든_속성으로필터링 {
    public static List<Apple> filterGreenApplesList(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 뭘할려는 건지, 코드만 보고 전혀 알 수 가 없음
            if((flag && apple.getColor().equals(color)) ||
                (!flag &&apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }
}
