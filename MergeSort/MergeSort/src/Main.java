import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a[] = {3,6,1,2,8,7,4,5};
        System.out.println(Arrays.toString(a));
        MergeSort.merge_sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}