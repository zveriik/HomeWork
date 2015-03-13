package homeWorks;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zveriki on 13.03.2015.
 */
public class LSDSorting {

    public static void main(String[] args) {

        int[] array = generateRandomArray(1000000);
        int[] copy1 = array.clone();
        int[] copy2 = array.clone();

        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        sortLSD(copy1);
        System.out.println("LSD time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Arrays.sort(copy2);
        System.out.println("QuickSort time: " + (System.currentTimeMillis() - start));

    }

    private static int[] generateRandomArray(int max) {
        Random rnd = new Random();
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            array[i] = rnd.nextInt(max);
        }
        return array;
    }

    //iteration int by bit too slow, by byte optimal
    private static void sortLSD(int[] a) {

        int len = a.length;
        int iteration = 256;
        int[] aux = new int[len];
        for (int d = 0; d < 4; d++) {

            int[] count = new int[iteration + 1];

            for (int i = 0; i < len; i++) {
                count[((0b11111111 & a[i] >>> d) + 1)]++;
            }

            for (int i = 0; i < i; i++) {
                count[i + 1] += count[i];
            }

            for (int i = 0; i < len; i++) {
                aux[count[(0b11111111 & a[i] >>> d)]++] = a[i];
            }

            for (int i = 0; i < len; i++) {
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
