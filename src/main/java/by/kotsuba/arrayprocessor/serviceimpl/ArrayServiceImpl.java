package by.kotsuba.arrayprocessor.serviceimpl;

import by.kotsuba.arrayprocessor.entity.IntArray;
import by.kotsuba.arrayprocessor.service.ArrayService;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServiceImpl implements ArrayService {
    @Override
    public OptionalInt findMin(IntArray array) {
        int[] values = array.getValues();
        if(values.length == 0){
            return OptionalInt.empty();
        }
        int min = values[0];

        for(int i = 1;i<values.length;i++){
            if(values[i]< min){
                min = values[i];
            }
        }

        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMax(IntArray array) {
        int[] values = array.getValues();
        if(values.length == 0 ){
            return OptionalInt.empty();
        }
        int max = values[0];
        for(int i = 1;i<values.length;i++){
            if(values[i]>max){
                max = values[i];
            }
        }
        return OptionalInt.of(max);
    }

    @Override
    public int sum(IntArray array) {
       int[] values = array.getValues();
       int sum = 0;
       for(int i : values){
           sum+=i;
       }
       return sum;
    }

    @Override
    public OptionalDouble average(IntArray array) {
        int[] values = array.getValues();

        if(values.length == 0) {
            return OptionalDouble.empty();
        }
        int sum = sum(array);

        double average =(double)sum/values.length;
        return OptionalDouble.of(average);
    }

    @Override
    public void bubbleSort(IntArray array) {
        int[] values = array.getValues();
        for(int i = 0;i<values.length-1;i++){
            for(int j = 0;j<values.length-1-i;j++){
                if(values[j]>values[j+1]){
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }
    }

    @Override
    public void insertionSort(IntArray array) {
        int[] values = array.getValues();
        for(int i = 1;i<values.length;i++){
            int current = values[i];
            int j = i-1;
            while(j>=0 && values[j] > current){
                values[j+1] = values[j];
                j--;
            }
            values[j+1] = current;
        }
    }
}
