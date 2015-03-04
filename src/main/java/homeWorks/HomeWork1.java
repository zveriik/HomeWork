package homeWorks;

import java.util.Scanner;

public class HomeWork1 {

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        System.out.println("Загадайте число от 1 до 100");
        findNumber(in, initArray(), 0, 99);



    }

    private static int[] initArray(){
        int[] initArray = new int[100];
        for (int i = 0; i<initArray.length; i++){
            initArray[i] = i;
        }
        return initArray;
    }

    private static int findNumber(Scanner in, int [] array, int first, int last){

        int answear = array[last/2+first];
        System.out.println(answear);
        String str = in.nextLine();
        if (str.equals("+")){
            findNumber(in, array, answear+1, last);
        } else {
            findNumber(in, array, first, answear-1);
        }
        return answear;
    }
}
