package homeWorks;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zveriki on 13.03.2015.
 */
public class LSDSorting {

    public static void main(String[] args) {

        int[] array = generateRandomArray(1000000);
        int[][] arrays = new int[6][];
        for (int i = 0; i < 6; i++) {
            arrays[i] = array.clone();
        }

        long start = System.nanoTime();
        Arrays.sort(arrays[0]);
        System.out.println("QuickSort time: " + ((double) (System.nanoTime() - start)) / 1000000000d + " сек");

        System.out.println("Some analysis of the sort of word width...");
        for (int i = 1; i < 6; i++) {
            start = System.nanoTime();
//            System.out.println(Arrays.toString(arrays[i]));
            sortLSD(arrays[i], 32, 1 << i - 1);
//            System.out.println(Arrays.toString(arrays[i])); for checking sorting
            System.out.println("LSD time for width " + (1 << i - 1) + ", time: " + ((double) (System.nanoTime() - start)) / 1000000000d + " сек");
        }
    }

    private static int[] generateRandomArray(int max) {
        Random rnd = new Random();
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            array[i] = rnd.nextInt(max);
        }
        return array;
    }

    /**
     * Add parameters total and step for analyze dependence on time from the width of sorting word
     *
     * @param a     - sorting array
     * @param total - size of each element in array's cell
     * @param step  - width of sorting word
     */
    private static void sortLSD(int[] a, int total, int step) {

        int size = a.length;
        int iteration = 1 << step;
        int mask = (1 << step) - 1;
        int[] aux = new int[size];

        for (int d = 0; d < total /step; d++) {

            int[] count = new int[iteration + 1];

            for (int i = 0; i < size; i++) {

                count[(mask & (a[i] >> step * d)) + 1]++;
            }

            for (int i = 0; i < iteration; i++) {
                count[i + 1] += count[i];
            }

            for (int i = 0; i < size; i++) {
                aux[count[mask & (a[i] >> step * d)]++] = a[i];
            }

            for (int i = 0; i < size; i++) {
                a[i] = aux[i];
            }
        }
    }

    //some experiment -- too slow
    public static void sortAsString(int[] a) {

        int len = a.length;
        int iteration = 10;
        int[] aux = new int[len];
        for (int d = 1; d >= 0; d--) {

            int[] count = new int[iteration + 1];

            for (int i = 0; i < len; i++) {
                String number = Integer.toString(a[i]);
                number = "000000".substring(0, 6 - number.length()) + number;
                count[Character.getNumericValue(number.charAt(5 - d)) + 1]++;
            }
            for (int r = 0; r < iteration; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < len; i++) {
                String number = Integer.toString(a[i]);
                number = "000000".substring(0, 6 - number.length()) + number;
                aux[count[Character.getNumericValue(number.charAt(5 - d))]++] = a[i];
            }
            for (int i = 0; i < len; i++)
                a[i] = aux[i];
        }
    }

}
