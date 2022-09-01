package chapter3_람다표현식;

import chapter2_동작파라미터.common.Apple;
import java.util.Comparator;

public class Chapter3_1_람다기본표현식 {

    /**
     * 람다를 사용하지 않았을 떄
     */
    Comparator<Apple> byWeight = new Comparator<Apple>() {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    };

    /**
     * 람다를 사용하면 아래처럼
     * 람다는 3부분으로 이루어짐 : 람다 파라미터 ->(화살표) 람다 바디
     */
    Comparator<Apple> byWeight_Lambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    /**
     * 람다 예시
     */

    /*
    //람다는 return이 함축되어 있음
     int slen = (String s) -> s.length();

     //람다 바디 중괄호 안에 여러 행의 문장을 포함할 수 있음
    (int x, int y) -> {
        System.out.println("순서대로");
        System.out.println(x + y);
        System.out.println("실행해요");
    }

    //람다의 파라미터가 없을 수도 있다. 이때는 42를 그대로 반환
    () -> 42
    */


}
