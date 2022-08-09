package modern.util.predicator;

import modern.domain.Apple;
import modern.domain.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
