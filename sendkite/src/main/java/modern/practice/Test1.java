package modern.practice;

// Test 1
// 람다표현식으로 바꾸어 보세요
public class Test1 {
    public static void main(String[] args) {
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
        new Thread(runnable).start();
    }
}
