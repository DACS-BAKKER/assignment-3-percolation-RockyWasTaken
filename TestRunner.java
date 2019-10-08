import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestRunner {

    public static int firstValue = 0;
    public static int secondValue = 0;
    public static int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args){
        quickFindTest();
        //quickUnionTest();
    }

    public static void quickFindTest(){
        QuickFind find = new QuickFind(arr);
        while(true){
            StdOut.println("Enter value 1");
            firstValue = StdIn.readInt();
            StdOut.println("Enter value 2");
            secondValue = StdIn.readInt();
            find.union(firstValue, secondValue);
            for(int i = 0; i < arr.length; i++){
                StdOut.print(arr[i] + " ");
            }
            StdOut.print("\n");
        }
    }

    public static void quickUnionTest(){
        QuickUnion union = new QuickUnion(arr);
        while(true){
            StdOut.println("Enter value 1");
            firstValue = StdIn.readInt();
            StdOut.println("Enter value 2");
            secondValue = StdIn.readInt();
            union.union(firstValue, secondValue);
            for(int i = 0; i < arr.length; i++){
                StdOut.print(arr[i] + " ");
            }
            StdOut.print("\n");
        }
    }

}
