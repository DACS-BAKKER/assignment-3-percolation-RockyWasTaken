import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {

    private int rowSize;
    private int[] connections;
    private int[] grid;

    //0 == blocked, 1 == open
    public Percolation(int n){
        if(n < 0){
            StdOut.println("The size of the percolation grid must be greater than zero");
        }
        else {
            rowSize = n;
            connections = new int[(rowSize * rowSize)];
            grid = new int[(rowSize * rowSize)];

            for(int i = 1; i < grid.length-1; i++) {
                grid[i] = 0;
            }

            for(int i = 0; i < connections.length; i++){
                connections[i] = i;
            }
        }

    }

    public void open(int i, int j){
        if(grid[getSite(i, j)] == 0){
            grid[getSite(i, j)] = 1;
        }
    }

    public boolean isOpen(int i, int j){
        if(grid[getSite(i, j)] == 1){
            return true;
        }
        return false;
    }

    public boolean isFull(int i, int j){
        if(connections[getSite(i, j)] != getSite(i, j)){
            return true;
        }
        return false;
    }

    public boolean percolatesWithQuickFind(){
        QuickFind find = new QuickFind(connections);
        for(int i = 1; i < rowSize; i++){
            for(int j = 0; j < rowSize; j++){
                if(i == 1){
                    if(isOpen(i, j) && isOpen(i - 1, j)){
                        find.union(getSite(i, j), getSite(i - 1, j));
                    }
                }
                else {
                    if(isOpen(i, j) && isFull(i - 1, j)){
                        find.union(getSite(i, j), getSite(i - 1, j));
                    }
                }
            }

            if(isFull(i, 0) && isOpen(i, 1)){
                find.union(getSite(i, 1), getSite(i, 0));
            }
            else if(isFull(i, rowSize - 1) && isOpen(i, rowSize - 2)){
                find.union(getSite(i, rowSize - 2), getSite(i, rowSize - 1));
            }

            for(int k = 1; k < rowSize - 1; k++){
                if(isFull(i, k) && isOpen(i, k - 1) && !isFull(i, k - 1)){
                    find.union(getSite(i, k - 1), getSite(i, k));
                }
                if(isFull(i, k) && isOpen(i, k + 1) && !isFull(i, k + 1)){
                    find.union(getSite(i, k + 1), getSite(i, k));
                }
            }
        }
        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (find.isConnected(getSite(0, i), getSite(rowSize - 1, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean percolatesWithQuickUnion(){
        QuickUnion union = new QuickUnion(connections);
        for(int i = 1; i < rowSize; i++){
            for(int j = 0; j < rowSize; j++){
                if(i == 1){
                    if(isOpen(i, j) && isOpen(i - 1, j)){
                        union.union(getSite(i, j), getSite(i - 1, j));
                    }
                }
                else {
                    if(isOpen(i, j) && isFull(i - 1, j)){
                        union.union(getSite(i, j), getSite(i - 1, j));
                    }
                }
            }

            if(isFull(i, 0) && isOpen(i, 1)){
                union.union(getSite(i, 1), getSite(i, 0));
            }
            else if(isFull(i, rowSize - 1) && isOpen(i, rowSize - 2)){
                union.union(getSite(i, rowSize - 2), getSite(i, rowSize - 1));
            }

            for(int k = 1; k < rowSize - 1; k++){
                if(isFull(i, k) && isOpen(i, k - 1) && !isFull(i, k - 1)){
                    union.union(getSite(i, k - 1), getSite(i, k));
                }
                if(isFull(i, k) && isOpen(i, k + 1) && !isFull(i, k + 1)){
                    union.union(getSite(i, k + 1), getSite(i, k));
                }
            }
        }
        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (union.isConnected(getSite(0, i), getSite(rowSize - 1, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean percolatesWithWeightedQuickUnion(){
        QuickUnion union = new QuickUnion(connections);
        for(int i = 1; i < rowSize; i++){
            for(int j = 0; j < rowSize; j++){
                if(i == 1){
                    if(isOpen(i, j) && isOpen(i - 1, j)){
                        union.weightedUnion(getSite(i, j), getSite(i - 1, j));
                    }
                }
                else {
                    if(isOpen(i, j) && isFull(i - 1, j)){
                        union.weightedUnion(getSite(i, j), getSite(i - 1, j));
                    }
                }
            }

            if(isFull(i, 0) && isOpen(i, 1)){
                union.weightedUnion(getSite(i, 1), getSite(i, 0));
            }
            else if(isFull(i, rowSize - 1) && isOpen(i, rowSize - 2)){
                union.weightedUnion(getSite(i, rowSize - 2), getSite(i, rowSize - 1));
            }

            for(int k = 1; k < rowSize - 1; k++){
                if(isFull(i, k) && isOpen(i, k - 1) && !isFull(i, k - 1)){
                    union.weightedUnion(getSite(i, k - 1), getSite(i, k));
                }
                if(isFull(i, k) && isOpen(i, k + 1) && !isFull(i, k + 1)){
                    union.weightedUnion(getSite(i, k + 1), getSite(i, k));
                }
            }
        }
        for(int i = 0; i < rowSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (union.isConnected(getSite(0, i), getSite(rowSize - 1, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    //Returns the index of site at row i, column j
    public int getSite(int i, int j){
        return rowSize * i + j;
    }
}
