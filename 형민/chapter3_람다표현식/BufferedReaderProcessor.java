package chapter3_람다표현식;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 함수형 인터페이스는 단 1개의 추상 메서드를 가짐
 *
 * @FuntionalInterface 는 명시적으로 함수형 인터페이스임을 가르킴 -> 함수형 인터페이스가 아니면 컴파일 에러
 */

@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
