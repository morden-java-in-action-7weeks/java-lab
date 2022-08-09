package modern.util.formatter;

import modern.domain.Apple;

public class ApplePrintFormatter implements AppleFormatter{

    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple" ;
    }
}
