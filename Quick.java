import java.util.Arrays;
import java.util.Random;

public class Quick {
    private static Random random = new Random();

    public static void main(String[]args){
        System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
        int[]MAX_LIST = {1_000_000_000,500,10};
        for(int MAX : MAX_LIST){
            for(int size = 31250; size < 2000001; size*=2){
                long qtime=0;
                long btime=0;
                //average of 5 sorts.
                for(int trial = 0 ; trial <=5; trial++){
                    int []data1 = new int[size];
                    int []data2 = new int[size];
                    for(int i = 0; i < data1.length; i++){
                        data1[i] = (int)(Math.random()*MAX);
                        data2[i] = data1[i];
                    }
                    long t1,t2;
                    t1 = System.currentTimeMillis();
                    Quick.quicksort(data2);
                    t2 = System.currentTimeMillis();
                    qtime += t2 - t1;
                    t1 = System.currentTimeMillis();
                    Arrays.sort(data1);
                    t2 = System.currentTimeMillis();
                    btime+= t2 - t1;
                    if(!Arrays.equals(data1,data2)){
                        System.out.println("FAIL TO SORT!");
                        System.exit(0);
                    }
                }
                System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
            }
            System.out.println();
        }
    }

    public static int quickselect(int[] data, int k){
        if(k >= data.length){
            throw new IllegalArgumentException("k must be within array");
        }

        int pivot = data.length;
        int start = 0;
        int end = data.length - 1; // inclusive

        while(pivot != k){
            pivot = partition(data, start, end);
            if(pivot > k){
                end = pivot - 1;
            }else if(pivot < k){
		              start = pivot + 1;
            }
        }

        return data[pivot];
    }

    public static void quicksort(int[] data){
        //calls helper function
        quicksortHelper(data, 0, data.length -1);
    }

    private static void quicksortHelper(int[] data, int start, int end){
        if(end <= start){
            return;
        }else{
            int pivot = partition(data, start, end);
            // recursion on both sides
            quicksortHelper(data, start, pivot - 1);
            quicksortHelper(data, pivot + 1, end);
        }
    }

    public static int partition(int[] data, int start, int end){
        if(end == start || end <= 0){
            return start;
        }

        int pivotIndex = getPivot(data, start, end);
        int pivot = data[pivotIndex];

        swap(data, pivotIndex, start);
        pivotIndex = start;
        start++;

        while(start != end){
            int current = data[start];
            if(current < pivot){
                start++;
            }else if(current > pivot){
                swap(data, start, end);
                end--;
            }else{
                if(random.nextInt(2) == 0){
                    swap(data, start, end);
                    end--;
                }else{
                    start++;
                }
            }
        }

        if(pivot > data[start]){
            swap(data, pivotIndex, start);
            return start;
        }else{
            swap(data, pivotIndex, start - 1);
            return start - 1;
        }
    }

    private static void swap(int[] data, int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static int getPivot(int[] data, int lo, int hi) {
            int start = data[lo];
            int middle = data[(lo + hi) / 2];
            int end = data[hi];

            if ((start <= middle) && (middle <= end)){
            return (lo + hi) / 2;
            }
            if ((start <= end) && (end <= middle)){
            return hi;
            }
            if ((middle <= start) && (start <= end)){
            return lo;
            }
            if ((middle <= end) && (end <= start)){
            return hi;
            }
            if ((end <= start) && (start <= middle)){
            return lo;
            }

            return (lo + hi) / 2;
        }
}
