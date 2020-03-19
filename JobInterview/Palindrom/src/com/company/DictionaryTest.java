package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void testIsBookContainRecursive_NonEquals_false() {

        Set<String> dictionary = new HashSet<>(Arrays.asList("mu", "tex", "call"));
        Dictionary ourDictionary = new Dictionary(dictionary);
        String text01 = "mutexmum";
        String text02 = "texm";
        String text03 = "mutexmut";
        assertNull(ourDictionary.split(text01));
        assertNull(ourDictionary.split(text02));
        assertNull(ourDictionary.split(text03));
    }

    @Test
    public void testIsBookContainRecursive_Equals_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("who", "are", "you"));
        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "whoareyou";
        Deque<String> expected = new ArrayDeque<>(Arrays.asList("who", "are", "you"));
        Deque<String> result = new ArrayDeque<>(ourDictionary.split(text));
        assertArrayEquals(expected.toArray(), result.toArray());
    }


    @Test
    public void testIsBookContainRecursive_EqualsWithSameWord_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("mu"));
        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "mumu";
        Deque<String> expected = new ArrayDeque<>(Arrays.asList("mu", "mu"));
        Deque<String> result = new ArrayDeque<>(ourDictionary.split(text));
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testIsBookContainRecursive_EqualsWithDifferentWords_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("mu", "tex", "call"));
        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "mutex";
        Deque<String> expected = new ArrayDeque<>(Arrays.asList("mu", "tex"));
        Deque<String> result = new ArrayDeque<>(ourDictionary.split(text));
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testIsBookContainRecursive_EqualsWithDifferentAndSameWords_true() {
        Set<String> dictionary = new HashSet<>(Arrays.asList("mu", "tex", "call"));
        Dictionary ourDictionary = new Dictionary(dictionary);
        String text = "calltexcall";
        Deque<String> expected = new ArrayDeque<>(Arrays.asList("call", "tex", "call"));
        Deque<String> result = new ArrayDeque<>(ourDictionary.split(text));
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}