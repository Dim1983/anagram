package com.homework.anagram;

public class AnagramCreator {

    private static final String SPACE = " ";

    public String createAnagram(String sentence) {
        validateInputDate(sentence);
        final String[] words = sentence.split(SPACE);
        final String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }

        return String.join(SPACE, reversedWords);
    }

    private void validateInputDate(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Input string is null!");
        }
        if (sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string is empty or contains only tabulation symbols!");
        }
    }

    private String reverseWord(String word) {

        char[] reverseChars = word.toCharArray();
        int countLeft = 0;
        int countRight = reverseChars.length - 1;

        while (countLeft < countRight) {
            if (!Character.isLetter(reverseChars[countLeft])) {
                countLeft++;
            } else if (!Character.isLetter(reverseChars[countRight])) {
                countRight--;
            } else {
                char buffSymbol = reverseChars[countLeft];
                reverseChars[countLeft] = reverseChars[countRight];
                reverseChars[countRight] = buffSymbol;
                countLeft++;
                countRight--;
            }
        }

        return String.valueOf(reverseChars);
    }
}
