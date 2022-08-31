package modern.practice;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "mysql", false));

        System.out.println("spring 으로 시작하는 수업");
        // TODO

        System.out.println("closed 되지 않은 수업");
        // TODO

        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO

        List<OnlineClass> javaClasses = new ArrayList<>();

        javaClasses.add(new OnlineClass(6, "Java 8", true));
        javaClasses.add(new OnlineClass(7, "Java 11", true));
        javaClasses.add(new OnlineClass(8, "Java 17 test", false));

        List<List<OnlineClass>> allClass = new ArrayList<>();
        allClass.add(springClasses);
        allClass.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO

        System.out.println("10부터 1씩 증가하는 무한 스트림 중에서 앞에 10개");
        // TODO
        // 무제한 스트림 = Stream.iterate(10, i -> i + 1);

        System.out.println("springClass에서 spring 들어간 것만 모아서 List로 출력");
        // TODO

        System.out.println("javaClass에서 test 들어간 것 List로 출력");
        // TODO

    }

}
