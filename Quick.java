import java.util.Arrays;


public class Quick{

  public static int partition(int[] data, int start, int end){
    int pivotIndex = (int)(Math.random() * 10000 ) % data.length;
    int pivot = data[pivotIndex];

    swap(data, pivotIndex, start); // swap the pivot and the start
    pivotIndex = start;            // move the pivotIndex to the start
    start++;

    while(start != end){
      int current = data[start];

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

    if(pivot > data[start]){
      swap(data, pivotIndex, start);
      return start;
    }else{
      swap(data, pivotIndex, start -1);
      return start -1;
    }

  }

  public static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public static int quickSelect(int[] data, int val){
    if( val >= data.length){
      throw new IllegalArgumentException("Must be a valid index");
    }

    int pivot = data.length;
    int start = 0;
    int end = pivot -1;

    while(pivot != val){ // if its not at the wanted val, keep going
      System.out.println("");
      System.out.println("start : " + start);
      System.out.println("end : " + end);
      System.out.println(pivot = partition(data, start, end)); // partition the array
      System.out.println(Arrays.toString(data));
      System.out.println("pivot : "+ pivot );
      System.out.println("val : "+val);
      if(pivot < val){
        System.out.println("the pivot is less than the value");
        start = pivot +1; // move the start if pivot is less than k
      } else {
        System.out.println("the pivot is more than the value");
        end = pivot -1; // move the end
      }
    }
    return data[pivot];

  }

  public static void quickSort(int[] data){
    quickSortHelper(data,0,data.length);
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

    System.out.println("Array a");
    int[] a = {4,6,1,3,5,8};
    System.out.println(Arrays.toString(a));
    System.out.println("");

    System.out.println("Partition on Array a");
    System.out.println(partition(a,0,a.length -1));
    System.out.println(Arrays.toString(a));
    System.out.println();

    System.out.println("quickSelect on Array a");
    System.out.println(quickSelect(a,2));
    System.out.println("Should be 4");
  }
}
