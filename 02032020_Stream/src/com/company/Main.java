package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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

        List<String> dictionary = Arrays.asList("first", "second", "third");
        String text = "My first task was to find second and third words in the text, but second word was missed";
        List<String> foundedWords = foundedWords(dictionary, text);
        System.out.println(foundedWords.toString());

        Censor censor = new Censor(dictionary);
        List<String> foundWords = censor.findBadWords(text);
        System.out.println(foundWords);

        IntStream stream01 = IntStream.rangeClosed(1, 50);
        IntStream stream02 = IntStream.rangeClosed(50, 100);
        Stream newStream = createStream(stream01, stream02);
        System.out.println(newStream.collect(Collectors.toList()));
        System.out.println(countSum(1,4));

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

    public static List<String> foundedWords(List<String> dictionary, String text) {
        String[] textAsList = text.split(" ");
        return Arrays.stream(textAsList).filter(word -> dictionary.contains(word)).distinct().sorted().collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(num -> num % number == 0);
    }

    public static long factorial(int number) {
        return LongStream.rangeClosed(1, number).reduce((currentResult, currentNumber) -> currentResult * currentNumber).orElse(0);
    }

    public static Stream createStream(IntStream first, IntStream second) {
        return IntStream.concat(first, second).filter(n -> n % 3 == 0 && n % 5 == 0).distinct().sorted().skip(2).boxed();
    }

    public static int countSum (int a, int b) {
        return IntStream.rangeClosed(a, b).sum();
    }

}


