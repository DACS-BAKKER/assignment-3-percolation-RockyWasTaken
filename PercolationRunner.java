import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;
import java.util.Timer;

public class PercolationRunner {

    //Visual representation of the test grid
    public static int[] testGrid = new int[]{
            0, 0, 1, 0, 1, 0, 0, 0, 0, 0,
            0, 0, 1, 0, 1, 0, 0, 0, 0, 0,
            0, 0, 1, 1, 1, 0, 0, 0, 0, 0,
            0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 1, 1, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 1, 0, 0, 0, 0
    };

    public static void main(String[] args){
        StdOut.println("Enter grid size");
        int gridSize = StdIn.readInt();
        Percolation percolation = new Percolation(gridSize);
        StdOut.println("Enter number of open sites");
        int openSites = StdIn.readInt();
        Random rgen = new Random();
        for(int i = 0; i < openSites; i++){
            int row = rgen.nextInt(gridSize - 1);
            int col = rgen.nextInt(gridSize - 1);
            if(!percolation.isOpen(row, col)){
                percolation.open(row, col);
            }
            else {
                i--;
            }
        }
        StdOut.println("Select method to test percolation (Enter number)");
        StdOut.println("1) Quick find");
        StdOut.println("2) Quick union");
        StdOut.println("3) Weight quick union");
        int option = StdIn.readInt();
        long start = System.currentTimeMillis();
        boolean result;
        if(option == 1){
            result = percolation.percolatesWithQuickFind();
            long finish = System.currentTimeMillis();
            double runtimeSeconds = (finish - start)/1000;
            if(result){
                StdOut.println("System percolates");
            }
            else {
                StdOut.println("System does not percolate");
            }
            StdOut.println("Runtime: " + runtimeSeconds + " seconds");
        }
        else if(option == 2){
            result = percolation.percolatesWithQuickUnion();
            long finish = System.currentTimeMillis();
            double runtimeSeconds = (finish - start)/1000;
            if(result){
                StdOut.println("System percolates");
            }
            else {
                StdOut.println("System does not percolate");
            }
            StdOut.println("Runtime: " + runtimeSeconds + " seconds");
        }
        else if(option == 3){
            result = percolation.percolatesWithWeightedQuickUnion();
            long finish = System.currentTimeMillis();
            double runtimeSeconds = (finish - start)/1000;
            if(result){
                StdOut.println("System percolates");
            }
            else {
                StdOut.println("System does not percolate");
            }
            StdOut.println("Runtime: " + runtimeSeconds + " seconds");
        }
    }
}
