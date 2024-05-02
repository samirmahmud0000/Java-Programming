package class2;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] myArray = new int[5];
        System.out.println(myArray.length);

        for (int i = 0; i < 5; i++) {
            myArray[i] = i + 1;
        }

        System.out.println(Arrays.toString(myArray));

        //Array Initializer

        int[] oneDArray = {1, 32, 33, 5, 7, 8}; //OK
//        oneDArray = {2,3,45,6};//error - because initializer can only be used while declaring
        oneDArray = new int[]{2, 3, 45, 6}; //works fine

        System.out.println(Arrays.toString(oneDArray));
        System.out.println(oneDArray.length);


        int[][] twoDArray = new int[3][];
//        System.out.println(twoDArray.length);
        twoDArray[0] = new int[]{2,3,4,5};
        twoDArray[1] = new int[2];
        twoDArray[2] = new int[]{1,2,3};


        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
