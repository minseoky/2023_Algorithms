import java.util.Arrays;

public class MergeSort {
    public static void merge_sort(int array[],int start, int end){
        if(end-start >= 1){
            int mid = (start+end)/2;
            merge_sort(array, start, mid);
            merge_sort(array, mid+1, end);
            int l = start;
            int r = mid+1;
            int newArray[] = new int[end-start+1];
            int idx = 0;
            while(l <= mid && r <= end){
                if(array[l] < array[r]){
                    newArray[idx++] = array[l++];
                }
                else{
                    newArray[idx++] = array[r++];
                }
            }
            while(l <= mid){
                newArray[idx++] = array[l++];
            }
            while(r <= end){
                newArray[idx++] = array[r++];
            }
            idx = 0;
            for(int i = start ; i <= end ; i++){
                array[i] = newArray[idx++];
            }
        }
    }
}
