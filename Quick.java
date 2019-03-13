

public class Quick{

  public static int quickSelect(int[] data, int k){
    return 0;

  }

  public static int partition(int[] data, int start, int end){
    if(start < 0 || end > data.length){
      return start;
    }
    int pivotIndex = (int)(Math.random() * 10000 ) % data.length;
    int pivot = data[pivotIndex];

    return pivot;

  }

  public static void quickSortHelper(int[] data, int lo, int hi){
    if( lo >= hi){
      return;
    }
    int pivot = partition(data,lo,hi);
    quickSortHelper(data, pivot -1, hi);
    quickSortHelper(data, lo, pivot +1);

  }

  public static void main(String[] args){
    int[] a = {1,4,2,1,2,14,4,1};
    System.out.println(partition(a,0,0));
  }
}
