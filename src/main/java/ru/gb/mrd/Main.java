package ru.gb.mrd;
import ru.gb.firstTask.FirstTask;
import ru.gb.secondTask.SecondTask;
import ru.gb.thirdTask.ThirdTask;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;



public class Main {
    public static void main(String[] args) {

        //----------------FirstTask-----------------

        FirstTask firstTask = new FirstTask();
        Random random = new Random();
        int arraySize = 20;
        int[] array = new int[arraySize];
        IntStream.range(0, arraySize).forEach(index -> array[index] = random.nextInt(-20, 20));
        System.out.println("Исходный массив " + Arrays.toString(array));
        System.out.println("Отсортированный массив " + Arrays.toString(firstTask.countingSort(array)));

        //----------------SecondTask-----------------

        SecondTask secondTask = new SecondTask();
        System.out.println(secondTask.caesarCode("Hello World!",2, false));
        System.out.println(secondTask.caesarCode("Fcjjm\u001EUmpjb\u001F",2, true));


        //----------------ThirdTask-----------------

        ThirdTask thirdTask = new ThirdTask();
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(thirdTask.arrayShift(arr, 4)));
        System.out.println(Arrays.toString(thirdTask.arrayShift(arr, 10)));

    }
}