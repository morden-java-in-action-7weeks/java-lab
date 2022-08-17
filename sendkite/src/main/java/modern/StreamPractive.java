package modern;

import modern.domain.Dish;
import modern.domain.type.Type;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractive {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 400, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH)
        );

        // 자바 7에서 컬렉션을 사용하는 방법 (반복자 사용과 외부반복)
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish: menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        System.out.println("저칼로리 음식 = " + lowCaloricDishes);

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });
        System.out.println("저칼로리 음식 정렬= " + lowCaloricDishes);


        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish: lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        System.out.println("칼로리 폭단 음식 이름 = " + lowCaloricDishesName);


        // 자바 8에서 컬렉션을 다루는 방법 (내부반복)
        List<String> lowCaloricDishesName2 = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("스트림 쓴 저칼로리 음식 = " + lowCaloricDishesName2);

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("탑 3 고칼로리 음식 = " + threeHighCaloricDishNames);


    }
}
