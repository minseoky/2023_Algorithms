import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {2,7,6,3,5,9,4,8};
        mergeSort(list);

        System.out.println(Arrays.toString(list));
    }

    public static void mergeSort(int[] arr){
        if(arr.length == 1){
            return;
        }
        int len1 = arr.length/2;
        int len2 = arr.length - len1;
        int[] new_arr1 = new int[len1];
        int[] new_arr2 = new int[len2];
        for(int i = 0 ; i < arr.length ; i++){
            if(i < len1){
                new_arr1[i] = arr[i];
            }
            else{
                new_arr2[i-len1] = arr[i];
            }
        }

        mergeSort(new_arr1);
        mergeSort(new_arr2);
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while(p1 < new_arr1.length && p2 < new_arr2.length){
            if(new_arr1[p1] < new_arr2[p2]){
                arr[index++] = new_arr1[p1++];
            }
            else{
                arr[index++] = new_arr2[p2++];
            }
        }
        while(p1 < new_arr1.length){
            arr[index++] = new_arr1[p1++];
        }
        while(p2 < new_arr2.length){
            arr[index++] = new_arr2[p2++];
        }
    }
}