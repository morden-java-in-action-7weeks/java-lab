package practice;

import java.util.Arrays;

// Test 1
// 람다표현식으로 바꾸어 보세요
public class Test1 {
    public static void main(String[] args) {
        Runnable runnable = getRunnable_origin();
        Runnable runnable2 = getRunnable_lambda();
        new Thread(runnable).start();
    }

    private static Runnable getRunnable_origin() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String hello = "Modern Java in Action";
                String[] parts = hello.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        return runnable;
    }

    private static Runnable getRunnable_lambda() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String hello = "Modern Java in Action";
                String[] parts = hello.split(" ");
                Arrays.stream(parts).forEach(System.out::println);
            }
        };
        return runnable;
    }
}
