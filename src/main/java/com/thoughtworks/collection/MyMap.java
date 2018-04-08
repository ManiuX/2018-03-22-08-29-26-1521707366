package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(item -> item * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream().map(item -> letterList.get(item - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return this.array.stream().map(item -> {
            int a = item / 26;
            int b = item % 26;
            if (a == 0 && b == 0) {
                return null;
            }
            if (a == 0) {
                return letterList.get(b - 1);
            } else if (b == 0) {
                return letterList.get(a - 2) + "z";
            } else {
                return letterList.get(a - 1) + letterList.get(b - 1);
            }
        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        List result = this.array.stream().sorted().collect(Collectors.toList());
        Collections.reverse(result);
        return result;
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream().sorted().collect(Collectors.toList());
    }
}
