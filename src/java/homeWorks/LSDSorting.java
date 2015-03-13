package homeWorks;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zveriki on 13.03.2015.
 */
public class LSDSorting {

    public static void main(String[] args) {

        int[] array = generateRandomArray(1000000);
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);

        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        sortAsString(array);
        System.out.println("LSD time: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        Arrays.sort(copy);
        System.out.println("QuickSort time: " + (System.currentTimeMillis() - start));

//        int mask = 0b1;
//
//        for (int i = 0; i<32; i++) {
//            System.out.print(mask & 1000000 >>> 31-i);
//        }

    }

    private static int[] generateRandomArray(int max) {
        Random rnd = new Random();
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            array[i] = rnd.nextInt(max);
        }
        return array;
    }

    private static void sort(int[] a) {

        int n = a.length;
        int r = 2;
        int[] aux = new int[n];
        for (int d = 0; d < 20; d++) {

            int[] count = new int[r + 1];

            for (int i = 0; i < n; i++) {
                count[((0b1 & a[i] >>> d) + 1)]++;
            }

            for (int i = 0; i < i; i++) {
                count[i + 1] += count[i];
            }

            for (int i = 0; i < n; i++) {
                aux[count[(0b1 & a[i] >>> d)]++] = a[i];
            }

            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void sortAsString(int[] a) {

        int N = a.length;
        int R = 10;
        int[] aux = new int[N];
        for (int d = 1; d >= 0; d--) {

            int[] count = new int[R + 1];     // Compute frequency counts.

            for (int i = 0; i < N; i++) {
                String number = Integer.toString(a[i]);
                number = "000000".substring(0, 6 - number.length()) + number;
//                System.out.println(number);
                count[Character.getNumericValue(number.charAt(5 - d)) + 1]++;

            }
            for (int r = 0; r < R; r++)     // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = 0; i < N; i++) {     // Distribute.
                String number = Integer.toString(a[i]);
                number = "000000".substring(0, 6 - number.length()) + number;
                aux[count[Character.getNumericValue(number.charAt(5 - d))]++] = a[i];
            }
            for (int i = 0; i < N; i++)     // Copy back.
                a[i] = aux[i];
        }
    }

}
