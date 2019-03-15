

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

    swap(data, pivotIndex, start); // swap the pivot and the start
    pivotIndex = start;            // move the pivotIndex to the start
    start++;

    while(start != end){
      int currnet = data[start];

      if( current < pivot){ // if smaller than pivot, stay
        start++;
      } else if( current > pivot){ // if bigger, move to the other end
        swap(data, start, end);
        end--;
      }else{ // first optimization
        if( Math.random() * 10000 % 2 == 0){ // 50 50 chance of sending it to either side, if its equal to the pivot
          swap(data, start, end);
          end--;
        } else{
          start++;
        }
      }
    }

    return pivot;

  }

  public static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
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
