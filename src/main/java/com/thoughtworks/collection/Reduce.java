package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        List result = this.arrayList.stream().sorted().collect(Collectors.toList());
        Collections.reverse(result);
        return (int) result.get(0);
    }

    public double getMinimum() {
        return this.arrayList.stream().sorted().findFirst().get();
    }

    public double getAverage() {
        DecimalFormat df = new DecimalFormat("0.00");
        double result = this.arrayList.stream().reduce(0, (sum, item) -> sum + item);
        return Double.parseDouble(df.format(result / arrayList.size()));
    }

    public double getOrderedMedian() {
        int count = this.arrayList.size();
        int index = count / 2;
        if (count % 2 == 0) {
            return ((double) (arrayList.get(index) + arrayList.get(index - 1))) / 2.0;
        } else {
            return arrayList.get(index);
        }
    }

    public int getFirstEven() {
        return this.arrayList.stream().filter(item -> item % 2 == 0).findFirst().get();

    }

    public int getIndexOfFirstEven() {
        return IntStream.range(0, arrayList.size()).map(index -> {
            if (arrayList.get(index) % 2 == 0) {
                return index;
            }
            return -1;
        }).filter(item -> item != -1).boxed().collect(Collectors.toList()).get(0);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        for (int i = 0; i < arrayList.size(); i++) {
            singleLink.addTailPointer(arrayList.get(i));
        }
        int index = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            double a = Double.parseDouble(singleLink.getNode(index).toString());
            double b = Double.parseDouble(singleLink.getNode(index + 1).toString());
            return (a + b) / 2.0;
        } else {
            return Double.parseDouble(singleLink.getNode(index + 1).toString());
        }
    }

    public int getLastOdd() {
        List result = this.arrayList.stream().filter(item -> item % 2 != 0).collect(Collectors.toList());
        return Integer.parseInt(result.get(result.size() - 1).toString());
    }

    public int getIndexOfLastOdd() {
        List list = IntStream.range(0, arrayList.size()).map(index -> {
            if (arrayList.get(index) % 2 != 0) {
                return index;
            }
            return -1;
        }).filter(item -> item != -1).boxed().collect(Collectors.toList());
        return Integer.parseInt(list.get(list.size() - 1).toString());
    }
}
