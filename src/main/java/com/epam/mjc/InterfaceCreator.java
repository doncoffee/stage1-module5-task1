package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String str : list) {
                char c = str.toCharArray()[0];
                if (!Character.isUpperCase(c)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            ArrayList<Integer> integers = new ArrayList<>();
            for (Integer ints : list) {
                if (ints % 2 == 0) {
                    integers.add(ints);
                }
            }
            list.addAll(integers);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String strings : values) {
                char firstLetter = strings.toCharArray()[0];
                String[] arr = strings.split("\\s+");
                if (Character.isUpperCase(firstLetter)
                        && arr.length > 3
                        && strings.endsWith(".")) {
                    result.add(strings);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for (String strings : list) {
                map.put(strings, strings.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
