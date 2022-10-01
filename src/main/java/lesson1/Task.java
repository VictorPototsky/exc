package lesson1;

import java.text.ParseException;

public class Task {
    private static String[][] firstArray = {
            {"4", "2", "6", "12"},
            {"11", "7", "5", "6"},
            {"9", "5", "3", "1"},
            {"10", "1", "1", "2"}};
    private static String[][] secondArray = {
            {"3", "2", "5", "6", "3"},
            {"1", "1", "1", "j5.5", "3"},
            {"5", "5", "2", "8", "3"},
            {"5", "5", "2", "8", "3"},
            {"11", "11", "11", "12", "3"}};
    private static String[][] thirdArray;

    private static int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static int[] arr2 = {3, 2, 1, 2, 3, 2, 1, 2, 3, 2};
    private static int[] arr3 = {1, 1, 1, 1};
    private static int[] arr4 = {3, 2, 1, 1, 0, 2, 2, 6, 2, 3};

    private static Exception e;


    public static void main(String[] args) {
        System.out.println("---Задача 1------------------------------------");
        divide(15, 3);
        System.out.println("---Задача 1------------------------------------");
        divide(10, 0);
        System.out.println("---Задача 1------------------------------------");
        // Массив с корректными данными firstArray
        test(firstArray);
        System.out.println("---Задача 1------------------------------------");
        // Массив secondArray с некорректным значением
        test(secondArray);
        System.out.println("---Задача 1------------------------------------");
        //Массив thirdArray - не заполнен
        test(thirdArray);

        int[] res1;
        System.out.println("---Задача 3------------------------------------");
        // На вход метода даем массивы одинаковой длины. Операция - вычитание
        res1 = t3(arr1, arr2);

        System.out.println("---Задача 3------------------------------------");
        // На вход метода даем массивы разной длины
        res1 = t3(arr1, arr3);

        System.out.println("---Задача 4------------------------------------");
        double[] res2;
        // На вход метода даем массивы одинаковой длины. Операция - деление
        res2 = t4(arr1, arr2);

        System.out.println("---Задача 4------------------------------------");
        // Во втором массиве есть 0-й элемент.
        res2 = t4(arr1, arr4);

        System.out.println("---Задача 4------------------------------------");
        // На вход метода даем массивы разной длины
         res2 = t4 (arr1, arr3);
         System.out.println("---------------------------------------");


    }

/*
    1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
*/

    private static void divide(int a, int b) {
        int result;
        try {
            System.out.println("Деление " + a + " на " + b);
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Исключение " + e);
            System.out.println("Поймали ошибку - 'Деление на ноль' \n");
            return;
        }
        System.out.println("Результат деления : " + result + "\n");
    }

    private static void test(String ar[][]) {
        String str = "";
        int res = 0;
        int rows;
        int columns;

        try {
            rows = ar.length;
            columns = ar[0].length;
            for (int i = 1; i < rows; i++) {
                if (ar[i].length > columns) {
                    columns = ar[i].length;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Исключение " + e);
            System.out.println("Массив строк не определен \n");
            return;
        }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                try {
                    res += Integer.parseInt(ar[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Исключение " + e);
                    System.out.println("Некорректные данные в ячейке [" + i + "][" + j + "]. Значение : " + ar[i][j] + "\n");
                    return;
                }
            }
        }
        System.out.println("Данные корректны. Сумма элементов массива : " + res + "\n");
    }

/*
    2.  Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
       public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)  {
        for (int j = 0; j < 5; j++) {
         int val = Integer.parseInt(arr[i][j]);
         sum += val;
       }
      }
        return sum;
       }
   Возможные исключения реализованы в методе test (см. выше)- это
   NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException

*/

    /*
       3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
       и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов
       в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
    */
    private static int[] t3(int[] arr1, int[] arr2) {
        int[] resArr = arr1;
        try {
            if (arr1.length != arr2.length) {
                throw new ArrayIndexOutOfBoundsException("Длины массивов не равны!");
            } else
                System.out.println("Новый массив :");
            for (int i = 0; i < arr1.length; i++) {
                resArr[i] -= arr2[i];
                System.out.print(resArr[i] + " ");
            }
            System.out.println("\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение : " + e);
            System.out.println("Задача создания нового массива не выполнена");
        }
        return resArr;
    }

    /*
       4. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
       и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов
       в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
       Важно: При выполнении метода единственное исключение, которое пользователь может увидеть -
       RuntimeException, т.е. ваше
     */
    private static double[] t4(int[] arr1, int[] arr2) {
        double[] resArr = new double[arr1.length];
        try {
            if (arr1.length != arr2.length) {
                throw new MyException("Длины массивов не равны!");
            }
            if (arr1.length == 0) {
                throw new MyException("Переданы пустые массивы");
            } else {
                for (int i = 0; i < arr1.length; i++) {
                    if (arr2[i] == 0) {
                        throw new MyException("Деление на ноль!");
                    } else {
                        resArr[i] = (double) arr1[i] / arr2[i];
                    }
                    System.out.println(resArr[i]+"  ");
                }
            }
        } catch (MyException e) {
            System.out.println("Исключение : " + e);
            System.out.println("Новый массив не создан");
        }
        return resArr;
    }
}