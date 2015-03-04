package homeWorks;

import java.util.Scanner;

public class HomeWork1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Загадайте число от 1 до 100");
        int a = findNumberWithoutfor(in, initArray(), 0, 99);
        System.out.print("Ваше число: " + a);
    }

    private static int[] initArray(){
        int[] initArray = new int[100];
        for (int i = 0; i<initArray.length; i++){
            initArray[i] = i;
        }
        return initArray;
    }

    private static int findNumberWithoutfor(Scanner in, int[] array, int first, int last){
        int pivot = first + (last - first)/2;
        int check = array[pivot];
        System.out.println(check);
        System.out.println("Больше [+], меньше [-], угадал [=]");
        String str = in.nextLine();
        if (str.equals("=")){
            return check;
        } else if (str.equals("+")){
            return findNumberWithoutfor(in, array, pivot + 1, last);
        } else {
            return findNumberWithoutfor(in, array, first, pivot);
        }
    }
}
