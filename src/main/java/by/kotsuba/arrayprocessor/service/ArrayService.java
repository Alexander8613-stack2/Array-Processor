package by.kotsuba.arrayprocessor.service;

import by.kotsuba.arrayprocessor.entity.IntArray;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {
    OptionalInt findMin(IntArray array);
    OptionalInt findMax(IntArray array);
    int sum(IntArray array);
    OptionalDouble average(IntArray array);
    void bubbleSort(IntArray array);
    void insertionSort(IntArray array);
}
