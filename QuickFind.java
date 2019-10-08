public class QuickFind {

    private int[] source;

    public QuickFind(int[] source){
        this.source = source;
    }

    public void union(int firstIndex, int secondIndex){
        int temp = source[firstIndex];
        for(int i = 0; i < source.length; i++){
            if(source[i] == temp){
                source[i] = source[secondIndex];
            }
        }
    }

    public boolean isConnected(int firstIndex, int secondIndex){
        return source[firstIndex] == source[secondIndex];
    }

}
