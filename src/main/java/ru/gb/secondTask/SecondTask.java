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
