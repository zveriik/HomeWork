package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zveriki on 04.03.2015.
 */
public class FlippingBit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int listSize = in.nextInt();
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i<listSize; i++){
            list.add(in.nextLong());
        }
        for (Long out:list){
            System.out.println(~out & 0xffffffffL);
        }
    }
}
