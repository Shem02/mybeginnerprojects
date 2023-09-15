import java.util.Scanner;

class Solution{
    static void findLargest(int N, int S){
        int num;
        // code here
        return ;
    }

    public static void main (String[] arg) {


        System.out.println ("Enter a number: ");
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int largest = 0;
        for(int i = 0; i < num; i++) {
            num = in.nextInt();

            if (num > largest) {
                largest = num;
            }
        }
        System.out.println("the largest number is: "+ largest);
    }

}