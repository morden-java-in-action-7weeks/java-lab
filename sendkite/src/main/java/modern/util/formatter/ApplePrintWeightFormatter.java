package modern.util.formatter;

import modern.domain.Apple;

public class ApplePrintWeightFormatter implements AppleFormatter{

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
