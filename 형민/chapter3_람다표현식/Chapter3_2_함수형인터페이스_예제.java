package chapter3_람다표현식;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.NoArgsConstructor;

public class Chapter3_2_함수형인터페이스_예제 {

    //람다 이용
    Runnable r1 = () -> System.out.println("람다를 이용해서 메소드를 바로 직접 구현");

    //익명클래스 이용
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("익명 클래스를 이용해서 직접 구현한 케이스");
        }
    };

    //함수형 인터페이스는 파라미터로 전달 가능
    public void process(Runnable r3) {
        r3.run();
    }

    //predicate


}
