package homeWorks;

import java.util.Scanner;

public class HomeWork1 {

    static int count = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Загадайте число от 1 до 100");
        count = 0;
        int a = findNumberWithoutFor(in, initArray(), 0, 99);
        System.out.print("Ваше число: " + a + ", попыток: " + count);
    }

    private static int[] initArray() {
        int[] initArray = new int[100];
        for (int i = 0; i < initArray.length; i++) {
            initArray[i] = i;
        }
        return initArray;
    }

    private static int findNumberWithoutFor(Scanner in, int[] array, int first, int last) {
        int pivot = first + (last - first) / 2;
        int check = array[pivot] + 1;
        System.out.println(check);
        System.out.println("Больше [+], меньше [-], угадал [=]");
        String str = in.nextLine();
        count++;
        if (str.equals("=")) {
            return check;
        } else if (str.equals("+")) {
            return findNumberWithoutFor(in, array, pivot + 1, last);
        } else {
            return findNumberWithoutFor(in, array, first, pivot);
        }
    }
}
