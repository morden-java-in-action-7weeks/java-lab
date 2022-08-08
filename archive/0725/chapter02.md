# Chapter 2 - 동작 파라미터화로 코드 전달하기

## 1. 동작 파라미터화란

- 동작 파라미터화란, 어떻게 실행할지 결정하지 않은 코드 블록을 의미합니다.
- 이 코드블록은 나중에 호출되어 사용되어질 때, 실행됩니다.
- 즉, 자주 바뀌는 요구사항에 효과적으로 대응할 수 있음을 의미합니다. (실행을 뒤로 미루기 때문에)
- 예를들어, 나중에 실행될 메서드의 인수로 코드블록을 전달할 수 있고, 결과적으로 코드블록에 메서드의 동작이 파라미터화 되어 전달됩니다.

## 2. 변화하는 요구사항에 대응하기

- 이번에는 예제를 통해 단계별로, 요구사항 변경에 대응하는 코드 작성 방법을 정리해보겠습니다.

~~~
요구사항
1. 기존의 농장 재고목록 어플리케이션에 리스트에서 녹색(green) 사과만 필터링하는 기능을 추가
사과 색을 정의하는 Color Enum Class가 존재
~~~

```
public enum Color {
RED,
GREEN
}
```

색을 가지는 Apple Class

```
@Data
@AllArgsConstructor
public class Apple {

    public Color color;
}
```

### 2.1  1번째 시도 - 녹색사과만을 필터링

```
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
```

- 오로지 녹색사과만을 필터링하는 코드입니다.
- 빨과 사과를 필터링하고 싶다는 요구사항이 추가되면, 또 다시 코드를 변경해야합니다.
- 변경에 유연하지 못한 코드

👉 초록, 빨강, 검정을 비교하는 코드 등등 "이렇게 비슷한 코드를 반복 존재하게 된다면 그 코드를 추상화할 수 있습니다."

### 2.2 두번째 시도 - 색을 파라미터화

- 색을 파라미터화하여, 메서드에 파라미터를 추가하면 색을 비교하는 요구사항에 대해 자유로워질 수 있습니다.

```
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
```

하지만 무게도 비교하고 싶다면?? 비슷한 비교코드를 새롭게 작성해주어야합니다.

이는 소프트웨어 공학의 DRY 원칙을 어기는 것이라고 합니다. (Don't Repeat Yourself - 같은 것을 반복하지 말 것)\

만약 이렇게 중복-중복- 작성된 비슷한 코드를 개선할려면 (리팩토링) 수 많은 코드를 반복 수정해야합니다. - 엔지니어링적 비싼 대가를 치룸

```
### 2.3 세번째 시도 - 가능한 모든 경우의 수를 필터링
- 요구사항을 미리 예측하여 모든 속성을 메서드 파라미터로 추가한 경우 입니다.
- 가장가장 안좋은 방법입니다.

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
```

➡️ 요기서, 파라미터를 추가하는 방법이 아닌 변화하는 요구사항에 좀 더 유연하게 대응할 수 있는 방법이 절실하다. (동작파라미터화..!!!)

### 2.4 네번째 시도 - 추상적 조건으로 필터링

- 파라미터를 추가하지 않고, 사과의 어떤 속성에 기초해서 불리언 값을 반환하는 방법

- 📌 참 또는 거짓을 반환하는 (Boolean 형식의 프리디케이트 를 이용하자!!

- Predicate 란, 선택 조건을 결정하는 인터페이스
- Boolean, 참 거짓을 반환한다.

💡 Boolean 메소드를 가지는 Predicate 인터페이스

```
public interface ApplePredicate {
boolean test(Apple apple);
}
```

```
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
```

프레디케이트 객체로 사과 검사 조건을 캡슐화했습니다.

이렇게 되면, 요구사항이 변경되더라도 -> ApplePredicate를 적절하게 구현하는 클래스만 만들면 됩니다!!! (요구사항 변경에 유연한 코드가 되었다!!!✨)

📌 우리가 전달한 ApplePredicate 객체에 의해 filterApples 메서드의 동작이 결정되는 구조입니다.

즉, 제서드의 동작을 파라미터화 한 것입니다.!!!

이러한 구조를 이용하여 메소드에 "코드를 전달" 할 수 있게되었습니다.

## 3. 동작 파라미터화의 장점

1) 이렇게 동작 파라미터화를 사용한다면, 각 항목에 적용할 동작을 분리함으로써, 각각의 조건에 대해 코드적으로 변경에 닫혀있고 확장에 유연한 코드가 되었습니다. (개방폐쇄 원칙)


2) 또한, 하나의 메소드가 다른 동작을 수행하도록 재활용할 수 있는 구조가 되었습니다.

## 4. 익명 클래스

익명클래스란, 이름 그대로 이름이 없는 클래스입니다.

자바의 지역클래스와 비슷한 개념으로,

익명 클래스를 이용하면 클래스 선언과 인스턴스화를 동시에 할 수 있습니다.

```
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
```

요롷게 메소드의 동작을 직접 파라미터화 하는 것이, 익명클래스입니다.

귀찮게 구현 클래스를 만들 필요는 없어졌지만, 너무나 지저분한 코드가 되었습니다.

익명클래스를 사용하게되어, 반복되어 지저분해진 코드를 깔끔하게 해결하기 위해 나온것이 바로!! 람다 표현식입니다.

## 5. 람다 표현식의 사용

```   
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
```

## 6. 리스트 형식으로 추상화

```
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
```

## 7. 정리

1. 동작 파라미터화에서는 메서드 내부적으로 다양한 동작을 수행할 수 있도록 코드를 메서드 인수로 전달합니다.
2. 동작 파라미터화를 이용하면 변화하는 요구사항에 더 잘 대응할 수 있는 코드를 구현할 수 있으며 나중에 유지보수에 많은 비용을 줄일 수 있습니다.
3. 코드 전달기법을 이용하면 동작을 메서드 인수로 전달할 수 있습니다.


