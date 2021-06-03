package com.homework.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramCreatorTest {

    private final AnagramCreator creater = new AnagramCreator();

    @Test
    void createAnagramShouldThrownIllegalArgumentExceptionIfSentenceContanisNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            creater.createAnagram(" ");
        });

        assertEquals("Input string is empty or contains only tabulation symbols!", thrown.getMessage());
    }

    @Test
    void createAnagramShouldThrownIllegalArgumentExceptionIfSentenceContanisOnlyWhiteSpace() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            creater.createAnagram(null);
        });

        assertEquals("Input string is null!", thrown.getMessage());
    }

    @Test
    void createAnagramShouldReturnOnlySymbol() {
        final String actual = creater.createAnagram("!)(*&)&&^%");
        final String expected = "!)(*&)&&^%";

        assertEquals(expected, actual);
    }

    @Test
    void createAnagramShouldReturnOnlyNumber() {
        final String actual = creater.createAnagram("1209841");
        final String expected = "1209841";

        assertEquals(expected, actual);
    }

    @Test
    void createAnagramShouldReturnChangeLetterNotChangeNumber() {
        final String actual = creater.createAnagram("09jhg7fas");
        final String expected = "09saf7ghj";

        assertEquals(expected, actual);
    }

    @Test
    void createAnagramShouldReturnChangeWord() {
        final String actual = creater.createAnagram("jhgfas");
        final String expected = "safghj";

        assertEquals(expected, actual);
    }

    @Test
    void createAnagramShouldReturnChangeSeveralWordsWithLetter() {
        final String actual = creater.createAnagram("lakjdf poieuw lgsdj");
        final String expected = "fdjkal wueiop jdsgl";

        assertEquals(expected, actual);
    }

    @Test
    void createAnagramShouldReturnChangeSeveralWordsWithLetterAndNumber() {
        final String actual = creater.createAnagram("lakj3df po34uw lg3j");
        final String expected = "fdjk3al wu34op jg3l";

        assertEquals(expected, actual);
    }

    @Test
    void createAnagramShouldReturnChangeSeveralWordsWithLetterAndNotChangeNumberAndSymbol() {
        final String actual = creater.createAnagram("la!!kj3df po34$#uw lg3$*j");
        final String expected = "fd!!jk3al wu34$#op jg3$*l";

        assertEquals(expected, actual);
    }
}
