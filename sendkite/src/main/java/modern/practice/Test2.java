package modern.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "mysql", false));

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(it -> it.getTitle().startsWith("spring"))
                        .forEach(System.out::println);
        System.out.println("======");

        System.out.println("closed 되지 않은 수업");
        // Predicate.not()
        springClasses.stream()
                .filter(it -> !it.isClosed())
                .forEach(System.out::println);
        System.out.println("======");

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);
        System.out.println("======");


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "Java 8", true));
        javaClasses.add(new OnlineClass(7, "Java 11", true));
        javaClasses.add(new OnlineClass(8, "Java 17 test", false));

        List<List<OnlineClass>> allClass = new ArrayList<>();
        allClass.add(springClasses);
        allClass.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        List<Integer> result = allClass.stream()
                .flatMap(Collection::stream)
                .map(OnlineClass::getId)
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("10부터 1씩 증가하는 무한 스트림 중에서 앞에 10개");
        List<Integer> collect = Stream.iterate(10, i -> i + 1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(collect.size());

        System.out.println("springClass에서 spring 들어간 것만 모아서 List로 출력");
        List<String> spring = springClasses.stream()
                .filter(it -> it.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);


        System.out.println("javaClass에서 test 들어간 것 List로 출력");
        List<String> javaWithTest = javaClasses.stream()
                .filter(it -> it.getTitle().contains("test"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        javaWithTest.forEach(System.out::println);
    }
}
