package com.homework.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        System.out.println("Input line!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        AnagramCreator anagram = new AnagramCreator();
        System.out.println(anagram.createAnagram(line));
    }
}   
