package ru.gb.firstTask;
import java.util.TreeMap;

public class FirstTask {

    public int[] countingSort(int[] array){
        TreeMap<String, Integer> minMax = getMaxMinValue(array);
        int min = minMax.get("min");
        int max = minMax.get("max");
        int[] result = new int[array.length];
        int[] buffArray = getBuffArray(array, max, min);
        int index = 0;
        for (int k : buffArray) {
            if (k != 0) {
                for (int j = 0; j < k; j++) {
                    result[index] = min;
                    index++;
                }
            }
            min++;
        }
        return result;
    }

    private int[] getBuffArray(int[] arr, int max, int min){
        int zeroPosition = 0;
        if(min < 0) {
            min = min * -1;
            zeroPosition = min;
        }
        int[] buffArray = new int[min + max + 1];
        for (int j : arr) {
            int position = zeroPosition + j;
            buffArray[position]++;
        }
        return  buffArray;
    }

    private TreeMap<String, Integer> getMaxMinValue(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        TreeMap<String, Integer> minMaxValue = new TreeMap<String, Integer>();
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        minMaxValue.put("min", min);
        minMaxValue.put("max", max);
        return minMaxValue;
    }



}


