# Данные и функции
## Задание 1.
Доделать сортировку подсчетом с урока (если нет, реализовать) классическим способом через промежуточный массив (см. последние минут 10 семинара)

Class FirstTask
```java
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
```
Class Main
```java

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


    }
}
```
![task1](https://github.com/MaksimZ91/JavaCoreLseeon2/assets/72209139/39d4a236-1c6a-4a79-89e1-145127385dbe)

## Задание 2.
Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифро- вания и числовым ключом;
Class SecondTask
```java
package ru.gb.secondTask;

public class SecondTask {
    public  String caesarCode(String text, int key, boolean encrypt) {
        char[] result = new char[text.length()];
         for (int i = 0; i < text.length(); ++i) {
             if (encrypt) {
                 result[i] = (char)(text.charAt(i) + key);
             } else {
                 result[i] = (char)(text.charAt(i) - key);
             }
         }
         return new String(result);
    }
}
```
Class Main
```java
import ru.gb.secondTask.SecondTask;
import ru.gb.thirdTask.ThirdTask;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;



public class Main {
    public static void main(String[] args) {

        //----------------SecondTask-----------------

        SecondTask secondTask = new SecondTask();
        System.out.println(secondTask.caesarCode("Hello World!",2, false));
        System.out.println(secondTask.caesarCode("Fcjjm\u001EUmpjb\u001F",2, true));

    }
}
```
![task2](https://github.com/MaksimZ91/JavaCoreLseeon2/assets/72209139/9917919a-a270-4bf1-a0e3-482c1804a14c)

## Задание 3.
Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический (последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций;

Class ThirdTask
```java
package ru.gb.thirdTask;

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
```
Class Main
```java
package ru.gb.mrd;
import ru.gb.firstTask.FirstTask;
import ru.gb.secondTask.SecondTask;
import ru.gb.thirdTask.ThirdTask;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;



public class Main {
    public static void main(String[] args) {

        //----------------ThirdTask-----------------

        ThirdTask thirdTask = new ThirdTask();
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(thirdTask.arrayShift(arr, 4)));
        System.out.println(Arrays.toString(thirdTask.arrayShift(arr, 10)));

    }
}
```
![task3](https://github.com/MaksimZ91/JavaCoreLseeon2/assets/72209139/1f5ce64f-63a8-457e-9e8c-59c3dce1e1af)









