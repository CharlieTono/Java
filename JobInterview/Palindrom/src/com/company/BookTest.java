package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testIsBookContainRecursive_Equals_true() {
        List<String> dictionary = new ArrayList<>();
        String word01 = "who";
        String word02 = "are";
        String word03 = "you";
        dictionary.add(word01);
        dictionary.add(word02);
        dictionary.add(word03);
        Book ourBook = new Book(dictionary);
        String text = "whoareyou";
        assertTrue(ourBook.isBookContain(text));
    }

    @Test
    public void testIsBookContainRecursive_NonEquals_false() {
        List<String> dictionary = new ArrayList<>();
        String word01 = "who";
        String word02 = "are";
        String word03 = "you";
        dictionary.add(word01);
        dictionary.add(word02);
        dictionary.add(word03);
        Book ourBook = new Book(dictionary);
        String text = "whoaredyou";
        assertFalse(ourBook.isBookContain(text));
    }

    @Test
    public void testIsBookContainRecursive_EqualsWithSameWord_true() {
        List<String> dictionary = new ArrayList<>();
        String word01 = "mu";
        dictionary.add(word01);
        Book ourBook = new Book(dictionary);
        String text = "mumu";
        assertTrue(ourBook.isBookContain(text));
    }

    @Test
    public void testIsBookContainRecursive_NonEqualsWithSameWord_false() {
        List<String> dictionary = new ArrayList<>();
        String word01 = "mu";
        String word02 = "mu";
        dictionary.add(word01);
        dictionary.add(word02);
        Book ourBook = new Book(dictionary);
        String text = "mumum";
        assertFalse(ourBook.isBookContain(text));
    }

    @Test
    public void testIsBookContainRecursive_EqualsWithDifferentWords_true() {
        List<String> dictionary = new ArrayList<>();
        String word01 = "mu";
        String word02 = "tex";
        String word03 = "call";
        dictionary.add(word01);
        dictionary.add(word02);
        dictionary.add(word03);
        Book ourBook = new Book(dictionary);
        String text = "texcall";
        assertTrue(ourBook.isBookContain(text));
    }

    @Test
    public void testIsBookContainRecursive_NonEqualsWithDifferentWords_false() {
        List<String> dictionary = new ArrayList<>();
        String word01 = "mu";
        String word02 = "tex";
        dictionary.add(word01);
        dictionary.add(word02);
        Book ourBook = new Book(dictionary);
        String text = "mucall";
        assertFalse(ourBook.isBookContain(text));
    }
}