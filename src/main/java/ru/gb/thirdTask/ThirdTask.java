package ru.gb.thirdTask;

import java.util.Arrays;

public class ThirdTask {
    public int[] arrayShift(int[] array, int k){
        int[] newArray =  new int[array.length];
        int shift = k;
        if (k > array.length){
            shift = k - ( k/array.length ) * array.length;
        }
        System.arraycopy(array,0,newArray,shift,newArray.length-shift);
        System.arraycopy(array,newArray.length-shift,newArray,0,shift);
        return newArray;
    }
}
