package com.demo.generics;

import java.util.Arrays;

public class IntegerServiceImp implements ArrayService<Integer> {
    @Override
    public void printArray(Integer[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }
}
