package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 9, 10, 5));
        int max = numbers.stream().filter(val -> (val % 3) == 0).max(Integer::compareTo).get();
        System.out.println(max);

        List<String> words = new ArrayList<>(Arrays.asList("Hello", "Hey,", " you", " you"));
        String word = words.stream().filter(str -> str.length() < 5).map(str -> str.toUpperCase()).distinct().reduce(
                (str, str2) -> str.concat(str2)).orElse((""));
        System.out.println(word);

        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("fjklmn");
        Stream<String> stream = trickyFilter(strings);
        strings.add("de");
        System.out.println(stream.reduce(String::concat).orElse(""));

        System.out.println(IntStream.generate(() -> 100).limit(100).filter(n -> n % 2 != 0).noneMatch(n -> n % 2 == 0));
        System.out.println(IntStream.iterate(0, n -> n + 1).limit(100).filter(n -> n % 2 != 0).noneMatch(n -> n % 2 == 0));
        System.out.println(IntStream.generate(() -> 100).limit(101).allMatch(val -> val >= 100));
        
    }

    public static Stream<String> trickyFilter(List<String> ourList) {
        return ourList.stream().filter(str -> str.length() < 5).
                map(str -> str.toUpperCase()).
                distinct();
    }

    public static IntStream toLengthsStream(Collection<String> strings) {
        return strings.
                stream().
                mapToInt(value -> value.length());
    }

}


