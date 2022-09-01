package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
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

        //todo 1
        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
            .filter(onlineClass -> onlineClass.getTitle().split(" ")[0].equals("spring"))
            .forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

        //todo 2
        System.out.println("closed 되지 않은 수업");
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
            .forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

        //todo 3
        System.out.println("수업 이름만 모아서 스트림 만들기");
        Stream<String> result = springClasses.stream().map(OnlineClass::getTitle);

        List<OnlineClass> javaClasses = new ArrayList<>();

        javaClasses.add(new OnlineClass(6, "Java 8", true));
        javaClasses.add(new OnlineClass(7, "Java 11", true));
        javaClasses.add(new OnlineClass(8, "Java 17 test", false));

        List<List<OnlineClass>> allClass = new ArrayList<>();
        allClass.add(springClasses);
        allClass.add(javaClasses);

        //todo 4
        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        allClass.forEach(onlineClasses ->
            onlineClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println)
        );

        //TODO 5
        System.out.println("10부터 1씩 증가하는 무한 스트림 중에서 앞에 10개");
        // 무제한 스트림 = Stream.iterate(10, i -> i + 1);
        Stream.iterate(10, i -> i + 1).limit(10).forEach(System.out::println);

        //todo 6
        System.out.println("springClass에서 spring 들어간 것만 모아서 List로 출력");
        springClasses.stream()
            .filter(onlineClass -> onlineClass.getTitle().contains("spring"))
            .collect(Collectors.toList())
            .forEach(onlineClass -> System.out.println(onlineClass.getTitle()));

        //todo 7
        System.out.println("javaClass에서 test 들어간 것 List로 출력");
        System.out.println(javaClasses.stream()
            .filter(onlineClass -> onlineClass.getTitle().contains("test"))
            .collect(Collectors.toList()));
    }
}
