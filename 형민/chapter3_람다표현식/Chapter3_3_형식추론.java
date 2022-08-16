package chapter3_람다표현식;

import chapter2_동작파라미터.common.Apple;
import java.util.Comparator;

/**
 * 람다를 더 축약하는 방법 - 형식추론
 *
 * 자바 컴파일러는, 람다표현식이 사용된 콘텍스트(대상 혀식)을 이용해서 람다 표현식과 관련된 함수형 인터페이스를 추론한다.
 * 컴파일일러는 람다의 시그니처도 추론가능
 * 즉, 파라미터 형시에 접근할 수 있고, 람다 문법에서 이를 생략할 수 있다.
 */
public class Chapter3_3_형식추론 {
    Comparator<Apple> byWeight_Lambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    //형식추론으로 생략
    Comparator<Apple> byWeight_Context = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

}
