package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {

        int left = leftBorder > rightBorder ? rightBorder : leftBorder;
        int right = leftBorder <= rightBorder ? rightBorder : leftBorder;
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (i % 2 == 0) {
               result+= i;
            }
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int left = leftBorder > rightBorder ? rightBorder : leftBorder;
        int right = leftBorder <= rightBorder ? rightBorder : leftBorder;
        int result = 0;
        for (int i = left; i <= right; i++) {
            if (i % 2 != 0) {
                result+= i;
            }
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0, (result, item) -> result + (item * 3 + 2));
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(item -> {
            if (item % 2 != 0) {
                return item * 3 + 2;
            }
            return item;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 != 0)
                .map(item -> item * 3 + 5)
                .reduce(0, (result, item) ->result + item);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List list = arrayList.stream()
                .filter(item -> item % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        int count = list.size();
        if (count % 2 == 0) {
            int right = (int) list.get(count / 2);
            int left = (int) list.get(count / 2 - 1);
            return (right + left) / 2;
        }
        return (double) list.get(count / 2);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        long count = arrayList.stream().filter(item -> item % 2 == 0).count();
        return arrayList.stream()
                .filter(item -> item % 2 == 0)
                .reduce(0, (result, item) -> result + item) / count;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(item -> item % 2 == 0)
                .collect(Collectors.toList())
                .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(item -> item % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List even = arrayList.stream().filter(item -> item % 2 == 0).sorted().collect(Collectors.toList());
        List odd = arrayList.stream().filter(item -> item % 2 != 0).sorted().collect(Collectors.toList());
        Collections.reverse(odd);
        even.addAll(odd);
        return even;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            result.add((arrayList.get(i - 1) + arrayList.get(i)) * 3);
        }
        return result;
    }
}
