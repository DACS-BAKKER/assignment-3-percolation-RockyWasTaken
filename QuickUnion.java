public class QuickUnion {

    private int[] source;

    public QuickUnion(int[] source){
        this.source = source;
    }

    public void union(int firstIndex, int secondIndex){
        if(source[secondIndex] != secondIndex){
            source[firstIndex] = findOrigin(secondIndex);
        }
        else {
            source[firstIndex] = source[secondIndex];
        }
    }

    public void weightedUnion(int firstIndex, int secondIndex){
        if(getTreeSize(firstIndex) > getTreeSize(secondIndex)){
            union(secondIndex, firstIndex);
        }
        else {
            union(firstIndex, secondIndex);
        }
    }

    public boolean isConnected(int firstIndex, int secondIndex){
        return findOrigin(firstIndex) == findOrigin(secondIndex);
    }

    public int findOrigin(int index){
        int indexVar = index;
        while(source[indexVar] != indexVar){
            indexVar = source[indexVar];
        }
        return indexVar;
    }

    public int getTreeSize(int index){
        int count = 1;
        int indexVar = index;
        while(source[indexVar] != indexVar){
            indexVar = source[indexVar];
            count++;
        }
        return count;
    }
}
